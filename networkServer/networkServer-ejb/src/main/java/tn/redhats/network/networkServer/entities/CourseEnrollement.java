package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CourseEnrollement
 *
 */
@Entity

public class CourseEnrollement implements Serializable {

	   
	
	@EmbeddedId
	private CourseEnrollementPK courseEnrollementPK;
	
	@ManyToOne
	@JoinColumn(name="idUser", referencedColumnName="id", insertable=false, updatable=false)
	private User user;
	@ManyToOne
	@JoinColumn(name="idCourse", referencedColumnName="id", insertable=false, updatable=false)
	private Course course;
	
	
	private static final long serialVersionUID = 1L;

	public CourseEnrollement() {
		super();
	}   
	
	public CourseEnrollementPK getCourseEnrollementPK() {
		return courseEnrollementPK;
	}
	public void setCourseEnrollementPK(CourseEnrollementPK courseEnrollementPK) {
		this.courseEnrollementPK = courseEnrollementPK;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "CourseEnrollement [courseEnrollementPK=" + courseEnrollementPK + ", user=" + user + ", course=" + course
				+ "]";
	}
	
	
	
	
   
}
