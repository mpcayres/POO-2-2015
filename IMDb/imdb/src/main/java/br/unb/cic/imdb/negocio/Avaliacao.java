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
@Table(name="TB_AVALIACAO")
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column
	private int escala;
	
	@Column
	private String comentario;
	
	@ManyToOne
	//@JoinColumn(name = "usuario")
	private Usuario usuario;
	
	@ManyToOne
	//@JoinColumn(name = "album")
	private AlbumMusical album;
	
	@ManyToOne
	//@JoinColumn(name = "filme")
	private Filme filme;
	
	public Avaliacao() { }

	public Avaliacao(int escala, String comentario, Usuario usuario, AlbumMusical album) {
		this.escala = escala;
		this.comentario = comentario;
		this.usuario = usuario;
		this.album = album;
	}
	
	public Avaliacao(int escala, String comentario, Usuario usuario, Filme filme) {
		this.escala = escala;
		this.comentario = comentario;
		this.usuario = usuario;
		this.filme = filme;
	}

	public int getEscala() {
		return escala;
	}

	public void setEscala(int escala) {
		this.escala = escala;
	}
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public AlbumMusical getAlbum() {
		return album;
	}

	public void setAlbum(AlbumMusical trabalho) {
		this.album = trabalho;
	}
	
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme trabalho) {
		this.filme = trabalho;
	}

	public Long getId() {
		return id;
	}

}
