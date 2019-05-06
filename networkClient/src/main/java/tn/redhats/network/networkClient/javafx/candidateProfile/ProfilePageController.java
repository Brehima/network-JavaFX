/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.candidateProfile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import networkClient.main.candidateFXMain;
import tn.redhats.network.networkServer.entities.CandidateProfile;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.entities.invitations;
import tn.redhats.network.networkServer.services.CandidatProfilServiceRemote;

/**
 * FXML Controller class
 *
 * @author Coulibaly
 */
public class ProfilePageController implements Initializable {

    /**
     * Initializes the controller class.
     */
	@FXML
	private Label firstName;
	@FXML
	private Label lastName;
	@FXML
	private JFXButton modifyProfile;
	@FXML
	private JFXButton editAboutMe;
	@FXML
	private JFXTextArea introduction;
	@FXML
	private JFXTextField totalContact;
	@FXML
	private JFXButton editEducations;
	@FXML
	private JFXTextField stringEducation;
	@FXML
	private JFXButton addEducation;
	@FXML
	private JFXListView<String> educations;
	@FXML
	private JFXButton editExperience;
	@FXML
	private JFXTextField stringExperience;
	@FXML
	private JFXButton addExperience;
	@FXML
	private JFXListView<String> experiences;
	@FXML
	private ImageView profileImage;
	@FXML
	private ContextMenu contexMenu;
	@FXML
	private MenuItem itemMenu;
	@FXML
	private JFXTextField searchContacts;
	@FXML
	private JFXButton friendRequest;
	@FXML
	private JFXButton aboutMeB;
	@FXML
	private JFXButton experienceB;
	@FXML
	private JFXButton educationB;
	@FXML
	private JFXButton friend;
	@FXML
	private Label notificationMsg;
	private User receiver;
	private User user;
	private String buffer;
	private Boolean boo;
	@FXML
	private ImageView miniprofil;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	User user = new User();
    	receiver = new User();
    	buffer="";
    	boo=false;
 //   	educations.setItems(FXCollections.observableArrayList());
    //	educations = new JFXListView<String>();
 //   	educations.getItems().add("hello");
    //	experiences = new JFXListView<String>();
   // 	experiences.setItems(FXCollections.observableArrayList());
    //	experiences.getItems().add("hhhhhh");
    	//educations.getItems().add("dddddd");
    	if(SignIn_fxmlController.userConnected!=null)
    	{
    		user = SignIn_fxmlController.userConnected;
    		friendRequest.setVisible(false);
    		friend.setVisible(false);
    		CandidateProfile profile = (CandidateProfile)user.getProfile();
    		firstName.setText(user.getFirstName());
    	    lastName.setText(user.getLastName());
    	    File file = new File(user.getProfile().getPhoto());
    	    profileImage.setImage(new Image(file.toURI().toString()));
    	    introduction.setText(profile.getIntroduction());
    	    totalContact.setText(""+user.getUsers().size()+"");
    	    miniprofil.setImage(new Image(file.toURI().toString()));
    	    Timer time = new Timer();
    	    refreshNotificationMsg();
    	    time.scheduleAtFixedRate(new TimerTask() {
				
				@Override
				public void run() {
					 Platform.runLater(()->{
							
						  refreshNotificationMsg();
					  });
					
					 //System.out.println("task de refresh notif");
				}
			}, 6000, 60000);
    	  //  refreshNotificationMsg();
    	    refreshEducation(profile);
    	    //refreshExperience(profile);
    	}  
    }    
    @FXML
    public void ajouterEducation()
    {
       String ch = stringEducation.getText();
       if(educations.getItems().contains(buffer))
       {
            educations.getItems().remove(buffer);
            if((!ch.equals("")) && (educations.getItems().contains(ch)==false))
           {
            educations.getItems().add(ch);
   
            updateEducationUserPage(educations);
            
      
           }   
       }
       else
       {
          if((!ch.equals("")) && (educations.getItems().contains(ch)==false))
         {
            educations.getItems().add(ch);
            
            updateEducationUserPage(educations);
            educations.refresh();
           // stringEducation.clear();
         }   
       }
      
       System.out.print(educations.getItems());
       educations.refresh();
    }
    @FXML
    public void modifierEducation()
    {
        buffer = educations.getSelectionModel().getSelectedItem();
        stringEducation.setText(buffer);
        
    }
    @FXML
    public void supprimerEducation()
    {
       String ch = stringEducation.getText();
        if(ch.equals(buffer))
        {
           if((!ch.equals("")) && (educations.getItems().contains(ch)==true))
           {
            educations.getItems().remove(ch);
        	
            updateEducationUserPage(educations);
            stringEducation.clear();
            buffer="";
           }   
            
        }
        else
        {
           if((!ch.equals("")) && (educations.getItems().contains(ch)==true))
           {
             educations.getItems().remove(ch);   
             updateEducationUserPage(educations);
             stringEducation.clear();           
           }   
        }
    }
    @FXML
    public void searchContact()
    {
 String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
			Context context;
			try {
				context = new InitialContext();
				CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
				List<User>users = proxy.searchContact(searchContacts.getText());
				List<invitations> invt = proxy.getFriendRequest(SignIn_fxmlController.userConnected);
				
				
				this.contexMenu.getItems().clear();
				if(users.size()>0)
				{
					List<MenuItem>items = new ArrayList<MenuItem>();
					for(User u : users)
					{
						MenuItem item = new MenuItem();
						ImageView image= new ImageView();
						File file = new File(u.getProfile().getPhoto());
				    	image.setImage(new Image(file.toURI().toString()));
				    	image.setFitHeight(100);
				    	image.setFitWidth(75);
				    	item.setGraphic(image);
				    	item.setText(u.getFirstName()+" "+u.getLastName()+"                                                  ");
				    	items.add(item);
				    	item.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								CandidateProfile profile = (CandidateProfile)u.getProfile();
					    		firstName.setText(u.getFirstName());
					    	    lastName.setText(u.getLastName());
					    	    File file = new File(u.getProfile().getPhoto());
					    	    profileImage.setImage(new Image(file.toURI().toString()));
					    	    introduction.setText(profile.getIntroduction());
					    	    totalContact.setText(""+u.getUsers().size()+"");
					    	    for(invitations i: invt)
								{
									if(i.getSender().equals(SignIn_fxmlController.userConnected) && i.getReceiver().equals(u))
									{
										boo = true;
									}
								}
					    	    if(u.getId()!=SignIn_fxmlController.userConnected.getId())
					    	    {
					    	    	 editAboutMe.setVisible(false);
							    	    editEducations.setVisible(false);
							    	    editExperience.setVisible(false);
							    	    if(!u.getUsers().contains(SignIn_fxmlController.userConnected) && boo==false)
							    	    {
							    	    	friendRequest.setVisible(true);
							    	    }
							    	    else
							    	    {
							    	    	friend.setVisible(true);
							    	    	System.out.println("you are already friend");
							    	    }
							    	    
							    	    receiver = u;
					    	    }
					    	   
					    	    if(profile.getVolunteeringExperiences().size()>0)
								{
									for(String experience: profile.getVolunteeringExperiences() )
									{
										experiences.getItems().add(experience);
									}
								}
					    	    if(profile.getEducation().size()>0)
								{
									for(String education: profile.getEducation() )
									{
										educations.getItems().add(education);
									}
								}
							}
						});
					}
					this.contexMenu.getItems().addAll(items);
					this.contexMenu.show(searchContacts,Side.BOTTOM,0,0);
				}
				
			} catch (NamingException e) {
				
				e.printStackTrace();
			}
    }
    @FXML
    public void sendFriendRequest()
    {
    	 String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
			Context context;
			try {
				context = new InitialContext();
				CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
				System.out.println(receiver);
				if(receiver.getId()!=0)
				{
					 proxy.sendFriendRequest(SignIn_fxmlController.userConnected, receiver);
					 
				}
				
							
				
				
			} catch (NamingException e) {
				
				e.printStackTrace();
			}
    }
    public void refreshNotificationMsg()
    {
    	String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
		Context context;
		try {
			context = new InitialContext();
			CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
			List<invitations>invitation = proxy.getFriendRequest(SignIn_fxmlController.userConnected);
			System.out.println(invitation.size());
			notificationMsg.setText(invitation.size()+"");
			if(invitation.size()>0)
			{
				SignIn_fxmlController.showAlert();
			}
			//notificationMsg.setText(""+invitation.size());	
			System.out.println(notificationMsg);
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
    }
    @FXML
    public void loadContactPage()
    {
   	 Parent root;
   		try {
   			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/candidateProfile/contactPage.fxml"));
   			 Scene scene = new Scene(root);
   		      
   		        candidateFXMain.stage.setScene(scene);
   		        candidateFXMain.stage.setIconified(false);
   		       
   		       candidateFXMain.stage.show();
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
       
    }
    @FXML
    public void loadProfilePage()
    {
    	 Parent root;
    		try {
    			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/candidateProfile/profilePage.fxml"));
    			 Scene scene = new Scene(root);
    		      
    		        candidateFXMain.stage.setScene(scene);
    		        candidateFXMain.stage.setIconified(false);
    		       
    		       candidateFXMain.stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }
    public void updateEducationUserPage(ListView<String>list)
    {
    	 CandidateProfile profile = (CandidateProfile)SignIn_fxmlController.userConnected.getProfile();
         List<String> listEduc = new ArrayList<String>();
         for(String ch : list.getItems())
         {
        	 listEduc.add(ch);
         }
         
         profile.setEducation(listEduc);
         SignIn_fxmlController.userConnected.setProfile(profile);
         String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
			Context context;
			try {
				context = new InitialContext();
				CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);			
			    SignIn_fxmlController.userConnected=proxy.updateUser(SignIn_fxmlController.userConnected);								
			   } 
			catch (NamingException e)
			  {	
				 e.printStackTrace();
			  }
			//refreshEducation(profile);
			//refreshExperience(profile);
    }
 /*  public void refreshExperience(CandidateProfile profile)
    {
    	
    	 if(profile.getVolunteeringExperiences().size()>0)
			{
				for(String experience: profile.getVolunteeringExperiences() )
				{
					experiences.getItems().add(experience);
				}
			}
 	    
    }*/
    public void refreshEducation(CandidateProfile profile)
    {
    	
    	if(profile.getEducation().size()>0)
		{
			for(String education: profile.getEducation() )
			{
				educations.getItems().add(education);
			}
		}
    }
    @FXML
    private void loadSignIn() {
   	 Parent root;
		try {
			SignIn_fxmlController.userConnected = new User();
			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/candidateProfile/signIN_fxml.fxml"));
			 Scene scene = new Scene(root);
		      
		        candidateFXMain.stage.setScene(scene);
		        candidateFXMain.stage.setIconified(false);
		       
		       candidateFXMain.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
       
       
   	
   }
}
