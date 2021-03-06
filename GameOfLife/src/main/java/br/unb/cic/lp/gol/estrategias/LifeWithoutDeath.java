package br.unb.cic.lp.gol.estrategias;

import br.unb.cic.lp.gol.EstrategiaDeDerivacao;
import br.unb.cic.lp.gol.GameEngine;

public class LifeWithoutDeath implements EstrategiaDeDerivacao {

	@Override
	public boolean shouldKeepAlive(int i, int j, GameEngine engine) {
		return true;
				
	}
	
	@Override
	public boolean shouldRevive(int i, int j, GameEngine engine) {
		return !engine.isCellAlive(i, j) &&
				engine.numberOfNeighborhoodAliveCells(i, j) == 3; 
	}
}
