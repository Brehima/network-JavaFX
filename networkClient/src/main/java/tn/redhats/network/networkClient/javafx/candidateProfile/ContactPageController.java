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
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import networkClient.main.candidateFXMain;
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
	@FXML
	private VBox friendList;
	@FXML
	private Label notificationMsg;
	private User user;
	@FXML
	private ImageView miniprofil;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	//friendRequest = new VBox();
    	user = new User();
    	actualizeFriendRequest();
    	showFriends();
    	Timer time = new Timer();
  	    time.scheduleAtFixedRate(new TimerTask() {
				
				@Override
				public void run() {
					  refreshNotificationMsg();
					 //System.out.println("task de refresh notif");
				}
			}, 4000, 2000);
    }    
    public void actualizeFriendRequest()
    {
    	 String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
			Context context;
			try {
				context = new InitialContext();
				CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
				User u = proxy.findUserByUsername(SignIn_fxmlController.userConnected.getUsername());
				SignIn_fxmlController.userConnected = u;
				user = u;
				List<invitations>invitation = proxy.getFriendRequest(u);		
			
				friendRequest.getChildren().clear();
				for(invitations i : invitation)
				{
					System.out.println(i);
					HBox hbox = new HBox();
					HBox imgBox = new HBox();
					HBox labelBox = new HBox();
					HBox buttons = new HBox();
					//hbox.setPrefSize(200, 85);
					//hbox.setPadding(new Insets(0, 0, 0, 0));
					ImageView profileImage = new ImageView();
					
					File file = new File(i.getSender().getProfile().getPhoto());
			    	profileImage.setImage(new Image(file.toURI().toString()));
			    	profileImage.setFitHeight(100);
			    	profileImage.setFitWidth(80);
			    	imgBox.getChildren().add(profileImage);
			    	Label label = new Label(i.getSender().getFirstName()+" "+i.getSender().getLastName());
			    	label.setPrefSize(190, 17);
			        label.setTextFill(Color.WHITE);
			        label.setPadding(new Insets(30, 0, 0, 0));
			        
			    	JFXButton accept = new JFXButton("accept");
			    	
		
			    	accept.setStyle("-fx-background-color:green;");
			    	MaterialDesignIconView acceptIcon = new MaterialDesignIconView(MaterialDesignIcon.CHECKBOX_MARKED);
			    	accept.setGraphic(acceptIcon);
			    	
			    	JFXButton decline = new JFXButton("decline");
			    	decline.setStyle("-fx-background-color:red;");
			    	
			    	MaterialDesignIconView deniedIcon = new MaterialDesignIconView(MaterialDesignIcon.ACCOUNT_REMOVE);
			    	decline.setGraphic(deniedIcon);
			    	
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
								friendRequest.getChildren().clear();
								actualizeFriendRequest();
								showFriends();
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
								friendRequest.getChildren().clear();
								actualizeFriendRequest();
								showFriends();
							} catch (NamingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
			    		
					});
			    	buttons.getChildren().addAll(accept,decline);
			    	buttons.setMargin(accept, new Insets(0, 5, 0, 0));
			    	buttons.setMargin(decline, new Insets(0, 0, 0, 5));
			    	hbox.getChildren().addAll(imgBox,labelBox,buttons);
			    	hbox.setMargin(labelBox, new Insets(0, 15, 0, 15));
			    	hbox.setMargin(buttons, new Insets(30,0,0,0));
			    	
			    	friendRequest.getChildren().add(hbox);
			    }
			    } catch (NamingException e) {
				
				e.printStackTrace();
				System.out.println("lol");
			    }
    }
    public void showFriends()
    {

   	 String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
			Context context;
			try {
				context = new InitialContext();
				CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
				friendList.getChildren().clear();
				User u = proxy.findUserByUsername(SignIn_fxmlController.userConnected.getUsername());
				SignIn_fxmlController.userConnected = u;
				user = u;
				List<User> users = user.getUsers();
				if(users.size()>0)
				{
					
				for(User i : users)
				{
					HBox hbox = new HBox();
					HBox imgBox = new HBox();
					HBox labelBox = new HBox();
					HBox buttons = new HBox();
					//hbox.setPrefSize(200, 85);
					//hbox.setPadding(new Insets(0, 0, 0, 0));
					ImageView profileImage = new ImageView();
					
					File file = new File(i.getProfile().getPhoto());
			    	profileImage.setImage(new Image(file.toURI().toString()));
			    	profileImage.setFitHeight(100);
			    	profileImage.setFitWidth(80);
			    	imgBox.getChildren().add(profileImage);
			    	Label label = new Label(i.getFirstName()+" "+i.getLastName());
			    	label.setPrefSize(190, 17);
			        label.setTextFill(Color.WHITE);
			        label.setPadding(new Insets(30, 0, 0, 0));
			        
			        JFXButton sendMsg = new JFXButton("sendMessage");
			    	
		
			        sendMsg.setStyle("-fx-background-color:green;");
			    	MaterialDesignIconView sendIcon = new MaterialDesignIconView(MaterialDesignIcon.MESSAGE);
			    	sendMsg.setGraphic(sendIcon);
			    				    			    			        
		    	    sendMsg.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							System.out.println("redirect to message");
							
						}
			    		
					});
			     	buttons.getChildren().add(sendMsg);
			    	buttons.setMargin(sendMsg, new Insets(0, 5, 0, 0));
			    	hbox.getChildren().addAll(imgBox,labelBox,buttons);
			    	hbox.setMargin(labelBox, new Insets(0, 15, 0, 15));
			    	hbox.setMargin(buttons, new Insets(30,0,0,0));
			   
			    	friendList.getChildren().add(hbox);
			    	
				}
				}
				else
				{
					HBox hbox = new HBox();
					hbox.setPrefSize(200, 85);
					Label label = new Label("you have no contact");
			    	label.setPrefSize(190, 17);
			        label.setTextFill(Color.WHITE);
			        hbox.getChildren().add(label);
			    	friendList.getChildren().add(hbox);
				}
			    } catch (NamingException e) {
				
				e.printStackTrace();
				System.out.println("lol");
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
    public void refreshNotificationMsg()
    {
    	String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
		Context context;
		try {
			context = new InitialContext();
			CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
			List<invitations>invitation = proxy.getFriendRequest(SignIn_fxmlController.userConnected);
			notificationMsg.setText(""+invitation.size());
								
			
		} catch (NamingException e) {
			
			e.printStackTrace();
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
