package br.unb.cic.imdb.ui;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.*;

import br.unb.cic.imdb.integracao.jpa.EMFactoryHelper;
import br.unb.cic.imdb.negocio.*;
import br.unb.cic.imdb.util.ContextoID;

public class Interface {
	
	private static IMDBFacade facade;
	private static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	/*Tela Principal*/
	private static JFrame tela1;
	private static JPanel panel1;
	private static JLabel label1;
	private static JButton user;
	private static JButton func;
	private static JButton back;
	private static mainListener mainlistener = new mainListener();
	private enum TipoUser {DEFAULT, USUARIO, FUNCIONARIO};
	private static TipoUser tUser = TipoUser.DEFAULT;
	private static int tela = 1;
	
	/*Tela Log In*/
	private static JFrame tela2;
	private static JLabel label2;
	private static Container contentPane;
	private static SpringLayout layout;
	private static JLabel cod;
	private static JTextField codText;
	private static JLabel senha;
	private static JTextField senhaText;
	private static JButton login;
	private static backListener backlistener = new backListener();
	
	/*Tela de Opções*/
	private static JFrame tela3;
	private static JPanel panel3;
	private static JLabel label3;
	private static JButton gerenciar;
	private static JButton register;
	private static JButton avaliar;
	private static JButton deletar;
	private static JButton consultar;
	private static ButtonListener listener = new ButtonListener();
	private enum Opcao {DEFAULT, CONSULTAR, AVALIAR, GERENCIAR, REGISTRAR, DELETAR};
	private enum Campo {DEFAULT, ALBUM, FILME, AUTOR, GENERO, USUARIO};
	private static Opcao op = Opcao.DEFAULT;
	private static Campo campo = Campo.DEFAULT;
	
	/*Tela de Campos*/
	private static JFrame tela4;
	private static JPanel panel4;
	private static JLabel label4;
	private static JButton autor;
	private static JButton album;
	private static JButton filme;
	private static JButton genero;
	private static JButton userEdit;
	private static campoListener campolistener = new campoListener();
	
	/*Tela de Listagem*/
	private static JFrame tela5;
	private static JPanel panel5;
	private static JLabel label5;
	private static JComboBox<String> opts;
	private static ArrayList<String> list;
	private static optListener optlistener = new optListener();
	private static int optSelected;
	private static boolean selected = false;
	
	/*Tela Final*/
	private static JFrame tela6;
	private static JPanel panel6;
	private static JScrollPane jsp;
	private static JLabel nomeacao;
	private static JTextField nomeText;
	private static JLabel anoProducao;
	private static JTextField anoText;
	private static JLabel autorLabel;
	private static JTextField autorText;
	private static JLabel generoLabel;
	private static JTextField generoText;
	private static JLabel faixas;
	private static JLabel duracao;
	private static JTextField duracaoText;
	private static JLabel descricao;
	private static JTextField descText;
	private static JLabel pass;
	private static JTextField passText;
	private static JLabel nome;
	private static JTextField nText;
	private static JLabel dataNasc;
	private static JTextField nascText;
	private static JLabel gerente;
	private static JCheckBox gerBox;
	private static JLabel avaliacao;
	private static JButton aplicar;
	private static Container contentPane6;
	private static SpringLayout layout6;
	private static JLabel escala;
	private static String[] esc = {"","0","1","2","3","4","5"}; 
	private static JComboBox<String> escBox;
	private static int i = 0;
	private static int max = 0;
	private static JButton faixaExtra;
	private static JButton faixaDelet;
	private static faixaListener faixalistener = new faixaListener();
	private static ArrayList<JLabel> titLabel = new ArrayList<JLabel>();
	private static ArrayList<JTextField> titText = new ArrayList<JTextField>();
	private static ArrayList<JLabel> durLabel = new ArrayList<JLabel>();
	private static ArrayList<JTextField> durText = new ArrayList<JTextField>();
	
	/*Tela Faixas*/
	private static JFrame tela7;
	private static JPanel panel7;
	private static JLabel titLabel7;
	private static JTextField titText7;
	private static JLabel durLabel7;
	private static JTextField durText7;
	private static JComboBox<String> opts7;
	private static List<FaixaMusical> listFaixas = null;
	private static ArrayList<String> nomeFaixas = null;
	private static ArrayList<Integer> durFaixas = null;
	private static JButton aplicar7;
	private static editFaixaListener editFaixalistener = new editFaixaListener();
	private static boolean deletFaixa;
	private static applyListener applylistener = new applyListener();
	
