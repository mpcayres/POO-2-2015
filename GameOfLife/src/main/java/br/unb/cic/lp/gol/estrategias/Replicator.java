package br.unb.cic.lp.gol.estrategias;

import br.unb.cic.lp.gol.EstrategiaDeDerivacao;
import br.unb.cic.lp.gol.GameEngine;


public class Replicator implements EstrategiaDeDerivacao {

	@Override
	public boolean shouldKeepAlive(int i, int j, GameEngine engine) {
		return engine.isCellAlive(i, j) && 
				(engine.numberOfNeighborhoodAliveCells(i, j)% 2) == 1;
	}

	@Override
	public boolean shouldRevive(int i, int j, GameEngine engine) {
		return !engine.isCellAlive(i, j) &&
				(engine.numberOfNeighborhoodAliveCells(i, j)% 2) == 1;
	}

}