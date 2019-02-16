package br.com.caelum.financas.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class DAO<T, K> {
	
	@PersistenceContext
	private EntityManager em;
	private final Class<T> clazz;
	
	protected DAO(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	protected EntityManager getEm() {
		return this.em;
	}

	public void adiciona(T t) {
		this.em.persist(t);
	}
	
	public void altera(T t) {
		this.em.merge(t);
	}
	
	public void remove(T...t) {
		for (T i : t) {
			this.em.remove(em.merge(i));
		}
	}
	
	public T busca(K id) {
		return this.em.find(this.clazz, id);
	}
	
	public List<T> lista() {
		String sql = "SELECT t FROM " + this.clazz.getSimpleName() + " t";
		return Collections.unmodifiableList(this.em.createQuery(sql, this.clazz).getResultList());
	}
	
}
