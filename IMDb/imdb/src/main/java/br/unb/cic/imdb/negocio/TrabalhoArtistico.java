package br.unb.cic.imdb.negocio;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public abstract class TrabalhoArtistico {
	
	@Column
	private String titulo;
	
	@Column
	private int ano;
	
	@ManyToOne
	//@JoinColumn(name = "genero")
	private Genero genero;
	
	@ManyToOne
	//@JoinColumn(name = "autor")
	private Autor autor;
	
	@OneToMany //(mappedBy = "trabalho", targetEntity = Avaliacao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JoinColumn(name = "avaliacoes")
	private List<Avaliacao> avaliacoes;
	
	public TrabalhoArtistico() { }
	
	public TrabalhoArtistico(String titulo, int ano){
		this.titulo = titulo;
		this.ano = ano;
	}
	
	public TrabalhoArtistico(String titulo, int ano, Genero genero, Autor autor, List<Avaliacao> avaliacoes) {
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
		this.autor = autor;
		this.avaliacoes = avaliacoes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public void addAvaliacao(Avaliacao avaliacao){
		avaliacoes.add(avaliacao);
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
}
