/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.candidateProfile;

import java.awt.Desktop.Action;
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
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.DatatypeConverter;

import org.mindrot.jbcrypt.BCrypt;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import antlr.debug.Event;
import de.jensd.fx.glyphs.GlyphsBuilder;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import networkClient.main.candidateFXMain;
import networkClient.main.main;
import tn.redhats.network.networkServer.entities.CandidateProfile;
import tn.redhats.network.networkServer.entities.Code2FACandidate;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.enumeration.AccountStatus;
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
	private JFXTabPane  tabs;
	@FXML
	private Tab tab1;
	@FXML
	private Tab tab2;
	@FXML
	private Label passLabel;
	@FXML
	private JFXTextField signUpCode;
	@FXML
	private Label msgEmail;
	@FXML 
	private Label msgUserName;
	@FXML
	private JFXSpinner spinner2;
	@FXML
	private JFXSpinner spinner3;
	private String profileHashName;
	
	private File file;
	private String generatedCode="";
	private User user;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	spinner2.setVisible(false);
    	spinner3.setVisible(false);
        sexe.getItems().add("Man");
        sexe.getItems().add("Women");
        sexe.setStyle("-fx-padding:20px ; -fx-text-inner-color:white;-fx-text-fill:white;");
        NameValidator firstNameValidator = new NameValidator();
        firstNameValidator.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
        								    .glyph(FontAwesomeIcon.WARNING)
        								    .size("1em")
        								    .styleClass("error")
        								    .build());  
    	firstName.getValidators().add(firstNameValidator);
    	
    	NameValidator lastNameValidator = new NameValidator();
        lastNameValidator.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
        								    .glyph(FontAwesomeIcon.WARNING)
        								    .size("1em")
        								    .styleClass("error")
        								    .build());
    	lastName.getValidators().add(lastNameValidator);
    	
    	BirthDateValidator birthDateValidator= new BirthDateValidator();
    	birthDateValidator.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
				    .glyph(FontAwesomeIcon.WARNING)
				    .size("1em")
				    .styleClass("error")
				    .build());   	
    	birthDate.getValidators().add(birthDateValidator);
    	
    	EmailValidator emailValidator = new EmailValidator();
    	emailValidator.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
			    .glyph(FontAwesomeIcon.WARNING)
			    .size("1em")
			    .styleClass("error")
			    .build());   	
    	email.getValidators().add(emailValidator);
    	
    	usernameValidator userValidator = new usernameValidator();
    	userValidator.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
			    .glyph(FontAwesomeIcon.WARNING)
			    .size("1em")
			    .styleClass("error")
			    .build());   	
    	username.getValidators().add(userValidator);
    	
    	passwordValidator passValidator = new passwordValidator();
    	passValidator.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
			    .glyph(FontAwesomeIcon.WARNING)
			    .size("1em")
			    .styleClass("error")
			    .build());   	
    	password.getValidators().add(passValidator);
    	
    	profileHashName="";	
    	user = new User();
        
    }    
    public void goToStep2SignUp()
    {
   
    	tabs.getSelectionModel().select(1);
      
    }
    public void goToStep1SignUp()
    {
    	tabs.getSelectionModel().select(0);
    }
    public void goToStep3SignUp()
    {
    	tabs.getSelectionModel().select(2);
    }
    public void finishSignUp()
    {
    	Date date = Date.from(birthDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    	Timestamp time = new Timestamp(date.getTime());
    	User user = new User();
    	if(this.user.getId()!=0)
    	{
    	  user = this.user;
    	}
    	
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
		user.setAccountStatus(AccountStatus.DISABLED);
		
		  String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
			Context context;
			try {
				context = new InitialContext();
				CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
				proxy.signUp(user);
				User newUser = proxy.findUserByUsername(user.getUsername());
				if(newUser!=null)
				{
					
					this.user = newUser;
					SignIn_fxmlController.userConnected=this.user;
					spinner2.setVisible(true);
					Timer time2 = new Timer();
					time2.schedule(new TimerTask() {
						
						@Override
						public void run() {
							generatedCode = SignUp_fxmlController.generateCode();
							Code2FACandidate code = new Code2FACandidate();
							code.setIdUser(newUser.getId());
							code.setCode(generatedCode);
							//proxy.addCode(code);
							sendEmailBySSl(code.getCode(), SignIn_fxmlController.userConnected.getEmail());
						    spinner2.setVisible(false);
						  Platform.runLater(()->{
							  goToStep3SignUp();
						  });
						}
					}, 3000);
				}
				
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    }
    public void verifyUserCode()
    {
    	 String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
			Context context;
			try {
				context = new InitialContext();
				CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
				//Code2FACandidate code = proxy.findCode(this.user.getId());
			    if(generatedCode.equals(signUpCode.getText()) && generatedCode!="" )
			      {
			    	user.setAccountStatus(AccountStatus.ACTIVATED);
			    	proxy.updateAccountStatus(user);
			    	Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Account ");
					alert.setHeaderText("Welcome in Network");
					alert.setContentText("Wish you a good journey throught your carreer!");
					alert.showAndWait();
			    	loadSignIn();
			      }
			    else
			    {
			    	Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Incorrect Code ");
					alert.setContentText("your inserted code is incorrect please check your email");
					alert.showAndWait();
			    }
			} catch (NamingException e) {
				
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
    		 Color c = Color.web("#ef3a23"); //red
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
    		 Color c = Color.web("#ef3a23"); //red
    		 lastName.validate();
    		 lastName.focusColorProperty().setValue(c);
    		 lastName.getValidators().get(0).setMessage("you must enter at list 4 caracter");
    	}
    	validateFirstName();
    	
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
    		 Color c = Color.web("#ef3a23"); //red
    		 birthDate.validate();
    		 //lastName.focusColorProperty().setValue(c);
    		 birthDate.getValidators().get(0).setMessage("your age should be between 18 and 70 year old");
    	}
    	validateLastName();
    	
    	
    }
    public void validateEmail()
    {
    	EmailValidator emailValid = (EmailValidator) this.email.getValidators().get(0);
    	 String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
			Context context;
			try {
				context = new InitialContext();
				CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
				if(proxy.checkEmail(email.getText()))
				{
					emailValid.setCheckExistEmail(true);
					this.email.getValidators().set(0, emailValid);
				}
				else
				{
					emailValid.setCheckExistEmail(false);
					this.email.getValidators().set(0, emailValid);
				}
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    	if(this.email.validate())
    	{
    		String msg=((EmailValidator)email.getValidators().get(0)).msg;
    		
    		Color c = Color.web("#008000"); //green
            email.validate();
            email.focusColorProperty().setValue(c);
            msgEmail.setTextFill(c);
            msgEmail.setText(msg);
           // email.getValidators().get(0).setMessage(msg);
            System.out.println("aft:"+msg);
           
    	}
    	else
    	{
    		String msg=((EmailValidator)email.getValidators().get(0)).msg;
    		 Color c = Color.web("#ef3a23"); //red
    		 email.validate();
    		 email.focusColorProperty().setValue(c);
    		// email.getValidators().get(0).setMessage(msg);
    		 msgEmail.setTextFill(c);
             msgEmail.setText(msg);
    		  System.out.println("aft:"+msg);
    		 
    		// email.getValidators().get(0).setMessage("please enter a valid email and non existent email");
    	}
    	
    	validateDate();
    
    }
    public void validateUsername()
    {
    	usernameValidator validator = (usernameValidator) this.username.getValidators().get(0);
   	 String jndiName1="networkServer-ear/networkServer-ejb/CandidatProfilService!tn.redhats.network.networkServer.services.CandidatProfilServiceRemote";
			Context context;
			try {
				context = new InitialContext();
				CandidatProfilServiceRemote proxy = (CandidatProfilServiceRemote) context.lookup(jndiName1);
				if(proxy.checkUserName(username.getText()))
				{
					validator.setCheckExistUsername(true);
					this.username.getValidators().set(0, validator);
				}
				else
				{
					validator.setCheckExistUsername(false);
					this.username.getValidators().set(0, validator);
				}
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   	if(this.username.validate())
   	{
   		String msg=((usernameValidator)username.getValidators().get(0)).msg;
   		Color c = Color.web("#008000"); //green
        username.validate();
        username.focusColorProperty().setValue(c);
        msgUserName.setTextFill(c);
        msgUserName.setText(msg);
   	}
   	else
   	{
   		 String msg=((usernameValidator)username.getValidators().get(0)).msg;
   		 Color c = Color.web("#ef3a23"); //red
   		 username.validate();
   		 username.focusColorProperty().setValue(c);
   	     msgUserName.setTextFill(c);
         msgUserName.setText(msg);
   	}
    }
    public void validatePassword()
    {
    	String msg=((passwordValidator)password.getValidators().get(0)).msg;

    	if(this.password.validate())
    	{
    		
    		Color c = Color.web("#008000"); //green
    		password.validate();
    		password.focusColorProperty().setValue(c);
    		passLabel.setTextFill(c);
    		passLabel.setText(msg);
    		System.out.println(msg);
    		
    	}
    	else
    	{
    		 Color c = Color.web("#ef3a23"); //red
    		 password.validate();
    		 password.focusColorProperty().setValue(c);
    		 passLabel.setTextFill(c);
     		 passLabel.setText(msg);
     		 System.out.println(msg);
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
    public static String hashPassword(String pass)
    {

    	String chaineHasher=BCrypt.hashpw(pass, BCrypt.gensalt());   	
    	return chaineHasher;
    }
    public static String generateCode()
    {
    	  String alphabet= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789&é(-_@=)}{$*%^!:+~";
          String s = "";
          Random random = new Random();
       
          
          for (int i = 0; i < 10; i++) {
              char c = alphabet.charAt(random.nextInt(alphabet.length()));
              s+=c;
          }
           
         return s;
    }
    public static Boolean sendEmailBySSl(String code,String userEmail)
    {
    	Properties properties = new Properties();
    	properties.put("mail.smtp.host","smtp.gmail.com");
    	properties.put("mail.smtp.socketFactory.port","465");
    	properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
    	properties.put("mail.smtp.auth","true");
    	properties.put("mail.smtp.port","465");
    	Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
			  return new PasswordAuthentication("projectnetwork87@gmail.com", "netw@rKPr0jec7");	
			}
    	});
    	try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("projectnetwork87@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
			message.setSubject("Network account Validation");
			message.setText(" your account validation code is:"+code+"\n\n\n\n Best regards Network");
			Transport.send(message);
			System.out.println(" code send is:"+code);
			return true;
		} catch (MessagingException e) {
			System.out.println("impossible d'envoyer le mail");
		}
    	return false;
    }
    @FXML 
    private void loadSignIn() {
    	 Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/networkClient/javafx/candidateProfile/signIN_fxml.fxml"));
			 Scene scene = new Scene(root);
		      
		        candidateFXMain.stage.setScene(scene);
		        candidateFXMain.stage.setIconified(false);
		       
		       candidateFXMain.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
        
        
    	
    }
}
