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
@Table(name="TB_AUTOR")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String descricao;
	
	@OneToMany(mappedBy="autor")
	private List<AlbumMusical> producaoMusical;
	
	@OneToMany(mappedBy="autor")
	private List<Filme> producaoArtistica;
	
	public Autor() { }
	
	public Autor(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao; 
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Long getId() {
		return id;
	}

}
