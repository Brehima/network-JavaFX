/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.candidateProfile;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.entities.invitations;
import tn.redhats.network.networkServer.services.CandidatProfilServiceRemote;

/**
 * FXML Controller class
 *
 * @author Coulibaly
 */
public class ContactPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
	@FXML
	private VBox friendRequest;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	//friendRequest = new VBox();
    	actualizeFriendRequest();
    }    
    public void actualizeFriendRequest()
    {
    	 String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
			Context context;
			try {
				context = new InitialContext();
				CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
				User u = proxy.findUserByUsername("lolo");
				
				List<invitations>invitation = proxy.getFriendRequest(u);		
				
				for(invitations i : invitation)
				{
					System.out.println(i);
					HBox hbox = new HBox();
					hbox.setPrefSize(200, 85);
					//hbox.setPadding(new Insets(0, 0, 0, 0));
					ImageView profileImage = new ImageView();
					
					File file = new File(i.getSender().getProfile().getPhoto());
			    	profileImage.setImage(new Image(file.toURI().toString()));
			    	profileImage.setFitHeight(100);
			    	profileImage.setFitWidth(80);
			    	Label label = new Label(i.getSender().getFirstName()+" "+i.getSender().getLastName());
			    	label.setPrefSize(190, 17);
			        label.setTextFill(Color.WHITE);
			        label.setPadding(new Insets(30, 0, 0, 0));
			        
			    	JFXButton accept = new JFXButton("accept");
			    	
			    	accept.setPadding(new Insets(25, 0, 0, 0));
			    	accept.setStyle("-fx-background-color:green;");
			    	JFXButton decline = new JFXButton("decline");
			    	accept.setPadding(new Insets(25, 0, 0, 0));
			    	accept.setStyle("-fx-background-color:red;");
			    	accept.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							System.out.println("invit accept");
							CandidatProfilServiceRemote proxy;
							String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
							Context context;
							try {
								context = new InitialContext();
								proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
								proxy.removeUserFriendList(i.getSender().getId() , i.getReceiver().getId(), "ACCEPT");
							} catch (NamingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
						}
					});
			    	decline.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							System.out.println("invit decline");
							CandidatProfilServiceRemote proxy;
							String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
							Context context;
							try {
								context = new InitialContext();
								proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
								proxy.removeUserFriendList(i.getSender().getId() , i.getReceiver().getId(), "DECLINED");
							} catch (NamingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
			    		
					});
			    	hbox.getChildren().addAll(profileImage,label,accept,decline);
			    	friendRequest.getChildren().add(hbox);
			    }
			    } catch (NamingException e) {
				
				e.printStackTrace();
				System.out.println("lol");
			    }
    }
    public void showFriends()
    {
    	
    }
    
}
