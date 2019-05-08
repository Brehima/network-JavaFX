/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.jobOffer;


import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import networkClient.main.InterviewAndApplication;

import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.services.JobOfferServiceRemote;
import tn.redhats.network.networkServer.services_impl.JobOfferService;

/**
 * FXML Controller class
 *
 * @author Naskez
 */
public class JobOffer1Controller implements Initializable {

	@FXML
	private TableView<JobOffer> table;
	@FXML
	private TableColumn<JobOffer, Integer> id;
	@FXML
	private TableColumn<JobOffer, String> descriptionT;
	@FXML
	private TableColumn<JobOffer, String> expertiseLevelT;
	@FXML
	private TableColumn<JobOffer, String> locationT;
	
	ObservableList<String> comboList = FXCollections.observableArrayList("C", "C++","Java","Python","JavaFX");

	private TextField DescriptionF;
	private TextField ExpertiseLevelF;
	private TextField LocationF;

	public static JobOffer j;
	String OfferId;
	ObservableList<JobOffer> JobOL = FXCollections.observableArrayList();
    @FXML
    private AnchorPane Recherche;
    @FXML
    private TextField Description;
    @FXML
    private TextField ExpertiseLevel;
    @FXML
    private TextField Location;
    @FXML
    private JFXButton next;
    @FXML
    private JFXButton Delete;
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	    
		
		AfficheJobs();
		/*
		 * Recherche.textProperty().addListener(new ChangeListener() {
		 * 
		 * @Override public void changed(ObservableValue observable, Object oldValue,
		 * Object newValue) { try { filtrerStadiumList((String) oldValue, (String)
		 * newValue); } catch (SQLException ex) {
		 * Logger.getLogger(JobOffer1Controller.class.getName()).log(Level.SEVERE, null,
		 * ex); } }
		 * 
		 * });
		 */
	}

	void showJobList(JobOffer JobO) {
		OfferId = String.valueOf(JobO.getId());
		DescriptionF.setText(JobO.getDescription());
		ExpertiseLevelF.setText(JobO.getExpertiseLevel());
		LocationF.setText(JobO.getLocation());
	}

	public void AfficheJobs() {
		JobOfferService s = new JobOfferService();
		List<JobOffer> JobO = getProxy().findAllJobOffer();
		
		if(JobO !=null) {
			
			for(JobOffer j:JobO) {
				
				//id.setCellValueFactory(new PropertyValueFactory<JobOffer, Integer>("OfferId"));
				descriptionT.setCellValueFactory(new PropertyValueFactory<JobOffer, String>("description"));
				locationT.setCellValueFactory(new PropertyValueFactory<JobOffer, String>("location"));
				expertiseLevelT.setCellValueFactory(new PropertyValueFactory<JobOffer, String>("expertiseLevel"));
				
				table.setEditable(true);
			
				
				descriptionT.setCellFactory(TextFieldTableCell.forTableColumn());
		        locationT.setCellFactory(TextFieldTableCell.forTableColumn());
		        expertiseLevelT.setCellFactory(TextFieldTableCell.forTableColumn());
		        JobOL.add(j);
		        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			
			}
			
			table.setItems(JobOL);
		}
	}
	public JobOfferServiceRemote getProxy() {
		String gndi="networkServer-ear/networkServer-ejb/JobOfferService!tn.redhats.network.networkServer.services.JobOfferServiceRemote";
		Context context;
		try {
			context = new InitialContext();
			JobOfferServiceRemote proxy= (JobOfferServiceRemote) context.lookup(gndi); 
		
			return proxy;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	@FXML
//    private void SwitchInterface(ActionEvent event) {
//		
//	}
//	
//	void filterJobOffer(String oldValue, String newValue) throws SQLException {
//		JobOffer JobO = new JobOffer();
//		String choix = choiseBox.getValue();
//		if (choix.equals("Java")){
//			ObservableList<JobOffer> filteredList = FXCollections.observableArrayList();
//			if (Filter.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
//				table.setItems(JobO);
//			}else{
//				newValue = newValue.toUpperCase();
//				for (JobOffer st : table.getItems()) {
//					String filterJobOfferExpertise = st.getExpertiseLevel();
//					if (filterJobOfferExpertise.toUpperCase().contains(newValue)){
//						filteredList.add(st);
//					}
//				}
//				table.setItems(filteredList);
//			}
//		}
//	}
	
	
	
	@FXML
	private void loadStep2Code()
    {
		  j = (JobOffer) table.getSelectionModel().getSelectedItem();
    	 Parent root;
 		try {
 			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/jobOffer/JobOffer2.fxml"));
 			 Scene scene = new Scene(root);
 		      
 		       InterviewAndApplication.stage.setScene(scene);
 		       InterviewAndApplication.stage.setIconified(false);
 		       
 		       InterviewAndApplication.stage.show();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    }

    @FXML
    private void DeleteAction(ActionEvent event) {
    	JobOffer selectedone = table.getSelectionModel().getSelectedItem();
        if (selectedone != null) {
            table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
           
            
            
    		getProxy().Remove(selectedone.getId());;
         
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Job Offer Was deleted", ButtonType.OK);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Select an  element to delete", ButtonType.OK);
            alert.showAndWait();
        }
    	
    	
    }
    @FXML
    private void changeCellEvent(TableColumn.CellEditEvent<JobOffer, String> event) {
        JobOffer conseilSelected = table.getSelectionModel().getSelectedItem();
        conseilSelected.setDescription(event.getNewValue().toString());

        getProxy().UpdateJobOffer(conseilSelected);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Description modified.", ButtonType.OK);
        alert.showAndWait();
    }

    
  
    @FXML
    private void changeCellEvent1(TableColumn.CellEditEvent<JobOffer, String> event) {
    	JobOffer conseilSelected = table.getSelectionModel().getSelectedItem();
        conseilSelected.setExpertiseLevel(event.getNewValue().toString());

        getProxy().UpdateJobOffer(conseilSelected);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Expertise Level modified.", ButtonType.OK);
        alert.showAndWait();
    }
    @FXML
    private void changeCellEvent2(TableColumn.CellEditEvent<JobOffer, String> event) {
    	JobOffer conseilSelected = table.getSelectionModel().getSelectedItem();
        conseilSelected.setLocation(event.getNewValue().toString());

        getProxy().UpdateJobOffer(conseilSelected);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Localisation Level modified.", ButtonType.OK);
        alert.showAndWait();
    }


}
