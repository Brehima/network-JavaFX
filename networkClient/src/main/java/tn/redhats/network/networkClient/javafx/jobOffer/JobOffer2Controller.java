/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.jobOffer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import networkClient.main.InterviewAndApplication;
import static tn.redhats.network.networkClient.javafx.jobOffer.JobOffer1Controller.j;
/**
 * FXML Controller class
 *
 * @author Naskez
 */
public class JobOffer2Controller implements Initializable {

	@FXML
    private Label descTextId;

    @FXML
    private Label ExperTextId;

    @FXML
    private Label LocatTextId;

   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
        JobOffer1Controller lc = new JobOffer1Controller();
         ExperTextId.setText(String.valueOf(lc.j.getExpertiseLevel()));
         descTextId.setText(String.valueOf(lc.j.getDescription()));
         LocatTextId.setText(String.valueOf(lc.j.getLocation()));
      
     

    }
    @FXML
	private void Back()
    {
    	 Parent root;
 		try {
 			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/jobOffer/JobOffer1.fxml"));
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
