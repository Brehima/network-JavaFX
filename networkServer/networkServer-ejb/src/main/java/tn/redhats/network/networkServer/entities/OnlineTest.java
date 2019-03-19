package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: OnlineTest
 *
 */
@Entity

public class OnlineTest implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String testType;
	private double score;
	@OneToOne
	private Interview interview;
	@OneToMany
	@Column
	@ElementCollection(targetClass=Question.class)
	private List<Question> questions;
	@OneToOne
	private JobApplication jobApplication;
	private static final long serialVersionUID = 1L;

	public OnlineTest() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getTestType() {
		return this.testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}   
	public double getScore() {
		return this.score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	public Interview getInterview() {
		return interview;
	}
	public void setInterview(Interview interview) {
		this.interview = interview;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public JobApplication getJobApplication() {
		return jobApplication;
	}
	public void setJobApplication(JobApplication jobApplication) {
		this.jobApplication = jobApplication;
	}
	@Override
	public String toString() {
		return "OnlineTest [id=" + id + ", testType=" + testType + ", score=" + score + ", interview=" + interview
				+ ", questions=" + questions + ", jobApplication=" + jobApplication + "]";
	}
	
	
   
}
