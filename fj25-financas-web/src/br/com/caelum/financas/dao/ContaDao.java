package br.com.caelum.financas.dao;

import javax.ejb.Stateless;

import br.com.caelum.financas.modelo.Conta;

@Stateless
public class ContaDao extends DAO<Conta, Integer> {

	public ContaDao() {
		super(Conta.class);
	}

}
