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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.redhats.network.networkServer.entities.Course;
import tn.redhats.network.networkServer.services.Course_chapterServicesRemote;
import tn.redhats.network.networkServer.services.CoursesserviceRemote;

/**
 * FXML Controller class
 *
 * @author Emir Fattoum
 */
public class Course_ModelController implements Initializable {
       
    @FXML
    private ImageView Course_photo;
    @FXML
    private JFXTextField course_title;
    @FXML
    private AnchorPane Course_link;
    
    public static Course course =new Course()  ;
    @FXML
    private JFXButton view_course;
    @FXML
    private Pane course_model_price_visibility;
    @FXML
    private Text Price_text;
    @FXML
    private Text rating_text;
    @FXML
    private Text course_percentage_status;
    @FXML
    private JFXButton edit_course;
    @FXML
    private JFXButton delete_course;
    @FXML
    private Pane course_model_status_visibility;
    @FXML
    private Text course_desc;
    @FXML
    private Label course_id;
    @FXML
    private JFXButton gochapter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    	
    	//course=CoursesClientController.course ;

        if (LoginController.role == "client")
        {	
        	if (CoursesClientController.m=="")
        	{	
            edit_course.setVisible(false);
            delete_course.setVisible(false);
            course_model_status_visibility.setVisible(false);
            
            
        	}
        	if (CoursesClientController.m=="on")
        	{	
            edit_course.setVisible(false);
            delete_course.setVisible(false);
            course_model_status_visibility.setVisible(false);
            view_course.setVisible(false);
            gochapter.setVisible(true);
            
            
        	}
        	
        if (LoginController.role == "admin")
        {
            edit_course.setVisible(true);
            delete_course.setVisible(true);
            course_model_status_visibility.setVisible(true);
            course_model_price_visibility.setVisible(false);
            view_course.setVisible(false);
            
        }
        course_title.setText(course.getCourseTitle());
        course_desc.setText(course.getDescription());
        Image im = new Image(course.getImage_url()) ;
        Course_photo.setImage(im);
        Price_text.setText(course.getPrice()+"");
        rating_text.setText(course.getRate()+"");
        course_id.setText(course.getId()+"");

        }
    }  
    public static void setparameters (Course c)
    {
    	Course_ModelController.course = c ;
        
    }

    @FXML
    private void go_to_course(MouseEvent event) throws NamingException {
    	Context ctx = new InitialContext() ;
        Object obj = ctx.lookup("/networkServer-ear/networkServer-ejb/Coursesservice!tn.redhats.network.networkServer.services.CoursesserviceRemote");
        CoursesserviceRemote s = (CoursesserviceRemote)obj;
        s.read_course(Integerparseint(course_id.getText()));
    	Course_View_ModelController.setparameters (course);
    	try {
            Parent root = FXMLLoader.load(getClass().getResource("Course_View_Model.fxml"));
            Scene scene = new Scene( root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Network");
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    private int Integerparseint(String text) {
		// TODO Auto-generated method stub
		return 0;
	}
	@FXML
    private void go_to_course11(ActionEvent event) throws NamingException {
		Context ctx = new InitialContext() ;
        Object obj = ctx.lookup("/networkServer-ear/networkServer-ejb/Coursesservice!tn.redhats.network.networkServer.services.CoursesserviceRemote");
        CoursesserviceRemote s = (CoursesserviceRemote)obj;
        s.read_course(Integerparseint(course_id.getText()));
    	Course_View_ModelController.setparameters (course);
    	try {
            Parent root = FXMLLoader.load(getClass().getResource("Course_View_Model.fxml"));
            Scene scene = new Scene( root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Network");
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    	
    }

    @FXML
    private void edit_course(ActionEvent event) {
    
    	
    }

    @FXML
    private void delete_course(ActionEvent event) throws NamingException {
    	Context ctx = new InitialContext() ;
        Object obj = ctx.lookup("/networkServer-ear/networkServer-ejb/Coursesservice!tn.redhats.network.networkServer.services.CoursesserviceRemote");
        CoursesserviceRemote s = (CoursesserviceRemote)obj;
        s.del_course(course);
    }

    @FXML
    private void go_to_chapter(ActionEvent event) throws NamingException {
        Course_Chapter_ModelController.setparameters (course);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Course_Chapter_Model.fxml"));
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
