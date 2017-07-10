package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class ExpressaoMaiorIgualTest extends TestCase {

	public void testExpMaiorIgual() {
		Expressao v10 = new ValorInteiro(10);
		Expressao v15 = new ValorInteiro(15);
		Expressao igual = new ExpressaoMaiorIgual(v10, v15);
		
		ValorBooleano res = (ValorBooleano)igual.avaliar();
		assertEquals(new Boolean(false), res.getValor());
		
		igual = new ExpressaoMaiorIgual(v15, v10);
		res = (ValorBooleano)igual.avaliar();
		assertEquals(new Boolean(true), res.getValor());
		
		igual = new ExpressaoMaiorIgual(v15, v15);
		res = (ValorBooleano)igual.avaliar();
		assertEquals(new Boolean(true), res.getValor());
	}
	
	public void testExpMaiorIgualErroTipo() {
		Expressao vTrue = new ValorBooleano(true);
		Expressao v10   = new ValorInteiro(10);
		Expressao soma = new ExpressaoMaiorIgual(vTrue, v10);
		
		try {
			soma.avaliar(); //Valor res = 
			fail();
		}
		catch(RuntimeException e) {
			assertTrue(true);
		}
	}
}