package br.unb.cic.lp.gol;

/**
 * Interface com a declaracao dos metodos  que apoiam o 
 * calculo de uma proxima derivacao no GameOfLife. 
 * 
 */
public interface EstrategiaDeDerivacao {	
	/**
	 * Verifica se uma celula (na posica (i, j)) deve 
	 * ser mantida viva. 
	 * 
	 * @param i posicao da celula na ith linha
	 * @param j posicao da celula na jth coluna 
	 * 
	 * @param engine referencia para a Game Engine
	 * 
	 * @return <i>true</i> caso a celula deva ser mantida viva. <i>false</i> caso contrario. 
	 */
	public boolean shouldKeepAlive(int i, int j, GameEngine engine);
	
	/**
	 * Verifica se uma celula (na posica (i, j)) deve 
	 * se tornar uma celula viva. 
	 * 
	 * @param i posicao da celula na ith linha
	 * @param j posicao da celula na jth coluna 
	 * 
	 * @param engine referencia para a Game Engine
	 * 
	 * @return <i>true</i> caso a celula deva se tornar viva. <i>false</i> caso contrario. 
	 */
	public boolean shouldRevive(int i, int j, GameEngine engine);
}
