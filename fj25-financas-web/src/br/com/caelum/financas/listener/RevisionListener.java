package br.com.caelum.financas.listener;

import br.com.caelum.financas.modelo.RevisionEntity;

public class RevisionListener implements org.hibernate.envers.RevisionListener {

	@Override
	public void newRevision(Object arg0) {
		RevisionEntity rev = (RevisionEntity) arg0;
		
		String nomeUsuario = "user";
		rev.setUserName(nomeUsuario);
	}

}
