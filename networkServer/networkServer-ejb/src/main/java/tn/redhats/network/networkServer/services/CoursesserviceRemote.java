package tn.redhats.network.networkServer.services;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import tn.redhats.network.networkServer.entities.Course;

@Remote
public interface CoursesserviceRemote {

	public void  add_course(Course c);
	public void  mod_course(Course c);
	public Course read_course(int id);
	public void del_course(Course c);
	public List<Course> return_course();
	public ArrayList<Course> return_v_course();
	public int count_courses();
}
