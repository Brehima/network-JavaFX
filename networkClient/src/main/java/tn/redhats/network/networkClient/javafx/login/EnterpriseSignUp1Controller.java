/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.networkClient.javafx.login;

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
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import networkClient.main.main;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class EnterpriseSignUp1Controller implements Initializable {

	
	public static String staticenterpriseName="", staticIntroduction="", staticEmployeesNumber="", staticJobField="", staticWebsite="";
	//public static List<String> staticLocations = new ArrayList<String>();
	public static File staticFile = new File("");
	public static ImageView staticLogoImageView = new ImageView();
	public static ObservableList<String> staticLocationsList =FXCollections.observableArrayList();
	public static int nextButtonOpacity = 0;
	public static int removeLocationOpacity = 0;
	public static int removeImageOpacity = 0;
	public static List<String> listEmails = new ArrayList<String>();
	public static List<String> listUsernames = new ArrayList<String>();
	public static String profileHashName="";
	
	
    @FXML
    private AnchorPane anchorPaneID;
    @FXML
    private JFXButton backButton;
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
    private JFXComboBox<String> locationsComboBox;
    @FXML
    private JFXListView<String> locationsListView;
    @FXML
    private JFXButton addButton;
    @FXML
    private JFXButton nextButton;
    @FXML
    private JFXButton fileButton;
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
    
    public static final Pattern websitePattern =  Pattern.compile("^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$");
    
    private File file;
    @FXML
    private ImageView logo;
    
    private Boolean enterpriseNameValidation = false, introductionValidation = false, employeesNumberValidation = false, jobFieldValidation = false, websiteValidation = false, locationsValidation = false, logoValidation = false;

    
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
    private Label locationLabel;
    @FXML
    private ImageView removeImageView;
    @FXML
    private JFXButton removeLocationButton;

    
    public EnterpriseSignUp1Controller() {
		// TODO Auto-generated constructor stub
	}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    	enterpriseNameTextField.setText(staticenterpriseName);
    	introductionTextArea.setText(staticIntroduction);
    	employeesNumberTextField.setText(staticEmployeesNumber);
    	jobFieldTextField.setText(staticJobField);
    	websiteTextField.setText(staticWebsite);
    	locationsListView.setItems(staticLocationsList);
    	logo.setImage(new Image(staticFile.toURI().toString()));
    	nextButton.setOpacity(nextButtonOpacity);
    	removeLocationButton.setOpacity(removeLocationOpacity);
    	removeImageView.setOpacity(removeImageOpacity);
    	
    	
    	
    	locationsComboBox.setItems(cl);
    	new AutoCompleteCmb<String>(locationsComboBox);
    	enterpriseNameTextField.setStyle("-fx-text-inner-color: white;");
    	introductionTextArea.setStyle("-fx-text-inner-color: white;");
    	employeesNumberTextField.setStyle("-fx-text-inner-color: white;");
    	jobFieldTextField.setStyle("-fx-text-inner-color: white;");
    	websiteTextField.setStyle("-fx-text-inner-color: white;");
    	
    	if(locationsListView.getItems().isEmpty()) {
    		locationLabel.setText("You must choose at least one location");
    		locationLabel.setTextFill(Color.RED);
    		locationLabel.setOpacity(1);
    	}else {
    		locationLabel.setText("Valid location");
    		locationLabel.setTextFill(Color.LAWNGREEN);
    		locationLabel.setOpacity(1);
    		locationsValidation = true;
    		checkValidation();
    	}
    	
    	checkValidation();
    }    

    @FXML
    private void clicBack(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/ProfileType.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
    }

    @FXML
    private void clicNext(ActionEvent event) throws IOException {
    	staticenterpriseName = enterpriseNameTextField.getText();
    	staticIntroduction = introductionTextArea.getText();
    	staticEmployeesNumber = employeesNumberTextField.getText();
    	staticJobField = jobFieldTextField.getText();
    	staticWebsite = websiteTextField.getText();
    	staticLocationsList = locationsListView.getItems();
    	staticFile = file;
    	nextButtonOpacity = 1;
    	removeLocationOpacity = 1;
    	removeImageOpacity = 1;
    	
    	
    	
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/enterpriseSignUp2.fxml")); 
        Parent root=loader.load();
        Scene s = anchorPaneID.getScene(); 
        s.setRoot(root);
        
        /*
        System.out.println(staticenterpriseName);
        System.out.println(staticIntroduction);
        System.out.println(staticEmployeesNumber);
        System.out.println(staticJobField);
        System.out.println(staticWebsite);
        System.out.println(staticLocationsList);
        System.out.println(staticFile);
        */
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
    private void clicRemoveLocation(ActionEvent event) {
    	locationsListView.getItems().remove(locationsListView.getSelectionModel().getSelectedItem());
    	if (locationsListView.getSelectionModel().getSelectedItems().isEmpty()) {
    		locationLabel.setText("You must choose at least one location");
    		locationLabel.setTextFill(Color.RED);
    		locationLabel.setOpacity(1);
    	}
    	
    }

    private void checkValidation() {
    	if (employeesNumberValidation == true && enterpriseNameValidation == true 
    			&& introductionValidation == true && jobFieldValidation == true 
    			&& locationsValidation == true && logoValidation == true && websiteValidation == true) {
    		nextButton.setOpacity(1);
    	}
    }
    
    
    public static void saveFile(File image)
    {
    	String fileName = "C:\\Users\\Coulibaly\\Desktop\\images\\EnterprisesLogos\\"+hashPicture(EnterpriseSignUp1Controller.staticenterpriseName)+".png";
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
    
  
    
}
