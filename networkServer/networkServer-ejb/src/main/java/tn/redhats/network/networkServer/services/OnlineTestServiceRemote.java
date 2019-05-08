package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Remote;

import tn.redhats.network.networkServer.entities.Answer;
import tn.redhats.network.networkServer.entities.JobApplication;
import tn.redhats.network.networkServer.entities.JobApplicationPK;
import tn.redhats.network.networkServer.entities.OnlineTest;
import tn.redhats.network.networkServer.entities.Question;
@Remote
public interface OnlineTestServiceRemote {
	OnlineTest updateOnlineTest(OnlineTest quest);
	void AddOnlineTest(OnlineTest quest);
	OnlineTest findOnlineTestById (int id);
	List<OnlineTest> findAllOnlineTest();
	public void Remove(int id);
	public List<Answer> getAnswersFromTest(int testId);
	public List<Question>getQuestionFromTest(int testid);
}
