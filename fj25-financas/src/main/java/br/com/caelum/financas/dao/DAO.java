package br.com.caelum.financas.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

public abstract class DAO<T, K> {
	
	private final EntityManager em;
	private final Class<T> clazz;
	
	protected DAO(EntityManager em, Class<T> clazz) {
		this.em = em;
		this.clazz = clazz;
	}
	
	protected EntityManager getEm() {
		return this.em;
	}

	public void adiciona(T t) {
		this.em.persist(t);
	}
	
	public void remove(T t) {
		this.em.remove(t);
	}
	
	public T busca(K id) {
		return this.em.find(this.clazz, id);
	}
	
	public List<T> lista() {
		String sql = "SELECT t FROM " + this.clazz.getSimpleName() + " t";
		return Collections.unmodifiableList(this.em.createQuery(sql, this.clazz).getResultList());
	}
	
}
