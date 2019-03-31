/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkClient.main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tn.redhats.network.networkServer.services.CandidatProfilServiceRemote;

/**
 *
 * @author Coulibaly
 */
public class candidateFXMain extends Application {
    
    private static CandidatProfilServiceRemote proxy;
    public static Stage stage= new Stage();
	@Override
    public void start(Stage stage) throws Exception {    
      
        //Parent root  = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/candidateProfile/signUp_fxml.fxml"));
      //  Parent root  = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/candidateProfile/profilePage.fxml"));
      //Parent root  = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/candidateProfile/signIN_fxml.fxml"));
        Parent root  = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/candidateProfile/contactPage.fxml"));
        //JFXDecorator decorator = new JFXDecorator(stage, root);
        //decorator.setCustomMaximize(false);
        //decorator.setBorder(Border.EMPTY);
        Scene scene = new Scene(root);
       // scene.getStylesheets().add(BIENETRE.class.getResource("styles.css").toExternalForm());
        //stage.initStyle(StageStyle.UNDECORATED);
         
        stage.setScene(scene);
        stage.setIconified(false);
        candidateFXMain.stage=stage;
        stage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
		 launch(args);
    }
    
}
