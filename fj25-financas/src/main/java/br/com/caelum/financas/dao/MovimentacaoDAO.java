package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDAO extends DAO<Movimentacao, Integer> {

	public MovimentacaoDAO(EntityManager em) {
		super(em, Movimentacao.class);
	}

}
