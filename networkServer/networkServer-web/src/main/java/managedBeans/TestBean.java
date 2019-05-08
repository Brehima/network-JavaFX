package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.redhats.network.networkServer.entities.Answer;
import tn.redhats.network.networkServer.entities.Question;
import tn.redhats.network.networkServer.services_impl.QuestionService;
import tn.redhats.network.networkServer.services_impl.AnswerService;
import tn.redhats.network.networkServer.services_impl.OnlineTestService;
import tn.redhats.network.networkServer.entities.OnlineTest;

@ManagedBean
@ViewScoped
public class TestBean {
	
	@EJB
	OnlineTestService onlineTestService;
	
	private OnlineTest test;
	private int testId=1;

	private List<Question>questions;
	private List<Answer>answers;
	private List<String>Useranswers;
	private String answer;
	private List<String>choices;
	private Question currentQuestion;
	private int index=0;
	private Integer quest;
	
	
	@PostConstruct
	public void init() {
		Useranswers = new ArrayList<String>();
		choices = new ArrayList<String>();
		test = onlineTestService.findOnlineTestById(testId);
		questions = test.getQuestions();
		quest= questions.size();
		answers = onlineTestService.getAnswersFromTest(testId);
		choices.add(questions.get(index).getChoice1());
		choices.add(questions.get(index).getChoice2());
		choices.add(questions.get(index).getAnswer().getAnswer());
		currentQuestion = questions.get(index);
	}
	
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Integer getQuest() {
		return quest;
	}

	public void setQuest(Integer quest) {
		this.quest = quest;
	}

	public String next() {
		Useranswers.add(answer);
		index++;
		choices.clear();
		currentQuestion = questions.get(index);
		choices.add(currentQuestion.getChoice1());
		choices.add(currentQuestion.getChoice2());
		choices.add(currentQuestion.getAnswer().getAnswer());
		return null;
	}
	
	
	public String submit() {
		String navigateTo; 
		for (String string : Useranswers) {
			System.out.println(string+"\n");
		}
		Useranswers.add(answer);
		test.setScore(scoreFunction());
		onlineTestService.AddOnlineTest(test);
		navigateTo= "finish";
		
		return navigateTo;
		
	}
	
	public double scoreFunction() {
    	double score=0;
    	for (int i=0;i<Useranswers.size();i++) {
			if (Useranswers.get(i).equals(questions.get(i).getAnswer().getAnswer()))
				score++;
    	}
    	System.out.println(Useranswers.size()+"***********************"+questions.size());	
		return score;
			
    }
	
	
	
	

	public OnlineTest getTest() {
		return test;
	}

	public void setTest(OnlineTest test) {
		this.test = test;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<String> getChoices() {
		return choices;
	}

	public void setChoices(List<String> choices) {
		this.choices = choices;
	}

	public Question getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public List<String> getUseranswers() {
		return Useranswers;
	}

	public void setUseranswers(List<String> useranswers) {
		Useranswers = useranswers;
	}
	
	
	

}
