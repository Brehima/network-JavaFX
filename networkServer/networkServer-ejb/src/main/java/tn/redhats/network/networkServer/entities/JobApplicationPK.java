package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: JobApplicationPK
 *
 */
@Embeddable

public class JobApplicationPK implements Serializable {

	
	private int idUser;
	private int idJobOffer;
	private static final long serialVersionUID = 1L;

	public JobApplicationPK() {
		super();
	}   
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}   
	public int getIdJobOffer() {
		return this.idJobOffer;
	}

	public void setIdJobOffer(int idJobOffer) {
		this.idJobOffer = idJobOffer;
	}
	@Override
	public int hashCode() {
		return 5;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobApplicationPK other = (JobApplicationPK) obj;
		if (idJobOffer != other.idJobOffer)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "JobApplicationPK [idUser=" + idUser + ", idJobOffer=" + idJobOffer + "]";
	}
	
	
   
}
