package tn.redhats.network.networkServer.services;

import java.util.ArrayList;

import javax.ejb.Remote;


import tn.redhats.network.networkServer.entities.Course_chapters;

@Remote
public interface Course_chapterServicesRemote {
	
	public ArrayList<Course_chapters> return_course_chapters(int id);

}
