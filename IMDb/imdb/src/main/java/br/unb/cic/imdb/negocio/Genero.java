package br.unb.cic.imdb.negocio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_GENERO")
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String titulo;
	
	@Column
	private String descricao;
	
	@OneToMany(mappedBy="genero")
	private List<AlbumMusical> producaoMusical;
	
	@OneToMany(mappedBy="genero")
	private List<Filme> producaoArtistica;
	
	public Genero() { } 
	
	public Genero(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}
	
	public void adicionaFilme(Filme contribuicao) {
		producaoArtistica.add(contribuicao);
	}
	
	public List<Filme> getFilmes() {
		return producaoArtistica;
	}

	public void setFilmes(List<Filme> producaoArtistica) {
		this.producaoArtistica = producaoArtistica;
	}
	
	public void adicionaAlbum(AlbumMusical contribuicao) {
		producaoMusical.add(contribuicao);
	}
	
	public List<AlbumMusical> getAlbuns() {
		return producaoMusical;
	}

	public void setAlbuns(List<AlbumMusical> producaoArtistica) {
		this.producaoMusical = producaoArtistica;
	}
	
}
