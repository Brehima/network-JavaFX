package managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import tn.redhats.network.networkServer.services_impl.OnlineTestService;
import tn.redhats.network.networkServer.entities.OnlineTest;



@ManagedBean
@ViewScoped
public class AfficheOnlineTest {
	
	
	@EJB
	OnlineTestService onlineTestService;
	
	private double score;
	private String testType;
	private List<OnlineTest> Tests;
	
	@PostConstruct
	public void init() {
		Tests = onlineTestService.findAllOnlineTest();
		
	
}
	public void delete(int testId) {
		onlineTestService.Remove(testId);
	}
	
	public void update() {
		
	}


	public OnlineTestService getOnlineTestService() {
		return onlineTestService;
	}


	public void setOnlineTestService(OnlineTestService onlineTestService) {
		this.onlineTestService = onlineTestService;
	}





	public double getScore() {
		return score;
	}


	public void setScore(double score) {
		this.score = score;
	}


	public String getTestType() {
		return testType;
	}


	public void setTestType(String testType) {
		this.testType = testType;
	}


	public List<OnlineTest> getTests() {
		return Tests;
	}


	public void setTests(List<OnlineTest> tests) {
		Tests = tests;
	}
}
