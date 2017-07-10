package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unb.cic.imdb.integracao.DAOAlbum;
import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.FaixaMusical;
import br.unb.cic.imdb.negocio.Genero;

public class DAOAlbumJPA implements DAOAlbum {
	
	private EntityManager em;

	@Override
	public void salvar(AlbumMusical trabalho) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(trabalho);
		em.getTransaction().commit();
	}

	@Override
	public List<AlbumMusical> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM AlbumMusical").getResultList();
	}

	@Override
	public AlbumMusical recuperaPorTitulo(String titulo) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<AlbumMusical> trabalhos = em.createQuery("FROM AlbumMusical WHERE "
				+ "titulo = :tituloParam").setParameter("tituloParam", titulo).getResultList();
		return trabalhos.size() == 1 ? trabalhos.get(0): null;
	}
	
	@Override
	public List<AlbumMusical> recuperaPorAutor(String autor) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<AlbumMusical> trabalhos = em.createQuery("FROM AlbumMusical WHERE "
				+ "autor = :tituloParam").setParameter("tituloParam", autor).getResultList();
		return trabalhos.size() == 1 ? trabalhos: null;
	}
	
	@Override
	public List<AlbumMusical> recuperaPorGenero(String genero) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<AlbumMusical> trabalhos = em.createQuery("FROM AlbumMusical WHERE "
				+ "genero = :tituloParam").setParameter("tituloParam", genero).getResultList();
		return trabalhos.size() == 1 ? trabalhos: null;
	}

	@Override
	public AlbumMusical recuperaPorId(Long id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<AlbumMusical> trabalhos = em.createQuery("FROM AlbumMusical WHERE "
				+ "id = :tituloParam").setParameter("tituloParam", id).getResultList();
		return trabalhos.size() == 1 ? trabalhos.get(0): null;
	}

	@Override
	public void editar(Long id, String titulo, int ano, Autor autor, Genero genero, List<FaixaMusical> listaFaixas) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		Query query =  em.createQuery("UPDATE AlbumMusical SET "
				+ "titulo = :tituloParam, ano = :anoParam, autor = :autorParam, "
				+ "genero = :genParam, listaFaixas = :faixaParam "
				+ "WHERE id = :idParam");
		query.setParameter("idParam", id);
		query.setParameter("tituloParam", titulo);
		query.setParameter("anoParam", ano);
		query.setParameter("autorParam", autor);
		query.setParameter("genParam", genero);
		query.setParameter("faixaParam", listaFaixas);
		query.executeUpdate();
		em.getTransaction().commit();
		em.getTransaction().commit();
	}

	@Override
	public void deletar(AlbumMusical trabalho) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		Query query =  em.createQuery("DELETE AlbumMusical WHERE id = :idParam");
		query.setParameter("idParam", trabalho.getId());
		query.executeUpdate();
		em.getTransaction().commit();
	}

}
