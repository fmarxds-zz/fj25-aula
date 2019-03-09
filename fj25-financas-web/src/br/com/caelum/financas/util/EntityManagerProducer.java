package br.com.caelum.financas.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import br.com.caelum.financas.wrapper.EntityManagerWrapper;

@ApplicationScoped
public class EntityManagerProducer {
	
	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return new EntityManagerWrapper(factory.createEntityManager());
	}
	
	public void close (@Disposes EntityManager entityManager) {
		entityManager.close();
	}

}
