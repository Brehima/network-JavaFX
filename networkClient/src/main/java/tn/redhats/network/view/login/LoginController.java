/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.view.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;

import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import network.client.view.main.mainView;
import networkClient.main.main;
import tn.redhats.network.networkClient.view.home.HomeController;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services.UserServiceRemote;
import tn.redhats.network.view.consultMsg.ConsultMessageController;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class LoginController implements Initializable {


    @FXML
    private JFXButton btnConnect;

    @FXML
    private JFXTextField tfUserName;

    @FXML
    private JFXPasswordField tfPassword;
   
    //String checkUser, checkPw;
    public static User connectedUser = new User();
   // public static ConsultMessageController con;
  

    @FXML
    void loginButton(ActionEvent event) throws Exception{
    	
    	String jndiUser = "networkServer-ear/networkServer-ejb/UserService!tn.redhats.network.networkServer.services.UserServiceRemote";
		Context context =  new InitialContext();
		UserServiceRemote proxyUser = (UserServiceRemote) context.lookup(jndiUser);
    	          connectedUser = proxyUser.signIn(tfUserName.getText());
    	          //System.out.println(connectedUser);
    	          if(connectedUser!=null){
    	        	 context = new InitialContext();
    	            Alert alert = new Alert(AlertType.INFORMATION);
    	          	alert.setTitle("Information Dialog");
    	          	alert.setHeaderText(null);
    	          	alert.setContentText("Login Success");
    	          	alert.showAndWait();
    	        	Stage primarystage = new Stage();
    	        	//Parent  root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/view/home/home.fxml"));
    	        	FXMLLoader fmxlLoader = new FXMLLoader(getClass().getResource("/tn/redhats/network/view/post/Post1.fxml"));
    	            Parent window = (Pane) fmxlLoader.load();
    	    	       Scene scene = new Scene(window);
    	    	       scene.setRoot(window);
    	    	        primarystage.setResizable(false);
    	    	        primarystage.setScene(scene);
    	    	        primarystage.show();
    	    	        primarystage.setOnCloseRequest(e -> Platform.exit());
    	    	        //con = fmxlLoader.<ConsultMessageController>getController();

    	          }
    	          else{
    	        	Alert alert = new Alert(AlertType.INFORMATION);
    	          	alert.setTitle("Information Dialog");
    	          	alert.setHeaderText(null);
    	          	alert.setContentText("Login failed");
    	          	alert.showAndWait();
    	          }
    	          
    	          
    	         
		 }
      
        
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    		tfPassword.setStyle("-fx-text-inner-color: white;");
	        tfUserName.setStyle("-fx-text-inner-color: white;");
        // TODO
    	
    }
}
         

      
    

