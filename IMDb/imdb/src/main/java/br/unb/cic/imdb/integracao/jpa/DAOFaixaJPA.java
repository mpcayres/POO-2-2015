package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unb.cic.imdb.integracao.DAOFaixa;
import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.FaixaMusical;

public class DAOFaixaJPA implements DAOFaixa {
	
	private EntityManager em;

	@Override
	public void salvar(FaixaMusical faixa) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(faixa);
		em.getTransaction().commit();
	}

	@Override
	public List<FaixaMusical> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM FaixaMusical").getResultList();
	}
	
	@Override
	public FaixaMusical recuperaPorTitulo(String titulo) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<FaixaMusical> faixas = em.createQuery("FROM FaixaMusical "
				+ "WHERE titulo = :tituloParam").setParameter("tituloParam", titulo).getResultList();
		return faixas.size() == 1 ? faixas.get(0): null;
	}

	@Override
	public List<FaixaMusical> recuperaPorAlbum(String album) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<FaixaMusical> faixas = em.createQuery("FROM FaixaMusical "
				+ "WHERE album = :tituloParam").setParameter("tituloParam", album).getResultList();
		return faixas.size() == 1 ? faixas: null;
	}

	@Override
	public FaixaMusical recuperaPorId(Long id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<FaixaMusical> faixas = em.createQuery("FROM FaixaMusical "
				+ "WHERE id = :tituloParam").setParameter("tituloParam", id).getResultList();
		return faixas.size() == 1 ? faixas.get(0): null;
	}

	@Override
	public void editar(Long id, String titulo, int duracao, AlbumMusical album) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		Query query =  em.createQuery("UPDATE FaixaMusical SET "
				+ "titulo = :nomeParam, duracao = :durParam, album = :albumParam "
				+ "WHERE id = :idParam");
		query.setParameter("idParam", id);
		query.setParameter("nomeParam", titulo);
		query.setParameter("durParam", duracao);
		query.setParameter("albumParam", album);
		query.executeUpdate();
		em.getTransaction().commit();
	}

	@Override
	public void deletar(FaixaMusical faixa) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		Query query =  em.createQuery("DELETE FaixaMusical WHERE id = :idParam");
		query.setParameter("idParam", faixa.getId());
		query.executeUpdate();
		em.getTransaction().commit();
	}

}
