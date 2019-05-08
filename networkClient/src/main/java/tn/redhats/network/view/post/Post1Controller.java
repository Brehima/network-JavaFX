/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.view.post;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;
import javax.xml.bind.DatatypeConverter;

import org.omg.CORBA.INITIALIZE;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.controls.JFXTextArea;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import networkClient.main.main;
import tn.redhats.network.networkClient.view.home.HomeController;
import tn.redhats.network.networkServer.entities.Comment;
import tn.redhats.network.networkServer.entities.Message;
import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.services.PostServiceRemote;
import tn.redhats.network.networkServer.services_impl.CommentService;
import tn.redhats.network.networkServer.services_impl.PostService;
import tn.redhats.network.view.consultMsg.ConsultMessageController;
/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Post1Controller implements Initializable {
	//private final Image likebutton = new Image("/C:/Users/Asus/Desktop/Esprit/Semestre 2/PI sem2/img_95084.png");
	
	//ImageView imageviewlike = new ImageView(likebutton);
	public static int recupid;  
	public static Post pst;
	private File file;
	String pic="";
	private Image image;
	 //private Upload up;
    @FXML
    private AnchorPane anchronePane2;

    @FXML
    private JFXTextArea taPost;

    @FXML
    private JFXButton btnpost;

    @FXML
    private JFXButton delete;

   
    @FXML
    private JFXButton btnUpload;

    @FXML
    private Label lblUpload;
    @FXML
    private JFXScrollPane spPost;

    @FXML
    private JFXButton btnUploadVid;

    @FXML
    private Label lblVideo;
    @FXML
    private JFXButton btnHome;

    @FXML
    private ImageView imageHome;

    @FXML
    private JFXButton btnChat;

    @FXML
    private JFXButton btnNotif;
    @FXML
    void goToChat(ActionEvent event) {
    	btnChat.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    	     public void handle(ActionEvent event) {
    	    	try 
    	    	{
               
    	    	 Parent root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/view/consultMsg/consultMessage.fxml"));
                  //Scene s = AnchorPane1.getScene(); 
                 Scene s = new Scene(root);
                 Stage secondStage = new Stage();
                secondStage.setScene(s);
                secondStage.show();
	}

    	    	catch (IOException ex) {
    	              Logger.getLogger(ConsultMessageController.class.getName()).log(Level.SEVERE, null, ex);
    	          }
    	   }
    		
		});
    	
    } 
    
    @FXML
    void goToNotif(ActionEvent event) {
    	btnNotif.setOnAction(new EventHandler<ActionEvent>() {
			   @Override
	    	     public void handle(ActionEvent event) {
	    	    	try 
	    	    	{
                
	    	    	 Parent root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/view/notification/Notification.fxml"));
	                  //Scene s = AnchorPane1.getScene(); 
	                 Scene s = new Scene(root);
	                 Stage secondStage = new Stage();
	                secondStage.setScene(s);
	                secondStage.show();
		}

	    	    	catch (IOException ex) {
	    	              Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
	    	          }
	    	   }
	    	    	 });
	    	   }
    

    private ObservableList<Post> data = FXCollections.observableArrayList();
    FilteredList<Post> filteredData = new FilteredList<>(data);
    public static Post newPost = new Post();
    Label l = new Label();
    PostService ps = new PostService();
    //Post p= new Post();
    List<Post> listp= new ArrayList<Post>();
    private Upload up;
    String vid;
    private File file1 = new File("");
    
   @FXML
    void onAddPost(ActionEvent event) throws NamingException,IOException {
	   
	  
       /*if (file1.isFile()) {
                  
                         
            pic=up.upload(file1, "picture");                                

               }*/
       newPost.setPhotos(new ArrayList<String>());
       //PostService ps3 = new PostService();
       String champpub= taPost.getText();
       //Post p1 = new Post();
       newPost.setDescription(champpub);
       Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
       newPost.setDatePost(ts);
       System.out.println("------------------------------"+pic);
       newPost.getPhotos().add(pic);
       main.getPostProxy().AddPost(newPost);
       //ps.AddPost(p);
       ObservableList<Post> PublicationData = FXCollections.observableArrayList();
       //PostService ps4= new PostService();
       //List<Post> listep= new ArrayList<Post>();
      listp=main.getPostProxy().findAllPost();
      PublicationData.addAll(listp);
      Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Information Dialog");
    	alert.setHeaderText(null);
    	alert.setContentText("Post added");
    	 
  			showList();
  		   
    	alert.showAndWait();
         
    }

    @FXML
    void deletePost(ActionEvent event) {

    }

   

    @FXML
    void uploadVideo(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     * 
     */
    
    @FXML
    void uploadImage(ActionEvent event) throws IOException{
    	FileChooser fc = new FileChooser();
    	fc.setTitle("select an image");
    	file = fc.showOpenDialog(null);
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
       
        //pic=(file.toURI().toString());
        pic ="C://xampp/img/pi-img/img/"+ new Upload().upload(file,"img");
        
        System.out.println(pic);
        image = new Image(pic);
        lblUpload.setText(pic);
        
        
      
       /*
    	if(file!=null){
    		pic.setImage(new Image(file.toURI().toString()));
    		lvPost.getItems();
    		lblUpload.setText("Valid logo");
    		lblUpload.setTextFill(Color.LAWNGREEN);
    		lblUpload.setOpacity(1);
    		logoValidation = true;
    		checkValidation();
    	}
    	else{
    		lblUpload.setText("No file selected");
    		lblUpload.setTextFill(Color.RED);
    		lblUpload.setOpacity(1);
    	}
*/
    
    }
    
    /*
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
    }*/
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        // TODO
    
    	 ObservableList<Post> PostData = FXCollections.observableArrayList();
	      List<Post> listp= new ArrayList<Post>();
	  
	       try {
			listp=main.getPostProxy().findAllPost();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	       PostData.addAll(listp);
	       try {
			showList();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        } 
    public void showList() throws NamingException
    {
          //Image[] images;
        
            //AnchorPane pane1 = new AnchorPane();
            GridPane grid = new GridPane();
    	   data = FXCollections.observableArrayList();
          
         data.addAll(main.getPostProxy().findAllPost());
         System.out.println(data);
    	int  k = 0;
    	grid.setHgap(1);
        grid.setVgap((data.stream().count()) + 1);
        grid.setPadding(new Insets(50, 50, 50, 50));
        for (int i = 0; i < (data.stream().count() / 1) + 1; i++) {
            for (int j = 0; j < 1; j++) {
                if (k < data.stream().count()) {
    	//List<String> urli = data.get(k).getPhotos();
         String urli="";
        if(data.get(k).getPhotos().size()>0)
        {
         urli = data.get(k).getPhotos().get(0);
        }
       
    	Group root = new Group();
    	File file3 = new File(urli);
    	ImageView im = new ImageView(new Image(file3.toURI().toString()));
        im.setFitWidth(250);
        im.setFitHeight(200);
        
        Label visit = new Label("");
        visit.setOnMouseEntered(event -> {
                            visit.setUnderline(true);
                        });
                        visit.setOnMouseExited(event -> {
                            visit.setUnderline(false);
                        });
                        visit.setOnMouseClicked(event -> {
                        });
                        
        root.getChildren().add(im);
        root.setAccessibleText(Integer.valueOf(data.get(k).getId()).toString());
        
        Label l = new Label();
        l.setStyle("-fx-font-size: 20px;"
                + " -fx-font-weight: bold;"
                + "-fx-text-fill: #818181;"
                + "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );"
                + "-fx-font-family: Arial Black;"
        );
        Label id = new Label(String.valueOf(data.get(k).getId()));
        id.setVisible(false);
        id.setAccessibleText("id");
        
        Pane p1 = new Pane();
        p1.setStyle("-fx-background-color: white;"
                + "-fx-background-radius: 10px;"
                + "-fx-border-color: black;"
                + "-fx-border-radius:10px;"
                + "-fx-opacity: 0.6;");
        
        Label l2 = new Label("clik me !!!");
        l2.setStyle("-fx-font-size: 20px;"
                + " -fx-font-weight: bold;"
                + "-fx-text-fill: #818181;"
                + "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );"
                + "-fx-font-family: Arial Black;"
        );
        p1.setVisible(false);
        l2.setVisible(true);
        l.setOnMouseEntered(event -> {
           p1.setVisible(true);
        });

       
        l.setOnMouseExited((event) -> {
            p1.setVisible(false);
        });
       
        p1.getChildren().add(l2);
        l.setAlignment(Pos.CENTER);
        
        VBox vb = new VBox();
        vb.setSpacing(5);

        
       VBox vb2 = new VBox();
        vb2.setSpacing(5);
        
        Label datePost = new Label("Date: ");
        datePost.setStyle("-fx-text-fill: #7f171f;-fx-font-weight: bold; -fx-font: 20px Tahoma;");
        System.out.println(data.get(k).getDatePost());
         Label datePostP = new Label(data.get(k).getDatePost().toString());
         datePostP.setStyle("-fx-text-fill:  #27313a;-fx-font-weight: bold; -fx-font: 20px Tahoma;");
         Label desc = new Label();
         desc.setStyle("-fx-text-fill:  #27313a;-fx-font-weight: bold; -fx-font: 20px Tahoma;");
        desc.setText(data.get(k).getDescription());
     
         JFXButton delete = new JFXButton();
        delete.setText("Delete ");
        delete.setStyle("-fx-text-fill: hite;-fx-font: 11 'system'; -fx-background-radius: 5px; -padding-left: 50px;-fx-background-color:#c49e56;");
         delete.prefWidth(80);
        delete.setAccessibleHelp("Bouton");
       delete.setAccessibleText(Integer.toString(data.get(0).getId()));
   
        /*JFXButton likeBtn = new JFXButton();
        int nblike = (data.get(k).getLikesNumber());
         likeBtn.setStyle("-fx-text-fill: hite;-fx-font: 15 'system'; -fx-background-radius: 5px; -padding-left: 50px;-fx-text-color:red;");
        likeBtn.setText(Integer.toString(nblike));
         likeBtn.setGraphic(imageviewlike);
         likeBtn.setAccessibleText(Integer.toString(data.get(0).getId()));*/
   


   delete.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent event) {
                           try {
							main.getPostProxy().RemovePost(Integer.valueOf(data.get(0).getId()));
						} catch (NamingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                             Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText(null);
alert.setContentText("Confirm your action ?");
alert.showAndWait();

                                          try {
               
                   Pane newLoadedPaneExp = FXMLLoader.load(getClass().getResource("/tn/redhats/network/view/post/Post1.fxml"));
                   anchronePane2.getChildren().clear();
                   anchronePane2.getChildren().add(newLoadedPaneExp);
               } catch (IOException ex) {
                   Logger.getLogger(Post1Controller.class.getName()).log(Level.SEVERE, null, ex);
               }
                              
                              
                              
                           }
                       });

 
 JFXButton addCom = new JFXButton();
       
         addCom.setText("Add comment ");
         addCom.setStyle("-fx-text-fill: hite;-fx-font: 11 'system'; -fx-background-radius: 5px; -padding-left: 50px;-fx-background-color:#c49e56;");
        addCom.prefWidth(120);

       addCom.setAccessibleText(Integer.valueOf(data.get(k).getId()).toString());
        addCom.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent event) {
                                   recupid=Integer.valueOf(addCom.getAccessibleText());
                                   System.out.println(recupid+"jjjj");
                                   try {
;
                                    
                   Pane newLoadedPaneExp = FXMLLoader.load(getClass().getResource("/tn/redhats/network/view/comment/Comment.fxml"));
                   anchronePane2.getChildren().clear();
                   anchronePane2.getChildren().add(newLoadedPaneExp);
               } catch (IOException ex) {
                   Logger.getLogger(Post1Controller.class.getName()).log(Level.SEVERE, null, ex);
               }
                              
                              
                              
                           }
                       });

        grid.add(new VBox(root, id, l, p1), j, i);
        vb.getChildren().addAll(l, datePostP, desc);
          vb2.getChildren().addAll( datePost,delete, addCom);
grid.add((vb2), 1, i);
grid.add((vb), 2, i);                

        k++;
             spPost.setContent(grid);
           
         }

     }

     for (Node node : grid.getChildren()) {
         if (node instanceof VBox) {
             for (Node node1 : ((VBox) node).getChildren()) {
                 if (node1 instanceof ImageView) {
                     node1.setOnMouseClicked((E) -> {
                     });
                 }

             }
         }
     }

     grid.setOnMouseClicked((E) -> {
         for (Node node : grid.getChildren()) {

             for (Node node1 : ((VBox) node).getChildren()) {
                 if (node1 instanceof Group) {
                     node1.setOnMouseClicked(( E1) -> {

                         try {
                             // recupid = Integer.valueOf(node1.getAccessibleText());
                             
                             
                          //   recupid = Integer.valueOf(node1.getAccessibleText());
                           System.out.println(recupid+"-------------------");
                             Pane newLoadedPaneExp = FXMLLoader.load(getClass().getResource("/tn/redhats/network/view/post/Post1.fxml"));
                             //   a.findMyannonce(recupid);
                             anchronePane2.getChildren().clear();
                             anchronePane2.getChildren().add(newLoadedPaneExp);
                             //      System.out.println(recupid);
                             //        System.out.println(annonce);
                         } catch (IOException ex) {
                             Logger.getLogger(tn.redhats.network.view.post.Post1Controller.class.getName()).log(Level.SEVERE, null, ex);
                         }

                       
                     });
                 }
             }
         }
     });


 }



    }
   

	
}
