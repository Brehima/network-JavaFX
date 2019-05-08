package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Answer
 *
 */
@Entity

public class Answer implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	public Answer(String answer) {
		super();
		this.answer = answer;
	}
	private String answer;
	@OneToOne(mappedBy="answer")
	private Question question;
	public Answer(int id, String answer) {
		super();
		this.id = id;
		this.answer = answer;
	}
	private static final long serialVersionUID = 1L;

	public Answer() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}   
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + ", question=" + question + "]";
	}
	
	
   
}
