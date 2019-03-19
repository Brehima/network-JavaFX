package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity

public class Message implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Timestamp dateMessage;
	private String message;
	private String status;
	
	
	
	private static final long serialVersionUID = 1L;

	public Message() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Timestamp getDateMessage() {
		return this.dateMessage;
	}

	public void setDateMessage(Timestamp dateMessage) {
		this.dateMessage = dateMessage;
	}   
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}   
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", dateMessage=" + dateMessage + ", message=" + message + ", status=" + status
				+ "]";
	}
	
	
   
}
