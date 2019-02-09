package br.com.caelum.financas.teste.movimentacao;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaPesquisaIdMovimentacao {
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			MovimentacaoDAO dao = new MovimentacaoDAO(em);
			Movimentacao movimentacao = dao.busca(2);
			System.out.println("Titular da movimentacao: " + movimentacao.getConta().getTitular());
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
				 
	}
}
