package br.unb.cic.lp.gol.estrategias;

import br.unb.cic.lp.gol.GameEngine;

public class HighLife extends Conway {	
	
	@Override
	public boolean shouldRevive(int i, int j, GameEngine engine) {
		return !engine.isCellAlive(i, j) &&
				(engine.numberOfNeighborhoodAliveCells(i, j) == 3 ||
				 engine.numberOfNeighborhoodAliveCells(i, j) == 6);
	}
	

	
}
