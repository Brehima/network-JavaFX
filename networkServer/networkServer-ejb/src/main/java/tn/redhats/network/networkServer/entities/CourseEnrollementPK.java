package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CourseEnrollementPK
 *
 */
@Embeddable

public class CourseEnrollementPK implements Serializable {

	
	private int idUser;
	private int idCourse;
	private static final long serialVersionUID = 1L;

	public CourseEnrollementPK() {
		super();
	}   
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}   
	public int getIdCourse() {
		return this.idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
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
		CourseEnrollementPK other = (CourseEnrollementPK) obj;
		if (idCourse != other.idCourse)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CourseEnrollementPK [idUser=" + idUser + ", idCourse=" + idCourse + "]";
	}
	
	
   
}
