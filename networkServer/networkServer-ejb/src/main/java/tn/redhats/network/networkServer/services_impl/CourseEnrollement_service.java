package tn.redhats.network.networkServer.services_impl;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.redhats.network.networkServer.entities.Course;
import tn.redhats.network.networkServer.entities.CourseEnrollement;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services.CourseEnrollement_serviceLocal;
import tn.redhats.network.networkServer.services.CourseEnrollement_serviceRemote;

/**
 * Session Bean implementation class CourseEnrollement_service
 */
@Stateless
@LocalBean
public class CourseEnrollement_service implements CourseEnrollement_serviceRemote, CourseEnrollement_serviceLocal 
{

    /**
     * Default constructor. 
     */
	@PersistenceContext (unitName="networkServer-ejb")
	EntityManager em;
    public CourseEnrollement_service() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add_courseEnrollement(CourseEnrollement ce) {
		// TODO Auto-generated method stub
		em.persist(ce);
	}

	@Override
	public ArrayList<CourseEnrollement> read_courseEnrollement(int id) {
		// TODO Auto-generated method stub
		User user = em.find(User.class,id);
		System.out.println(id);
		TypedQuery<CourseEnrollement> query = em.createQuery("Select ce From CourseEnrollement ce where ce.user = :idUser",CourseEnrollement.class);
		ArrayList<CourseEnrollement> x = (ArrayList<CourseEnrollement>) query.setParameter("idUser",user).getResultList();
		return x;
	 
	}


}
