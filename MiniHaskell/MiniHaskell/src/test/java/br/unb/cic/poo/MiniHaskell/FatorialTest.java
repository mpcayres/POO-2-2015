package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class FatorialTest extends TestCase {

	public void testExpFatorial() {
		Expressao v2 = new ValorInteiro(2);
		Expressao v5 = new ValorInteiro(5);
		Expressao fat = new Fatorial(v2);
		
		ValorInteiro res = (ValorInteiro)fat.avaliar();
		assertEquals(new Integer(2), res.getValor());
		
		fat = new Fatorial(v5);
		res = (ValorInteiro)fat.avaliar();
		assertEquals(new Integer(120), res.getValor());
	}
	
	public void testExpFatErroTipo() {
		Expressao vTrue = new ValorBooleano(true);
		Expressao soma = new Fatorial(vTrue);
		
		try {
			soma.avaliar(); //Valor res = 
			fail();
		}
		catch(RuntimeException e) {
			assertTrue(true);
		}
	}
}
