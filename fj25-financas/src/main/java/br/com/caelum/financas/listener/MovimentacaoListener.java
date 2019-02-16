package br.com.caelum.financas.listener;

import javax.persistence.PreUpdate;

import br.com.caelum.financas.modelo.Movimentacao;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;

public class MovimentacaoListener {
	
	@PrePersist
	@PreUpdate
	public void preAltera(Movimentacao mov) {
		System.out.println("Atualizando data da movimentação");
		mov.setData(LocalDateTime.now());
	}

}
