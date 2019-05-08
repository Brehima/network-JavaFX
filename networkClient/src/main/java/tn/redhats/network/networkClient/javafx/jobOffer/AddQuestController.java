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
import javafx.event.ActionEvent;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
import tn.redhats.network.networkServer.entities.Question;
import tn.redhats.network.networkServer.services.QuestionServiceRemote;


/**
 * FXML Controller class
 *
 * @author Naskez
 */
public class AddQuestController implements Initializable {

    @FXML
    private JFXTextArea textarea;
    @FXML
    private JFXButton addbtn;
    @FXML
    private JFXButton addbtn1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public QuestionServiceRemote getProxy() {
		String gndi="networkServer-ear/networkServer-ejb/QuestionService!tn.redhats.network.networkServer.services.QuestionServiceRemote";
		Context context;
		try {
			context = new InitialContext();
			QuestionServiceRemote proxy= (QuestionServiceRemote) context.lookup(gndi); 
		
			return proxy;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

    @FXML
    private void ADDONE(ActionEvent event) {
    	if (textarea.getText().length()< 10) {
      		 Alert alert = new Alert(Alert.AlertType.INFORMATION, "Your question must at least contain 10 letters", ButtonType.OK);
               alert.showAndWait();
      	}
       	
       	else {    	    	   	
    	Question ns = new Question( textarea.getText());
 	   getProxy().AddQuestion(ns);
 	  Alert alert = new Alert(Alert.AlertType.INFORMATION, "Question Added ", ButtonType.OK);
      alert.showAndWait();
    }}

    @FXML
    private void Lists(ActionEvent event) {
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
    void RedFunction(KeyEvent event) {
    	if (textarea.getText().length()< 10) {
    	textarea.setFocusColor(Color.RED);
    }else {
    	textarea.setFocusColor(Color.GREEN);
    }
    	}

    
}
