package br.unb.cic.lp.gol;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

import br.unb.cic.lp.gol.estrategias.Conway;
import br.unb.cic.lp.gol.estrategias.HighLife;
import br.unb.cic.lp.gol.estrategias.LifeWithoutDeath;
import br.unb.cic.lp.gol.estrategias.LiveFreeOrDie;
import br.unb.cic.lp.gol.estrategias.Maze;
import br.unb.cic.lp.gol.estrategias.Mazectric;
import br.unb.cic.lp.gol.estrategias.Move;
import br.unb.cic.lp.gol.estrategias.Replicator;
import br.unb.cic.lp.gol.estrategias.Seeds;

/*Classe que permite a injeção dos métodos ao invés de instancia-los diretamente*/
public class AdicionarEstrategia implements Module{
	public void configure(Binder binder) {
		binder.bind(EstrategiaDeDerivacao.class).annotatedWith(Names.named("Conway")).to(Conway.class);
		binder.bind(EstrategiaDeDerivacao.class).annotatedWith(Names.named("HighLife")).to(HighLife.class);
		binder.bind(EstrategiaDeDerivacao.class).annotatedWith(Names.named("LiveFOrD")).to(LiveFreeOrDie.class);
		binder.bind(EstrategiaDeDerivacao.class).annotatedWith(Names.named("Maze")).to(Maze.class);
		binder.bind(EstrategiaDeDerivacao.class).annotatedWith(Names.named("Move")).to(Move.class);
		binder.bind(EstrategiaDeDerivacao.class).annotatedWith(Names.named("Seeds")).to(Seeds.class);
		binder.bind(EstrategiaDeDerivacao.class).annotatedWith(Names.named("LifeWithoutDeath")).to(LifeWithoutDeath.class);
		binder.bind(EstrategiaDeDerivacao.class).annotatedWith(Names.named("Mazectric")).to(Mazectric.class);
		binder.bind(EstrategiaDeDerivacao.class).annotatedWith(Names.named("Replicator")).to(Replicator.class);
	}

}