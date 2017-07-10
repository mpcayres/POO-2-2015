package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unb.cic.imdb.integracao.DAOGenero;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Genero;

/**
 * Implementacao da interface DAOGenero usando 
 * a tecnologia JPA, tendo como uma das implementacoes 
 * o Hibernate. 
 * 
 * @author rbonifacio
 */
public class DAOGeneroJPA implements DAOGenero {

	private EntityManager em; 
	
	@Override
	public void salvar(Genero genero) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(genero);
		em.getTransaction().commit();
	}

	@Override
	public List<Genero> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Genero").getResultList();
	}

	@Override
	public Genero recuperaPorTitulo(String titulo) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Genero> generos = em.createQuery("FROM Genero "
				+ "WHERE titulo = :tituloParam").setParameter("tituloParam", titulo).getResultList();
		return generos.size() == 1 ? generos.get(0): null;
	}

	@Override
	public Genero recuperaPorId(Long id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Genero> generos = em.createQuery("FROM Genero "
				+ "WHERE id titulo = :tituloParam").setParameter("tituloParam", id).getResultList();
		return generos.size() == 1 ? generos.get(0): null;
	}
	
	public void editar(Long id, String titulo, String descricao) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		Query query =  em.createQuery("UPDATE Genero SET "
				+ "titulo = :nomeParam, descricao = :descParam "
				+ "WHERE id = :idParam");
		query.setParameter("idParam", id);
		query.setParameter("nomeParam", titulo);
		query.setParameter("descParam", descricao);
		query.executeUpdate();
		em.getTransaction().commit();
	}

	@Override
	public void deletar(Genero genero) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		Query query =  em.createQuery("DELETE Genero WHERE id = :idParam");
		query.setParameter("idParam", genero.getId());
		query.executeUpdate();
		em.getTransaction().commit();		
	}
}
