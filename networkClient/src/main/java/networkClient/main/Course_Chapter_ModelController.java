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
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.redhats.network.networkServer.entities.Course;
import tn.redhats.network.networkServer.entities.Course_chapters;
import tn.redhats.network.networkServer.services.Course_chapterServicesRemote;
import tn.redhats.network.networkServer.services.CoursesserviceRemote;

/**
 * FXML Controller class
 *
 * @author Emir Fattoum
 */
public class Course_Chapter_ModelController  {
    @FXML
    private JFXButton back;
    @FXML
    private JFXButton finish_chapter;
    @FXML
    private JFXButton my_courses;
    @FXML
    private JFXButton home;
    @FXML
    private JFXTextField course_title;
    @FXML
    private Text course_link;
    
   public static Course course =new Course()  ;
    @FXML
    private VBox Vchapters;

    /**
     * Initializes the controller class.
     */

    public void initialize() {
        
    	// TODO
    	try {
            // TODO
    		course_title.setText(course.getCourseTitle());
            Context ctx = new InitialContext() ;
            Object obj = ctx.lookup("networkServer-ear/networkServer-ejb/Course_chapterServices!tn.redhats.network.networkServer.services.Course_chapterServicesRemote");
            Course_chapterServicesRemote s = (Course_chapterServicesRemote)obj;
            List <Course_chapters> list = s.return_course_chapters(course.getId());
            for(Course_chapters c : list) 
                {
                    Chapter_modelController.setparameters(c);
                    Parent root = FXMLLoader.load(getClass().getResource("chapter_Model.fxml"));
                    Vchapters.getChildren().add(root);
                    
                 }
            
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
        ex.printStackTrace();
        }
    	
    }    
    
    public static void setparameters (Course c)
    {
    	Course_Chapter_ModelController.course = c ;
    }

    @FXML
    private void close(ActionEvent event) {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	primaryStage.close();
    }

    @FXML
    private void Next_chapter(ActionEvent event) {
    	
    }

    @FXML
    private void my_courses(ActionEvent event) {
    }

    @FXML
    private void go_home(ActionEvent event) {
    }

    @FXML
    private void chapter_url_text(MouseEvent event) {
    }
    
}
