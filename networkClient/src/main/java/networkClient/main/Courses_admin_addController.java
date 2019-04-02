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
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.redhats.network.networkServer.entities.Course;
import tn.redhats.network.networkServer.entities.Course_chapters;
import tn.redhats.network.networkServer.services.CoursesserviceRemote;

/**
 * FXML Controller class
 *
 * @author Emir Fattoum
 */
public class Courses_admin_addController implements Initializable {
    @FXML
    private Button back;
    @FXML
    private JFXTextField course_a_title;
    @FXML
    private JFXTextField course_a_domain;
    @FXML
    private JFXTextField course_a_price;
    @FXML
    private JFXTextField course_a_source;
    @FXML
    private JFXTextField course_a_desc;
    @FXML
    private Spinner<Integer> course_chapters;
    @FXML
    private JFXButton course_chapters_set;
    @FXML
    public static JFXButton course_add_a;
    @FXML
    private VBox chapterslist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void close(ActionEvent event) {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	primaryStage.close();
    }

    @FXML
    private void set_chapters(ActionEvent event) throws IOException {
    	int i=Integer.parseInt((course_chapters_set.getText()));
    	for(int j=0 ; j<i ;j++)
    	{
    		 Parent root = FXMLLoader.load(getClass().getResource("Course_Model.fxml"));
             chapterslist.getChildren().add(root);
    	}
    	
    }

    @FXML
    private void add_course(ActionEvent event) throws NamingException {
    	Course c =new Course();
    	c.setCourseTitle(course_a_title.getText());
    	c.setDescription(course_a_desc.getText());
    	c.setImage_url(course_a_source.getText());
    	c.setDomain(course_a_domain.getText());
    	c.setValidationStatus("Valid");
    	c.setPrice(Float.parseFloat(course_a_price.getText()));
    	
    	Context ctx = new InitialContext() ;
        Object obj = ctx.lookup("//networkServer-ear/networkServer-ejb/Coursesservice!tn.redhats.network.networkServer.services.CoursesserviceRemote");
        CoursesserviceRemote s = (CoursesserviceRemote)obj;
        s.add_course(c);
        for(Course_chapters chap : Chapter_modelController.chapters)
        {
        	chap.setCourse(c);
        	//add chapter  with service implemented  in ejb
        	
        }
        
        System.out.println("Course added  successfully");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	primaryStage.close();
    }
    
}
