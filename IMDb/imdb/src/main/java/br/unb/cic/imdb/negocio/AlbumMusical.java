package br.unb.cic.imdb.negocio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ALBUM_MUSICAL")
public class AlbumMusical extends TrabalhoArtistico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@ManyToMany
	private List<FaixaMusical> listaFaixas;
	
	public AlbumMusical() { }
	
	public AlbumMusical(String titulo, int ano, List<FaixaMusical> listaFaixas) {
		super(titulo, ano);
		this.listaFaixas = listaFaixas;
	}
	
	public AlbumMusical(String titulo, int ano, Autor autor, Genero gen, List<FaixaMusical> listaFaixas, List<Avaliacao> avals) {
		super(titulo, ano, gen, autor, avals);
		this.listaFaixas = listaFaixas;
	}

	public void addFaixa(FaixaMusical faixa){
		listaFaixas.add(faixa);
	}

	public List<FaixaMusical> getListaFaixas() {
		return listaFaixas;
	}

	public void setListaFaixas(List<FaixaMusical> listaFaixas) {
		this.listaFaixas = listaFaixas;
	}
	
	public Long getId() {
		return id;
	}
	
}
