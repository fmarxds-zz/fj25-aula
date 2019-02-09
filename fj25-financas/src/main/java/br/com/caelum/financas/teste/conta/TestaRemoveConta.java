package br.com.caelum.financas.teste.conta;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.util.JPAUtil;

public class TestaRemoveConta {
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			ContaDAO dao = new ContaDAO(em);
			em.getTransaction().begin();
			dao.remove(dao.busca(1));
			em.getTransaction().commit();
			System.out.println("Conta removida com sucesso!");
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
				 
	}
}
