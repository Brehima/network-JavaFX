package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CourseRating
 *
 */
@Entity

public class CourseRating implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private double rate;
	@ManyToOne
	private Course course;
	@OneToOne
	private User user;
	private static final long serialVersionUID = 1L;

	public CourseRating() {
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
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "CourseRating [id=" + id + ", rate=" + rate + ", course=" + course + ", user=" + user + "]";
	}
	
	
   
}
