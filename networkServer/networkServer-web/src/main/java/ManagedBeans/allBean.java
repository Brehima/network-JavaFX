package ManagedBeans;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import tn.redhats.network.networkServer.entities.Course;
import tn.redhats.network.networkServer.services_impl.Coursesservice;
import tn.redhats.network.networkServer.services_impl.EntrepriseService;
import tn.redhats.network.networkServer.services_impl.InterviewsService;
import tn.redhats.network.networkServer.services_impl.JoboffersService;
import tn.redhats.network.networkServer.services_impl.LikesService;
import tn.redhats.network.networkServer.services_impl.PostService;
import tn.redhats.network.networkServer.services_impl.UserService;
import tn.redhats.network.networkServer.services_impl.commentservice;

@ManagedBean(name="bean")	
@SessionScoped
public class allBean {
	
	@EJB
	LikesService like;
	@EJB
	JoboffersService job;
	@EJB
	commentservice com;
	@EJB
	EntrepriseService entreprise;
	@EJB
	PostService post;
	@EJB
	UserService user;
	@EJB
	InterviewsService interview;
	@EJB
	Coursesservice course;
	

	 
	public String money()
	{
		int x = (int)course.money();
		System.out.print(x);
		return ("$"+x);
	}
	
	
	
	public String comments()
	{
		int x=(int)com.count_comments();
		System.out.println(x);
		
		return""+x+"";
	}
	public int entreprises()
	{
		int x=(int)entreprise.count_Enterprises();
		System.out.println(x);
		return (x);
	}
	public int joboffers()
	{
		int x= (int) job.count_joboffers();
		System.out.println(x);
		return (x);
	}
	public int likes()
	{
		int x = (int)like.count_Likes();
		System.out.print(x);
		return (x);
	}
	public int posts()
	{
		int x=(int)post.count_Posts();
		System.out.println(x);
		return (x);
	}
	public int users()
	{
		int x=(int)user.count_users();
		System.out.println(x);
		return (x);
	}
	public int interviews()
	{
		int x=(int)interview.count_Interviews();
		System.out.println(x);
		return (x);
	}
	public int courses()
	{
		List<Course> x=course.return_course();
		System.out.println(x);
		return x.size();
	}
	
	
	
	public int dailylikes()
	{
		int x = (int)like.daily_Likes();
		System.out.print(x);
		return (x);
	}
	
	public String dailycomments()
	{
		int x = (int)like.daily_comments();
		System.out.print(x);
		return (""+x);
	}
	
	public String dailyposts()
	{
		int x = (int)like.daily_posts();
		System.out.print(x);
		return (""+x);
	}
	
	public long rating()
	{
		int x = (int)like.ratings();
		System.out.print(x);
		return (x);
	}
	
	
	
	
	public LikesService getLike() {
		return like;
	}
	public void setLike(LikesService like) {
		this.like = like;
	}
	public JoboffersService getJob() {
		return job;
	}
	public void setJob(JoboffersService job) {
		this.job = job;
	}
	public commentservice getCom() {
		return com;
	}
	public void setCom(commentservice com) {
		this.com = com;
	}
	public EntrepriseService getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(EntrepriseService entreprise) {
		this.entreprise = entreprise;
	}
	public PostService getPost() {
		return post;
	}
	public void setPost(PostService post) {
		this.post = post;
	}
	public UserService getUser() {
		return user;
	}
	public void setUser(UserService user) {
		this.user = user;
	}
	public InterviewsService getInterview() {
		return interview;
	}
	public void setInterview(InterviewsService interview) {
		this.interview = interview;
	}
	public Coursesservice getCourse() {
		return course;
	}
	public void setCourse(Coursesservice course) {
		this.course = course;
	}
	public String redirect_dashboard()
	{
		String navigateTo="/Admin_template/testing?faces-redirect=true";
				return navigateTo;
		
	}


}

