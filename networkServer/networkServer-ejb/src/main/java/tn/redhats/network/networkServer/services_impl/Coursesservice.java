package tn.redhats.network.networkServer.services_impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.redhats.network.networkServer.entities.Course;
import tn.redhats.network.networkServer.services.CoursesserviceLocal;
import tn.redhats.network.networkServer.services.CoursesserviceRemote;

/**
 * Session Bean implementation class Coursesservice
 */
@Stateless
@LocalBean
public class Coursesservice implements CoursesserviceRemote, CoursesserviceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext (unitName="networkServer-ejb")
	EntityManager em;
    public Coursesservice() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void add_course(Course c) {
		// TODO Auto-generated method stub
		em.persist(c);
		
	}
	@Override
	public void mod_course(Course c) {
		// TODO Auto-generated method stub
		if (null!=em.find(Course.class, c.getId()))
			em.merge(c);
		else
		{	
			//implementing exception
		}
	}
	@Override
	public Course read_course(int id) {
		// TODO Auto-generated method stub
		return em.find(Course.class, id);
	}
	@Override
	public void del_course(Course c) {
		// TODO Auto-generated method stub
		c=em.find(Course.class, c.getId());
		em.remove(c);
		
	}
	@Override
	public List<Course> return_course() {
		// TODO Auto-generated method stub
		TypedQuery<Course> query = em.createQuery("Select c From Course c ",Course.class);
		List<Course> x = query.getResultList();
		return x;
	}
	@Override
	public ArrayList<Course> return_v_course() {
		// TODO Auto-generated method stub
		TypedQuery<Course> query = em.createQuery("Select c From Course c where c.validationStatus = :v ",Course.class);
		ArrayList<Course> x = (ArrayList<Course>) query.setParameter("v","valid").getResultList();
		return x;
		
	}

}
