package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.*;

import com.sun.mail.imap.protocol.Status;

import tn.redhats.network.networkServer.enumeration.messageStatus;
import tn.redhats.network.networkServer.enumeration.messageType;

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
	private int count;
	@Enumerated(EnumType.STRING)
	private messageType type;
	@Enumerated(EnumType.STRING)
	private messageStatus status;
	private String picture;
	@ElementCollection(targetClass=String.class,fetch=FetchType.EAGER)
	private List<User> users;
	@ElementCollection(targetClass=String.class,fetch=FetchType.EAGER)
	private List<User> list;
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
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", dateMessage=" + dateMessage + ", message=" + message + ", status=" + status
				+ ", picture=" + picture + ", count=" + count + "]";
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getOnlineCount() {
		return count;
	}
	public void setOnlineCount(int count) {
		this.count = count;
	}
	public messageType getType() {
		return type;
	}
	public void setType(messageType type) {
		this.type = type;
	}
	public messageStatus getStatus() {
		return status;
	}
	public void setStatus(messageStatus status) {
		this.status = status;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<User> getUserList() {
		return list;
	}
	public void setList(HashMap<String, User> userlist) {
		this.list = new ArrayList<>(userlist.values());
	}
	
	
   
}
