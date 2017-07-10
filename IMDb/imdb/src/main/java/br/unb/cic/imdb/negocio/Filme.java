package br.unb.cic.imdb.negocio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_FILME")
public class Filme extends TrabalhoArtistico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column
	private int duracao;
	
	public Filme() { }
	
	public Filme(String titulo, int ano, int duracao, Autor autor, Genero gen, List<Avaliacao> avals) {
		super(titulo, ano, gen, autor, avals);
		this.duracao = duracao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public Long getId() {
		return id;
	}
}
