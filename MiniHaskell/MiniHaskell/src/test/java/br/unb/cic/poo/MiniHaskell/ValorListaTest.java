package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class ValorListaTest extends TestCase {
	public void testValorLista() {
		ValorLista vfList = new ValorLista();
		
		vfList.addInicio(1); vfList.addFim(2);
		assertEquals(vfList.elemExiste(2), true);
		assertEquals(vfList.toString(), "[1, 2]");
		
		vfList.add(3, 2); vfList.add(4, 0);
		assertEquals(vfList.size(), 4);
		assertEquals(vfList.toString(), "[4, 1, 2, 3]");
		
		vfList.add(6, 0);
		assertEquals(vfList.size(), 5);
		assertEquals(vfList.toString(), "[6, 4, 1, 2, 3]");
		
		vfList.removeInicio(); vfList.removeFim();
		assertEquals(vfList.size(), 3);
		assertEquals(vfList.toString(), "[4, 1, 2]");
		
		vfList.remove(1); vfList.remove(0);
		assertEquals(vfList.size(), 1);
		assertEquals(vfList.toString(), "[2]");
		
		vfList.clear();
		assertEquals(vfList.isEmpty(), true);
		
		vfList.avaliar();
		
	}
	
}
