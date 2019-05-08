package managedBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import tn.redhats.network.networkServer.entities.OnlineTest;
import tn.redhats.network.networkServer.services_impl.JobOfferService;
import tn.redhats.network.networkServer.services_impl.OnlineTestService;
import tn.redhats.network.networkServer.entities.JobOffer;

@ManagedBean
@ViewScoped
public class AcceptRefuse {
	@EJB	
	OnlineTestService onlineTestService;
	@EJB
	JobOfferService jobOfferService;
	String JobName;
	String Type;
	Integer TestScore;
	Integer TestId=1;
	JobOffer job;
	
	
	
	@PostConstruct
	public void init() {
		job=jobOfferService.findJobOfferById(TestId);			
	}
	public void accept() {
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	public JobOffer getJob() {
		return job;
	}
	public void setJob(JobOffer job) {
		this.job = job;
	}
	public OnlineTestService getOnlineTestService() {
		return onlineTestService;
	}
	public void setOnlineTestService(OnlineTestService onlineTestService) {
		this.onlineTestService = onlineTestService;
	}
	public JobOfferService getJobOfferService() {
		return jobOfferService;
	}
	public void setJobOfferService(JobOfferService jobOfferService) {
		this.jobOfferService = jobOfferService;
	}
	public String getJobName() {
		return JobName;
	}
	public void setJobName(String jobName) {
		JobName = jobName;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Integer getTestScore() {
		return TestScore;
	}
	public void setTestScore(Integer testScore) {
		TestScore = testScore;
	}
	public Integer getTestId() {
		return TestId;
	}
	public void setTestId(Integer testId) {
		TestId = testId;
	}
}
