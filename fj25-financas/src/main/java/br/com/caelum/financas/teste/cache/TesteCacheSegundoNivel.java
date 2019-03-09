package br.com.caelum.financas.teste.cache;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteCacheSegundoNivel {
	public static void main(String[] args) {

		EntityManager em1 = JPAUtil.getEntityManager();
		em1.getTransaction().begin();
		Conta conta1 = em1.find(Conta.class, 8);
		em1.getTransaction().commit();
		em1.close();

		EntityManager em2 = JPAUtil.getEntityManager();
		Conta conta2 = em2.find(Conta.class, 8);
		em2.close();
		
		System.out.println("Titular da primeira conta: " + conta1.getTitular());
		System.out.println("Titular da segunda conta: " + conta2.getTitular());

	}
}
