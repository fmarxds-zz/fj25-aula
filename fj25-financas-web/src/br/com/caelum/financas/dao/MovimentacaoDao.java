package br.com.caelum.financas.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.com.caelum.financas.exception.ValorInvalidoException;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.ValorPorMesEAno;

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
	
	public List<Movimentacao> listaPorConta(Conta conta) {
		return super.getEm().createQuery("select m from Movimentacao m where m.conta = :conta order by m.valor desc", Movimentacao.class)
				.setParameter("conta", conta)
				.getResultList();
	}
	
	public List<Movimentacao> listaPorValorETipo(BigDecimal valor, TipoMovimentacao tipo) {
		String query = "select m from Movimentacao m where m.valor <= :valor and m.tipoMovimentacao = :tipo";
		return super.getEm().createQuery(query, Movimentacao.class)
			.setParameter("valor", valor)
			.setParameter("tipo", tipo)
			.setHint("org.hibernate.cacheable", "true")
			.getResultList();
	}
	
	public List<Movimentacao> listaComCategoria() {
		String query = "select distinct m from Movimentacao m left join fetch m.categorias";
		return super.getEm().createQuery(query, Movimentacao.class).getResultList();
	}
	
	public BigDecimal calculaTotalMovimentadoPorTipo(Conta conta, TipoMovimentacao tipo) {
		String query = "select sum(m.valor) from Movimentacao m where m.conta = :conta and m.tipoMovimentacao = :tipo";
		return super.getEm().createQuery(query, BigDecimal.class)
			.setParameter("conta", conta)
			.setParameter("tipo", tipo)
			.getSingleResult();
	}
	
	public List<Movimentacao> buscaTodasMovimentacoesDaConta(String titular) {
		String query = "select m from Movimentacao m where m.conta.titular like :titular";
		return super.getEm().createQuery(query, Movimentacao.class)
				.setParameter("titular", "%"+titular+"%")
				.getResultList();
	}
	
	public List<ValorPorMesEAno> listaMesesComMovimentacoes(Conta conta, TipoMovimentacao tipo) {
		String jpql = "select "
						+ "new br.com.caelum.financas.modelo.ValorPorMesEAno(year(m.data), month(m.data), sum(m.valor)) "
					+ "from "
						+ "Movimentacao m "
					+ "where "
						+ "m.conta = :conta "
					+ "and "
						+ "m.tipoMovimentacao = :tipo "
					+ "group by "
						+ "year(m.data), "
						+ "month(m.data) "
					+ "order by "
						+ "sum(m.valor) desc";
		
		return super.getEm().createQuery(jpql, ValorPorMesEAno.class)
			.setParameter("conta", conta)
			.setParameter("tipo", tipo)
			.getResultList();
	}
	
	@Override
	public void adiciona(Movimentacao mov) {
		EntityManager manager = super.getEm();
		manager.joinTransaction();
		manager.persist(mov);
		if (mov.getValor().compareTo(BigDecimal.ZERO) < 0) {
			throw new ValorInvalidoException("Movimentavcao negativa!");
		}
	}

}
