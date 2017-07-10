package br.unb.cic.poo.MiniHaskell.visitors;

import br.unb.cic.poo.MiniHaskell.AplicacaoDeFuncao;
import br.unb.cic.poo.MiniHaskell.ExpressaoIgualdade;
import br.unb.cic.poo.MiniHaskell.ExpressaoLet;
import br.unb.cic.poo.MiniHaskell.ExpressaoMaiorIgual;
import br.unb.cic.poo.MiniHaskell.ExpressaoMenorIgual;
import br.unb.cic.poo.MiniHaskell.ExpressaoMultiplicacao;
import br.unb.cic.poo.MiniHaskell.ExpressaoSoma;
import br.unb.cic.poo.MiniHaskell.Fatorial;
import br.unb.cic.poo.MiniHaskell.IfThenElse;
import br.unb.cic.poo.MiniHaskell.ValorBooleano;
import br.unb.cic.poo.MiniHaskell.ValorInteiro;
import br.unb.cic.poo.MiniHaskell.ValorLista;

public interface Visitor {
	public void visitar(ValorInteiro exp);
	public void visitar(ValorBooleano exp);
	public void visitar(ExpressaoSoma exp);
	public void visitar(ExpressaoMultiplicacao exp);
	public void visitar(IfThenElse exp);
	public void visitar(ExpressaoLet exp);
	public void init();
	public void visitar(ExpressaoIgualdade exp);
	public void visitar(ExpressaoMaiorIgual exp);
	public void visitar(ExpressaoMenorIgual exp);
	public void visitar(Fatorial exp);
	public void visitar(ValorLista exp);
	public void visitar(AplicacaoDeFuncao exp);
}
