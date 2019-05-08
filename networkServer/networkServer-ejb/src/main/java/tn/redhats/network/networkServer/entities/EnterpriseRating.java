package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EnterpriseRating
 *
 */
@Entity

public class EnterpriseRating implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private double rate;
	@ManyToOne
	private EnterpriseProfile enterprise;
	@OneToOne
	private User user;
	private static final long serialVersionUID = 1L;

	public EnterpriseRating() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}   
	public EnterpriseProfile getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(EnterpriseProfile enterprise) {
		this.enterprise = enterprise;
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "EnterpriseRating [id=" + id + ", rate=" + rate + ", enterprise=" + enterprise + ", user=" + user + "]";
	}
	
	
   
}
