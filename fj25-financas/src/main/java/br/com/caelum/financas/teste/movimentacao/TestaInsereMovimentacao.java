package br.com.caelum.financas.teste.movimentacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereMovimentacao {
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		Conta conta = new Conta("Ronaldo", "8536", "56987-2", "Banco do Brasil");
		Movimentacao movimentacao = new Movimentacao(TipoMovimentacao.ENTRADA, "Salario", LocalDateTime.now(), BigDecimal.valueOf(2000.00), conta);
		
		try {
			MovimentacaoDAO dao = new MovimentacaoDAO(em);
			em.getTransaction().begin();
			dao.adiciona(movimentacao);
			em.getTransaction().commit();
			System.out.println("Movimentacao gravada com sucesso!");
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
				 
	}
}
