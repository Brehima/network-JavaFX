package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: invitations
 *
 */
@Entity

public class invitations implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	private User sender;
	@ManyToOne
	private User receiver;
	private static final long serialVersionUID = 1L;

	public invitations() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public User getSender() {
		return this.sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}   
	public User getReceiver() {
		return this.receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	@Override
	public String toString() {
		return "invitations [id=" + id + ", sender=" + sender + ", receiver=" + receiver + "]";
	}
	
   
}
