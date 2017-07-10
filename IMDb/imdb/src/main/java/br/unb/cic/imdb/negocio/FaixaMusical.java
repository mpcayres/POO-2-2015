package br.unb.cic.imdb.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_FAIXA_MUSICAL")
public class FaixaMusical {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String titulo;
	
	@Column
	private int duracao;
	
	@ManyToOne
	@JoinColumn(name = "album")
	private AlbumMusical album;
	
	public FaixaMusical() { }
	
	public FaixaMusical(String titulo, int duracao) {
		this.titulo = titulo;
		this.duracao = duracao;
	}
	
	public FaixaMusical(String titulo, int duracao, AlbumMusical album) {
		this.titulo = titulo;
		this.duracao = duracao;
		this.album = album;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public AlbumMusical getAlbum() {
		return album;
	}

	public void setAlbum(AlbumMusical album) {
		this.album = album;
	}

	public Long getId() {
		return id;
	}

}
