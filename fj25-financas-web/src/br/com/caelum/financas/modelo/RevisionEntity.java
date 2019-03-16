package br.com.caelum.financas.modelo;

import org.hibernate.envers.DefaultRevisionEntity;

import br.com.caelum.financas.listener.RevisionListener;

@org.hibernate.envers.RevisionEntity(RevisionListener.class)
public class RevisionEntity extends DefaultRevisionEntity {

	private static final long serialVersionUID = 1L;
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
