package tn.redhats.network.networkServer.services;



import java.util.ArrayList;

import javax.ejb.Remote;


import tn.redhats.network.networkServer.entities.CourseEnrollement;

@Remote
public interface CourseEnrollement_serviceRemote {

	public void add_courseEnrollement(CourseEnrollement ce);
	public ArrayList<CourseEnrollement> read_courseEnrollement(int id);

}
