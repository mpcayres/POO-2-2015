package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class ValorLista extends Valor{
	private ElementoLista primeira;  
	private ElementoLista ultima;
	private int size;
	
	public ValorLista(){
		this.size = 0;
		this.primeira = null;
		this.ultima = null;
	}
	
	public ValorLista(Object valor){
		this.size = 0;
		addInicio(valor);
	}

	public Tipo tipo() {
		return Tipo.LISTA;
	}

	public void aceitar(Visitor v) {
		v.visitar(this);
	}

	@Override
	boolean checarTipo() {
		return true;
	}
	
	public void addInicio(Object valor){
		if(this.size == 0){
			ElementoLista nova = new ElementoLista(valor);
		    this.primeira = nova;
		    this.ultima = nova;
		} else {
			ElementoLista nova = new ElementoLista(this.primeira, valor);
		    this.primeira.setAnt(nova);
		    this.primeira = nova;
		}
		this.size++;
	}
	
	public void addFim(Object valor){
		if (this.size == 0) {
		    this.addInicio(valor);
		} else {
			ElementoLista nova = new ElementoLista(valor);
		    this.ultima.setProx(nova);
		    nova.setAnt(this.ultima);
		    this.ultima = nova;
		    this.size++;
		}
	}
	
	public void add(Object valor, int pos) {
		if(pos == 0){
		    this.addInicio(valor);
		} else if(pos == this.size){
		    this.addFim(valor);
		} else {
			ElementoLista anterior = this.encontraCelula(pos - 1);
			ElementoLista proxima = anterior.getProx();
			ElementoLista nova = new ElementoLista(anterior.getProx(), valor);
		    nova.setAnt(anterior);
		    anterior.setProx(nova);
		    proxima.setAnt(nova);
		    this.size++;
		}
	}
	
	public void removeInicio() {
		if (!this.posNotEmpty(0)) {
			throw new IllegalArgumentException("Posição não existe");
		}

		this.primeira = this.primeira.getProx();
		this.size--;
		  
		if (this.size == 0) {
			this.ultima = null;
		}
	}
	
	public void removeFim() {
		if (!this.posNotEmpty(this.size - 1)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		if (this.size == 1) {
		    this.removeInicio();
		} else {
			ElementoLista penultima = this.ultima.getAnt();
		    penultima.setProx(null);
		    this.ultima = penultima;
		    this.size--;
		}
	}
	
	public void remove(int posicao) {
		if (!this.posNotEmpty(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}

		if (posicao == 0) {
		    this.removeInicio();
		} else if (posicao == this.size - 1) {
		    this.removeFim();
		} else {
			ElementoLista anterior = this.encontraCelula(posicao - 1);
			ElementoLista atual = anterior.getProx();
			ElementoLista proxima = atual.getProx();
		    
		    anterior.setProx(proxima);
		    proxima.setAnt(anterior);
		    
		    this.size--;
		}
	}
	
	private boolean posNotEmpty(int posicao){
		return posicao >= 0 && posicao < this.size;
	}

	private ElementoLista encontraCelula(int posicao) {
		if(!this.posNotEmpty(posicao)){
			throw new IllegalArgumentException("Posição não existe");
		}

		ElementoLista atual = primeira;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProx();
		}
		return atual;
	}
	
	public boolean elemExiste(Object elemento) {
		ElementoLista atual = this.primeira;

		while (atual != null) {
			if (atual.getElement().equals(elemento)) {
				return true;
		    }
		    atual = atual.getProx();
		}
		return false;
	}
		  
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public void clear(){
		final int original = this.size - 1;
		for (int i = 0; i < original; i++) {
		  		removeInicio();
		}
		removeInicio();
	}
	
	public String toString() {
		  if(isEmpty()){
		    return "[]";
		  }
		  
		  StringBuilder builder = new StringBuilder("[");
		  ElementoLista atual = primeira;

		  for (int i = 0; i < this.size - 1; i++) {
		  		builder.append(atual.getElement());
		  		builder.append(", ");
		  		atual = atual.getProx();
		  }

		  builder.append(atual.getElement());
		  builder.append("]");
		  
		  return builder.toString();
	}

}
