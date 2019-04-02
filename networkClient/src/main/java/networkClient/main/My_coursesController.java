/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkClient.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import tn.redhats.network.networkServer.entities.CourseEnrollement;

/**
 * FXML Controller class
 *
 * @author Emir Fattoum
 */
public class My_coursesController implements Initializable {
    @FXML
    private VBox V_my_courses;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	for (CourseEnrollement c : CoursesClientController.list)
    	{
    	
    		Course_ModelController.setparameters(c.getCourse());
            Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("Course_Model.fxml"));
				V_my_courses.getChildren().add(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
    	}	
    }    
    	
    
}
