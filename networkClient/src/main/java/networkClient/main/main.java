package networkClient.main;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



import tn.redhats.network.networkServer.entities.Answer;
import tn.redhats.network.networkServer.entities.Interview;
import tn.redhats.network.networkServer.entities.JobApplication;
import tn.redhats.network.networkServer.entities.JobApplicationPK;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.entities.OnlineTest;
import tn.redhats.network.networkServer.entities.Question;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services.AdminServiceRemote;
import tn.redhats.network.networkServer.services.AnswerServiceRemote;
import tn.redhats.network.networkServer.services.InterviewServiceRemote;
import tn.redhats.network.networkServer.services.JobApplicationServiceRemote;
import tn.redhats.network.networkServer.services.JobOfferServiceRemote;
import tn.redhats.network.networkServer.services.OnlineTestServiceRemote;
import tn.redhats.network.networkServer.services.QuestionServiceRemote;
import tn.redhats.network.networkServer.services_impl.JobOfferService;

public class main {

public static	AnswerServiceRemote proxyAnswer ;
	public static void main(String[] args) throws NamingException{
		
		/*String jndiName = "networkServer-ear/networkServer-ejb/AdminService!tn.redhats.network.networkServer.services.AdminServiceRemote";
		AdminServiceRemote proxy = (AdminServiceRemote) context.lookup(jndiName);
		
		System.out.print(proxy.sayHello("Hello test !"));
		*/
		Context context =  new InitialContext();
		JobOfferServiceRemote proxyJobOffer = (JobOfferServiceRemote) context.lookup("networkServer-ear/networkServer-ejb/JobOfferService!tn.redhats.network.networkServer.services.JobOfferServiceRemote");
		JobOffer JobO = new JobOffer();
	
		JobOffer JOO = new JobOffer(1,"AAA", "EER", "sldkslkd");
	
//		proxyJobOffer.AddJobOffer(JOO);
		
		proxyJobOffer.UpdateJobOffer(JOO);
		
	//	proxyJobOffer.findAllJobOffer();
		
	
		
		
		//JobO.setId(1);
		//JobO.setDescription("test");
		//JobO.setExpertiseLevel("test");
//		JobO.setLocation("test");
//		proxyJobOffer.AddJobOffer(JobO);
		
		JobApplicationServiceRemote proxyJobApplication = (JobApplicationServiceRemote) context.lookup("networkServer-ear/networkServer-ejb/JobApplicationService!tn.redhats.network.networkServer.services.JobApplicationServiceRemote");
		
		AnswerServiceRemote proxyAnswer = (AnswerServiceRemote) context.lookup("networkServer-ear/networkServer-ejb/AnswerService!tn.redhats.network.networkServer.services.AnswerServiceRemote");

		QuestionServiceRemote proxyQuestion = (QuestionServiceRemote) context.lookup("networkServer-ear/networkServer-ejb/QuestionService!tn.redhats.network.networkServer.services.QuestionServiceRemote");

		InterviewServiceRemote proxyInterview = (InterviewServiceRemote) context.lookup("networkServer-ear/networkServer-ejb/InterviewService!tn.redhats.network.networkServer.services.InterviewServiceRemote");

		/**Calendar calendar = Calendar.getInstance();
		Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

		Interview inter = new Interview(currentTimestamp, "sjssj");
		proxyInterview.AddInterview(inter);
		System.out.println(proxyInterview.findInterviewById(9));
		**/
		
		System.out.println("TRYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
	
		
		OnlineTestServiceRemote proxyOnlineTest = (OnlineTestServiceRemote) context.lookup("networkServer-ear/networkServer-ejb/OnlineTestService!tn.redhats.network.networkServer.services.OnlineTestServiceRemote");

		//OnlineTest ott = new OnlineTest(11,"ZZZ", 00.5);
		proxyOnlineTest.Remove(11);
		
		
		
		
		
		
		//proxyJobApplication.findJobApplicationById(1,1);
		
		//Answer anss = new Answer("zezezez");
		//proxyAnswer.AddAnswer(anss);
		//proxyAnswer.Remove(4);
		
		
		//Answer ss = new Answer(5,"AAAAAA");
		//proxyAnswer.updateAnswer(ss);
		
		System.out.println("TRYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		
		User x = new User();
		x.setId(1);
		//bA.setUser(x);
		//JobA.setStatus("accept");
		//JobA.setJobOffer(JobO);
		JobApplicationPK JobAPK= new JobApplicationPK();
		JobAPK.setIdJobOffer(1);
		JobAPK.setIdUser(x.getId());
		//JobA.setJobApplicationPK(JobAPK);
		//System.out.println(JobA);
		//proxyJobApplication.AddJobApplication(JobA);
		
	System.out.println(proxyJobApplication.updateJobApplication(1,1));
		//System.out.println(proxyJobApplication.findJobApplicationById(1));
	}

}
