package ManagedBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import tn.redhats.network.networkServer.entities.Course;
import tn.redhats.network.networkServer.services.*;


@ManagedBean(name="coursebean")	
@SessionScoped
public class coursebean {
	@EJB
	CoursesserviceRemote co ;
	
	public void add_course (Course c) {
		 co.add_course(c);
	}

	public void mod_course(Course c) {
		co.mod_course(c);
		
	}
	
	public void read_course(int id) {
		co.read_course(id);
		
	}
	
	

	public String del_course(Course c) {
		 co.del_course(c);
		 return "/Admin_template/docs?faces-redirect=true";
	}

	public List<Course> return_course() {

		return co.return_course();
	}
	
}
