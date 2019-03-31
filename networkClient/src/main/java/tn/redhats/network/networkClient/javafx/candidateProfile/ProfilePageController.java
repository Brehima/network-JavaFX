/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.candidateProfile;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tn.redhats.network.networkServer.entities.CandidateProfile;
import tn.redhats.network.networkServer.entities.User;
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
	
	private User receiver;
	private User user;
	private String buffer;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	User user = new User();
    	receiver = new User();
    	buffer="";
    	educations = new JFXListView<String>();
    	educations.getItems().add("hello");
    	experiences = new JFXListView<String>();
    	experiences.getItems().add("hhhhhh");
    	educations.getItems().add("dddddd");
    	if(SignIn_fxmlController.userConnected!=null)
    	{
    		user = SignIn_fxmlController.userConnected;
    		friendRequest.setVisible(false);
    		CandidateProfile profile = (CandidateProfile)user.getProfile();
    		firstName.setText(user.getFirstName());
    	    lastName.setText(user.getLastName());
    	    File file = new File(user.getProfile().getPhoto());
    	    profileImage.setImage(new Image(file.toURI().toString()));
    	    introduction.setText(profile.getIntroduction());
    	    totalContact.setText(""+user.getUsers().size()+"");
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
            stringEducation.clear();
           }   
       }
       else
       {
          if((!ch.equals("")) && (educations.getItems().contains(ch)==false))
         {
            educations.getItems().add(ch);  
            educations.refresh();
            stringEducation.clear();
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
            stringEducation.clear();
            buffer="";
           }   
            
        }
        else
        {
           if((!ch.equals("")) && (educations.getItems().contains(ch)==true))
           {
             educations.getItems().remove(ch);   
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
					    	    if(u.getId()!=SignIn_fxmlController.userConnected.getId())
					    	    {
					    	    	 editAboutMe.setVisible(false);
							    	    editEducations.setVisible(false);
							    	    editExperience.setVisible(false);
							    	    friendRequest.setVisible(true);
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
}
