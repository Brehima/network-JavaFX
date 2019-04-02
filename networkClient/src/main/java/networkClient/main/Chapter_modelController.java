/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkClient.main;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javax.swing.text.PlainDocument;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.redhats.network.networkServer.entities.Course;
import tn.redhats.network.networkServer.entities.Course_chapters;

/**
 * FXML Controller class
 *
 * @author Emir Fattoum
 */
public class Chapter_modelController implements Initializable {
    @FXML
    private Text chapter_number;
    @FXML
    private JFXTextField chapter_title;
    @FXML
    private JFXTextField chapter_url;
    @FXML
    private Button Addbtn;
    
    public static Set<Course_chapters> chapters=new HashSet<Course_chapters>() ;
    @FXML
    private Button play;
    
    public static Course_chapters ch =new Course_chapters()  ;
    public static String path;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	if (LoginController.role == "client")
        {
            Addbtn.setVisible(false);
            play.setVisible(true);

            
            
        }
        if (LoginController.role == "admin")
        {
        	Addbtn.setVisible(true);
            play.setVisible(false);
            
        }
        chapter_title.setText(ch.getChapter_title());
        chapter_url.setText(ch.getUrl());
        path=ch.getUrl();
        chapter_number.setText(ch.getChapter_id()+"");
    }    
    
    public static void setparameters (Course_chapters c)
    {
    	Chapter_modelController.ch = c ;
    }

    @FXML
    private void AddAction(ActionEvent event) {
    	Course_chapters chp = new Course_chapters();
    	chp.setChapter_title(chapter_title.getText());
    	chp.setUrl(chapter_url.getText());
    	chapters.add(chp);
    }

    @FXML
    private void play_chapter(ActionEvent event) {
    	
        Media_playerController.setparameters (ch);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Media_player.fxml"));
            Scene scene = new Scene( root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Network");
            primaryStage.show();
        } 
        catch (IOException ex)
        {
        	
            ex.printStackTrace();
        }
    	
    }
    
    


	
}
