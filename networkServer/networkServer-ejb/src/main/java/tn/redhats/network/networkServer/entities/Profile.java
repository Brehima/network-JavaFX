package tn.redhats.network.networkServer.entities;

import java.io.Serializable;
import java.lang.String;
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
	@OneToOne(mappedBy="profile")
	protected User user;
	
	private static final long serialVersionUID = 1L;

	public Profile() {
		super();
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Profile [id=" + id + ", introduction=" + introduction + ", user=" + user + "]";
	}
	
	
   
}
