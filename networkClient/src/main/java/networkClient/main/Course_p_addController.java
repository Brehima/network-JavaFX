/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkClient.main;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.redhats.network.networkServer.entities.Course;
import tn.redhats.network.networkServer.entities.CourseEnrollement;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services.CourseEnrollement_serviceRemote;
import tn.redhats.network.networkServer.services.CoursesserviceRemote;

/**
 * FXML Controller class
 *
 * @author Emir Fattoum
 */
public class Course_p_addController implements Initializable {
    @FXML
    private TextField course_p_title;
    @FXML
    private TextField course_p_url;
    @FXML
    private TextField course_p_desc;
    @FXML
    private TextField course_p_domain;
    @FXML
    private JFXButton add_course_p;
    @FXML
    private JFXButton back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void p_course(ActionEvent event) throws NamingException {
    	Course c =new Course();
    	c.setCourseTitle(course_p_title.getText());
    	c.setDescription(course_p_desc.getText());
    	c.setImage_url(course_p_url.getText());
    	c.setDomain(course_p_domain.getText());
    	Context ctx = new InitialContext() ;
        Object obj = ctx.lookup("//networkServer-ear/networkServer-ejb/Coursesservice!tn.redhats.network.networkServer.services.CoursesserviceRemote");
        CoursesserviceRemote s = (CoursesserviceRemote)obj;
        s.add_course(c);
        System.out.println("Enrolled successfully");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	primaryStage.close();
    }

    @FXML
    private void back(ActionEvent event) {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	primaryStage.close();
    }
    
}
