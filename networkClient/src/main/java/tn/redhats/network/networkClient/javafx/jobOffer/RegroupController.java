/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.jobOffer;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import networkClient.main.InterviewAndApplication;
import tn.redhats.network.networkServer.entities.Question;

/**
 * FXML Controller class
 *
 * @author Naskez
 */

public class RegroupController implements Initializable {


    @FXML
    private JFXButton Button1;

    @FXML
    private JFXButton Button2;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    @FXML
    void JobOfferButton(ActionEvent event) {
       	 Parent root;
    		try {
    			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/jobOffer/JobOffer1.fxml"));
    			 Scene scene = new Scene(root);
    		      
    		       InterviewAndApplication.stage.setScene(scene);
    		       InterviewAndApplication.stage.setIconified(false);
    		       
    		       InterviewAndApplication.stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();    }

    }

    @FXML
    void OnlineTestButton(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/jobOffer/Questions.fxml"));
			 Scene scene = new Scene(root);
		      
		       InterviewAndApplication.stage.setScene(scene);
		       InterviewAndApplication.stage.setIconified(false);
		       
		       InterviewAndApplication.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

    }
    
}
}

