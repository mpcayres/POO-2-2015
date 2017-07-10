package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.SubExpVisitor;
import junit.framework.TestCase;

public class SubExpVisitorTest extends TestCase {

	public void testSubExp() {
		Expressao v3 = new ValorInteiro(3);
		Expressao s1 = new ExpressaoSoma(new ValorInteiro(1), new ValorInteiro(2));
		Expressao s2 = new ExpressaoSoma(s1, v3);
		Expressao s3 = new Fatorial(v3);
		
		SubExpVisitor v = new SubExpVisitor();
		
		v3.aceitar(v);
		assertEquals(1, v.getTotal());
		
		v.init();
		
		s1.aceitar(v);
		assertEquals(3, v.getTotal());
		
		v.init();
		
		s2.aceitar(v);
		assertEquals(5, v.getTotal());
		
		v.init();
		
		s3.aceitar(v);
		assertEquals(2, v.getTotal());
	}
}
