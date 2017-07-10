package br.unb.cic.lp.gol;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

/**
 * Classe que define o metodo principal do programa.
 */
public class Main {

	public static void main(String args[]) {
		final GameController controller = new GameController();
		
		Statistics statistics = new Statistics();

		GameEngine engine = new GameEngine(statistics);	
		
		//nessa implementacao, a estrategia do Conway eh 
		//configurada como a estrategia inicial.
		Injector injector = Guice.createInjector(new AdicionarEstrategia());
		EstrategiaDeDerivacao add = (EstrategiaDeDerivacao) 
				injector.getInstance(Key.get(EstrategiaDeDerivacao.class, Names.named("Conway")));
		engine.setEstrategia(add);
		
		GameView board = new GameView(controller, engine, statistics);
		
		controller.setBoard(board);
		controller.setEngine(engine);
		
		engine.setEngine(board.getHeight(), board.getWidth());
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			 public void run() {
				 controller.start();
			 }
		});
	}
}
