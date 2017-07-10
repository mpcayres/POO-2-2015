package br.unb.cic.lp.gol;


/**
 * Classe que atua como um controlador do 
 * padrao MVC, separando os componentes da 
 * camada de apresentacao e model. 
 * 
 */
public class GameController {

	private GameEngine engine;
	private GameView board;

	public void setEngine(GameEngine engine) {
		this.engine = engine;
	}
	

	public void setBoard(GameView board) {
		this.board = board;
		board.setSize();
	}
	

	public void start() {
		board.initBoard();
	}
	
	public void nextGeneration() {
		engine.nextGeneration();
		board.update();
	}
	
}
