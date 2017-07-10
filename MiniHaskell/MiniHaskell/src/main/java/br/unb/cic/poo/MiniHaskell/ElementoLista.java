package br.unb.cic.poo.MiniHaskell;

public class ElementoLista {
	private ElementoLista prox;
	private ElementoLista ant;
	private Object element;

	public ElementoLista(ElementoLista prox, Object element) {
		this.prox = prox;
		this.element = element;
	}

	public ElementoLista(Object element) {
		this.element = element;
	}
	
	public void setProx(ElementoLista prox) {
		this.prox = prox;
	}
	
	public ElementoLista getProx() {
		return prox;
	}
	
	public void setAnt(ElementoLista ant) {
	    this.ant = ant;
	}
	
	public ElementoLista getAnt() {
	    return ant;
	}
	
	public Object getElement() {
		return element;
	}
	  
}
