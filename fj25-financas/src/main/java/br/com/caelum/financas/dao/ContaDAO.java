package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class ContaDAO extends DAO<Conta, Integer> {

	public ContaDAO(EntityManager em) {
		super(em, Conta.class);
	}

}
