package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class ExpressaoMaiorIgual extends ExpressaoBinInt {

	public ExpressaoMaiorIgual(Expressao lhs, Expressao rhs) {
		super(lhs, rhs);
	}

	@Override
	public Valor avaliar(Integer x, Integer y) {
		return new ValorBooleano(x >= y);
	}

	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}