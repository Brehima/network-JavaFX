/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

  package tn.redhats.network.view.post;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.spec.PSource;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.redhats.network.networkClient.view.home.HomeController;
import tn.redhats.network.networkServer.entities.Comment;
import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.services_impl.PostService;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.controls.JFXTextArea;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class PostController implements Initializable {
	//private final Image likebutton = new Image("/images/like.png");
	//ImageView imageviewlike = new ImageView(likebutton);
	 @FXML
	    private AnchorPane anchronePane2;

	    @FXML
	    private JFXButton btnpost;

	    @FXML
	    private JFXTextArea taPost;
        @FXML
	    private JFXButton delete;

	    @FXML
	    private JFXButton btnUpload;
	    @FXML
	    private Label lblUpload;

	    @FXML
	    private JFXButton btnUploadVid;

	    @FXML
	    private Label lblVideo;
	    @FXML
	    private JFXButton supprimer;
	    private File file;
	    String vid;
	   
	    private Image image;
	    String pic;
	    @FXML
	    private JFXScrollPane spPost;
	    public static int recupid;                                                                    
	     int iduser;
	     int idpub;
	     private ObservableList<Post> data = FXCollections.observableArrayList();
	     FilteredList<Post> filteredData = new FilteredList<>(data);
	     public static Post p;
	     
	     Label l = new Label();
	     PostService ps = new PostService();
	     //private FileChooser.ExtensionFilter extFilterJPG;
	      //private FileChooser.ExtensionFilter extFilterjpg;
	           private Upload up;
	           private File file1 = new File("");
	           public PostController()
	           {
	           iduser=2;
	           }
	          
	     @Override
	      public void initialize(URL url, ResourceBundle rb) {
	      ObservableList<Post> PostData = FXCollections.observableArrayList();
	      PostService ps1= new PostService();
	      List<Post> listp= new ArrayList<Post>();
	     // listp=ps1.findAllPost();
	       PostData.addAll(listp);
	       showList();
	        } 
	     public void showList()
	     {
	       
	         //PostService ps2 = new PostService();

	           //Image[] images;
	         
	             AnchorPane pane1 = new AnchorPane();
	             GridPane grid = new GridPane();
	            
	         
	             data = FXCollections.observableArrayList();
	          
	             
	             //data.addAll(ps.findAllPost());

	            int k = 0;
	             grid.setHgap(1);
	             grid.setVgap((data.stream().count()) + 1);
	             grid.setPadding(new Insets(50, 50, 50, 50));
	             for (int i = 0; i < (data.stream().count() / 1) + 1; i++) {
	                 for (int j = 0; j < 1; j++) {
	                     if (k < data.stream().count()) {
	                        List<String> urli = data.get(k).getPhotos();
	                           Group root = new Group();
	                             ImageView im= new ImageView(new Image("http://localhost/uimg/"+urli));
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
	 //css for design
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
	                         Label lbl2 = new Label("clik me !!!");
	                         lbl2.setStyle("-fx-font-size: 20px;"
	                                 + " -fx-font-weight: bold;"
	                                 + "-fx-text-fill: #818181;"
	                                 + "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );"
	                                 + "-fx-font-family: Arial Black;"
	                         );
	                         p1.setVisible(false);
	                         lbl2.setVisible(true);
	                         l.setOnMouseEntered((MouseEvent event) -> {
	                         p1.setVisible(true);

	                         });
	                         l.setOnMouseExited((MouseEvent event) -> {
	                             p1.setVisible(false);
	                         });
	                         p1.getChildren().add(lbl2);
	                         l.setAlignment(Pos.CENTER);
	                 
	 VBox vv = new VBox();
	           vv.setSpacing(5);

	           
	           
	          VBox v1 = new VBox();
	           v1.setSpacing(5);
	           
	                   Label l = new Label("");
	                   
	                        //PostService ps3 =new PostService();
	                         int nblike = (data.get(k).getLikesNumber());
	            Label lbl1 = new Label("");
	           // l.setText(Integer.toString(nblike));
	             Label lbl3 = new Label("");
	            Label contenue = new Label("Post: ");
	           contenue.setStyle("-fx-text-fill: #7f171f;-fx-font-weight: bold; -fx-font: 20px Tahoma;");
	               Label contenupub = new Label(data.get(k).getDescription());
	                  contenupub.setStyle("-fx-text-fill:  #27313a;-fx-font-weight: bold; -fx-font: 20px Tahoma;");
	             
	                  
	              
	                        Label datePost = new Label("Date: ");
	                      datePost.setStyle("-fx-text-fill: #7f171f;-fx-font-weight: bold; -fx-font: 20px Tahoma;");
	                    Label datePostP = new Label (data.get(k).getDatePost().toString());
	                       datePostP.setStyle("-fx-text-fill:  #27313a;-fx-font-weight: bold; -fx-font: 20px Tahoma;");
	                        
	                          
	                
	                  JFXButton delete = new JFXButton();
	                         
	                  delete.setText("delete ");
	                 delete.setStyle("-fx-text-fill: hite;-fx-font: 11 'system'; -fx-background-radius: 5px; -padding-left: 50px;-fx-background-color:#c49e56;");
	                 delete.prefWidth(80);
	                 delete.setAccessibleHelp("Bouton");
	                 delete.setAccessibleText(Integer.toString(data.get(0).getId()));
	                         
	                  JFXButton likeBtn = new JFXButton();
	                 
	                 likeBtn.setStyle("-fx-text-fill: hite;-fx-font: 15 'system'; -fx-background-radius: 5px; -padding-left: 50px;-fx-text-color:red;");
	                  likeBtn.setText(Integer.toString(nblike));
	                 //likeBtn.setGraphic(imageviewlike);
	                 likeBtn.setAccessibleText(Integer.toString(data.get(0).getId()));
	                         
	                  
	                    
	                       delete.setOnAction(new EventHandler<ActionEvent>() {
	                                                 @Override
	                                                 public void handle(ActionEvent event) {
	                                                 ps.RemovePost(data.get(0).getId());
	                                                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
	         alert.setTitle("Information Dialog");
	         alert.setHeaderText(null);
	         alert.setContentText("Confirm your action ?");
	         alert.show();
	         
	                                                                try {
	                                     
	                                         Pane newLoadedPaneExp = FXMLLoader.load(getClass().getResource("/tn/redhats/network/view/post/Post.fxml"));
	                                         anchronePane2.getChildren().clear();
	                                         anchronePane2.getChildren().add(newLoadedPaneExp);
	                                     } catch (IOException ex) {
	                                         Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
	                                     }
	                                                    
	                                                    
	                                                    
	                                                 }
	                                             });
	                 
	                       
	                       JFXButton addCom = new JFXButton();
	                             
	                               addCom.setText("Add a comment ");
	                 addCom.setStyle("-fx-text-fill: hite;-fx-font: 11 'system'; -fx-background-radius: 5px; -padding-left: 50px;-fx-background-color:#c49e56;");
	                 addCom.prefWidth(120);
	                 
	                    addCom.setAccessibleText(Integer.valueOf(data.get(k).getId()).toString());
	                       addCom.setOnAction(new EventHandler<ActionEvent>() {
	                                                 @Override
	                                                 public void handle(ActionEvent event) {
	                                                                      recupid=Integer.valueOf(addCom.getAccessibleText());
	                                                                         System.out.println(recupid+"jjjj");
	       ;
	                                                                try {
	                                     
	                                         Pane newLoadedPaneExp = FXMLLoader.load(getClass().getResource("/tn/redhats/network/view/comment/Comment.fxml"));
	                                         anchronePane2.getChildren().clear();
	                                         anchronePane2.getChildren().add(newLoadedPaneExp);
	                                     } catch (IOException ex) {
	                                         Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
	                                     }
	                                                    
	                                                    
	                                                    
	                                                 }
	                                             });
	                       JFXButton addvideo = new JFXButton();
	                             
	                               addvideo.setText("Show video ");
	                 addvideo.setStyle("-fx-text-fill: hite;-fx-font: 11 'system'; -fx-background-radius: 5px; -padding-left: 50px;-fx-background-color:#c49e56;");
	                 addvideo.prefWidth(120);
	                 
	                    addvideo.setAccessibleText(Integer.valueOf(data.get(k).getId()).toString());

	                         
	                         
	                 
	                       addvideo.setOnAction(new EventHandler<ActionEvent>() {
	                                                 @Override
	                                                 public void handle(ActionEvent event) {
	                                                                       recupid=Integer.valueOf(addCom.getAccessibleText());
	                                                                         System.out.println(recupid+"jjjj");
	                                           p = new Post();
	                                          p = ps.findPosttById(recupid);
	                                                     System.out.println(p.getVideos()+"kkkk");
	                                         
	                                                                try {
	                                     
	                                         Pane newLoadedPaneExp = FXMLLoader.load(getClass().getResource("/FXML/VideoPublication.fxml"));
	                                         anchronePane2.getChildren().clear();
	                                         anchronePane2.getChildren().add(newLoadedPaneExp);
	                                     } catch (IOException ex) {
	                                         Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
	                                     }  
	                                                 }
	                                             });
	                       
	                 /* likeBtn.setOnAction(new EventHandler<ActionEvent>() {
	                                                 @Override
	                                                 public void handle(ActionEvent event) {
	                                            idpub=Integer.valueOf(likeBtn.getAccessibleText());
	                                          // pp=new Publication(); 
	                                          //pp=a.rechercherPublicationsById(recupid);
	                                             PublicationLikeService  pls=new PublicationLikeService();
	                                             PublicationLike pl=new PublicationLike(iduser,idpub);  
	                                             if(!pls.getUserLike(pl))
	                                             {
	                                             pls.ajouterLike(pl);
	                                             
	                                            afficherlist();
	                                                 }
	                                             
	                                                 }
	                                                 
	                                             }); */
	                 
	                 
	                    grid.add(new VBox(root, id, l, p1), j, i);
	                    vv.getChildren().addAll(l,lbl1,contenupub,datePostP);
	                      v1.getChildren().addAll(likeBtn,contenue,datePost,delete ,addvideo,addCom);
	        grid.add((v1), 1, i);
	          grid.add((vv), 2, i);                

	                    k++;
	                         spPost.setContent(grid);
	                       
	                     }

	                 }}

	                for (Node node : grid.getChildren()) {
	                     if (node instanceof VBox) {
	                         for (Node node1 : ((VBox) node).getChildren()) {
	                             if (node1 instanceof ImageView) {
	                                 node1.setOnMouseClicked((MouseEvent E) -> {
	                                 });
	                             }

	                         }
	                     }
	                 }

	                 grid.setOnMouseClicked((MouseEvent E) -> {
	                     for (Node node : grid.getChildren()) {

	                         for (Node node1 : ((VBox) node).getChildren()) {
	                             if (node1 instanceof Group) {
	                                 node1.setOnMouseClicked((MouseEvent E1) -> {

	                                     try {
	                                         recupid = Integer.valueOf(node1.getAccessibleText());
	                                         
	                                         
	                                      recupid = Integer.valueOf(node1.getAccessibleText());
	                                       System.out.println(recupid+"-------------------");
	                                         Pane newLoadedPaneExp = FXMLLoader.load(getClass().getResource("/FXML/actualite.fxml"));
	                                         //   a.findMyannonce(recupid);
	                                         anchronePane2.getChildren().clear();
	                                         anchronePane2.getChildren().add(newLoadedPaneExp);
	                                         //      System.out.println(recupid);
	                                         //        System.out.println(annonce);
	                                     } catch (IOException ex) {
	                                         Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
	                                     }

	                                   
	                                 });
	                             }
	                         }
	                     }
	                 });


	             }
	     

	           
	    @FXML
	    void onAddPost(ActionEvent event) {

	    	 boolean ajoute = true;
	         Post pst = new Post();
	         if (file1.isFile()) {
	                     try {
	                           
	              vid=up.upload(file1, "video");                                

	                     } 
	                     catch (IOException ex) {
	                         Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
	                     }
	                 }
	        
	         
	         PostService ps3 = new PostService();
	         String champpub= taPost.getText();
	         Post p= new Post();
	         ps3.AddPost(p);
	         ObservableList<Post> PublicationData = FXCollections.observableArrayList();
	         PostService ps4= new PostService();
	         List<Post> listep= new ArrayList<Post>();
	        //listep=ps4.findAllPost();
	        PublicationData.addAll(listep);
	            String pub = taPost.getText();
	        //tts
	           /* FTTS freeTTSPub = new FTTS(pub);
	                 freeTTSPub.speak();
	                 
	 //notif
	           TrayNotification tray = new TrayNotification("Notification !", "Publication ajoutée avec succée", NotificationType.SUCCESS);
	         tray.showAndDismiss(Duration.seconds(6));
	        afficherlist(); */
	      
	     
	        
	     }
	    

	    @FXML
	    void deletePost(ActionEvent event) {

	    }

	    @FXML
	    void uploadImage(ActionEvent event) {
	    	FileChooser fileChooser = new FileChooser();
            file = fileChooser.showOpenDialog(null);
             FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            //pic=(file.toURI().toString());
            //pic=new Upload().upload(file,"img");
            System.out.println(pic);
            image= new Image("http://localhost/uimguimg/"+pic);
            lblUpload.setText(pic);
    }
	    

	    
}