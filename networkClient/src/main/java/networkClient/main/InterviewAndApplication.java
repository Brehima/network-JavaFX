/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkClient.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Naskez
 */

public class InterviewAndApplication extends Application {
	public static Stage stage= new Stage();
    @Override
    public void start(Stage stage) throws IOException {
        Parent root  = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/jobOffer/Regroup.fxml"));
       // Parent root  = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/candidateProfile/signIN_fxml.fxml"));
        //JFXDecorator decorator = new JFXDecorator(stage, root);
        //decorator.setCustomMaximize(false);
        //decorator.setBorder(Border.EMPTY);
        Scene scene1 = new Scene(root);
       // scene.getStylesheets().add(BIENETRE.class.getResource("styles.css").toExternalForm());
        //stage.initStyle(StageStyle.UNDECORATED);
         
        stage.setScene(scene1);
        stage.setIconified(false);
        
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
