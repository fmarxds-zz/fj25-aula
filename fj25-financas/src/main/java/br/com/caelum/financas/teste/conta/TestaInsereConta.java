package br.com.caelum.financas.teste.conta;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		Conta conta = new Conta("Felipe", "4569", "12349-8", "Itau Unibanco");
		
		try {
			ContaDAO dao = new ContaDAO(em);
			em.getTransaction().begin();
			dao.adiciona(conta);
			em.getTransaction().commit();
			System.out.println("Conta gravada com sucesso!");
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
				 
	}
}
