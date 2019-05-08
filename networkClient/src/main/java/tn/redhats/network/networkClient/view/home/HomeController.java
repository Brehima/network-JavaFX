/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.view.home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tn.redhats.network.view.consultMsg.ConsultMessageController;
import tn.redhats.network.view.post.Post1Controller;

import java.util.logging.Level;
import com.jfoenix.controls.JFXButton;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class HomeController implements Initializable {
	 @FXML
	    private AnchorPane AnchorPane1;
	  @FXML
	    private JFXButton btnChat;
	   @FXML
	    private JFXButton btnHome;
	   @FXML
	    private JFXButton btnNotif;
	   @FXML
	    private ImageView imageHome;


	    @FXML
	    void goToChat(ActionEvent event) throws IOException {
	    	btnChat.setOnAction(new EventHandler<ActionEvent>() {
	    		@Override
	    	     public void handle(ActionEvent event) {
	    	    	try 
	    	    	{
                   
	    	    	 Parent root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/view/consultMsg/consultMessage.fxml"));
	                  //Scene s = AnchorPane1.getScene(); 
	                 Scene s = new Scene(root);
	                 Stage secondStage = new Stage();
	                secondStage.setScene(s);
	                secondStage.show();
		}

	    	    	catch (IOException ex) {
	    	              Logger.getLogger(ConsultMessageController.class.getName()).log(Level.SEVERE, null, ex);
	    	          }
	    	   }
	    		
			});
	    	
	    } 
	    
	   @FXML
	    void goToNotif(ActionEvent event) throws IOException{
		   btnNotif.setOnAction(new EventHandler<ActionEvent>() {
			   @Override
	    	     public void handle(ActionEvent event) {
	    	    	try 
	    	    	{
                   
	    	    	 Parent root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/view/notification/Notification.fxml"));
	                  //Scene s = AnchorPane1.getScene(); 
	                 Scene s = new Scene(root);
	                 Stage secondStage = new Stage();
	                secondStage.setScene(s);
	                secondStage.show();
		}

	    	    	catch (IOException ex) {
	    	              Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
	    	          }
	    	   }
	    	    	 });
	    	   }
			 
	   @FXML
	    void goToHome(ActionEvent event) throws IOException {
	    	btnHome.setOnAction(new EventHandler<ActionEvent>() {

	    	     @Override
	    	     public void handle(ActionEvent event) {
	    	    	try 
	    	    	{
                     //FXMLLoader loader=new FXMLLoader(getClass().getResource("/tn/redhats/network/view/post/Post1.fxml")); 
	    	    	 Parent root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/view/post/Post1.fxml"));
	                  //Scene s = AnchorPane1.getScene(); 
	                 Scene s = new Scene(root);
	                 Stage secondStage = new Stage();
	                secondStage.setScene(s);
	                secondStage.show();
	                
	               
	               //s.setRoot(root);
	                		 
	       
	    	    	 }
	    	    	 
	    	     
	    
	    	catch (IOException ex) {
	              Logger.getLogger(Post1Controller.class.getName()).log(Level.SEVERE, null, ex);
	          }
	   }
	    	 });
	   }
	   
	
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	// Image img1 = new Image(getClass().getResourceAsStream("C:\\Users\\Asus\\Desktop\\Esprit\\Semestre 2\\PI sem2\\basic2-004_comment_chat-512.png"));
         //Image img2 = new Image(getClass().getResourceAsStream("close.png"));
    	btnHome.setGraphic(imageHome);
        // TODO
    }    
    
}
