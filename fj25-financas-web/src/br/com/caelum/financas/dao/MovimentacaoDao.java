package br.com.caelum.financas.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.com.caelum.financas.modelo.Movimentacao;

@Stateless
public class MovimentacaoDao extends DAO<Movimentacao, Integer> {
	
	public MovimentacaoDao() {
		super(Movimentacao.class);
	}
	
	public List<Movimentacao> listaPorIdConta(Integer id) {
		return super.getEm().createQuery("select m from Movimentacao m where m.conta.id = :contaId", Movimentacao.class)
			.setParameter("contaId", id)
			.getResultList();
	}

}
