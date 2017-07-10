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

public class PrettyPrinter implements Visitor {

	String res = "";
	
	public String getRes() {
		return res;
	}
	
	public void visitar(ValorInteiro exp) {
		res += exp.getValor();
	}

	public void visitar(ValorBooleano exp) {
		res += exp.getValor();
	}

	public void visitar(ExpressaoSoma exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " + ";
		exp.rhs().aceitar(this);
		res += ")";
	}

	public void visitar(IfThenElse exp) {
		res += "if(";
		exp.condicao().aceitar(this);
		res += ")";
		res += " then {";
		exp.expThen().aceitar(this);
		res += " } else {";
		exp.expElse().aceitar(this);
		res += "}";
	}

	public void init() {
		res = "";
	}

	public void visitar(ExpressaoLet exp) {
		/*Rever isso*/
		res += "let ";
		exp.atribuicao().aceitar(this);
		res += " = ";
		exp.corpo().aceitar(this);
	}

	public void visitar(ExpressaoMultiplicacao exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " * ";
		exp.rhs().aceitar(this);
		res += ")";
	}

	public void visitar(ExpressaoIgualdade exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " == ";
		exp.rhs().aceitar(this);
		res += ")";
	}

	public void visitar(ExpressaoMaiorIgual exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " >= ";
		exp.rhs().aceitar(this);
		res += ")";		
	}

	public void visitar(ExpressaoMenorIgual exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " <= ";
		exp.rhs().aceitar(this);
		res += ")";
	}

	public void visitar(Fatorial exp) {
		res += "(";
		exp.valor().aceitar(this);
		res += "!";
		res += ")";
	}

	public void visitar(ValorLista exp) {
		exp.toString();
		
	}
	
	public void visitar(AplicacaoDeFuncao exp) {
		// TODO Auto-generated method stub
		
	}

}
