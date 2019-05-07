package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: profile
 *
 */
@Entity
@Table(name="Profile")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value="cv")
public class Profile implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int id;
	protected String introduction;
	protected String photo;
	@Column
	@ElementCollection(targetClass=User.class, fetch=FetchType.EAGER)
	@OneToMany(mappedBy="profile", cascade=CascadeType.REMOVE)
	protected List<User> users;
	
	private static final long serialVersionUID = 1L;

	
	
	
	public Profile(String introduction) {
		super();
		this.introduction = introduction;
	}
	
	public Profile(String introduction, String photo, List<User> users) {
		super();
		users = new ArrayList<User>();
		this.introduction = introduction;
		this.photo = photo;
		this.users = users;
	}
	public Profile() {
		super();
		users = new ArrayList<User>();
		
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "Profile [id=" + id + ", introduction=" + introduction + ", photo=" + photo + "]";
	}
	
	
	
	
	
	
	
   
}
