package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Course_chapters
 *
 */
@Entity

public class Course_chapters implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer chapter_id;
	private String url;
	private String chapter_title;
	private static final long serialVersionUID = 1L;
	@ManyToOne private Course course ;
	
	

	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Course_chapters() {
		super();
	}   
	public Integer getChapter_id() {
		return this.chapter_id;
	}

	public void setChapter_id(Integer chapter_id) {
		this.chapter_id = chapter_id;
	}   
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}   
	public String getChapter_title() {
		return this.chapter_title;
	}

	public void setChapter_title(String chapter_title) {
		this.chapter_title = chapter_title;
	}
   
}
