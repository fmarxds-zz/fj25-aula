package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.CategoriaDao;
import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@Named
@ViewScoped
public class MovimentacoesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MovimentacaoDao dao;
	@Inject
	private ContaDao contaDao;
	@Inject
	private CategoriaDao categoriaDao;
	
	private List<Movimentacao> movimentacoes;
	private List<Categoria> categorias;
	private Movimentacao movimentacao = new Movimentacao();
	private Integer contaId;
	private Integer categoriaId;
	
	
	public void grava() {
		System.out.println("Fazendo a gravacao da movimentacao");
		
		this.movimentacao.setConta(contaDao.busca(contaId));
		dao.adiciona(movimentacao);
		this.movimentacoes = dao.lista();
		
		limpaFormularioDoJSF();
	}
	

	public void remove() {
		System.out.println("Removendo a movimentacao");

		dao.remove(this.movimentacao);
		this.movimentacoes = dao.lista();
		
		limpaFormularioDoJSF();
	}
	
	public void adicionaCategoria() {
		if (this.categoriaId != null && this.categoriaId > 0) {
			Categoria categoria = categoriaDao.busca(this.categoriaId);
			this.movimentacao.getCategorias().add(categoria);
		}
	}

	public List<Movimentacao> getMovimentacoes() {
		atualizaMovimentacoes();
		return movimentacoes;
	}
	
	public Movimentacao getMovimentacao() {
		if(movimentacao.getData()==null) {
			movimentacao.setData(LocalDateTime.now());
		}
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public Integer getContaId() {
		return contaId;
	}

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}
	

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	/**
	 * Esse metodo apenas limpa o formulario da forma com que o JSF espera.
	 * Invoque-o no momento manager que precisar do formulario vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.movimentacao = new Movimentacao();
	}

	public TipoMovimentacao[] getTiposDeMovimentacao() {
		return TipoMovimentacao.values();
	}
	
	private void atualizaMovimentacoes() {
		if (this.movimentacoes == null || this.movimentacoes.isEmpty()) {
			this.movimentacoes = dao.lista();
		}
	}


	public List<Categoria> getCategorias() {
		if (this.categorias == null) {
			System.out.println("Listando categorias");
			this.categorias = categoriaDao.lista();
		}
		return this.categorias;
	}
}
