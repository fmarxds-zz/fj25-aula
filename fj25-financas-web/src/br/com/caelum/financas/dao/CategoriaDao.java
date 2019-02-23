package br.com.caelum.financas.dao;

import javax.ejb.Stateless;

import br.com.caelum.financas.modelo.Categoria;

@Stateless
public class CategoriaDao extends DAO<Categoria, Integer> {

	protected CategoriaDao() {
		super(Categoria.class);
	}

}
