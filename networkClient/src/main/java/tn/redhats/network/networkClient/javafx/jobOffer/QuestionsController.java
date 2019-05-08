/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.jobOffer;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import networkClient.main.InterviewAndApplication;
import tn.redhats.network.networkServer.entities.JobOffer;
import tn.redhats.network.networkServer.entities.Question;
import tn.redhats.network.networkServer.services.JobOfferServiceRemote;
import tn.redhats.network.networkServer.services.QuestionServiceLocal;
import tn.redhats.network.networkServer.services.QuestionServiceRemote;
import tn.redhats.network.networkServer.services_impl.JobOfferService;
import tn.redhats.network.networkServer.services_impl.QuestionService;

/**
 * FXML Controller class
 *
 * @author Naskez
 */
public class QuestionsController implements Initializable {

    @FXML
    private JFXButton btn1;
    @FXML
    private JFXButton btn2;
    public static Question j;
    @FXML
    private TableView<Question> questtable;
    @FXML
    private TableColumn<Question, String> questcol;

	ObservableList<Question> JobOL = FXCollections.observableArrayList();
    @FXML
    private JFXButton btndel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
		List<Question> JobO = getProxy().findAllQuestion();
		
		if(JobO !=null) {
			
			for(Question j:JobO) {
				
				//id.setCellValueFactory(new PropertyValueFactory<JobOffer, Integer>("OfferId"));
				
				questcol.setCellValueFactory(new PropertyValueFactory<Question, String>("question"));
				
				questtable.setEditable(true);
				questcol.setCellFactory(TextFieldTableCell.forTableColumn());
		     
		        JobOL.add(j);
		        questtable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			
			}
			questtable.setItems(JobOL);
		}
    }    
    public QuestionServiceRemote getProxy() {
		String gndi="networkServer-ear/networkServer-ejb/QuestionService!tn.redhats.network.networkServer.services.QuestionServiceRemote";
		Context context;
		try {
			context = new InitialContext();
			QuestionServiceRemote proxy= (QuestionServiceRemote) context.lookup(gndi); 
		
			return  proxy;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    @FXML
    private void Selecte(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/jobOffer/AddQuest.fxml"));
			 Scene scene = new Scene(root);
		      
		       InterviewAndApplication.stage.setScene(scene);
		       InterviewAndApplication.stage.setIconified(false);
		       
		       InterviewAndApplication.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();    } 
    }

    @FXML
    private void btnadd(ActionEvent event) {
		  j = (Question) questtable.getSelectionModel().getSelectedItem();

   	 Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/jobOffer/JobOffer3.fxml"));
			 Scene scene = new Scene(root);
		      
		       InterviewAndApplication.stage.setScene(scene);
		       InterviewAndApplication.stage.setIconified(false);
		       
		       InterviewAndApplication.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();    } }

    @FXML
    private void btndelete(ActionEvent event) {
    	Question selectedone = questtable.getSelectionModel().getSelectedItem();
        if (selectedone != null) {
        	questtable.getItems().removeAll(questtable.getSelectionModel().getSelectedItem());
           
            
            
    		getProxy().Remove(selectedone.getId());;
         
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Question Was deleted", ButtonType.OK);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Select a question to be deleted", ButtonType.OK);
            alert.showAndWait();
        }
    	
    	
    	
		}
    
    @FXML
    private void QuestionEdit(TableColumn.CellEditEvent<Question, String> event) {
    	 Question conseilSelected = questtable.getSelectionModel().getSelectedItem();
         conseilSelected.setQuestion(event.getNewValue().toString());

         getProxy().updateQuestion(conseilSelected);
         Alert alert = new Alert(Alert.AlertType.INFORMATION, "Question modified.", ButtonType.OK);
         alert.showAndWait();
    
    }
    
    
   
    
}
