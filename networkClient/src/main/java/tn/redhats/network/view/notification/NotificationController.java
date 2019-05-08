/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.view.notification;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import networkClient.main.main;
import tn.redhats.network.networkServer.services_impl.NotifService;
import tn.redhats.network.view.post.Post1Controller;
import tn.redhats.network.networkServer.entities.Comment;
import tn.redhats.network.networkServer.entities.Notification;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class NotificationController implements Initializable {
    @FXML
    private JFXButton notif;

    @FXML
    private Label lblNotif;

    @FXML
    private Circle cercle;
    
    private List<Notification> list;
    private int x=0;

    @FXML
    private JFXListView<Notification> listNotif;
    public static Notification newNotif = new Notification();
    Image image;
    public static int recupid;  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	lblNotif.setStyle("-fx-text-inner-color: white;");
    	lblNotif = new Label();
        listNotif.setVisible(false);
         
        try {
			x = main.getNotificationProxy().findAllNotification().size();
			if(x!=0)
				
	        {//lblNotif.setText("cbon");
				//System.out.println("c bon");
				lblNotif.setText(x+"");}
	        else 
	        { lblNotif.setVisible(false);
	             cercle.setVisible(false);
	        }
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
    
    @FXML
    void getNotif(ActionEvent event) throws NamingException {
    	if(listNotif.isVisible()==false)
        { 
            listNotif.setVisible(true);
            lblNotif.setVisible(false);
             cercle.setVisible(false);
        //NotifService notifS = new NotifService();
       
       list = main.getNotificationProxy().findAllNotification();
         Collections.sort(list, new Comparator<Notification>() {
        	 
        @Override
        public int compare(Notification o1, Notification o2) {
        	 return o1.getDateNotification().compareTo(
        	         o2.getDateNotification());
        	 }
         });
        
    
         ObservableList<Notification> items =FXCollections.observableArrayList(list) ;
         listNotif.setItems(items);
         listNotif.setCellFactory(param -> new ListCell<Notification>() {
          
            private ImageView imageView = new ImageView();
          
            @Override
            public void updateItem(Notification name, boolean empty) {
                 super.updateItem(name, empty);
                 if (empty) {
                     setText(null);
                     setGraphic(null);
                 }
                 
                 else {
                     image = new Image(name.getImage());
                     imageView.setImage(image);
                     imageView.setFitHeight(50);
                     imageView.setFitWidth(50);
                     setText(name.toString());
                     setGraphic(imageView);
                 }
           }
         });
        }
     

     else {
         for(Notification n:list) {
                listNotif.getItems().removeAll(n);
             }
       
             listNotif.setVisible(false);
    }
    }

    @FXML
    void setNotif(MouseEvent event) {
  
    	//NotifService notifS = new NotifService();
        listNotif.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
          try {
              Notification n =listNotif.getSelectionModel().getSelectedItem();
              main.getNotificationProxy().UpdateNotification(n);
                Stage st = new Stage();
      FXMLLoader loader = new FXMLLoader(getClass().getResource("tn/redhats/network/view/post/Post1.fxml"));
      Parent root1;
         
              root1 = (Parent) loader.load();
          
      st.setTitle("Event");
      Scene scene1 = new Scene(root1);
      
      // scene1.getStylesheets().add("css/stylesheet1.css");
      st.setScene(scene1);
      int id = n.getId();
      Post1Controller mainController = loader.<Post1Controller>getController();
      //Post1Controller.recupid;

      st.show();
              } catch (IOException ex) {
              Logger.getLogger(NotificationController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      }
  });
  }
    }


   