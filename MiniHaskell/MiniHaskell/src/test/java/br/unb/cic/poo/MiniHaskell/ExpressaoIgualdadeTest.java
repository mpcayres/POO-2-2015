package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class ExpressaoIgualdadeTest extends TestCase {

	public void testExpIgualdade() {
		Expressao v10 = new ValorInteiro(10);
		Expressao v15 = new ValorInteiro(15);
		Expressao igual = new ExpressaoIgualdade(v10, v15);
		
		ValorBooleano res = (ValorBooleano)igual.avaliar();
		
		assertEquals(new Boolean(false), res.getValor());
		
		igual = new ExpressaoIgualdade(v15, v15);
		res = (ValorBooleano)igual.avaliar();
		
		assertEquals(new Boolean(true), res.getValor());
	}
	
	public void testExpIgualErroTipo() {
		Expressao vTrue = new ValorBooleano(true);
		Expressao v10   = new ValorInteiro(10);
		Expressao soma = new ExpressaoIgualdade(vTrue, v10);
		
		try {
			soma.avaliar(); //Valor res = 
			fail();
		}
		catch(RuntimeException e) {
			
			assertTrue(true);
		}
	}
}