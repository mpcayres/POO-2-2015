package br.unb.cic.lp.gol;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;


public class GameView{    
	private GameEngine engine;
	private GameController controller;
	private Statistics statistics;
	
	private int height = 10, width = 10;
    
    private int genCount = 0;
    private int genDelay;
    
    /* Declarações de Recursos propostos pela plataforma swing para a criação da interface*/
    private JFrame frame = new JFrame();
    private JFrame size = new JFrame();
    private JPanel defPanel;
	private JPanel oPanel = new JPanel();
	private JPanel o2Panel = new JPanel();
	private JPanel gPanel  = new JPanel();
    private JLabel stats = new JLabel();
	private JButton celula[][];
	private JButton def;
	private JButton start; private JButton reset; private JButton stop;
    private JButton random; private JButton simauto; private JButton stopsim;
    private JLabel genLabel;
    
    private JRadioButton Conway, HighLife, LiveFreeOrDie, Maze, Move, Seeds,
    						LifeWithoutDeath, Mazectric, Replicator;
    private RadioButtonHandler handler;
    private ButtonGroup group = new ButtonGroup();
    private JLabel label;
    
    private defListener listenerDef = new defListener();
    private ButtonListener listener = new ButtonListener();
    private simListener listenerSim = new simListener();
    private stopListener listenerStop = new stopListener();
    
    private RunSimulation runSimulation;
    private volatile boolean running = false;
    private volatile boolean marcador = false;
    private volatile boolean parada = true;


	public GameView(GameController controller, GameEngine engine, Statistics statistics) {
		this.controller = controller;
		this.engine = engine;
		this.statistics = statistics;
	}
	
