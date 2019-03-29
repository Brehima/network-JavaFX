package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Course
 *
 */
@Entity

public class Course implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String courseTitle;
	private String description;
	private double rate;
	private double price;
	private String accomplishmentStatus;
	private double accomplishmentPercentage;
	private String validationStatus;
	private String image_url ;
	private String Domain;
	
	@OneToMany(mappedBy="course")	
	@Column
	@ElementCollection(targetClass=CourseEnrollement.class)
	private List<CourseEnrollement> courses;
	@OneToMany(mappedBy="course",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Course_chapters> chapters = new HashSet<Course_chapters>() ;
	
	
	public Set<Course_chapters> getChapters() {
		return chapters;
	}
	public void setChapters(Set<Course_chapters> chapters) {
		this.chapters = chapters;
	}
	private static final long serialVersionUID = 1L;

	public Course() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getCourseTitle() {
		return this.courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}   
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}   
	public String getAccomplishmentStatus() {
		return this.accomplishmentStatus;
	}

	public void setAccomplishmentStatus(String accomplishmentStatus) {
		this.accomplishmentStatus = accomplishmentStatus;
	}   
	public double getAccomplishmentPercentage() {
		return this.accomplishmentPercentage;
	}

	public void setAccomplishmentPercentage(double accomplishmentPercentage) {
		this.accomplishmentPercentage = accomplishmentPercentage;
	}   
	public String getValidationStatus() {
		return this.validationStatus;
	}

	public void setValidationStatus(String validationStatus) {
		this.validationStatus = validationStatus;
	}
	public List<CourseEnrollement> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseEnrollement> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseTitle=" + courseTitle + ", description=" + description + ", rate=" + rate
				+ ", price=" + price + ", accomplishmentStatus=" + accomplishmentStatus + ", accomplishmentPercentage="
				+ accomplishmentPercentage + ", validationStatus=" + validationStatus + ", courses=" + courses + "]";
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getDomain() {
		return Domain;
	}
	public void setDomain(String domain) {
		Domain = domain;
	}
	
	
	
	
   
}
