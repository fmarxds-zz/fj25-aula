package br.com.caelum.financas.teste.movimentacao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaListagemMovimentacao {
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			MovimentacaoDAO dao = new MovimentacaoDAO(em);
			List<Movimentacao> movimentacoes = dao.lista();
			movimentacoes.forEach(System.out::println);
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
				 
	}
}
