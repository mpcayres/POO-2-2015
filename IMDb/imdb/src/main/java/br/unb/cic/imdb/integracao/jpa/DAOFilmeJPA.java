package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unb.cic.imdb.integracao.DAOFilme;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Filme;
import br.unb.cic.imdb.negocio.Genero;

public class DAOFilmeJPA implements DAOFilme {
	
	private EntityManager em;

	@Override
	public void salvar(Filme trabalho) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(trabalho);
		em.getTransaction().commit();
	}

	@Override
	public List<Filme> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Filme").getResultList();
	}

	@Override
	public Filme recuperaPorTitulo(String titulo) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Filme> trabalhos = em.createQuery("FROM Filme WHERE "
				+ "titulo = :tituloParam").setParameter("tituloParam", titulo).getResultList();
		return trabalhos.size() == 1 ? trabalhos.get(0): null;
	}
	
	@Override
	public List<Filme> recuperaPorAutor(String autor) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Filme> trabalhos = em.createQuery("FROM Filme WHERE "
				+ "autor = :tituloParam").setParameter("tituloParam", autor).getResultList();
		return trabalhos.size() == 1 ? trabalhos: null;
	}
	
	@Override
	public List<Filme> recuperaPorGenero(String genero) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Filme> trabalhos = em.createQuery("FROM Filme WHERE "
				+ "genero = :tituloParam").setParameter("tituloParam", genero).getResultList();
		return trabalhos.size() == 1 ? trabalhos: null;
	}

	@Override
	public Filme recuperaPorId(Long id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Filme> trabalhos = em.createQuery("FROM Filme WHERE "
				+ "id = :tituloParam").setParameter("tituloParam", id).getResultList();
		return trabalhos.size() == 1 ? trabalhos.get(0): null;
	}

	@Override
	public void editar(Long id, String titulo, int ano, int duracao, Autor autor, Genero genero) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		Query query =  em.createQuery("UPDATE Filme SET "
				+ "titulo = :tituloParam, ano = :anoParam, autor = :autorParam, "
				+ "genero = :genParam, duracao = :durParam "
				+ "WHERE id = :idParam");
		query.setParameter("idParam", id);
		query.setParameter("tituloParam", titulo);
		query.setParameter("anoParam", ano);
		query.setParameter("autorParam", autor);
		query.setParameter("genParam", genero);
		query.setParameter("durParam", duracao);
		query.executeUpdate();
		em.getTransaction().commit();
	}

	@Override
	public void deletar(Filme filme) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		Query query =  em.createQuery("DELETE Filme WHERE id = :idParam");
		query.setParameter("idParam", filme.getId());
		query.executeUpdate();
		em.getTransaction().commit();
	}

}
