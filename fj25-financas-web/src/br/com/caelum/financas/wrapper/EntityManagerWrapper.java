package br.com.caelum.financas.wrapper;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

public class EntityManagerWrapper implements EntityManager {
	
	private EntityManager em;

	public EntityManagerWrapper(EntityManager em) {
		this.em = em;
	}

	public void clear() {
		em.clear();
	}

	public void close() {
		em.close();
	}

	public boolean contains(Object arg0) {
		return em.contains(arg0);
	}

	public <T> EntityGraph<T> createEntityGraph(Class<T> arg0) {
		return em.createEntityGraph(arg0);
	}

	public EntityGraph<?> createEntityGraph(String arg0) {
		return em.createEntityGraph(arg0);
	}

	public <T> TypedQuery<T> createNamedQuery(String arg0, Class<T> arg1) {
		return em.createNamedQuery(arg0, arg1);
	}

	public Query createNamedQuery(String arg0) {
		return em.createNamedQuery(arg0);
	}

	public StoredProcedureQuery createNamedStoredProcedureQuery(String arg0) {
		return em.createNamedStoredProcedureQuery(arg0);
	}

	public Query createNativeQuery(String arg0, Class arg1) {
		return em.createNativeQuery(arg0, arg1);
	}

	public Query createNativeQuery(String arg0, String arg1) {
		return em.createNativeQuery(arg0, arg1);
	}

	public Query createNativeQuery(String arg0) {
		return em.createNativeQuery(arg0);
	}

	public Query createQuery(CriteriaDelete arg0) {
		return em.createQuery(arg0);
	}

	public <T> TypedQuery<T> createQuery(CriteriaQuery<T> arg0) {
		return em.createQuery(arg0);
	}

	public Query createQuery(CriteriaUpdate arg0) {
		return em.createQuery(arg0);
	}

	public <T> TypedQuery<T> createQuery(String arg0, Class<T> arg1) {
		return em.createQuery(arg0, arg1);
	}

	public Query createQuery(String arg0) {
		return em.createQuery(arg0);
	}

	public StoredProcedureQuery createStoredProcedureQuery(String arg0, Class... arg1) {
		return em.createStoredProcedureQuery(arg0, arg1);
	}

	public StoredProcedureQuery createStoredProcedureQuery(String arg0, String... arg1) {
		return em.createStoredProcedureQuery(arg0, arg1);
	}

	public StoredProcedureQuery createStoredProcedureQuery(String arg0) {
		return em.createStoredProcedureQuery(arg0);
	}

	public void detach(Object arg0) {
		em.detach(arg0);
	}

	public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2, Map<String, Object> arg3) {
		return em.find(arg0, arg1, arg2, arg3);
	}

	public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2) {
		return em.find(arg0, arg1, arg2);
	}

	public <T> T find(Class<T> arg0, Object arg1, Map<String, Object> arg2) {
		return em.find(arg0, arg1, arg2);
	}

	public <T> T find(Class<T> arg0, Object arg1) {
		return em.find(arg0, arg1);
	}

	public void flush() {
		em.flush();
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return em.getCriteriaBuilder();
	}

	public Object getDelegate() {
		return em.getDelegate();
	}

	public EntityGraph<?> getEntityGraph(String arg0) {
		return em.getEntityGraph(arg0);
	}

	public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> arg0) {
		return em.getEntityGraphs(arg0);
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return em.getEntityManagerFactory();
	}

	public FlushModeType getFlushMode() {
		return em.getFlushMode();
	}

	public LockModeType getLockMode(Object arg0) {
		return em.getLockMode(arg0);
	}

	public Metamodel getMetamodel() {
		return em.getMetamodel();
	}

	public Map<String, Object> getProperties() {
		return em.getProperties();
	}

	public <T> T getReference(Class<T> arg0, Object arg1) {
		return em.getReference(arg0, arg1);
	}

	public EntityTransaction getTransaction() {
		return em.getTransaction();
	}

	public boolean isJoinedToTransaction() {
		return em.isJoinedToTransaction();
	}

	public boolean isOpen() {
		return em.isOpen();
	}

	public void joinTransaction() {
		em.joinTransaction();
	}

	public void lock(Object arg0, LockModeType arg1, Map<String, Object> arg2) {
		em.lock(arg0, arg1, arg2);
	}

	public void lock(Object arg0, LockModeType arg1) {
		em.lock(arg0, arg1);
	}

	public <T> T merge(T arg0) {
		return em.merge(arg0);
	}

	public void persist(Object arg0) {
		em.persist(arg0);
	}

	public void refresh(Object arg0, LockModeType arg1, Map<String, Object> arg2) {
		em.refresh(arg0, arg1, arg2);
	}

	public void refresh(Object arg0, LockModeType arg1) {
		em.refresh(arg0, arg1);
	}

	public void refresh(Object arg0, Map<String, Object> arg1) {
		em.refresh(arg0, arg1);
	}

	public void refresh(Object arg0) {
		em.refresh(arg0);
	}

	public void remove(Object arg0) {
		em.remove(arg0);
	}

	public void setFlushMode(FlushModeType arg0) {
		em.setFlushMode(arg0);
	}

	public void setProperty(String arg0, Object arg1) {
		em.setProperty(arg0, arg1);
	}

	public <T> T unwrap(Class<T> arg0) {
		return em.unwrap(arg0);
	}
	
	

}
