/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkClient.main;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.redhats.network.networkServer.entities.Course;
import tn.redhats.network.networkServer.entities.CourseEnrollement;
import tn.redhats.network.networkServer.services.CourseEnrollement_serviceRemote;
import tn.redhats.network.networkServer.services.CoursesserviceRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * FXML Controller class
 *
 * @author Emir Fattoum
 */
public class CoursesClientController implements Initializable {
    @FXML
    private VBox Vcourses;
    @FXML
    private JFXButton Homebutton;
    @FXML
    private JFXButton Profilebutton;
    @FXML
    private JFXButton JObutton;
    @FXML
    private JFXButton EnterButton;
    @FXML
    private JFXButton Eventbutton;
    @FXML
    private JFXButton coursesbutton;
    @FXML
    private JFXTextArea searchCourses;
    @FXML
    private JFXButton My_courses;
    @FXML
    private JFXButton propose_course;
    
    public static Course course;
    
    public static String m="" ;
    
    public static CourseEnrollement ce;
    
    public static ArrayList <CourseEnrollement> list = new ArrayList() ;

    /**
     * Initializes the controller class.
     */
    private static URL url;
    private static ResourceBundle rb ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Context ctx = new InitialContext() ;
            Object obj = ctx.lookup("/networkServer-ear/networkServer-ejb/Coursesservice!tn.redhats.network.networkServer.services.CoursesserviceRemote");
            CoursesserviceRemote s = (CoursesserviceRemote)obj;
            ArrayList <Course> l = s.return_v_course();
            for(Course c : l) 
                {
            	    
            		Course_ModelController.setparameters(c);
                    Parent root = FXMLLoader.load(getClass().getResource("Course_Model.fxml"));
                    Vcourses.getChildren().add(root);
                    
                 }
            
        
        } catch (NamingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
    
	

    @FXML
    private void all_courses(ActionEvent event) {
    	initialize(url,rb);
    }

     @FXML
    private void go_to_my_courses(ActionEvent event) {
    	
    	try {
            // TODO
    		m="on";
            Context ctx = new InitialContext() ;
            Object obj = ctx.lookup("/networkServer-ear/networkServer-ejb/CourseEnrollement_service!tn.redhats.network.networkServer.services.CourseEnrollement_serviceRemote");
            CourseEnrollement_serviceRemote s = (CourseEnrollement_serviceRemote)obj;
            list = s.read_courseEnrollement(0001);
            Parent root = FXMLLoader.load(getClass().getResource("My_courses.fxml"));
            Scene scene = new Scene( root);
            main.pStage.setScene(scene);
            main.pStage.setTitle("Network");
            main.pStage.show();

            
        
        } catch (NamingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }

    @FXML
    private void Propose_a_course_to_admin(ActionEvent event) {
    
    try {
        Parent root = FXMLLoader.load(getClass().getResource("Course_p_add.fxml"));
        Scene scene = new Scene( root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Network");
        primaryStage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
}
