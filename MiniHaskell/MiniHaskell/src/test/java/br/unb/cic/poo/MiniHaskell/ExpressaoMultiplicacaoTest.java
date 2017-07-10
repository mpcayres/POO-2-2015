package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class ExpressaoMultiplicacaoTest extends TestCase {

	public void testExpMult() {
		Expressao v10 = new ValorInteiro(10);
		Expressao v15 = new ValorInteiro(15);
		Expressao mult = new ExpressaoMultiplicacao(v10, v15);
		
		ValorInteiro res = (ValorInteiro)mult.avaliar();
		
		assertEquals(new Integer(150), res.getValor());
		
		mult = new ExpressaoMultiplicacao(mult, v10);
		res = (ValorInteiro)mult.avaliar();
		
		assertEquals(new Integer(1500), res.getValor());
	}
	
	public void testExpMultErroTipo() {
		Expressao vTrue = new ValorBooleano(true);
		Expressao v10   = new ValorInteiro(10);
		Expressao mult = new ExpressaoMultiplicacao(vTrue, v10);
		
		try {
			mult.avaliar(); //Valor res = 
			fail();
		}
		catch(RuntimeException e) {
			assertTrue(true);
		}
	}
}

