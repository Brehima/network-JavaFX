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
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.redhats.network.networkServer.entities.Course;
import tn.redhats.network.networkServer.entities.CourseEnrollement;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services.CourseEnrollement_serviceRemote;
import tn.redhats.network.networkServer.services.CoursesserviceRemote;
import tn.redhats.network.networkServer.services_impl.CourseEnrollement_service;

/**
 * FXML Controller class
 *
 * @author Emir Fattoum
 */
public class Course_View_ModelController implements Initializable {
    @FXML
    private AnchorPane Course_page_0;
    
    private static Course course  ;
    @FXML
    private Text rating;
    @FXML
    private Text price;
    @FXML
    private JFXTextField Course_title;
    @FXML
    private JFXButton Enroll;
    @FXML
    private Text course_desc;
    @FXML
    private ImageView course_url;
    @FXML
    private JFXButton Close;

    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
    	
        // TODO
    	Course_title.setText(course.getCourseTitle());
        course_desc.setText(course.getDescription());
        Image im = new Image(course.getImage_url()) ;
        course_url.setImage(im);
        price.setText(course.getPrice()+"");
        rating.setText(course.getRate()+"");
        

    }  
    public static void setparameters (Course c)
    {
    	Course_View_ModelController.course = c ;
        
    }

    @FXML
    private void close_course_view(MouseEvent event) {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	primaryStage.close();
    	
    }

    @FXML
    private void enroll_in_course(ActionEvent event) throws NamingException {
    	CourseEnrollement ce=new CourseEnrollement();
    	System.out.println(course);
    	ce.setCourse(course);
    	User u = new User() ;  
    	u.setId(LoginController.uid);
    	ce.setUser(u);
    	//Context ctx = new InitialContext() ;
        //Object obj = ctx.lookup("/networkServer-ear/networkServer-ejb/CourseEnrollement_service!tn.redhats.network.networkServer.services.CourseEnrollement_serviceRemote");
        CourseEnrollement_serviceRemote s =getProxy();
        s.add_courseEnrollement(ce);
        System.out.println("Enrolled successfully");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	primaryStage.close();
    	
    }
    
    public CourseEnrollement_serviceRemote getProxy() {
		String gndi="/networkServer-ear/networkServer-ejb/CourseEnrollement_service!tn.redhats.network.networkServer.services.CourseEnrollement_serviceRemote";
		Context context;
		try {
			context = new InitialContext();
			CourseEnrollement_serviceRemote proxy= (CourseEnrollement_serviceRemote) context.lookup(gndi); 
		
			return proxy;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    	
    }
