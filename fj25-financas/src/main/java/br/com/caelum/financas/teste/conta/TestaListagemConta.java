package br.com.caelum.financas.teste.conta;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaListagemConta {
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
				
		try {
			ContaDAO dao = new ContaDAO(em);
			List<Conta> contas = dao.lista();
			contas.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
				 
	}
}
