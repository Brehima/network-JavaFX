package tn.redhats.network.networkServer.services_impl;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.redhats.network.networkServer.entities.CourseEnrollement;
import tn.redhats.network.networkServer.entities.Course_chapters;
import tn.redhats.network.networkServer.services.Course_chapterServicesLocal;
import tn.redhats.network.networkServer.services.Course_chapterServicesRemote;

/**
 * Session Bean implementation class Course_chapterServices
 */
@Stateless
@LocalBean
public class Course_chapterServices implements Course_chapterServicesRemote, Course_chapterServicesLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext (unitName="networkServer-ejb")
	EntityManager em;
    public Course_chapterServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public ArrayList<Course_chapters> return_course_chapters(int id) {
		// TODO Auto-generated method stub
				TypedQuery<Course_chapters> query = em.createQuery("Select ch From Course_chapters ch where ch.course.id = :v ",Course_chapters.class);
				ArrayList<Course_chapters> x = (ArrayList<Course_chapters>) query.setParameter("v",id).getResultList();
				return x;
	}

}
