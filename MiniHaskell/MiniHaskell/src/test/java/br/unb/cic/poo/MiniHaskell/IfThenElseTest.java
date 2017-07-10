package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class IfThenElseTest extends TestCase {
	
	public void testIfThenElse(){
		Expressao v1 = new ValorInteiro(15);
		Expressao v2 = new ValorInteiro(15);
		Expressao v3 = new ValorInteiro(5);
		Expressao igual = new ExpressaoIgualdade(v1, v2);
		Expressao igual2 = new ExpressaoIgualdade(v1, v3);
	
		igual.avaliar();
		Expressao soma = new ExpressaoSoma(v1, v2);
		Expressao soma2 = new ExpressaoSoma(v1, v3);
	
		Expressao ifthenelse = new IfThenElse(igual.avaliar(),soma, soma2);
		ValorInteiro res = (ValorInteiro)ifthenelse.avaliar();

		assertEquals((Boolean)ifthenelse.checarTipo(), (Boolean)true);
		assertEquals(res.getValor(), (Integer) 30);
		
		
		Expressao ifthenelse2 = new IfThenElse(igual2.avaliar(),soma, soma2);
		ValorInteiro res2 = (ValorInteiro)ifthenelse2.avaliar();
		
		assertEquals((Boolean)ifthenelse2.checarTipo(), (Boolean)true);
		assertEquals(res2.getValor(), (Integer) 20);
		
		
	}

}