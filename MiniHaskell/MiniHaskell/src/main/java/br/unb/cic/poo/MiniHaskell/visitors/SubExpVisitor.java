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

public class SubExpVisitor implements Visitor{

	private int total = 0;
	
	public void init() {
		total = 0;
	}
	
	public void visitar(ValorInteiro exp) {
		total += 1; 
	}

	public void visitar(ValorBooleano exp) {
		total += 1; 
	}

	public void visitar(ExpressaoSoma exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);
	}

	public void visitar(IfThenElse exp) {
		total += 1;
		exp.condicao().aceitar(this);
		exp.expThen().aceitar(this);
		exp.expElse().aceitar(this);
	}
	
	public int getTotal() {
		return total;
	}

	public void visitar(ExpressaoLet exp) {
		// CONFERIR ?!?!?!?!??!
		exp.atribuicao().aceitar(this);
		exp.corpo().aceitar(this);
		
		
	}

	public void visitar(ExpressaoMultiplicacao exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);
	}

	public void visitar(ExpressaoIgualdade exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);		
	}

	public void visitar(ExpressaoMaiorIgual exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);			
	}

	public void visitar(ExpressaoMenorIgual exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);		
	}

	public void visitar(Fatorial exp) {
		/*Rever esse*/
		total += 1;
		exp.valor().aceitar(this);
	}

	public void visitar(ValorLista exp) {
		exp.aceitar(this);
		
	}
	
	public void visitar(AplicacaoDeFuncao exp) {
		exp.aceitar(this);
		
	}


}
