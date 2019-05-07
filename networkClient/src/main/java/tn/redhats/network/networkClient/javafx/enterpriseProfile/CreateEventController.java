/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.enterpriseProfile;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;


import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import networkClient.main.main;
import tn.redhats.network.networkClient.javafx.login.SigninController;
import tn.redhats.network.networkServer.entities.Event;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class CreateEventController implements Initializable {

    @FXML
    private JFXButton backButton;
    @FXML
    private AnchorPane anchorPaneID;
    @FXML
    private JFXTextField titleTextField;
    @FXML
    private JFXTextArea descriptionTextArea;
    @FXML
    private JFXTextField locationTextField;
    @FXML
    private DatePicker datePickerRDV;
    @FXML
    private JFXComboBox<String> hourMinCombobox;
    @FXML
    private JFXButton postButton;

    
    private Boolean eventTitleValidation = false, eventDescriptionValidation = false, eventLocationValidation = false;
    @FXML
    private Label titleLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label locationLabel;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	titleTextField.setStyle("-fx-text-inner-color: white;");
    	descriptionTextArea.setStyle("-fx-text-inner-color: white;");
    	locationTextField.setStyle("-fx-text-inner-color: white;");
    	
    	
    	String[] hhmm={
    			"08:00",
    			"08:30",
    			"09:00",
    			"09:30",
    			"10:00",
    			"10:30",
    			"11:00",
    			"11:30",
    			"12:00",
    			"12:30",
    			"13:00",
    			"13:30",
    			"14:00",
    			"14:30",
    			"15:00",
    			"15:30",
    			"16:00",
    			"16:30",
    			"17:00",
    			"17:30",
    			"18:00",
    			"18:30",
    			"19:00",
    			"19:30",
    			"20:00"};
    			ObservableList<String> sl=FXCollections.observableArrayList(hhmm);
    			hourMinCombobox.setItems(sl);
    			
    			
    			
    			
    
    			if(LocalTime.now().isAfter(LocalTime.of(20, 00)) && LocalTime.now().isBefore(LocalTime.of(23, 59)) ){
    			    final Callback<DatePicker, DateCell> dayCellFactory = 
    			            new Callback<DatePicker, DateCell>() {
    			                @Override
    			                public DateCell call(final DatePicker datePicker) {
    			                    return new DateCell() {
    			                        @Override
    			                        public void updateItem(LocalDate item, boolean empty) {
    			                            super.updateItem(item, empty);
    			                           
    			                            if (item.isBefore(LocalDate.now().plusDays(1)) || item.getDayOfWeek() == DayOfWeek.SUNDAY) {
    			                                    setDisable(true);
    			                                    setStyle("-fx-background-color: #ef3a23;");
    			                            }   
    			                    }
    			                };
    			            }
    			        };
    			datePickerRDV.setDayCellFactory(dayCellFactory);
    			datePickerRDV.setValue(LocalDate.now().plusDays(1));
    			hourMinCombobox.getSelectionModel().select("08:00");
    			}
    			else if(LocalTime.now().isBefore(LocalTime.of(8, 00)) && LocalTime.now().isAfter(LocalTime.of(00,01))){
    			    final Callback<DatePicker, DateCell> dayCellFactory = 
    			            new Callback<DatePicker, DateCell>(){
    			                @Override
    			                public DateCell call(final DatePicker datePicker) {
    			                    return new DateCell() {
    			                        @Override
    			                        public void updateItem(LocalDate item, boolean empty) {
    			                            super.updateItem(item, empty);
    			                           
    			                            if (item.isBefore(LocalDate.now()) || item.getDayOfWeek() == DayOfWeek.SUNDAY) {
    			                                    setDisable(true);
    			                                    setStyle("-fx-background-color: #ef3a23;");
    			                            }   
    			                    }
    			                };
    			            }
    			        };
    			datePickerRDV.setDayCellFactory(dayCellFactory);
    			datePickerRDV.setValue(LocalDate.now());
    			hourMinCombobox.getSelectionModel().select("08:00");   
    			}
    			else{
    			    final Callback<DatePicker, DateCell> dayCellFactory = 
    			            new Callback<DatePicker, DateCell>() {
    			                @Override
    			                public DateCell call(final DatePicker datePicker) {
    			                    return new DateCell() {
    			                        @Override
    			                        public void updateItem(LocalDate item, boolean empty) {
    			                            super.updateItem(item, empty);
    			                           
    			                            if (item.isBefore(LocalDate.now()) || item.getDayOfWeek() == DayOfWeek.SUNDAY) {
    			                                    setDisable(true);
    			                                    setStyle("-fx-background-color: #ef3a23;");
    			                            }   
    			                    }
    			                };
    			            }
    			        };
    			datePickerRDV.setDayCellFactory(dayCellFactory);
    			datePickerRDV.setValue(LocalDate.now());
    			hourMinCombobox.getSelectionModel().select((LocalTime.now().getHour()+2)+":00");
    			
    			
  }    }

    @FXML
    private void clicBack(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/accessEnterpriseProfile.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    }

    @FXML
    private void eventTitleKeyReleased(KeyEvent event) {
    	if(titleTextField.getText().length() > 4 ) {
    		titleTextField.setFocusColor(Color.LAWNGREEN);
    		titleLabel.setText("Valid title");
    		titleLabel.setTextFill(Color.LAWNGREEN);
    		titleLabel.setOpacity(1);
    		eventTitleValidation = true;
    		checkValidation();
    	}else {
    		titleTextField.setFocusColor(Color.RED);
    		titleLabel.setText("Invalid title (Please type at least 5 characters)");
    		titleLabel.setTextFill(Color.RED);
    		titleLabel.setOpacity(1);
    	}
    }

    @FXML
    private void desriptionKeyReleased(KeyEvent event) {
    	if(descriptionTextArea.getText().length() > 29 ) {
    		descriptionTextArea.setFocusColor(Color.LAWNGREEN);
    		descriptionLabel.setText("Valid description");
    		descriptionLabel.setTextFill(Color.LAWNGREEN);
    		descriptionLabel.setOpacity(1);
    		eventDescriptionValidation = true;
    		checkValidation();
    	}else {
    		descriptionTextArea.setFocusColor(Color.RED);
    		descriptionLabel.setText("Invalid description (Please type at least 30 characters)");
    		descriptionLabel.setTextFill(Color.RED);
    		descriptionLabel.setOpacity(1);
    	}
    }

    @FXML
    private void locationKeyReleased(KeyEvent event) {
    	if(locationTextField.getText().length() > 9 ) {
    		locationTextField.setFocusColor(Color.LAWNGREEN);
    		locationLabel.setText("Valid location");
    		locationLabel.setTextFill(Color.LAWNGREEN);
    		locationLabel.setOpacity(1);
    		eventLocationValidation = true;
    		checkValidation();
    	}else {
    		locationTextField.setFocusColor(Color.RED);
    		locationLabel.setText("Invalid location (Please type at least 10 characters)");
    		locationLabel.setTextFill(Color.RED);
    		locationLabel.setOpacity(1);
    	}
    }

    @FXML
    private void clicPost(ActionEvent event) throws NamingException {
    	Event e = new Event();
    	e.setTitle(titleTextField.getText());
    	e.setDescription(descriptionTextArea.getText());
    	e.setLocation(locationTextField.getText());
    	e.setEnterprise(SigninController.staticEP);
    	String date = datePickerRDV.getValue().toString();
    	String time = hourMinCombobox.getSelectionModel().getSelectedItem();
    	//e.setDateEvent("02-04-2019 16:44:28");
    	e.setDateEvent(date+" "+time);
    	main.getEnterpriseProfileProxy().addEvent(e);
    	
    	
    	Alert alerte = new Alert(Alert.AlertType.INFORMATION);
        alerte.setTitle("Information dialog");
        alerte.setHeaderText("Congratulations ! ");
        alerte.setContentText("Your event has been posted successfully");
        alerte.showAndWait();
        
    	
    }
    
    private void checkValidation() {
    	if (eventTitleValidation == true && eventDescriptionValidation == true 
    			&& eventLocationValidation == true) {
    		postButton.setOpacity(1);
    	}
    }
    
}
