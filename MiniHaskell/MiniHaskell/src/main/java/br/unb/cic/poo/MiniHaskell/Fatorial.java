package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class Fatorial extends Expressao {
	private Expressao valor;

	public Fatorial(Expressao valor) {
		this.valor = valor;
	}
	
	public Valor avaliar() {
		Valor x = valor.avaliar();
		if (x instanceof ValorInteiro) {
			Integer x1 = ((ValorInteiro) x).getValor();
			return avaliar(x1);
		} else {
			throw new RuntimeException("erro de tipos");
		}
	}

	public Valor avaliar(Integer x) {
		Expressao vX = new ValorInteiro(x);
		Expressao v0 = new ValorInteiro(0);
		Expressao menorIgual = new ExpressaoMenorIgual(vX, v0);
		ValorBooleano res = (ValorBooleano)menorIgual.avaliar();
		
		if(res.getValor()) {
			return new ValorInteiro(1);
		}
		else {
			Expressao vN1 = new ValorInteiro(-1);
			Expressao subt = new ExpressaoSoma(vX, vN1);
			ValorInteiro resS = (ValorInteiro)subt.avaliar();
			
			Expressao mult = new ExpressaoMultiplicacao(vX, avaliar(resS.getValor()));
			ValorInteiro resM = (ValorInteiro)mult.avaliar();
			
			return resM;
		}
	}

	public void aceitar(Visitor v) {
		v.visitar(this);
	}

	@Override
	public boolean checarTipo() {
		if(valor.tipo().equals(Tipo.INTEIRO)) {
			return true;
		}
		return false;
	}

	@Override
	public Tipo tipo() {
		if(checarTipo()) {
			return Tipo.INTEIRO;
		}
		return Tipo.ERROR;
	}
	
	public Expressao valor() {
		return valor;
	}

}
