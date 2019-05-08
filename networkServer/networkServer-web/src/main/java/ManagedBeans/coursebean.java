package ManagedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import tn.redhats.network.networkServer.entities.Course;
import tn.redhats.network.networkServer.services.*;
import tn.redhats.network.networkServer.services_impl.Coursesservice;


@ManagedBean(name="coursebean")	
public class coursebean implements Serializable{
	
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
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAccomplishmentStatus() {
		return accomplishmentStatus;
	}

	public void setAccomplishmentStatus(String accomplishmentStatus) {
		this.accomplishmentStatus = accomplishmentStatus;
	}

	public double getAccomplishmentPercentage() {
		return accomplishmentPercentage;
	}

	public void setAccomplishmentPercentage(double accomplishmentPercentage) {
		this.accomplishmentPercentage = accomplishmentPercentage;
	}

	public String getValidationStatus() {
		return validationStatus;
	}

	public void setValidationStatus(String validationStatus) {
		this.validationStatus = validationStatus;
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

	public CoursesserviceRemote getCo() {
		return co;
	}

	public void setCo(Coursesservice co) {
		this.co = co;
	}

	@EJB
	Coursesservice co ;
	
	public void add_course (Course c) {
		 co.add_course(c);
	}

	
	public void modifier (Course c) {
		this.setId(c.getId());
		this.setCourseTitle(c.getCourseTitle());
		this.setDescription(c.getDescription());
		this.setImage_url(c.getImage_url());
		this.setPrice(c.getPrice());
		this.setValidationStatus(c.getValidationStatus());
	}
	
	public void update_course(){
		co.mod_course(new Course(id, courseTitle, description, price, validationStatus, image_url));
		
		}
	
	
	public void read_course(int id) {
		co.read_course(id);
		
	}
	
	

	public String del_course(Course c) {
		 co.del_course(c);
		 return "/Admin_template/docs?faces-redirect=true";
	}

	public List<Course> return_course() {

		return co.return_course();
	}
	
}
