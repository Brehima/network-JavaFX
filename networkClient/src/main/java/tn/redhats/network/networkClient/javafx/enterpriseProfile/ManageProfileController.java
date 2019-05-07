/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.enterpriseProfile;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.naming.NamingException;
import javax.xml.bind.DatatypeConverter;

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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import networkClient.main.main;
import tn.redhats.network.networkClient.javafx.login.AutoCompleteCmb;
import tn.redhats.network.networkClient.javafx.login.EnterpriseSignUp1Controller;
import tn.redhats.network.networkClient.javafx.login.SigninController;
import tn.redhats.network.networkServer.entities.EnterpriseProfile;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ManageProfileController implements Initializable {

    @FXML
    private AnchorPane anchorPaneID;
    @FXML
    private JFXTextField enterpriseNameTextField;
    @FXML
    private JFXTextArea introductionTextArea;
    @FXML
    private JFXTextField employeesNumberTextField;
    @FXML
    private JFXTextField jobFieldTextField;
    @FXML
    private JFXTextField websiteTextField;
    @FXML
    private JFXButton backButton;
    @FXML
    private JFXListView<String> locationsListView;
    @FXML
    private JFXButton addButton;
    @FXML
    private ImageView removeImageView;
    @FXML
    private JFXButton removeLocationButton;
    @FXML
    private JFXButton fileButton;
    @FXML
    private ImageView logo;
    @FXML
    private JFXButton updateButton;
    @FXML
    private JFXComboBox<String> locationsComboBox;
    String[] countriesList={
        	"Afghanistan",
        	"Albania",
        	"Algeria",
        	"Andorra",
        	"Angola",
        	"Antigua and Barbuda",
        	"Argentina",
        	"Armenia",
        	"Australia",
        	"Austria",
        	"Azerbaijan",
        	"The Bahamas",
        	"Bahrain",
        	"Bangladesh",
        	"Barbados",
        	"Belarus",
        	"Belgium",
        	"Belize",
        	"Benin",
        	"Bhutan",
        	"Bolivia",
        	"Bosnia and Herzegovina",
        	"Botswana",
        	"Brazil",
        	"Brunei",
        	"Bulgaria",
        	"Burkina Faso",
        	"Burundi",
        	"Cabo Verde",
        	"Cambodia",
        	"Cameroon",
        	"Canada",
        	"Central African Republic",
        	"Chad",
        	"Chile",
        	"China",
        	"Colombia",
        	"Comoros",
        	"Congo",
        	"Costa Rica",
        	"Côte d’Ivoire",
        	"Croatia",
        	"Cuba",
        	"Cyprus",
        	"Czech Republic",
        	"Denmark",
        	"Djibouti",
        	"Dominica",
        	"Dominican Republic",
        	"East Timor",
        	"Ecuador",
        	"Egypt",
        	"El Salvador",
        	"Equatorial Guinea",
        	"Eritrea",
        	"Estonia",
        	"Eswatini",
        	"Ethiopia",
        	"Fiji",
        	"Finland",
        	"France",
        	"Gabon",
        	"The Gambia",
        	"Georgia",
        	"Germany",
        	"Ghana",
        	"Greece",
        	"Grenada",
        	"Guatemala",
        	"Guinea",
        	"Guinea-Bissau",
        	"Guyana",
        	"Haiti",
        	"Honduras",
        	"Hungary",
        	"Iceland",
        	"India",
        	"Indonesia",
        	"Iran",
        	"Iraq",
        	"Ireland",
        	"Italy",
        	"Jamaica",
        	"Japan",
        	"Jordan",
        	"Kazakhstan",
        	"Kenya",
        	"Kiribati",
        	"Korea, North",
        	"Korea, South",
        	"Kosovo",
        	"Kuwait",
        	"Kyrgyzstan",
        	"Laos",
        	"Latvia",
        	"Lebanon",
        	"Lesotho",
        	"Liberia",
        	"Libya",
        	"Liechtenstein",
        	"Lithuania",
        	"Luxembourg",
        	"Madagascar",
        	"Malawi",
        	"Malaysia",
        	"Maldives",
        	"Mali",
        	"Malta",
        	"Marshall Islands",
        	"Mauritania",
        	"Mauritius",
        	"Mexico",
        	"Micronesia",
        	"Moldova",
        	"Monaco",
        	"Mongolia",
        	"Montenegro",
        	"Morocco",
        	"Mozambique",
        	"Myanmar (Burma)",
        	"Namibia",
        	"Nauru",
        	"Nepal",
        	"Netherlands",
        	"New Zealand",
        	"Nicaragua",
        	"Niger",
        	"Nigeria",
        	"North Macedonia",
        	"Norway",
        	"Oman",
        	"Pakistan",
        	"Palau",
        	"Palestine",
        	"Panama",
        	"Papua New Guinea",
        	"Paraguay",
        	"Peru",
        	"Philippines",
        	"Poland",
        	"Portugal",
        	"Qatar",
        	"Romania",
        	"Russia",
        	"Rwanda",
        	"Saint Kitts and Nevis",
        	"Saint Lucia",
        	"Samoa",
        	"San Marino",
        	"Sao Tome and Principe",
        	"Saudi Arabia",
        	"Senegal",
        	"Serbia",
        	"Seychelles",
        	"Sierra Leone",
        	"Singapore",
        	"Slovakia",
        	"Slovenia",
        	"Solomon Islands",
        	"Somalia",
        	"South Africa",
        	"Spain",
        	"Sri Lanka",
        	"Sudan",
        	"Sudan, South",
        	"Suriname",
        	"Sweden",
        	"Switzerland",
        	"Syria",
        	"Taiwan",
        	"Tajikistan",
        	"Tanzania",
        	"Thailand",
        	"Togo",
        	"Tonga",
        	"Trinidad and Tobago",
        	"Tunisia",
        	"Turkey",
        	"Turkmenistan",
        	"Tuvalu",
        	"Uganda",
        	"Ukraine",
        	"United Arab Emirates",
        	"United Kingdom",
        	"United States",
        	"Uruguay",
        	"Uzbekistan",
        	"Vanuatu",
        	"Vatican City",
        	"Venezuela",
        	"Vietnam",
        	"Yemen",
        	"Zambia",
        	"Zimbabwe"};
    	    ObservableList<String> cl =FXCollections.observableArrayList(countriesList);
    @FXML
    private JFXButton deleteAccountButton;
    @FXML
    private Label enterpriseNameLabel;
    @FXML
    private Label introductionLabel;
    @FXML
    private Label employeesNumberLabel;
    @FXML
    private Label jobFieldLabel;
    @FXML
    private Label websiteLabel;
    @FXML
    private Label fileLabel;
    @FXML
    private Label locationLabel;
    private Boolean enterpriseNameValidation = false, introductionValidation = false, employeesNumberValidation = false, jobFieldValidation = false, websiteValidation = false, locationsValidation = false, logoValidation = false;
    public static final Pattern websitePattern =  Pattern.compile("^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$");
    private File file;
    public static String profileHashName="";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	
    	enterpriseNameTextField.setStyle("-fx-text-inner-color: white;");
    	introductionTextArea.setStyle("-fx-text-inner-color: white;");
    	employeesNumberTextField.setStyle("-fx-text-inner-color: white;");
    	jobFieldTextField.setStyle("-fx-text-inner-color: white;");
    	websiteTextField.setStyle("-fx-text-inner-color: white;");
    	
    	
    	enterpriseNameTextField.setText(SigninController.staticEP.getEnterpriseName());
    	introductionTextArea.setText(SigninController.staticEP.getIntroduction());
    	employeesNumberTextField.setText(SigninController.staticEP.getEmployeesNumber());
    	jobFieldTextField.setText(SigninController.staticEP.getJobField());
    	websiteTextField.setText(SigninController.staticEP.getWebsite());
    	
    	
    	locationsComboBox.setItems(cl);
    	new AutoCompleteCmb<String>(locationsComboBox);
    	
    	ObservableList<String> OldLocations =FXCollections.observableArrayList(SigninController.staticEP.getLocations());
    	locationsListView.setItems(OldLocations);
    	
    	try {
    		File image = new File(main.getEnterpriseProfileProxy().findEnterpriseById(SigninController.staticEP.getId()).getPhoto());
			logo.setImage(new Image(image.toURI().toString()));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }    

    @FXML
    private void enterpriseNameOnKeyReleased(KeyEvent event) throws NamingException {
    	if((enterpriseNameTextField.getText().length() > 1) && (main.getEnterpriseProfileProxy().checkEnterpriseName(enterpriseNameTextField.getText()) == false)) {
    		enterpriseNameTextField.setFocusColor(Color.LAWNGREEN);
    		enterpriseNameLabel.setText("Valid name");
    		enterpriseNameLabel.setTextFill(Color.LAWNGREEN);
    		enterpriseNameLabel.setOpacity(1);
    		enterpriseNameValidation = true;
    		checkValidation();
    		
    		
    	}else if (main.getEnterpriseProfileProxy().checkEnterpriseName(enterpriseNameTextField.getText()) == true) {
    		enterpriseNameTextField.setFocusColor(Color.RED);
    		enterpriseNameLabel.setText("Enterprise name already taken ...");
    		enterpriseNameLabel.setTextFill(Color.RED);
    		enterpriseNameLabel.setOpacity(1);
    	}
    	else {
    		
    		enterpriseNameTextField.setFocusColor(Color.RED);
    		enterpriseNameLabel.setText("Invalid name (The name must be at least 2 characters long)");
    		enterpriseNameLabel.setTextFill(Color.RED);
    		enterpriseNameLabel.setOpacity(1);
    	}
    }

    @FXML
    private void introductionOnKeyReleased(KeyEvent event) {
    	if(introductionTextArea.getText().length() > 9 ) {
    		introductionTextArea.setFocusColor(Color.LAWNGREEN);
    		introductionLabel.setText("Valid introduction");
    		introductionLabel.setTextFill(Color.LAWNGREEN);
    		introductionLabel.setOpacity(1);
    		introductionValidation = true;
    		checkValidation();
    	}else {
    		introductionTextArea.setFocusColor(Color.RED);
    		introductionLabel.setText("Invalid introduction (Please type at least 30 characters)");
    		introductionLabel.setTextFill(Color.RED);
    		introductionLabel.setOpacity(1);
    	}
    }

    @FXML
    private void employeesNumberOnKeyReleased(KeyEvent event) {
    	Boolean correctNumber = false;
    	try {
    		
    		int employeesNumber = Integer.parseInt(employeesNumberTextField.getText());
    		if(employeesNumber > 1) {
    			correctNumber= true;
        		employeesNumberTextField.setFocusColor(Color.LAWNGREEN);
        		employeesNumberLabel.setText("Valid employees number");
        		employeesNumberLabel.setTextFill(Color.LAWNGREEN);
        		employeesNumberLabel.setOpacity(1);
        		employeesNumberValidation = true;
        		checkValidation();
        	}
    		
    	}catch(NumberFormatException e){
    		
    		employeesNumberTextField.setFocusColor(Color.RED);
    		employeesNumberLabel.setText("Invalid employees number (Must have at least 2 employees)");
    		employeesNumberLabel.setTextFill(Color.RED);
    		employeesNumberLabel.setOpacity(1);
    	}	
    }

    @FXML
    private void jobFieldOnKeyReleased(KeyEvent event) {
    	if(jobFieldTextField.getText().length() > 4 ) {
    		jobFieldTextField.setFocusColor(Color.LAWNGREEN);
    		jobFieldLabel.setText("Valid job field");
    		jobFieldLabel.setTextFill(Color.LAWNGREEN);
    		jobFieldLabel.setOpacity(1);
    		jobFieldValidation = true;
    		checkValidation();
    	}else {
    		jobFieldTextField.setFocusColor(Color.RED);
    		jobFieldLabel.setText("Invalid job field (The job field must be at least 5 characters long)");
    		jobFieldLabel.setTextFill(Color.RED);
    		jobFieldLabel.setOpacity(1);
    	}
    }

    
    public static boolean validate(String website) {
		Matcher matcher = websitePattern .matcher(website);
		return matcher.find();
	}
    
    
    @FXML
    private void websiteOnKeyReleased(KeyEvent event) throws NamingException {
    	if(validate(websiteTextField.getText()) && main.getEnterpriseProfileProxy().checkWebsite(websiteTextField.getText()) == false ) {
    		websiteTextField.setFocusColor(Color.LAWNGREEN);
    		websiteLabel.setText("Valid website");
    		websiteLabel.setTextFill(Color.LAWNGREEN);
    		websiteLabel.setOpacity(1);
    		websiteValidation = true;
    		checkValidation();
    	}else if(main.getEnterpriseProfileProxy().checkWebsite(websiteTextField.getText()) == true) {
    		websiteTextField.setFocusColor(Color.RED);
    		websiteLabel.setText("Website already exists ...");
    		websiteLabel.setTextFill(Color.RED);
    		websiteLabel.setOpacity(1);
    	}
    	
    	else {
    		websiteTextField.setFocusColor(Color.RED);
    		websiteLabel.setText("Invalid website\nExample : www.EnterpriseName.com");
    		websiteLabel.setTextFill(Color.RED);
    		websiteLabel.setOpacity(1);
    	}
    }

    @FXML
    private void clicBack(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/accessEnterpriseProfile.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    }

    @FXML
    private void clicAddButton(ActionEvent event) {
    	if(locationsListView.getItems().contains(locationsComboBox.getSelectionModel().getSelectedItem())) {
    		
    	}else {
    		locationsListView.getItems().add(locationsComboBox.getSelectionModel().getSelectedItem());
        	removeImageView.setOpacity(1);
        	removeLocationButton.setOpacity(1);
        	locationLabel.setText("Valid location");
        	locationLabel.setTextFill(Color.LAWNGREEN);
        	locationLabel.setOpacity(1);
        	locationsValidation = true;
        	checkValidation();
    	}
    }

    @FXML
    private void clicRemoveLocation(ActionEvent event) {
    	locationsListView.getItems().remove(locationsListView.getSelectionModel().getSelectedItem());
    	if (locationsListView.getSelectionModel().getSelectedItems().isEmpty()) {
    		locationLabel.setText("You must choose at least one location");
    		locationLabel.setTextFill(Color.RED);
    		locationLabel.setOpacity(1);
    	}
    }

    @FXML
    private void clicChooseFile(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Select a logo");
    	fileChooser.getExtensionFilters().addAll(
    			new ExtensionFilter("JPG", "*.jpg"),
    			new ExtensionFilter("PNG", "*.png")
    			);
    	this.file= fileChooser.showOpenDialog(null);
    	if(file!=null){
    		logo.setImage(new Image(file.toURI().toString()));
    		fileLabel.setText("Valid logo");
    		fileLabel.setTextFill(Color.LAWNGREEN);
    		fileLabel.setOpacity(1);
    		logoValidation = true;
    		checkValidation();
    	}
    	else{
    		fileLabel.setText("No file selected");
    		fileLabel.setTextFill(Color.RED);
    		fileLabel.setOpacity(1);
    	}
    }

    @FXML
    private void clicUpdate(ActionEvent event) throws NamingException, IOException {
    	
    	ArrayList<String> updatedLocations = new ArrayList<String>();
		for(String loc : locationsListView.getItems()) {
			updatedLocations.add(loc);
		}


		saveFile(file);
		main.getEnterpriseProfileProxy().updateEnterpriseProfile(SigninController.staticEP.getId(), introductionTextArea.getText(), profileHashName, jobFieldTextField.getText(), updatedLocations, websiteTextField.getText(), employeesNumberTextField.getText(), enterpriseNameTextField.getText());
		//main.getEnterpriseProfileProxy().updateEnterpriseProfile(id, introduction, photo, jobField, locations, website, employeesNumber);
		
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/accessEnterpriseProfile.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    	
    	
    }
    
    public static void saveFile(File image)
    {
    	String fileName = "C:\\Users\\lenovo\\Desktop\\EnterprisesLogos\\"+hashPicture(EnterpriseSignUp1Controller.staticenterpriseName)+".png";
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
    public static String hashPicture(String name)
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

    @FXML
    private void clicDeleteAccount(ActionEvent event) throws NamingException, IOException {
    	
    	
    	Alert alerte = new Alert(Alert.AlertType.CONFIRMATION);
        alerte.setTitle("Confirmation dialog");
        alerte.setHeaderText("Be careful ! ");
        alerte.setContentText("Do you really want to delete your account ?");
        
        Optional<ButtonType> result = alerte.showAndWait();
        if (result.get() == ButtonType.OK)
        {
        	main.getEnterpriseProfileProxy().removeEnterprise(SigninController.staticEP.getId());          
        }else{
            
        }
        
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/signin.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    	
    	
    }
    
    private void checkValidation() {
    	if (employeesNumberValidation == true && enterpriseNameValidation == true 
    			&& introductionValidation == true && jobFieldValidation == true 
    			&& locationsValidation == true && logoValidation == true && websiteValidation == true) {
    		updateButton.setOpacity(1);
    	}
    }
    
}
