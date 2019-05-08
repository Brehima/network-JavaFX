package networkClient.main;

import java.sql.Timestamp;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.redhats.network.networkServer.entities.CandidateProfile;
import tn.redhats.network.networkServer.entities.Comment;
import tn.redhats.network.networkServer.entities.Message;
import tn.redhats.network.networkServer.entities.Notification;
import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.entities.Profile;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.enumeration.Role;
import tn.redhats.network.networkServer.enumeration.messageStatus;
import tn.redhats.network.networkServer.services.CommentServiceRemote;
import tn.redhats.network.networkServer.services.MessageServiceRemote;
import tn.redhats.network.networkServer.services.NotifServiceRemote;
import tn.redhats.network.networkServer.services.PostServiceRemote;
import tn.redhats.network.networkServer.services.UserServiceRemote;

public class main {

	
	


	public static NotifServiceRemote getNotificationProxy() throws NamingException{
		
		String jndiNotification = "networkServer-ear/networkServer-ejb/NotifService!tn.redhats.network.networkServer.services.NotifServiceRemote";
		Context context =  new InitialContext();
		NotifServiceRemote proxyNotification = (NotifServiceRemote) context.lookup(jndiNotification);
		return proxyNotification;
	}
	
	
	public static UserServiceRemote getUserProxy() throws NamingException {
		String jndiUser = "networkServer-ear/networkServer-ejb/UserService!tn.redhats.network.networkServer.services.UserServiceRemote";
		Context context =  new InitialContext();
		UserServiceRemote proxyUser = (UserServiceRemote) context.lookup(jndiUser);
		return proxyUser;
	}
	
	public static MessageServiceRemote getMessageProxy() throws NamingException {
		String jndiMessage = "networkServer-ear/networkServer-ejb/MessageService!tn.redhats.network.networkServer.services.MessageServiceRemote";
		Context context =  new InitialContext();
		MessageServiceRemote proxyMessage = (MessageServiceRemote) context.lookup(jndiMessage);
		return proxyMessage;
	}
	
	public static PostServiceRemote getPostProxy() throws NamingException {
		String jndiPost = "networkServer-ear/networkServer-ejb/PostService!tn.redhats.network.networkServer.services.PostServiceRemote";
		Context context =  new InitialContext();
		PostServiceRemote proxyPost = (PostServiceRemote) context.lookup(jndiPost);
		return proxyPost;
	}
	
	public static CommentServiceRemote getCommentProxy() throws NamingException {
		String jndiComment = "networkServer-ear/networkServer-ejb/CommentService!tn.redhats.network.networkServer.services.CommentServiceRemote";
		Context context =  new InitialContext();
		CommentServiceRemote proxyComment = (CommentServiceRemote) context.lookup(jndiComment);
		return proxyComment;
	}
	
	
	public static void main(String[] args) throws NamingException{
		
		//String jndiCommentServiceRemote = "networkServer-ear/networkServer-ejb/CommentService!tn.redhats.network.networkServer.services.CommentServiceRemote";
		//Context context =  new InitialContext();
		//CommentServiceRemote proxy = (CommentServiceRemote) context.lookup(jndiCommentServiceRemote);
		
		//PostServiceRemote proxyPost = (PostServiceRemote) context.lookup("networkServer-ear/networkServer-ejb/PostService!tn.redhats.network.networkServer.services.PostServiceRemote");
        
		Post p = new Post();
		/*p.setDescription("test");
		p.setDislikesNumber(5);
		p.setLikesNumber(5);
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		p.setDatePost(ts);*/
		
		getPostProxy().AddPost(p);
		
		
		CandidateProfile profile = new CandidateProfile();
		profile.setIntroduction("introduction");
		profile.setPhoto("photo");
		
		
		
		User user = new User();
		user.setFirstName("imen");
		user.setLastName("haouala");
		user.setEmail("test@test.tn");
		user.setPassword("0123456789");
		user.setRole(Role.Candidate);
		user.setUsername("imen");
		user.setProfile(profile);
		
		getUserProxy().addUser(user);
		
		
		
		
		
		
		/*
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		Post post = new Post();
		//post.setId(13);
		post.setDatePost(ts);
		post.setDescription("DescPost");
		post.setDislikesNumber(20);
		post.setLikesNumber(10);
		*/
		//proxyPost.AddPost(post);
		
		//System.out.println(proxyPost.findAllPost());
		
		
		
		/*Comment c = new Comment();
		c.setText("test");
		
		c.setDateComment(ts);
		c.setDislikesNumber(5);
		c.setLikesNumber(5);
		c.setPost(post);
		
		
		proxy.AddComment(c);
		//proxy.RemoveComment(4);
		//System.out.println(proxy.findCommentById(11));
		//System.out.println(proxy.findAllComment());
		*/
		
		
		
		//MessageServiceRemote proxyMessage = (MessageServiceRemote) context.lookup("networkServer-ear/networkServer-ejb/MessageService!tn.redhats.network.networkServer.services.MessageServiceRemote");
		Message m = new Message();
		/*m.setMessage("msg");
		m.setStatus(messageStatus.ONLINE);
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		m.setDateMessage(ts);*/
		
		
		getMessageProxy().AddMessage(m);
		
		//proxyMessage.RemoveMessage(5);
		
		//System.out.println(proxyMessage.findMessageById(6));
		
		//System.out.println(proxyMessage.findAllMessage());
		
		//proxyMessage.UpdateMessage(7);
		

	
	//NotifServiceRemote proxyNotif = (NotifServiceRemote) context.lookup("networkServer-ear/networkServer-ejb/NotifService!tn.redhats.network.networkServer.services.NotifServiceRemote");
	/*Notification notif = new Notification();
	Date date = new Date();
	long time = date.getTime();
	Timestamp ts = new Timestamp(time);
	notif.setDateNotification(ts);
	notif.setType("test");
	notif.setDescription("test");
	notif.setStatus("Unread");
	*/ 
	
	
	//proxyNotif.AddNotification(notif);
	//System.out.println(proxyNotif.findNotificationtById(9));
	//System.out.println(proxyNotif.findAllNotification());
	//proxyNotif.RemoveNotification(10);
	//proxyNotif.UpdateNotification(9);
	}
}
