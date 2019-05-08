/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.jobOffer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import networkClient.main.InterviewAndApplication;
import tn.redhats.network.networkServer.entities.Answer;
import tn.redhats.network.networkServer.services.AnswerServiceRemote;
import tn.redhats.network.networkServer.services.JobOfferServiceRemote;
import tn.redhats.network.networkServer.services_impl.AnswerService;

/**
 * FXML Controller class
 *
 * @author Naskez
 */
public class JobOffer3Controller implements Initializable {

    @FXML
    private JFXTextArea textarr;
    @FXML
    private JFXButton btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Save(ActionEvent event) {
    	if (textarr.getText().length()< 5) {
   		 Alert alert = new Alert(Alert.AlertType.INFORMATION, "Your answer must at least contain 5 letters", ButtonType.OK);
            alert.showAndWait();
   	}
    	
    	else {
    	
    	Answer ns = new Answer( textarr.getText());
    
    		getProxy().AddAnswer(ns);
      		 Alert alert = new Alert(Alert.AlertType.INFORMATION, "Answer Added ", ButtonType.OK);
               alert.showAndWait();
    	}}
  
    public AnswerServiceRemote getProxy() {
		String gndi="networkServer-ear/networkServer-ejb/AnswerService!tn.redhats.network.networkServer.services.AnswerServiceRemote";
		Context context;						
		try {
			context = new InitialContext();
			AnswerServiceRemote proxy= (AnswerServiceRemote) context.lookup(gndi); 
		
			return proxy;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    
    @FXML
    void ShowList(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/jobOffer/Questions.fxml"));
			 Scene scene = new Scene(root);
		      
		       InterviewAndApplication.stage.setScene(scene);
		       InterviewAndApplication.stage.setIconified(false);
		       
		       InterviewAndApplication.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();    } 
    }
    
    
    @FXML
    void InputControl(KeyEvent event) {
    	

    }
    @FXML
    void RedFunction(KeyEvent event) {
    	if (textarr.getText().length()<5) {
    	textarr.setFocusColor(Color.RED);
    }
    	else {
        	textarr.setFocusColor(Color.GREEN);
        }}

    
}
