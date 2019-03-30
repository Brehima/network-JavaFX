package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Code2FACandidate
 *
 */
@Entity

public class Code2FACandidate implements Serializable {

	   
	@Id
	private int idUser;   
	private String code;
	private static final long serialVersionUID = 1L;

	public Code2FACandidate() {
		super();
	}   
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}   
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
   
}
