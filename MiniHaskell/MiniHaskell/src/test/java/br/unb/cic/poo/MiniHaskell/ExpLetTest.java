package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class ExpLetTest extends TestCase {

	public void testTrivialLet() {
		Expressao let = new ExpressaoLet("x", new ValorInteiro(5), new ValorInteiro(10));
	
		ValorInteiro res = (ValorInteiro)let.avaliar();
		assertEquals(new Integer(10), res.getValor());
	}
	
	public void testNotSoTrivialTest() {
		Expressao let = new ExpressaoLet("x", new ValorInteiro(5), 
				new ExpressaoSoma(new ExpRef("x"), new ValorInteiro(1)));
		
		ValorInteiro res = (ValorInteiro)let.avaliar();
		
		assertEquals(new Integer(6), res.getValor());
	}
	
	public void testNotTrivial() {
		Expressao let1 = new ExpressaoLet("x", new ValorInteiro(10), 
				new ExpressaoSoma(new ExpRef("x"), new ValorInteiro(1)));
		
		Expressao let2 = new ExpressaoLet("x",
				new ValorInteiro(5),
				new ExpressaoSoma(let1, new ExpRef("x")));
	
		ValorInteiro res = (ValorInteiro)let2.avaliar();
		
		assertEquals(new Integer(16), res.getValor());
	}
	
	public void testNotTrivialMore() {
		Expressao let1 = new ExpressaoLet("x", new ValorInteiro(3), 
				new Fatorial(new ExpRef("x")));
		
		Expressao let2 = new ExpressaoLet("x",
				new ValorInteiro(5),
				new ExpressaoSoma(let1, new ExpRef("x")));
		
		Expressao let3 = new ExpressaoLet("x",
				new ValorInteiro(9),
				new ExpressaoSoma(let2, new ExpRef("x")));
	
		ValorInteiro res = (ValorInteiro)let3.avaliar();
		
		assertEquals(new Integer(20), res.getValor());
	}
	
	public void testTipo(){
		Expressao let1 = new ExpressaoLet("x", new ValorInteiro(1), 
				new ExpressaoSoma(new ExpRef("x"), new ValorInteiro(1)));
		assertEquals(new Boolean(false), (Boolean)let1.checarTipo());
		
		Expressao let2 = new ExpressaoLet("x",
				new ValorInteiro(5),
				new ExpressaoSoma(let1, new ExpRef("x")));
		
		assertEquals( let2.checarTipo(), let1.checarTipo());
	}
	
}
