package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Local;

import tn.redhats.network.networkServer.entities.Answer;
import tn.redhats.network.networkServer.entities.JobApplication;
import tn.redhats.network.networkServer.entities.JobApplicationPK;
import tn.redhats.network.networkServer.entities.OnlineTest;

@Local
public interface OnlineTestServiceLocal {
	OnlineTest updateOnlineTest(OnlineTest quest);
	void AddOnlineTest(OnlineTest quest);
	OnlineTest findOnlineTestById (int id);
	List<OnlineTest> findAllOnlineTest();
	public void Remove(int id);
}
