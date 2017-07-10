package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class ExpressaoMenorIgualTest extends TestCase {

	public void testExpMenorIgual() {
		Expressao v10 = new ValorInteiro(10);
		Expressao v15 = new ValorInteiro(15);
		Expressao igual = new ExpressaoMenorIgual(v15, v10);
		
		ValorBooleano res = (ValorBooleano)igual.avaliar();
		assertEquals(new Boolean(false), res.getValor());
		
		igual = new ExpressaoMenorIgual(v10, v15);
		res = (ValorBooleano)igual.avaliar();
		assertEquals(new Boolean(true), res.getValor());
		
		igual = new ExpressaoMenorIgual(v15, v15);
		res = (ValorBooleano)igual.avaliar();
		assertEquals(new Boolean(true), res.getValor());
	}
	
	public void testExpMenorIgualErroTipo() {
		Expressao vTrue = new ValorBooleano(true);
		Expressao v10   = new ValorInteiro(10);
		Expressao soma = new ExpressaoMenorIgual(vTrue, v10);
		
		try {
			soma.avaliar(); //Valor res = 
			fail();
		}
		catch(RuntimeException e) {
			assertTrue(true);
		}
	}
}
