package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Interview
 *
 */
@Entity

public class Interview implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Timestamp interviewDate;
	private String status;
	@OneToOne
	private OnlineTest onlineTest;
	private static final long serialVersionUID = 1L;

	public Interview() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Timestamp getInterviewDate() {
		return this.interviewDate;
	}

	public void setInterviewDate(Timestamp interviewDate) {
		this.interviewDate = interviewDate;
	}   
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}   
	public OnlineTest getOnlineTest() {
		return this.onlineTest;
	}

	public Interview(int id) {
		super();
		this.id = id;
	}
	public void setOnlineTest(OnlineTest onlineTest) {
		this.onlineTest = onlineTest;
	}
	public Interview(Timestamp interviewDate, String status) {
		super();
		this.interviewDate = interviewDate;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Interview [id=" + id + ", interviewDate=" + interviewDate + ", status=" + status + ", onlineTest="
				+ onlineTest + "]";
	}
	
	
   
}
