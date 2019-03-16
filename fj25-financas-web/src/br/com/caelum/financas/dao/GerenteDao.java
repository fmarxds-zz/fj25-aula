package br.com.caelum.financas.dao;

import javax.ejb.Stateless;

import br.com.caelum.financas.modelo.Gerente;
import br.com.caelum.financas.modelo.GerenteConta;

@Stateless
public class GerenteDao extends DAO<Gerente, Integer> {

	public GerenteDao() {
		super(Gerente.class);
	}

	@Override
	public GerenteConta busca(Integer id) {
		return super.getEm().find(GerenteConta.class, id);
	}
	
	

}
