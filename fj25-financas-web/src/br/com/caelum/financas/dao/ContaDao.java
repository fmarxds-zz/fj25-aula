package br.com.caelum.financas.dao;

import javax.ejb.Stateless;

import br.com.caelum.financas.modelo.Conta;

@Stateless
public class ContaDao extends DAO<Conta, Integer> {

	public ContaDao() {
		super(Conta.class);
	}
	
	public int trocaNomeDoBancoEmLote(String antigoNomeBanco, String novoNomeBanco) {
		String sql = "UPDATE Conta c SET c.banco = :novoNome WHERE c.banco = :antigoNome";
		return super.getEm().createQuery(sql)
			.setParameter("novoNome", novoNomeBanco)
			.setParameter("antigoNome", antigoNomeBanco)
			.executeUpdate();
	}

}
