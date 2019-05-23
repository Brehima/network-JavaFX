/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.main;

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
 * @author lenovo
 */
public class main extends Application {
    
    @Override
    public void start(Stage primaryStage) {

    	Parent root;
        try {
			root = FXMLLoader.load(getClass().getResource("/fxml/signin.fxml"));
			Scene scene = new Scene(root,950,650);
            primaryStage.setTitle("NetWork");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {

			e.printStackTrace();
		}
    	
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
