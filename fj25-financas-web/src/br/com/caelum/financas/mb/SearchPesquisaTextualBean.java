package br.com.caelum.financas.mb;

import java.util.List;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Movimentacao;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class SearchPesquisaTextualBean {

	@Inject
	private MovimentacaoDao dao;
	
	private String descricao;
	private List<Movimentacao> movimentacoes;	
	
	public void pesquisar() {
		movimentacoes = dao.buscaPorDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

}