	/* Definidor de tamanho interativo ao usuário, tornando livre a escolha das dimensões do tabuleiro*/
	public void setSize(){
		size.setTitle("Game of Life");
        size.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        size.setSize(700, 500);
        
        JSlider heightSlider = 
                new JSlider(JSlider.VERTICAL, 10, 70, height);
        heightSlider.addChangeListener(
                new heightListener());
        heightSlider.setMajorTickSpacing(5);
        heightSlider.setPaintLabels(true);
        heightSlider.setPaintTicks(true);
        
        JSlider widthSlider = 
                new JSlider(JSlider.HORIZONTAL, 10, 70, width);
        widthSlider.addChangeListener(
                new widthListener());
        widthSlider.setMajorTickSpacing(5);
        widthSlider.setPaintLabels(true);
        widthSlider.setPaintTicks(true);
              
        size.getContentPane().add(heightSlider, BorderLayout.WEST);
        size.getContentPane().add(widthSlider, BorderLayout.SOUTH);
        
        def = new JButton("<html>Aplicar definicao das<br>dimensoes do jogo<html>");
        defPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 200));
        defPanel.add(def);
        def.addActionListener(listenerDef);
        size.getContentPane().add(defPanel, BorderLayout.EAST);
        
        size.setVisible(true);
        frame.setVisible(false);
        
        size.addWindowListener(new WindowAdapter() {
      	  	public void windowClosing(WindowEvent we) {
      	  		System.exit(0);
      	  	}
        });
        
        while(parada){
        	try {
        		Thread.sleep(500);
        	}
        	catch(InterruptedException e) {
        		e.printStackTrace();
        	}
        }
	}
	
	public class defListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
				size.setVisible(false);
				frame.setVisible(true);
				parada = false;
		}
	}
	
	public class heightListener implements ChangeListener {    
        @Override
        public void stateChanged(ChangeEvent event) {
            JSlider source = (JSlider) event.getSource();
            if (!source.getValueIsAdjusting()) {
                height = source.getValue();
            }
        }
    }
	
	public class widthListener implements ChangeListener {    
        @Override
        public void stateChanged(ChangeEvent event) {
            JSlider source = (JSlider) event.getSource();
            if (!source.getValueIsAdjusting()) {
                width = source.getValue();
            }
        }
    }
	
	/* Metodos de acesso as propriedades height e width */
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public void initBoard() {
		genDelay = 2000;
        createPartControl();		
	}
 
	/* Criação dos diversos botões para mudança de estratégia de derivação do GameOfLife, cada botão é ligado a mesma
	 * resposta Handler.
	 */
	public void RadioButton(){
		handler = new RadioButtonHandler();
		
		label = new JLabel("Estrategia");
		Conway = new JRadioButton("Conway",false);
		HighLife = new JRadioButton("HighLife", false);
		LiveFreeOrDie = new JRadioButton("LiveFreeOrDie", false);
		Maze = new JRadioButton("Maze",false);
		Move = new JRadioButton("Move",false);
		Seeds = new JRadioButton("Seeds",false);
		LifeWithoutDeath = new JRadioButton("LifeWithoutDeath",false);
		Mazectric = new JRadioButton("Mazectric",false);
		Replicator = new JRadioButton("Replicator",false);
		
		oPanel.add(label); oPanel.add(Conway); oPanel.add(HighLife);
		oPanel.add(LiveFreeOrDie); oPanel.add(Maze); oPanel.add(Move); oPanel.add(Seeds);
		oPanel.add(LifeWithoutDeath); oPanel.add(Mazectric);  oPanel.add(Replicator);
		

		/* Adição dos botões dispostos para cada estratégia a um grupo definido, facilitanto a definição única de cada classe*/
		group.add(Conway); group.add(HighLife);
		group.add(LiveFreeOrDie); group.add(Maze); group.add(Move);
		group.add(Seeds); group.add(LifeWithoutDeath); group.add(Mazectric);
		group.add(Replicator);
		
		/* Adição da resposta ao clique a todos os botões criado*/
		Conway.addItemListener(handler);
		HighLife.addItemListener(handler);
		LiveFreeOrDie.addItemListener(handler);
		Maze.addItemListener(handler);
		Move.addItemListener(handler);
		Seeds.addItemListener(handler);
		LifeWithoutDeath.addItemListener(handler);
		Mazectric.addItemListener(handler);
		Replicator.addItemListener(handler);
	}
	
	
	/* Método de resposta handler, realiza a injeção de acordo com o botão de estratégia selecionado*/ 
	private class RadioButtonHandler implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent event) {
			Injector injector = Guice.createInjector(new AdicionarEstrategia());
			EstrategiaDeDerivacao add;
			if(Conway.isSelected()) {
				add = (EstrategiaDeDerivacao) 
						injector.getInstance(Key.get(EstrategiaDeDerivacao.class, Names.named("Conway")));
				Conway.setSelected(true);
				engine.setEstrategia(add);
			} else if(HighLife.isSelected()) {
				add = (EstrategiaDeDerivacao) 
						injector.getInstance(Key.get(EstrategiaDeDerivacao.class, Names.named("HighLife")));
				HighLife.setSelected(true);
				engine.setEstrategia(add);
			}
			else if(LiveFreeOrDie.isSelected()) {
				add = (EstrategiaDeDerivacao) 
						injector.getInstance(Key.get(EstrategiaDeDerivacao.class, Names.named("LiveFOrD")));
				LiveFreeOrDie.setSelected(true);
				engine.setEstrategia(add);
			}
			else if(Maze.isSelected()) {
				add = (EstrategiaDeDerivacao) 
						injector.getInstance(Key.get(EstrategiaDeDerivacao.class, Names.named("Maze")));
				Maze.setSelected(true);
				engine.setEstrategia(add);
		    }
			else if(Move.isSelected()) {
				add = (EstrategiaDeDerivacao) 
						injector.getInstance(Key.get(EstrategiaDeDerivacao.class, Names.named("Move")));
				Move.setSelected(true);
				engine.setEstrategia(add);
			}
			else if(Seeds.isSelected()){
				add = (EstrategiaDeDerivacao) 
						injector.getInstance(Key.get(EstrategiaDeDerivacao.class, Names.named("Seeds")));
				Seeds.setSelected(true);
				engine.setEstrategia(add);
			}else if(LifeWithoutDeath.isSelected()){
				add = (EstrategiaDeDerivacao) 
						injector.getInstance(Key.get(EstrategiaDeDerivacao.class, Names.named("LifeWithoutDeath")));
				LifeWithoutDeath.setSelected(true);
				engine.setEstrategia(add);
			}
			else if(Mazectric.isSelected()) {
				add = (EstrategiaDeDerivacao) 
						injector.getInstance(Key.get(EstrategiaDeDerivacao.class, Names.named("Mazectric")));
				Mazectric.setSelected(true);
				engine.setEstrategia(add);
			}
			else if(Replicator.isSelected()) {
				add = (EstrategiaDeDerivacao) 
						injector.getInstance(Key.get(EstrategiaDeDerivacao.class, Names.named("Replicator")));
				Replicator.setSelected(true);
				engine.setEstrategia(add);
			}
		}	
	}
	
	/* Criação do frame de maneira geral, ligando os diversos paineis que posssuem grupos de botões*/
    private void createPartControl() {  
    	
    	stats.setText("<html>Estatisticas<br>Celulas revividas: " + statistics.getRevivedCells() + 
        		"<br>Celulas mortas: " + statistics.getKilledCells() +"<br>Numero de geracoes: " + Integer.toString(genCount) + "<html>");
        
        frame.getContentPane().add(gPanel, BorderLayout.CENTER);
        frame.getContentPane().add(oPanel, BorderLayout.EAST);
        frame.getContentPane().add(o2Panel, BorderLayout.WEST);
        frame.getContentPane().add(stats, BorderLayout.SOUTH);
        
        optionsPanel();
        gridPanel();
        RadioButton();
        frame.setTitle("Game of Life");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(700, 500);
        
        frame.addWindowListener(new WindowAdapter() {
        	  public void windowClosing(WindowEvent we) {
        	    System.exit(0);
        	  }
        });
    }
    
    /* Adição dos botões principais aos paineis*/
    public void botoes(){
    	
    	start = new JButton("Proxima Geracao");
        reset = new JButton("Resetar");
        stop = new JButton("Sair");
        random = new JButton("Random");
        simauto = new JButton("Simulacao automatica");
        stopsim = new JButton("Finalizar simulacao");
        
    	start.addActionListener(listener);
        reset.addActionListener(listener);
        stop.addActionListener(listener);
        random.addActionListener(listener);
        simauto.addActionListener(listenerSim);
        stopsim.addActionListener(listenerStop);
        
        o2Panel.add(Box.createRigidArea(new Dimension(0,80)));
        o2Panel.add(start); o2Panel.add(Box.createRigidArea(new Dimension(0,5)));
        o2Panel.add(reset); o2Panel.add(Box.createRigidArea(new Dimension(0,5)));
        o2Panel.add(random); o2Panel.add(Box.createRigidArea(new Dimension(0,5)));
        o2Panel.add(simauto); o2Panel.add(Box.createRigidArea(new Dimension(0,5)));
        o2Panel.add(stopsim); o2Panel.add(Box.createRigidArea(new Dimension(0,5)));
        o2Panel.add(genLabel);
       
        reset.setAlignmentX(Component.CENTER_ALIGNMENT); reset.setBackground(Color.white);
        stop.setAlignmentX(Component.CENTER_ALIGNMENT); stop.setBackground(Color.white);
        start.setAlignmentX(Component.CENTER_ALIGNMENT); start.setBackground(Color.white);
        random.setAlignmentX(Component.CENTER_ALIGNMENT); random.setBackground(Color.white);
        simauto.setAlignmentX(Component.CENTER_ALIGNMENT); simauto.setBackground(Color.white);
        stopsim.setAlignmentX(Component.CENTER_ALIGNMENT); stopsim.setBackground(Color.white);
    }
    
    public void optionsPanel() {
    	o2Panel.setLayout(new BoxLayout(o2Panel, BoxLayout.PAGE_AXIS));
    	oPanel.setLayout(new BoxLayout(oPanel, BoxLayout.Y_AXIS));
    	
    	start = new JButton("Proxima Geracao");
        reset = new JButton("Resetar");
        stop = new JButton("Sair");
        random = new JButton("Random");
        simauto = new JButton("Simulacao automatica");
        stopsim = new JButton("Finalizar simulacao");
        genLabel = new JLabel("Velocidade (em segundos)", 
                JLabel.CENTER);
        genLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JSlider genSlider = 
                new JSlider(JSlider.HORIZONTAL, 1, 5, genDelay/1000);
        genSlider.addChangeListener(
                new genChangeListener());
        genSlider.setMajorTickSpacing(1);
        genSlider.setPaintLabels(true);
        genSlider.setPaintTicks(true);
        
        botoes();
        o2Panel.add(genSlider); o2Panel.add(Box.createRigidArea(new Dimension(0,5)));
        o2Panel.add(stop);
    }
    
    /* Criação do tabuleiro a partir da lógica de botões, tal que cada célula será correspondente a um botão*/
    public void gridPanel() {    
    	gPanel.setBackground(Color.BLACK);
    	gPanel.setLayout(new GridLayout(height, width));
        
        celula = new JButton[height][width];
        
        for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				    celula[i][j] = new JButton();
				    celula[i][j].setBackground(engine.isCellAlive(i, j) ? Color.orange : Color.white);
				    celula[i][j].addActionListener(listener);
					gPanel.add(celula[i][j]);
			}
		}
        
    }
    
    /* Passos que realizam o nascimento e morte manual de celulas*/
    private class ButtonListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
					
			if (event.getSource() == start) { 
				controller.nextGeneration();
				genCount++;
			}
			
			if (event.getSource() == reset) { 
				for (int i = 0; i < height; i++) {
					for (int j = 0; j < width; j++) {
						if(engine.isCellAlive(i, j)){
							engine.makeCellDead(i,j);
							 celula[i][j].setBackground(engine.isCellAlive(i, j) ? Color.orange : Color.white);
						    //genCount = 0;
						}
					}
				}
			}
			
			if (event.getSource() == stop) {
				System.exit(0);
			}
			
			if (event.getSource() == random) {
				engine.randomizar();
				update();
			}
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if(event.getSource() == celula[i][j]){
						if(!engine.isCellAlive(i, j)){
							engine.makeCellAlive(i, j);
							celula[i][j].setBackground(Color.orange);
						} else{
							engine.makeCellDead(i, j);
							celula[i][j].setBackground(Color.white);
						}
					}
				}
			}
			
	    	stats.setText("<html>Estatisticas<br>Celulas revividas: " + statistics.getRevivedCells() + 
	        		"<br>Celulas mortas: " + statistics.getKilledCells() +"<br>Numero de geracoes: " + Integer.toString(genCount) + "<html>");
		}
	}
    
    /* Conjunto de listeners(Respostas aos eventos de clique nos botões)*/
    private class simListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if(!marcador){
				marcador = true;
				runSimulation = new RunSimulation();
		        new Thread(runSimulation).start();	
			}
		}
	}
    
    private class stopListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			running = false; marcador = false;
		}
	}
    
    public class genChangeListener implements ChangeListener {    
        @Override
        public void stateChanged(ChangeEvent event) {
            JSlider source = (JSlider) event.getSource();
            if (!source.getValueIsAdjusting()) {
                genDelay = 1000 / source.getValue();
            }
        }
    }
    
    /* Classe responsável pela simulação automática do tabuleiro*/
    class RunSimulation implements Runnable {
		@Override
		public void run() {
			running = true;
			while(running){
				try {
				    Thread.sleep(genDelay);
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				controller.nextGeneration();
				genCount++;

		    	stats.setText("<html>Estatisticas<br>Celulas revividas: " + statistics.getRevivedCells() + 
		        		"<br>Celulas mortas: " + statistics.getKilledCells() +"<br>Numero de geracoes: " + Integer.toString(genCount) + "<html>");
				if(engine.numberOfAliveCells() == 0){
					running = false; marcador = false;
				}
			}
		}
    	
    }
    
	/* Atualiza o tabuleiro do jogo*/
	public void update() {	
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				  celula[i][j].setBackground(engine.isCellAlive(i, j) ? Color.orange : Color.white);
			}
		}		
	}

}
