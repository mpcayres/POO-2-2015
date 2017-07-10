package br.unb.cic.lp.gol;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Representa um ambiente (environment) do jogo GameOfLife;
 * Essa implementacao segue o padrao de projeto Strategy, e a 
 * classe GameEngine possui uma referencia para uma estrategia de 
 * derivacao que pode ser alterada durante a execucao do jogo. 
 */
public class GameEngine {
	private int height;
	private int width;
	private Cell[][] cells;
	private Statistics statistics;
	private EstrategiaDeDerivacao estrategia;

	/**
	 * Construtor da classe Environment.
	 * 
	 * @param height
	 *            dimensao vertical do ambiente
	 * @param width
	 *            dimentsao horizontal do ambiente
	 */
	public GameEngine(Statistics statistics) {	
		this.statistics = statistics;
	}
	
	public void setEngine(int height, int width){
		this.height = height;
		this.width = width;

		cells = new Cell[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				cells[i][j] = new Cell();
			}
		}
	}
	
	public void setEstrategia(EstrategiaDeDerivacao e) {
		estrategia = e;
	}

	/**
	 * Calcula uma nova geracao do ambiente. Essa implementacao delega para 
	 * a estrategia de derivacao a logica necessaria para identificar 
	 * se uma celula deve se tornar viva ou ser mantida viva na proxima 
	 * geracao. 
	 */
	public void nextGeneration() {
		List<Cell> mustRevive = new ArrayList<Cell>();
		List<Cell> mustKill = new ArrayList<Cell>();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (estrategia.shouldRevive(i, j, this)) {
					mustRevive.add(cells[i][j]);
				} 
				else if ((!estrategia.shouldKeepAlive(i, j, this)) && cells[i][j].isAlive()) {
					mustKill.add(cells[i][j]);
				}
			}
		}
		
		updateStatistics(mustRevive, mustKill);
	}

	/*
	 * Metodo auxiliar que atualiza as estatisticas das celulas 
	 * que foram mortas ou se tornaram vivas entre duas geracoes. 
	 */
	private void updateStatistics(List<Cell> mustRevive, List<Cell> mustKill) {
		for (Cell cell : mustRevive) {
			cell.revive();
			statistics.recordRevive();
		}
		
		for (Cell cell : mustKill) {
			cell.kill();
			statistics.recordKill();
		}
	}
	
	/**
	 * Torna a celula de posicao (i, j) viva
	 * 
	 * @param i posicao vertical da celula
	 * @param j posicao horizontal da celula
	 * 
	 * @throws InvalidParameterException caso a posicao (i, j) nao seja valida.
	 */
	public void makeCellAlive(int i, int j) throws InvalidParameterException {
		if(validPosition(i, j)) {
			cells[i][j].revive();
			statistics.recordRevive();
		}
		else {
			new InvalidParameterException("Invalid position (" + i + ", " + j + ")" );
		}
	}
	
	public void makeCellDead(int i, int j) throws InvalidParameterException {
		if(validPosition(i, j)) {
			cells[i][j].kill();
			statistics.recordKill();
		}
		else {
			new InvalidParameterException("Invalid position (" + i + ", " + j + ")" );
		}
	}
	
	/**
	 * Verifica se uma celula na posicao (i, j) estah viva.
	 * 
	 * @param i Posicao vertical da celula
	 * @param j Posicao horizontal da celula
	 * @return Verdadeiro caso a celula de posicao (i,j) esteja viva.
	 * 
	 * @throws InvalidParameterException caso a posicao (i,j) nao seja valida. 
	 */
	public boolean isCellAlive(int i, int j) throws InvalidParameterException {
		if(validPosition(i, j)) {
			return cells[i][j].isAlive();
		}
		else {
			throw new InvalidParameterException("Invalid position (" + i + ", " + j + ")" );
		}
	}

	/**
	 * Retorna o numero de celulas vivas no ambiente. 
	 * Esse metodo eh particularmente util para o calculo de 
	 * estatisticas e para melhorar a testabilidade.
	 * 
	 * @return  numero de celulas vivas.
	 */
	public int numberOfAliveCells() {
		int aliveCells = 0;
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(isCellAlive(i,j)) {
					aliveCells++;
				}
			}
		}
		return aliveCells;
	}

	/*
	 * Computa o numero de celulas vizinhas vivas, dada uma posicao no ambiente
	 * de referencia identificada pelos argumentos (i,j).
	 */
	public int numberOfNeighborhoodAliveCells(int i, int j) {
		int alive = 0, auxa, auxb;
		for (int a = i - 1; a <= i + 1; a++) {
			for (int b = j - 1; b <= j + 1; b++) {
				if (validPosition(a, b)) {
						if((!(a==i && b == j)) && cells[a][b].isAlive()) {
								alive++;
						}
				} else if (a == -1 || a == height || b == -1 || b == width) {
					auxa = a; auxb = b;
					if(a == -1){
						auxa = (height-1);
					}
					if(a == height){
						auxa = 0;
					}
					if(b == -1){
						auxb = (width-1);
					}
					if(b == width){
						auxb = 0;
					}
					if((!(auxa==i && auxb == j)) && cells[auxa][auxb].isAlive()) {
						alive++;
					}
		
				}
			}
		}
		return alive;
	}

	/*
	 * Verifica se uma posicao (a, b) referencia uma celula valida no tabuleiro.
	 */
	private boolean validPosition(int a, int b) {
		return a >= 0 && a < height && b >= 0 && b < width;
	}
	
	public void randomizar(){
		Random gerador = new Random();
		int count = height * width / 5;
        for (int k = 0; k < count; k++) {
            int i = gerador.nextInt(height);
            int j = gerador.nextInt(width);
            if(!isCellAlive(i, j)){
            	makeCellAlive(i, j);
            }
        }
	}
}
