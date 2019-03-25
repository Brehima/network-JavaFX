/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.candidateProfile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.DatatypeConverter;

import org.mindrot.jbcrypt.BCrypt;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import networkClient.main.main;
import tn.redhats.network.networkServer.entities.CandidateProfile;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.enumeration.Role;
import tn.redhats.network.networkServer.services.CandidatProfilServiceRemote;

/**
 * FXML Controller class
 *
 * @author Coulibaly
 */
public class SignUp_fxmlController implements Initializable {

    /**
     * Initializes the controller class.
     */
	@FXML
	private JFXTextField  firstName;
	@FXML
	private JFXTextField lastName;
	@FXML
	private JFXTextField email;
	@FXML
	private JFXTextField username;
	@FXML
	private JFXPasswordField password;
	@FXML 
	private JFXDatePicker birthDate;
	@FXML
	private JFXComboBox<String> sexe;
	@FXML
	private JFXTextArea introduction;
	@FXML 
	private ImageView profileImage;
	@FXML
	private TabPane tabs;
	@FXML
	private Tab tab1;
	@FXML
	private Tab tab2;
	
	private String profileHashName;
	
	private File file;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sexe.getItems().add("Man");
        sexe.getItems().add("Women");
    	firstName.getValidators().add(new NameValidator());
    	lastName.getValidators().add(new NameValidator());
    	birthDate.getValidators().add(new BirthDateValidator());
    	profileHashName="";	
     
    }    
    public void goToStep2SignUp()
    {
   
    	tabs.getSelectionModel().select(1);
    	System.out.print(hashPicture(email.getText()));   
      
    }
    public void goToStep1SignUp()
    {
    	tabs.getSelectionModel().select(0);
    }
    public void finishSignUp()
    {
    	Date date = Date.from(birthDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    	Timestamp time = new Timestamp(date.getTime());
    	User user = new User();
    	saveFile(this.file);
		CandidateProfile candidate = new CandidateProfile();
		candidate.setIntroduction(introduction.getText());
		
		user.setFirstName(firstName.getText());
		user.setLastName(lastName.getText());
		user.setEmail(email.getText());
		user.setPassword(hashPassword(password.getText()));
		user.setRole(Role.Candidate);
		user.setUsername(username.getText());
		candidate.setDateNaissance(time);
		candidate.setSexe(sexe.getSelectionModel().getSelectedItem());
		candidate.setPhoto(profileHashName);
		candidate.getUsers().add(user);
		user.setProfile(candidate);
		
		  String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
			Context context;
			try {
				context = new InitialContext();
				CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
				proxy.signUp(user);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    }
    public void setProfilePicture()
    {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Selection la photo de profil");
    	//file.ad
    	//chooser .addChoosableFileFilter(new FileNameExtensionFilter());
    	fileChooser.getExtensionFilters().addAll(
    			new ExtensionFilter("JPG", "*.jpg"),
    			new ExtensionFilter("PNG", "*.png")
    			);
    	this.file= fileChooser.showOpenDialog(null);
    	if(file!=null)
    	{
    		profileImage.setImage(new Image(file.toURI().toString()));
    	}
    	else
    	{
    		System.out.println("no file selected");
    	}
    }
    public void validateFirstName()
    {
    	if(this.firstName.validate())
    	{
    		Color c = Color.web("#008000"); //green
            firstName.validate();
            firstName.focusColorProperty().setValue(c);
            firstName.getValidators().get(0).setMessage("");
    	}
    	else
    	{
    		 Color c = Color.web("#FF0000"); //red
    		 firstName.validate();
    		 firstName.focusColorProperty().setValue(c);
    		 firstName.getValidators().get(0).setMessage("you must enter at list 4 caracter");
    	}
    }
    public void validateLastName()
    {
    	if(this.lastName.validate())
    	{
    		Color c = Color.web("#008000"); //green
            lastName.validate();
            lastName.focusColorProperty().setValue(c);
            lastName.getValidators().get(0).setMessage("");
    	}
    	else
    	{
    		 Color c = Color.web("#FF0000"); //red
    		 lastName.validate();
    		 lastName.focusColorProperty().setValue(c);
    		 lastName.getValidators().get(0).setMessage("you must enter at list 4 caracter");
    	}
    }
    public void validateDate()
    {
    	BirthDateValidator birth =(BirthDateValidator) this.birthDate.getValidators().get(0);
    	birth.setYear(birthDate.getValue().getYear());
    	this.birthDate.getValidators().set(0, birth);
    	//System.out.println( birthDate.getValue().getYear());
    	if(this.birthDate.validate())
    	{
    		Color c = Color.web("#008000"); //green
    		birthDate.validate();
    		//birthDate.focusColorProperty().setValue(c);
    		birthDate.getValidators().get(0).setMessage("");
    	}
    	else
    	{
    		 Color c = Color.web("#FF0000"); //red
    		 birthDate.validate();
    		 //lastName.focusColorProperty().setValue(c);
    		 birthDate.getValidators().get(0).setMessage("your age should be between 18 and 70 year old");
    	}
    	
    }
    public void saveFile(File image)
    {
    	String fileName = "D://cours/JEE/workspace_PI/users_profile/"+hashPicture(this.email.getText())+".png";
    	profileHashName = fileName;
    	
    	try {
    	 	BufferedImage bImage =ImageIO.read(image);
    		ImageIO.write(bImage, "png", new File(fileName));
    	}
    	catch (IOException e) {
			// TODO: handle exception
    		throw new RuntimeException(e);
		}
    }
    public String hashPicture(String name)
    {
    	byte[] byteName;
    	name = name+" profile";
    	String chaineHasher="";
		try {
			byteName = name.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] digest = md.digest(byteName);
			chaineHasher = DatatypeConverter.printHexBinary(digest);
		} catch (UnsupportedEncodingException e1) {
		    System.out.println("probleme de conversion en byte");
			e1.printStackTrace();
		}
    	 catch (NoSuchAlgorithmException e) {
    		System.out.println("probleme de chargement du MD5"); 
			e.printStackTrace();
		}
    	return chaineHasher;
    }
    public String hashPassword(String pass)
    {

    	String chaineHasher=BCrypt.hashpw(pass, BCrypt.gensalt());   	
    	return chaineHasher;
    }
    
}
