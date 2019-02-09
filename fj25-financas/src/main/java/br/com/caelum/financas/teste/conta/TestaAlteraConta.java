package br.com.caelum.financas.teste.conta;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaAlteraConta {
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			ContaDAO dao = new ContaDAO(em);
			em.getTransaction().begin();
			Conta conta = dao.busca(2);
			conta.setTitular("Deborah");
			em.getTransaction().commit();
			System.out.println("Conta alterada com sucesso!");
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
				 
	}
}
