package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import tn.redhats.network.networkServer.enumeration.AccountStatus;
import tn.redhats.network.networkServer.enumeration.Role;



/**
 * Entity implementation class for Entity: user
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	@ManyToOne
	private Profile profile;
	@Enumerated(EnumType.STRING)
	private Role role;
	@OneToMany(mappedBy="user")
	@Column
	@ElementCollection(targetClass=CourseEnrollement.class, fetch=FetchType.EAGER)
	private List<CourseEnrollement> courses;
	@OneToMany(mappedBy="user")
	@Column
	@ElementCollection(targetClass=JobApplication.class, fetch=FetchType.EAGER)
	private List<JobApplication> jobApplication;
	
	@ManyToOne
	@JoinColumn(name="user_fk")
	private User user;
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	@Column
	@ElementCollection(targetClass=User.class)
	private List<User> users;
	
	@OneToMany
	@Column
	@ElementCollection(targetClass=Message.class, fetch=FetchType.EAGER)
	private List<Message> messages;
	
	@Enumerated(EnumType.STRING)
	private AccountStatus accountStatus;
	private int loginAttempts;
	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
		users = new ArrayList<User>();
		
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<CourseEnrollement> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseEnrollement> courses) {
		this.courses = courses;
	}
	public List<JobApplication> getJobApplication() {
		return jobApplication;
	}
	public void setJobApplication(List<JobApplication> jobApplication) {
		this.jobApplication = jobApplication;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
	
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	public int getLoginAttempts() {
		return loginAttempts;
	}
	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", profile=" + profile + ", role=" + role + "]";
	}
	

	

	
	
	
   
}
