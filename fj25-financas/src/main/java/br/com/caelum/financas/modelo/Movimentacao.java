package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipo;
	private String descricao;
	private LocalDateTime data;
	private BigDecimal valor;
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	private Conta conta;

	public Movimentacao() {
	}

	public Movimentacao(TipoMovimentacao tipo, String descricao, LocalDateTime data, BigDecimal valor, Conta conta) {
		this.tipo = tipo;
		this.descricao = descricao;
		this.data = data;
		this.valor = valor;
		this.conta = conta;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Movimentacao [id=" + id + ", tipo=" + tipo + ", descricao=" + descricao + ", data=" + data + ", valor="
				+ valor + ", conta=" + conta + "]";
	}

}
