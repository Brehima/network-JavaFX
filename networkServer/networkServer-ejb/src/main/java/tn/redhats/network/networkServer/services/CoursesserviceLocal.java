package tn.redhats.network.networkServer.services;

import javax.ejb.Local;

import tn.redhats.network.networkServer.entities.Course;

@Local
public interface CoursesserviceLocal {

	public int count_courses();

	public void add_course(Course c);

	public Course read_course(int id);

	public void mod_course(Course c);

	public long money();

}
