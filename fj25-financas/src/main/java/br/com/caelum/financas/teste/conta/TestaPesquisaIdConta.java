package br.com.caelum.financas.teste.conta;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaPesquisaIdConta {
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
				
		try {
			ContaDAO dao = new ContaDAO(em);
			Conta conta = dao.busca(1);
			System.out.println(conta);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
				 
	}
}
