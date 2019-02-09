package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("controlefinancas");
	
	private JPAUtil() {
		// Essa classe nao deve ser instânciada
	}
	
	public static EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}
	
	

}