	public static void main(String args[]) {
		
		facade = ContextoID.instance().facade();
		
		if(facade.recuperarUsuarioPorUsername("admin") == null){
			LocalDate dateNasc = LocalDate.parse("2015-12-04", format);
			Usuario novoUser = new Usuario("admin", "0000", "Bonifacio", dateNasc, true);
			facade.adicionaUsuario(novoUser);
		}
		
		tela1 = new JFrame();
		tela1.setTitle("IMDb");
		centreWindow(tela1);
		tela1.setBackground(Color.BLACK);
	    tela1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    tela1.setSize(400,250);
	    
	    tela1.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent we) {
	    		System.exit(0);
      	  	}
	    });
	    
	    panel1 = new JPanel();
	    panel1.setBackground(Color.WHITE);
	    panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
	    panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    label1 = new JLabel("<html>Bem-Vindo ao Sistema IMDb");
	    label1.setFont(new Font("Arial", Font.BOLD, 25));
	    label1.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    panel1.add(label1); panel1.add(Box.createRigidArea(new Dimension(0, 10)));
	    user = new JButton("<html>Usuario<html>");
	    panel1.add(user); user.addActionListener(mainlistener);
	    panel1.add(Box.createRigidArea(new Dimension(0, 10)));
	    func = new JButton("<html>Gerenciamento<html>");
	    panel1.add(func); func.addActionListener(mainlistener);
	    
	    JButton end = new JButton("Finalizar sessão"); end.addActionListener(backlistener);
	    panel1.add(Box.createRigidArea(new Dimension(0, 10)));
		panel1.add(end);
	    
        tela1.getContentPane().add(panel1, BorderLayout.CENTER);
        tela1.setVisible(true);
	}
	
	private static void telaLogIn(){
		tela2 = new JFrame();
		tela = 2;
		tela2.setTitle("IMDb");

		centreWindow(tela2);
	    tela2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    tela2.setSize(400,200);
	    contentPane = tela2.getContentPane();
		layout = new SpringLayout();
		contentPane.setLayout(layout);
	    
	    tela2.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent we) {
	    		System.exit(0);
      	  	}
	    });
	     
	    contentPane.setBackground(Color.WHITE);
	    label2 = new JLabel("<html>Preencha os campos abaixo:<html>");
	    contentPane.add(label2);
	    layout.putConstraint(SpringLayout.WEST, label2, 10, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, label2, 25, SpringLayout.NORTH, contentPane);
		
		cod = new JLabel("<html>Login:<html>");
		codText = new JTextField(null, 20);
		contentPane.add(cod); contentPane.add(codText);
		layout.putConstraint(SpringLayout.WEST, cod, 10, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, cod, 25, SpringLayout.NORTH, label2);
		layout.putConstraint(SpringLayout.WEST, codText, 20, SpringLayout.EAST, cod);
		layout.putConstraint(SpringLayout.NORTH, codText, 25, SpringLayout.NORTH, label2);
		
		senha = new JLabel("<html>Senha:<html>");
		senhaText = new JTextField(null, 20);
		contentPane.add(senha); contentPane.add(senhaText);
		layout.putConstraint(SpringLayout.WEST, senha, 10, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, senha, 25, SpringLayout.NORTH, cod);
		layout.putConstraint(SpringLayout.WEST, senhaText, 20, SpringLayout.EAST, senha);
		layout.putConstraint(SpringLayout.NORTH, senhaText, 25, SpringLayout.NORTH, cod);
	    
		login = new JButton("Aplicar"); login.addActionListener(mainlistener);
		back = new JButton("Voltar"); back.addActionListener(backlistener);
		contentPane.add(login); contentPane.add(back);
		layout.putConstraint(SpringLayout.WEST, login, 20, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, login, 30, SpringLayout.NORTH, senha);
		layout.putConstraint(SpringLayout.WEST, back, 20, SpringLayout.EAST, login);
		layout.putConstraint(SpringLayout.NORTH, back, 30, SpringLayout.NORTH, senha);
	    
        tela1.setVisible(false); tela2.setVisible(true);
	}
	
	private static void telaUsuario(){
		tela3 = new JFrame();
		tela = 3;
		tela3.setTitle("IMDb");
		centreWindow(tela3);
	    tela3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    tela3.setSize(300,200);
	    
	    tela3.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent we) {
	    		System.exit(0);
      	  	}
	    });
	    
	    panel3 = new JPanel();
	    panel3.setBackground(Color.WHITE);
	    panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
	    panel3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    label3 = new JLabel("<html>Escolha uma das opcoes abaixo:<html>");
	    panel3.add(label3); panel3.add(Box.createRigidArea(new Dimension(0, 10)));
		consultar = new JButton("<html>Consultar<html>");
	    panel3.add(consultar); consultar.addActionListener(listener);
	    panel3.add(Box.createRigidArea(new Dimension(0, 10)));
	    avaliar = new JButton("<html>Avaliar<html>");
	    panel3.add(avaliar); avaliar.addActionListener(listener);
	    panel3.add(Box.createRigidArea(new Dimension(0, 20)));
	    back = new JButton("Voltar"); back.addActionListener(backlistener);
		panel3.add(back);
		
		tela3.getContentPane().add(panel3, BorderLayout.CENTER);
        tela2.setVisible(false); tela3.setVisible(true);
	}
	
	private static void telaFuncionario(){
		tela3 = new JFrame();
		tela = 3;
		tela3.setTitle("IMDb");
		centreWindow(tela3);
	    tela3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    tela3.setSize(300,230);
	    
	    tela3.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent we) {
	    		System.exit(0);
      	  	}
	    });

	    panel3 = new JPanel();
	    panel3.setBackground(Color.WHITE);
	    panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
	    panel3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    label3 = new JLabel("<html>Escolha uma das opcoes abaixo:<html>");
	    panel3.add(label3); panel3.add(Box.createRigidArea(new Dimension(0, 10)));
		gerenciar = new JButton("<html>Editar<html>");
		panel3.add(gerenciar); gerenciar.addActionListener(listener);
		panel3.add(Box.createRigidArea(new Dimension(0, 10)));
		register = new JButton("<html>Registrar<html>");
		panel3.add(register); register.addActionListener(listener);
		panel3.add(Box.createRigidArea(new Dimension(0, 10)));
		deletar = new JButton("<html>Deletar<html>");
		panel3.add(deletar); deletar.addActionListener(listener);
		panel3.add(Box.createRigidArea(new Dimension(0, 10)));
		back = new JButton("Voltar"); back.addActionListener(backlistener);
		panel3.add(back);
		
		tela3.getContentPane().add(panel3, BorderLayout.CENTER);
        tela2.setVisible(false); tela3.setVisible(true);
	}
	
	private static void telaCampo(){
		tela4 = new JFrame();
		tela = 4;
		tela4.setTitle("IMDb");
		centreWindow(tela4);
		tela4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		tela2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
	      	}
		});
		     
		panel4 = new JPanel();
		panel4.setBackground(Color.WHITE);
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.PAGE_AXIS));
		panel4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		    
		switch(op){
		 	case CONSULTAR:
		 		label4 = new JLabel("<html>Escolha o que será consultado:<html>");
			break;
			case AVALIAR:
				label4 = new JLabel("<html>Escolha o que será avaliado:<html>");
				break;
			case GERENCIAR:
				label4 = new JLabel("<html>Escolha o que será gerenciado:<html>");
				break;
			case REGISTRAR:
				label4 = new JLabel("<html>Escolha o que será registrado:<html>");
				break;
			case DELETAR:
				label4 = new JLabel("<html>Escolha o que será deletado:<html>");
				break;
			default:
				break;
		}
		panel4.add(label4); panel4.add(Box.createRigidArea(new Dimension(0, 10)));
		 
		album = new JButton("<html>Album Musical<html>");
		panel4.add(album); album.addActionListener(campolistener);
		panel4.add(Box.createRigidArea(new Dimension(0, 10)));
		filme = new JButton("<html>Filme<html>");
		panel4.add(filme); filme.addActionListener(campolistener);
		 
		if(op != Opcao.AVALIAR){
			panel4.add(Box.createRigidArea(new Dimension(0, 10)));
			autor = new JButton("<html>Autor<html>");
			panel4.add(autor); autor.addActionListener(campolistener);
			panel4.add(Box.createRigidArea(new Dimension(0, 10)));
			genero = new JButton("<html>Genero<html>");
			panel4.add(genero); genero.addActionListener(campolistener);
		 
			if(op != Opcao.CONSULTAR){
		 		panel4.add(Box.createRigidArea(new Dimension(0, 10)));
		 		userEdit = new JButton("<html>Usuario<html>");
				panel4.add(userEdit); userEdit.addActionListener(campolistener);
			}
			
			tela4.setSize(300,300);
		}
		else {
			 tela4.setSize(300,200);
		}
		 
		panel4.add(Box.createRigidArea(new Dimension(0, 20)));
		back = new JButton("Voltar"); back.addActionListener(backlistener);
		panel4.add(back);
		 	        
		tela4.getContentPane().add(panel4, BorderLayout.CENTER);
		tela3.setVisible(false); tela4.setVisible(true);		 
	}
	
	private static void telaListagem(){
		tela5 = new JFrame();
		tela = 5;
		tela5.setTitle("IMDb");
		centreWindow(tela5);
	    tela5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    tela5.setSize(350,230);
	    
	    tela5.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent we) {
	    		System.exit(0);
      	  	}
	    });
	    
	    panel5 = new JPanel();
	    panel5.setBackground(Color.WHITE);
		panel5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    list = new ArrayList<String>();
	    list.add("");
	    switch(campo){
		    case ALBUM:
		    	label5 = new JLabel("Escolha o album entre as opcoes listadas abaixo:");
		    	List<AlbumMusical> trabalhosA = facade.recuperarAlbuns();
		    	for(AlbumMusical album : trabalhosA){
		    		list.add(album.getTitulo());
		    	}	    	
		    	break;
		    case FILME:
		    	label5 = new JLabel("Escolha o filme entre as opcoes listadas abaixo:");
		    	List<Filme> trabalhosF = facade.recuperarFilmes();
		    	for(Filme filme : trabalhosF){
		    		list.add(filme.getTitulo());
		    	}	
		    	break;
		    case AUTOR:
		    	label5 = new JLabel("Escolha o autor entre as opcoes listadas abaixo:");
		    	List<Autor> autores = facade.recuperarAutor();
		    	for(Autor autor : autores){
		    		list.add(autor.getNome());
		    	}	
		    	break;
		    case GENERO:
		    	label5 = new JLabel("Escolha o genero entre as opcoes listadas abaixo:");
		    	List<Genero> generos = facade.recuperarGeneros();
		    	for(Genero gen : generos){
		    		list.add(gen.getTitulo());
		    	}	
		    	break;
		    case USUARIO:
		    	label5 = new JLabel("Escolha o usuario entre as opcoes listadas abaixo:");
		    	List<Usuario> users = facade.recuperarUsuarios();
		    	for(Usuario user : users){
		    		list.add(user.getUser());
		    	}	
		    	break;
	    	default:
	    		break;
	    }
	    panel5.add(label5); panel5.add(Box.createRigidArea(new Dimension(0, 10)));
	    String[] array = list.toArray(new String[list.size()]);
    	opts = new JComboBox<String>(array);
    	opts.setSelectedIndex(0);
    	opts.addItemListener(optlistener);
    	panel5.add(opts);
	    
	    panel5.add(Box.createRigidArea(new Dimension(0, 20)));
		back = new JButton("Voltar"); back.addActionListener(backlistener);
		panel5.add(back);
		 	        
		tela5.getContentPane().add(panel5, BorderLayout.CENTER);
		tela4.setVisible(false); tela5.setVisible(true);	
	}
	
	private static void telaConsulta(){
		tela6 = new JFrame();
		tela = 6;
		tela6.setTitle("IMDb");
		centreWindow(tela6);
	    tela6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    tela6.setSize(300,300);
	    
	    tela6.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent we) {
	    		System.exit(0);
      	  	}
	    });
	    
	    int posicao = optSelected - 1;
	    
	    panel6 = new JPanel();
	    panel6.setBackground(Color.WHITE);
	    panel6.setLayout(new BoxLayout(panel6, BoxLayout.PAGE_AXIS)); 
		panel6.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		jsp = new JScrollPane(panel6);
	    switch(campo){
		    case ALBUM:
		    	List<AlbumMusical> albuns = facade.recuperarAlbuns();
		    	AlbumMusical auxalbum = albuns.get(posicao);
		    	nomeacao = new JLabel("Título: " + auxalbum.getTitulo());	    	
		    	panel6.add(nomeacao); panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	
		    	anoProducao = new JLabel("Ano de Producao: " + auxalbum.getAno());
		    	panel6.add(anoProducao); panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	
		    	/*faixas = new JLabel("<html>Faixas:");
		    	for(FaixaMusical faixa : auxalbum.getListaFaixas()){
		    		faixas.setText(faixas.getText()+
		    				"<br>Titulo: " + faixa.getTitulo()+
		    				"<br>Duracao: " + faixa.getDuracao());
		    	}
		    	faixas.setText(faixas.getText()+"</html>");
		    	panel6.add(faixas); panel6.add(Box.createRigidArea(new Dimension(0, 10)));*/
		    	
		    	/*if(auxalbum.getAvaliacoes() != null){
			    	avaliacao = new JLabel("<html>Avaliacoes:");
			    	for(Avaliacao avaliado : auxalbum.getAvaliacoes()){
			    		avaliacao.setText(avaliacao.getText()+
			    				"<br>Usuario: "+avaliado.getUsuario()+
			    				"<br>Escala: "+avaliado.getEscala()+
			    				"<br>Comentario: "+avaliado.getComentario());
			    	}
			    	avaliacao.setText(avaliacao.getText()+"</html>");
			    	panel6.add(avaliacao);
		    	}*/
		    	break;
		    case FILME:
		    	List<Filme> filmes = facade.recuperarFilmes();
		        Filme auxfilme = filmes.get(posicao);	
		    	nomeacao = new JLabel("Título: " + auxfilme.getTitulo());
		    	panel6.add(nomeacao); panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	
		    	anoProducao = new JLabel("Ano de Producao: " + auxfilme.getAno());
		    	panel6.add(anoProducao); panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	
		    	duracao = new JLabel("Duracao: " + auxfilme.getDuracao());
		    	panel6.add(duracao); panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	
		    	/*if(auxfilme.getAvaliacoes() != null){
			    	avaliacao = new JLabel("<html>Avaliacoes:");
			    	for(Avaliacao avaliado : auxfilme.getAvaliacoes()){
			    		avaliacao.setText(avaliacao.getText()+
			    				"<br>Usuario: "+avaliado.getUsuario()+
			    				"<br>Escala: "+avaliado.getEscala()+
			    				"<br>Comentario: "+avaliado.getComentario());
			    	}
			    	avaliacao.setText(avaliacao.getText()+"</html>");
			    	panel6.add(avaliacao);
		    	}*/
		    	break;
		    case AUTOR:
		    	List<Autor> autores = facade.recuperarAutor();
		    	Autor autoraux = autores.get(posicao);	
		    	nomeacao = new JLabel("Autor: " + autoraux.getNome());
		    	panel6.add(nomeacao); panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	descricao = new JLabel("Descricao: " + autoraux.getDescricao());
		    	panel6.add(descricao);
		    	break;
		    case GENERO:
		    	List<Genero> generos = facade.recuperarGeneros();
		    	Genero generoaux = generos.get(posicao);	
		    	nomeacao = new JLabel("Genero: " + generoaux.getTitulo());
		    	panel6.add(nomeacao); panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	descricao = new JLabel("Descricao: " + generoaux.getDescricao());
		    	panel6.add(descricao);
		    	break;
	    	default:
	    		break;
	    }
	    
	    panel6.add(Box.createRigidArea(new Dimension(0, 20)));
		back = new JButton("Voltar"); back.addActionListener(backlistener);
		panel6.add(back);
		 	        
		tela6.getContentPane().add(jsp, BorderLayout.CENTER);
		tela5.setVisible(false); tela6.setVisible(true);	
	}
	
	private static void telaEdicao(){
		tela6 = new JFrame();
		tela = 6;
		tela6.setTitle("IMDb");
		centreWindow(tela6);
	    tela6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    tela6.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent we) {
	    		System.exit(0);
      	  	}
	    });
	    
	    panel6 = new JPanel();
	    panel6.setBackground(Color.WHITE);
	    panel6.setLayout(new BoxLayout(panel6, BoxLayout.PAGE_AXIS));
		panel6.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		jsp = new JScrollPane(panel6);
		
		aplicar = new JButton("Aplicar"); aplicar.addActionListener(applylistener);
	    back = new JButton("Voltar"); back.addActionListener(backlistener);
		panel6.add(aplicar); panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		panel6.add(back);
		
		int posicao = 0;		
		if(op == Opcao.GERENCIAR) posicao = optSelected - 1;
		
	    switch(campo){
		    case ALBUM:
		    	List<AlbumMusical> albuns = null;
		    	AlbumMusical auxalbum = null;
		    	if(op == Opcao.GERENCIAR){
		    		albuns = facade.recuperarAlbuns();
			    	auxalbum = albuns.get(posicao);
		    	}
		    	tela6.setSize(500,450);
		    	
		    	nomeacao = new JLabel("Título: ");
		    	if(op == Opcao.REGISTRAR || auxalbum.getTitulo() == null) nomeText = new JTextField(20);
		    	else nomeText = new JTextField(auxalbum.getTitulo(), 20);
		    	panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(nomeacao); panel6.add(nomeText);
		    	
		    	anoProducao = new JLabel("Ano de Producao: ");
		    	if(op == Opcao.REGISTRAR) anoText = new JTextField(10);
		    	else anoText = new JTextField(Integer.toString(auxalbum.getAno()), 10);
		    	panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(anoProducao); panel6.add(anoText);

		    	autorLabel = new JLabel("Autor: ");
		    	if(op == Opcao.REGISTRAR || auxalbum.getAutor() == null) autorText = new JTextField(10);
		    	else autorText = new JTextField(auxalbum.getAutor().getNome(), 10);
		    	panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(autorLabel); panel6.add(autorText);
		    	
		    	generoLabel = new JLabel("Genero: ");
		    	if(op == Opcao.REGISTRAR || auxalbum.getGenero() == null) generoText = new JTextField(10);
		    	else generoText = new JTextField(auxalbum.getGenero().getTitulo(), 10);
		    	panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(generoLabel); panel6.add(generoText);
		    	
		    	faixas = new JLabel("Faixas:");
		    	panel6.add(Box.createRigidArea(new Dimension(0, 15)));
		    	panel6.add(faixas);
				
		/*		if(op == Opcao.GERENCIAR){
					max = auxalbum.getListaFaixas().size();
					if(max > 0){
				    	for(i = 0; i <= max; i++){
				    		titLabel.add(new JLabel("Titulo: "));
				    		if(op == Opcao.REGISTRAR) titText.add(new JTextField(10));
					    	else titText.add(new JTextField(auxalbum.getListaFaixas().get(i).getTitulo(), 20));
				    		panel6.add(Box.createRigidArea(new Dimension(0, 10)));
				    		panel6.add(titLabel.get(i)); panel6.add(titText.get(i));
							
				    		durLabel.add(new JLabel("Duracao: "));
				    		if(op == Opcao.REGISTRAR) durText.add(new JTextField(10));
					    	else durText.add(new JTextField(Integer.toString(auxalbum.getListaFaixas().get(i).getDuracao()), 10));
				    		panel6.add(Box.createRigidArea(new Dimension(0, 10)));
				    		panel6.add(durLabel.get(i)); panel6.add(durText.get(i));
				    	}
					}
				}*/
				
				faixas = new JLabel("<html>Faixas:");
				if(op == Opcao.REGISTRAR && listFaixas != null){
					max = listFaixas.size();
					if(max > 0){
				    	for(i = 0; i <= max; i++){
				    		faixas.setText(faixas.getText()+
				    				"<br>Titulo: "+ listFaixas.get(i).getTitulo() +
				    				"<br>Duracao: "+ listFaixas.get(i).getDuracao());
				    	}
					}
				}
				
				if(listFaixas == null) listFaixas = new ArrayList<FaixaMusical>();
				if(nomeFaixas == null) nomeFaixas = new ArrayList<String>();
				if(durFaixas == null) durFaixas = new ArrayList<Integer>();
				
		    	faixaExtra = new JButton("Adicionar Faixa"); faixaExtra.addActionListener(faixalistener);
		    	faixaDelet = new JButton("Deletar Faixa"); faixaDelet.addActionListener(faixalistener);
		    	panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(faixaExtra); panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(faixaDelet);
		    	break;
		    case FILME:
		    	List<Filme> filmes = null;
		    	Filme auxfilme = null;
		    	if(op == Opcao.GERENCIAR){
		    		filmes = facade.recuperarFilmes();
			        auxfilme = filmes.get(posicao);
		    	}
		    	tela6.setSize(500,400);
		    	
		    	nomeacao = new JLabel("Título: ");
		    	if(op == Opcao.REGISTRAR || auxfilme.getTitulo() == null) nomeText = new JTextField(20);
		    	else nomeText = new JTextField(auxfilme.getTitulo(), 20);
		    	panel6.add(nomeacao); panel6.add(nomeText);
		    	
		    	anoProducao = new JLabel("Ano de Producao: ");
		    	if(op == Opcao.REGISTRAR) anoText = new JTextField(10);
		    	else anoText = new JTextField(Integer.toString(auxfilme.getAno()), 10);
		    	panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(anoProducao); panel6.add(anoText);
		    	
				duracao = new JLabel("Duracao: ");
		    	if(op == Opcao.REGISTRAR) duracaoText = new JTextField(10);
		    	else duracaoText = new JTextField(Integer.toString(auxfilme.getDuracao()), 10);
		    	panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(duracao); panel6.add(duracaoText);
		    	
		    	autorLabel = new JLabel("Autor: ");
		    	if(op == Opcao.REGISTRAR || auxfilme.getAutor() == null) autorText = new JTextField(10);
		    	else autorText = new JTextField(auxfilme.getAutor().getNome(), 10);
		    	panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(autorLabel); panel6.add(autorText);
		    	
		    	generoLabel = new JLabel("Genero: ");
		    	if(op == Opcao.REGISTRAR || auxfilme.getGenero() == null) generoText = new JTextField(10);
		    	else generoText = new JTextField(auxfilme.getGenero().getTitulo(), 10);
		    	panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(generoLabel); panel6.add(generoText);
		    	break;
		    case AUTOR:
		    case GENERO:
		    	List<Autor> autores = null;
		    	Autor autoraux = null;
		    	if(op == Opcao.GERENCIAR){
			    	autores = facade.recuperarAutor();
			    	autoraux = autores.get(posicao);
		    	}
		    	List<Genero> generos = null;
		    	Genero generoaux = null;
		    	if(op == Opcao.GERENCIAR && campo == Campo.GENERO){
			    	generos = facade.recuperarGeneros();
			    	generoaux = generos.get(posicao);
		    	}
		    	tela6.setSize(500,220);
		    	
		    	if(campo == Campo.AUTOR) nomeacao = new JLabel("Autor: ");
		    	else nomeacao = new JLabel("Genero: ");
		    	if(op == Opcao.REGISTRAR || autoraux.getNome() == null || generoaux.getTitulo() == null){
		    		nomeText = new JTextField(20);
		    	}
		    	else{
		    		if(campo == Campo.AUTOR) nomeText = new JTextField(autoraux.getNome(), 20);
		    		else nomeText = new JTextField(generoaux.getTitulo(), 20);
		    	}
		    	panel6.add(nomeacao); panel6.add(nomeText);
		    	
				descricao = new JLabel("Descricao: ");
		    	if(op == Opcao.REGISTRAR || autoraux.getNome() == null || generoaux.getTitulo() == null){
		    		descText = new JTextField(30);
		    	}
		    	else{
		    		if(campo == Campo.AUTOR) descText = new JTextField(autoraux.getDescricao(), 30);
		    		else descText = new JTextField(generoaux.getDescricao(), 30);
		    	}
		    	panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(descricao); panel6.add(descText);
		    	break;
		    case USUARIO:
		    	List<Usuario> users = null;
		    	Usuario useraux = null;
		    	if(op == Opcao.GERENCIAR){
			    	users = facade.recuperarUsuarios();
			    	useraux = users.get(posicao);
				}
		    	tela6.setSize(500,250);
		    	nomeacao = new JLabel("Usuario: ");
		    	if(op == Opcao.REGISTRAR || useraux.getUser() == null) nomeText = new JTextField(20);
		    	else nomeText = new JTextField(useraux.getUser(), 20);
		    	panel6.add(nomeacao); panel6.add(nomeText);

				pass = new JLabel("Senha: ");
		    	passText = new JTextField(20);
		    	panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(pass); panel6.add(passText);
		    	
		    	nome = new JLabel("Nome: ");
		    	if(op == Opcao.REGISTRAR || useraux.getNome() == null) nText = new JTextField(20);
		    	else nText = new JTextField(useraux.getNome(), 20);
		    	panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(nome); panel6.add(nText);
		    	
				dataNasc = new JLabel("Data de Nascimento: ");
		    	if(op == Opcao.REGISTRAR) nascText = new JTextField("YYYY-MM-DD", 20);
		    	else{
		    		LocalDate dataNasc = useraux.getDataNasc();
		    		nascText = new JTextField(dataNasc.toString(), 20);
		    	}
		    	panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(dataNasc); panel6.add(nascText);
		    	
		    	gerente = new JLabel("Gerencia: ");
		    	gerBox = new JCheckBox();
		    	if(op == Opcao.REGISTRAR) gerBox.setSelected(true);
		    	else gerBox.setSelected(useraux.isGerencia());
		    	panel6.add(Box.createRigidArea(new Dimension(0, 10)));
		    	panel6.add(gerente); panel6.add(gerBox);
		    	break;
	    	default:
	    		break;
	    }
	    
	    tela6.getContentPane().add(jsp, BorderLayout.CENTER);	
	    if(op == Opcao.REGISTRAR){
	    	tela4.setVisible(false);
	    }
	    else{
	    	tela5.setVisible(false);
	    }
	    tela6.setVisible(true);	
	}
	
	private static void telaAvaliacao(){
		tela6 = new JFrame();
		tela = 6;
		tela6.setTitle("IMDb");
	
		centreWindow(tela6);
	    tela6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    tela6.setSize(600,220);
	    contentPane6 = tela6.getContentPane();
		layout6 = new SpringLayout();
		contentPane6.setLayout(layout6);
		contentPane6.setBackground(Color.WHITE);
	    
	    tela6.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent we) {
	    		System.exit(0);
      	  	}
	    });
	     
	    avaliacao = new JLabel("<html>Preencha os campos abaixo:<html>");
	    contentPane6.add(avaliacao);
	    layout6.putConstraint(SpringLayout.WEST, avaliacao, 10, SpringLayout.WEST, contentPane6);
		layout6.putConstraint(SpringLayout.NORTH, avaliacao, 25, SpringLayout.NORTH, contentPane6);
		
		escala = new JLabel("<html>Escala: <html>");
		escBox = new JComboBox<String>(esc);
    	escBox.setSelectedIndex(0);
    	contentPane6.add(escala);
    	contentPane6.add(escBox);
    	layout6.putConstraint(SpringLayout.WEST, escala, 10, SpringLayout.WEST, contentPane6);
		layout6.putConstraint(SpringLayout.NORTH, escala, 25, SpringLayout.NORTH, avaliacao);
		layout6.putConstraint(SpringLayout.WEST, escBox, 20, SpringLayout.EAST, escala);
		layout6.putConstraint(SpringLayout.NORTH, escBox, 25, SpringLayout.NORTH, avaliacao);
    	
		descricao = new JLabel("<html>Descricao: <html>");
		descText = new JTextField(null, 40);
		contentPane6.add(descricao); contentPane6.add(descText);
		layout6.putConstraint(SpringLayout.WEST, descricao, 10, SpringLayout.WEST, contentPane6);
		layout6.putConstraint(SpringLayout.NORTH, descricao, 40, SpringLayout.NORTH, escala);
		layout6.putConstraint(SpringLayout.WEST, descText, 20, SpringLayout.EAST, descricao);
		layout6.putConstraint(SpringLayout.NORTH, descText, 40, SpringLayout.NORTH, escala);
		
		aplicar = new JButton("Aplicar"); aplicar.addActionListener(applylistener);
		contentPane6.add(aplicar);
		layout6.putConstraint(SpringLayout.WEST, aplicar, 10, SpringLayout.WEST, contentPane6);
		layout6.putConstraint(SpringLayout.NORTH, aplicar, 35, SpringLayout.NORTH, descricao);
		back = new JButton("Voltar"); back.addActionListener(backlistener);
		contentPane6.add(back);
		layout6.putConstraint(SpringLayout.WEST, back, 15, SpringLayout.EAST, aplicar);
		layout6.putConstraint(SpringLayout.NORTH, back, 35, SpringLayout.NORTH, descricao);
		
		tela5.setVisible(false); tela6.setVisible(true);
	}
	
	private static void telaAddFaixa() {
		tela7 = new JFrame();
		tela = 7;
		tela7.setTitle("IMDb");
		tela7.setBackground(Color.WHITE);
		centreWindow(tela7);
	    tela7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    listFaixas = new ArrayList<FaixaMusical>();
	    
	    tela7.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent we) {
	    		System.exit(0);
      	  	}
	    });
	    
	    panel7 = new JPanel();
		panel7.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel7.setBackground(Color.WHITE);
		titLabel7 = new JLabel("Titulo: ");
		titText7 = new JTextField(20);
		panel7.add(Box.createRigidArea(new Dimension(0, 10)));
		panel7.add(titLabel7); panel7.add(titText7);
		
		durLabel7 = new JLabel("Duracao: ");
		durText7 = new JTextField(10);
		panel7.add(Box.createRigidArea(new Dimension(0, 10)));
		panel7.add(durLabel7); panel7.add(durText7);
		
		panel7.add(Box.createRigidArea(new Dimension(0, 10)));
		aplicar7 = new JButton("Aplicar"); aplicar7.addActionListener(editFaixalistener);
	    back = new JButton("Voltar"); back.addActionListener(backlistener);
		panel7.add(aplicar7); panel7.add(Box.createRigidArea(new Dimension(0, 10)));
		panel7.add(back);
		
		tela7.setSize(320,150);
		tela7.getContentPane().add(panel7, BorderLayout.CENTER);
		tela6.setVisible(false); tela7.setVisible(true);
		tela6.dispose();
	}
	
	private static void telaDeletaFaixa() {
		tela7 = new JFrame();
		tela = 7;
		tela7.setTitle("IMDb");
		tela7.setBackground(Color.WHITE);
	    tela7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    centreWindow(tela7);
	    
	    tela7.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent we) {
	    		System.exit(0);
      	  	}
	    });
	    
	    panel7 = new JPanel();
		panel7.setBackground(Color.WHITE);
		panel7.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		nomeFaixas = new ArrayList<String>();
		durFaixas = new ArrayList<Integer>();
		listFaixas = facade.recuperarFaixas();
		for(FaixaMusical music : listFaixas){
			nomeFaixas.add(music.getTitulo());
			durFaixas.add(music.getDuracao());
		}
	    String[] array = listFaixas.toArray(new String[listFaixas.size()]);
    	opts7 = new JComboBox<String>(array);
    	opts7.setSelectedIndex(0);
    	panel7.add(opts7);
		
		panel7.add(Box.createRigidArea(new Dimension(0, 10)));
		aplicar7 = new JButton("Aplicar"); aplicar7.addActionListener(editFaixalistener);
	    back = new JButton("Voltar"); back.addActionListener(backlistener);
		panel7.add(aplicar7); panel7.add(Box.createRigidArea(new Dimension(0, 10)));
		panel7.add(back);
		
		tela7.setSize(500,100);
		tela7.getContentPane().add(panel7, BorderLayout.CENTER);
		tela6.setVisible(false); tela7.setVisible(true);
		tela6.dispose();
	}
	
	private static class mainListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if(event.getSource() == user) {
				tUser = TipoUser.USUARIO;
				telaLogIn();
			}
			else if(event.getSource() == func){
				tUser = TipoUser.FUNCIONARIO;
				telaLogIn();
			}
			else if(event.getSource() == login){
				Usuario user = facade.recuperarUsuarioPorUsername(codText.getText());
				if(tUser == TipoUser.USUARIO){
					if(user.getSenha().equals(senhaText.getText()))
						telaUsuario();
				}
				else if(tUser == TipoUser.FUNCIONARIO){
					if(user.getSenha().equals(senhaText.getText()) && user.isGerencia())
						telaFuncionario();
				}
			}
		}
	}
	
	private static class backListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			switch(tela){
				case 1:
					EntityManager em = EMFactoryHelper.instance().getFactory().createEntityManager();
					em.close();
					System.exit(0);
					break;
				case 2:
					tela2.setVisible(false);
					tela1.setVisible(true);
					tela2.dispose();
					tUser = TipoUser.DEFAULT;
					tela = 1;
					break;
				case 3:
					tela3.setVisible(false);
					tela2.setVisible(true);
					tela3.dispose();
					op = Opcao.DEFAULT;
					tela = 2;
					break;
				case 4:
					tela4.setVisible(false);
					tela3.setVisible(true);
					tela4.dispose();
					campo = Campo.DEFAULT;
					tela = 3;
					break;
				case 5:
					tela5.setVisible(false);
					tela4.setVisible(true);
					tela5.dispose();
					tela = 4;
					break;
				case 6:
					tela6.setVisible(false);
					tela4.setVisible(true);
					tela6.dispose();
					tela = 4;
					selected = false;
					listFaixas = null;
					nomeFaixas = null;
					durFaixas = null;
					break;
				case 7:
					tela7.setVisible(false);
					tela6.setVisible(true);
					tela7.dispose();
					tela = 6;
					break;
				default:
					break;
			}
		}
	}
	
	private static void deletar(){
		int posicao = optSelected - 1;
		switch(campo){
	    case ALBUM:
	    	List<AlbumMusical> albuns = facade.recuperarAlbuns();
	    	AlbumMusical auxalbum = albuns.get(posicao);	
	    	facade.deletaAlbum(auxalbum);
	    	break;
	    case FILME:
	    	List<Filme> filmes = facade.recuperarFilmes();
	        Filme auxfilme = filmes.get(posicao);	
	        facade.deletaFilme(auxfilme);
	    case AUTOR:
	    	List<Autor> autores = facade.recuperarAutor();
	    	Autor autoraux = autores.get(posicao);	
	    	facade.deletaAutor(autoraux);
	    
	    	break;
	    case GENERO:
	    	List<Genero> generos = facade.recuperarGeneros();
	    	Genero generoaux = generos.get(posicao);
	    	facade.deletaGenero(generoaux);
	    	break;
	    case USUARIO:
	    	List<Usuario> users = facade.recuperarUsuarios();
	    	Usuario useraux = users.get(posicao);
	    	facade.deletaUsuario(useraux);
    	default:
    		break;
		}
	}
	
	private static class ButtonListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (event.getSource() == consultar) {
				op = Opcao.CONSULTAR;
			}
			else if (event.getSource() == avaliar) {
				op = Opcao.AVALIAR;
			}
			else if (event.getSource() == gerenciar) {
				op = Opcao.GERENCIAR;
			}
			else if (event.getSource() == register) { 
				op = Opcao.REGISTRAR;
			}
			else if (event.getSource() == deletar) { 
				op = Opcao.DELETAR;
			}
			telaCampo();
		}
	}
	
	private static class campoListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (event.getSource() == album) {
				campo = Campo.ALBUM;
			}
			else if (event.getSource() == filme) {
				campo = Campo.FILME;
			}
			else if (event.getSource() == autor) {
				campo = Campo.AUTOR;
			}
			else if (event.getSource() == genero) { 
				campo = Campo.GENERO;
			}
			else if (event.getSource() == userEdit) { 
				campo = Campo.USUARIO;
			}
			
			if(op == Opcao.CONSULTAR || op == Opcao.DELETAR || op == Opcao.GERENCIAR || op == Opcao.AVALIAR){
				telaListagem();
			}
			else if(op == Opcao.REGISTRAR){
				listFaixas = null;
				nomeFaixas = null;
				durFaixas = null;
				telaEdicao();
			}
		}
	}
	
	private static class optListener implements ItemListener {
		public void itemStateChanged (ItemEvent event) {
	        optSelected = opts.getSelectedIndex();
	        if(!selected){
				if(op == Opcao.CONSULTAR){
					telaConsulta();
				}
				else if(op == Opcao.GERENCIAR){
					telaEdicao();
				}
				else if(op == Opcao.AVALIAR){
					telaAvaliacao();
				}
				else if(op == Opcao.DELETAR){
					deletar();
				}
	        }
			selected = true;
		}
	}
	
	private static class faixaListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if (event.getSource() == faixaExtra) {
				telaAddFaixa();
				deletFaixa = false;
			}
			else if (event.getSource() == faixaDelet) {
				telaDeletaFaixa();
				deletFaixa = true;
			}
		}
	}
	
	private static class editFaixaListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
	        if(deletFaixa){
	        	/*List<FaixaMusical> faixas = facade.recuperarFaixas();
		    	FaixaMusical auxfaixa = faixas.get();	
		    	facade.deletaFaixa(auxfaixa);*/
	        }
	        else{
	        	if(op == Opcao.REGISTRAR){
	        		nomeFaixas.add(titText7.getText());
	        		durFaixas.add(Integer.parseInt(durText7.getText()));
	        	}
	        	else if(op == Opcao.GERENCIAR){
	        		List<AlbumMusical> albuns = facade.recuperarAlbuns();
			    	AlbumMusical auxalbum = albuns.get(optSelected - 1);
	        		FaixaMusical novaFaixa = new FaixaMusical(titText7.getText(),
	        				Integer.parseInt(durText7.getText()), auxalbum);
					facade.adicionaFaixa(novaFaixa);
	        	}
	        }

		}
	}
	
	private static class applyListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if(op == Opcao.GERENCIAR){
				switch(campo){
				case ALBUM:
					Autor autorAlbum = null; Genero genAlbum = null;
					if(!(autorText.getText().equals("")) && (!autorText.getText().isEmpty())){
						autorAlbum = facade.recuperarAutorPorNome(autorText.getText());
						if(autorAlbum == null){
							autorAlbum = new Autor();
							autorAlbum.setNome(autorText.getText());
							facade.adicionaAutor(autorAlbum);
						}
					}
					
					if(!(generoText.getText().equals("")) && (!generoText.getText().isEmpty())){
						genAlbum = facade.recuperarGeneroPorTitulo(generoText.getText());
						if(genAlbum == null){
							genAlbum = new Genero();
							genAlbum.setTitulo(generoText.getText());
							facade.adicionaGenero(genAlbum);
						}
					}
					
					List<AlbumMusical> albuns = facade.recuperarAlbuns();
			    	AlbumMusical auxalbum = albuns.get(optSelected-1);
					facade.editaAlbum(auxalbum.getId(), nomeText.getText(), 
							Integer.parseInt(anoText.getText()), autorAlbum, genAlbum, listFaixas);
					break;
				case FILME:
					Autor autorFilme = null; Genero genFilme = null;
					if(!(autorText.getText().equals("")) && (!autorText.getText().isEmpty())){
						autorFilme = facade.recuperarAutorPorNome(autorText.getText());
						if(autorFilme == null){
							autorFilme = new Autor();
							autorFilme.setNome(autorText.getText());
							facade.adicionaAutor(autorFilme);
						}
					}
					
					if(!(generoText.getText().equals("")) && (!generoText.getText().isEmpty())){
						genFilme = facade.recuperarGeneroPorTitulo(generoText.getText());
						if(genFilme == null){
							genFilme = new Genero();
							genFilme.setTitulo(generoText.getText());
							facade.adicionaGenero(genFilme);
						}
					}
					
					List<Filme> filmes = facade.recuperarFilmes();
			    	Filme filmeaux = filmes.get(optSelected-1);
					facade.editaFilme(filmeaux.getId(), nomeText.getText(),
							Integer.parseInt(anoText.getText()), Integer.parseInt(duracaoText.getText()),
							autorFilme, genFilme);
					break;
				case AUTOR:
					List<Autor> autores = facade.recuperarAutor();
			    	Autor autoraux = autores.get(optSelected-1);
					facade.editaAutor(autoraux.getId(), nomeText.getText(), descText.getText());
					break;
				case GENERO:
					List<Genero> generos = facade.recuperarGeneros();
			    	Genero genaux = generos.get(optSelected-1);
					facade.editaGenero(genaux.getId(), nomeText.getText(), descText.getText());
					break;
				case USUARIO:
					LocalDate dateNasc;
					if(!nascText.getText().isEmpty())
						dateNasc = LocalDate.parse(nascText.getText(), format);
					else
						dateNasc = null;
					
					List<Usuario> users = facade.recuperarUsuarios();
			    	Usuario useraux = users.get(optSelected-1);
					facade.editaUsuario(useraux.getId(), nomeText.getText(), senhaText.getText(),
							nText.getText(), dateNasc, gerBox.isSelected());
					break;
				default:
					break;
				}
			}
			else if(op == Opcao.REGISTRAR){
				switch(campo){
					case ALBUM:
						Autor autorAlbum = null; Genero genAlbum = null;
						if(!(autorText.getText().equals("")) && (!autorText.getText().isEmpty())){
							autorAlbum = facade.recuperarAutorPorNome(autorText.getText());
							if(autorAlbum == null){
								autorAlbum = new Autor();
								autorAlbum.setNome(autorText.getText());
								facade.adicionaAutor(autorAlbum);
							}
						}
						
						if(!(generoText.getText().equals("")) && (!generoText.getText().isEmpty())){
							genAlbum = facade.recuperarGeneroPorTitulo(generoText.getText());
							if(genAlbum == null){
								genAlbum = new Genero();
								genAlbum.setTitulo(generoText.getText());
								facade.adicionaGenero(genAlbum);
							}
						}
						
						if(!nomeFaixas.isEmpty()){
							int max = nomeFaixas.size();
							for(int j = 0; j <= max-1; j++){
								listFaixas.add(new FaixaMusical(nomeFaixas.get(j), durFaixas.get(j)));
								facade.adicionaFaixa(listFaixas.get(j));
							}
						}
							
						AlbumMusical novoAlbum = new AlbumMusical(nomeText.getText(), 
								Integer.parseInt(anoText.getText()), autorAlbum, genAlbum, listFaixas, null);
						facade.adicionaAlbum(novoAlbum);
						
						if(!nomeFaixas.isEmpty()){
							int max = nomeFaixas.size();
							for(int j = 0; j <= max-1; j++){
								facade.editaFaixa(listFaixas.get(j).getId(), nomeFaixas.get(j),
										durFaixas.get(j), null); //novoAlbum
							}
						}
						break;
					case FILME:
						Autor autorFilme = null; Genero genFilme = null;
						if(!(autorText.getText().equals("")) && (!autorText.getText().isEmpty())){
							autorFilme = facade.recuperarAutorPorNome(autorText.getText());
							if(autorFilme == null){
								autorFilme = new Autor();
								autorFilme.setNome(autorText.getText());
								facade.adicionaAutor(autorFilme);
							}
						}
						
						if(!(generoText.getText().equals("")) && (!generoText.getText().isEmpty())){
							genFilme = facade.recuperarGeneroPorTitulo(generoText.getText());
							if(genFilme == null){
								genFilme = new Genero();
								genFilme.setTitulo(generoText.getText());
								facade.adicionaGenero(genFilme);
							}
						}
						
						Filme novoFilme = new Filme(nomeText.getText(),
								Integer.parseInt(anoText.getText()), Integer.parseInt(duracaoText.getText()),
								autorFilme, genFilme, null);
						facade.adicionaFilme(novoFilme);
						break;
					case AUTOR:
						Autor novoAutor = new Autor(nomeText.getText(), descText.getText());
						facade.adicionaAutor(novoAutor);
						break;
					case GENERO:
						Genero novoGenero = new Genero(nomeText.getText(), descText.getText());
						facade.adicionaGenero(novoGenero);
						break;
					case USUARIO:
						LocalDate dateNasc;
						if(!nascText.getText().isEmpty())
							dateNasc = LocalDate.parse(nascText.getText(), format);
						else
							dateNasc = null;
						Usuario novoUser = new Usuario(nomeText.getText(), senhaText.getText(),
								nText.getText(), dateNasc, gerBox.isSelected());
						facade.adicionaUsuario(novoUser);
						break;
					default:
						break;
				}
			}
			else if(op == Opcao.AVALIAR){
				Usuario user = facade.recuperarUsuarioPorUsername(codText.getText());
				if(campo == Campo.ALBUM){
					AlbumMusical album = facade.recuperarAlbumPorTitulo(list.get(optSelected - 1));
					Avaliacao novaAval = new Avaliacao(escBox.getSelectedIndex(), descricao.getText(),
							user, album);
					facade.adicionaAvaliacao(novaAval);
				}
				else if(campo == Campo.FILME){
					Filme filme = facade.recuperarFilmePorTitulo(list.get(optSelected - 1));
					Avaliacao novaAval = new Avaliacao(escBox.getSelectedIndex(), descricao.getText(),
							user, filme);
					facade.adicionaAvaliacao(novaAval);
				}
			}
		}
	}

	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) (dimension.getWidth() / 2.8);
	    int y = (int) (dimension.getHeight() / 2.8);
	    frame.setLocation(x, y);
	}
}