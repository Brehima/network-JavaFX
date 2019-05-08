/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rn.redhats.network.view.Comment;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import networkClient.main.main;
import tn.redhats.network.networkServer.entities.Comment;
import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.services_impl.CommentService;
import tn.redhats.network.view.post.Post1Controller;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CommentController implements Initializable {

    @FXML
    private AnchorPane apComment;

    @FXML
    private AnchorPane anchropaneA;

    
    @FXML
    private JFXTextArea taComment;

    @FXML
    private JFXButton btnComment;

    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnBack;


    /* @FXML
    void Delete(ActionEvent event) {
    }*/
   
    @FXML
    private ScrollPane scrollPaneComment;
    
    private ObservableList<Comment> data = FXCollections.observableArrayList();
    CommentService cs = new CommentService();
     Label l = new Label();
    private File file1 = new File("");
         
int id ;
static int recupid;

Post pub = Post1Controller.pst;
public static Comment newComment = new Comment();

public CommentController() {
    id = Post1Controller.recupid;
}

    @FXML
    void AddComment(ActionEvent event) throws NamingException,IOException {
    	//boolean add = true;
        //Comment com = new Comment();

        //CommentService cs1 = new CommentService();
    	
        String champpub = taComment.getText();
        newComment.setText(champpub);
        Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
       newComment.setDateComment(ts);
        //Comment p = new Comment(champpub);
       main.getCommentProxy().AddComment(newComment);
       
        //p.setId(id);
        //cs.AddComment(com);
        ObservableList<Comment> CommentData = FXCollections.observableArrayList();
        List<Comment> listCom = new ArrayList<Comment>();
        listCom= main.getCommentProxy().findAllComment();
        CommentData.addAll(listCom);
        Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Information Dialog");
    	alert.setHeaderText(null);
    	alert.setContentText("Post added");
    	 
  			showlist();
  		   
    	alert.showAndWait();
         
    }
     
          
          /*TrayNotification tray = new TrayNotification("Notification !", "Publication ajoutée avec succée", NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(6));
       afficherlist();
     */

    
    
   
    /**
     * Initializes the controller class.
     *
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	taComment.setStyle("-fx-text-inner-color: white;");
    	ObservableList<Comment> PostData = FXCollections.observableArrayList();
        //CommentService cs= new CommentService();
        List<Comment> listcom= new ArrayList<Comment>();
        //Comment c = new Comment();
        System.out.println("Id comment " +id);
        newComment.setId(recupid);
        try {
			listcom=main.getCommentProxy().findAllComment();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //listcom= cs.findCommentPost();
        PostData.addAll(listcom);
        try {
			showlist();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("list of posts"+listcom);
    }
    @FXML
    void back(ActionEvent event) {
    	 try {
             
             Pane newLoadedPaneExp = FXMLLoader.load(getClass().getResource("/tn/redhats/network/view/post/Post1.fxml"));
             apComment.getChildren().clear();
             apComment.getChildren().add(newLoadedPaneExp);
         } catch (IOException ex) {
             Logger.getLogger(CommentController.class.getName()).log(Level.SEVERE, null, ex);
         }
                        
                        
                        
                     }
    
    
    public void showlist() throws NamingException
    {
      //CommentService cs2 = new CommentService();
            //AnchorPane p = new AnchorPane();
            GridPane grid = new GridPane();
           
            data = FXCollections.observableArrayList();
         
            
            data.addAll(main.getCommentProxy().findAllComment());

            int k = 0;
            grid.setHgap(1);
            grid.setVgap((data.stream().count()) + 1);
            grid.setPadding(new Insets(50, 50, 50, 50));
            for (int i = 0; i < (data.stream().count() / 1) + 1; i++) {
                for (int j = 0; j < 1; j++) {
                    if (k < data.stream().count()) {
                       
                          
                
  Label visit = new Label("");

visit.setOnMouseEntered(event -> {
                    visit.setUnderline(true);
                });
                visit.setOnMouseExited(event -> {
                    visit.setUnderline(false);
                });
                visit.setOnMouseClicked(event -> {
                });
                
                     
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
                        l.setOnMouseEntered((MouseEvent event) -> {
                        p1.setVisible(true);

                        });
                        l.setOnMouseExited((MouseEvent event) -> {
                            p1.setVisible(false);
                        });
                        p1.getChildren().add(l2);
                        l.setAlignment(Pos.CENTER);
                
VBox vb = new VBox();
          vb.setSpacing(5);

          
          
         VBox vb1 = new VBox();
          vb1.setSpacing(5);
          
                  Label l = new Label("");
           Label l1 = new Label("");
           Label contenue = new Label("Commentaire ");
          contenue.setStyle("-fx-text-fill: #7f171f;-fx-font-weight: bold; -fx-font: 10px Tahoma;");
              Label contenupub = new Label(data.get(k).getText());
                 contenupub.setStyle("-fx-text-fill:  #27313a;-fx-font-weight: bold; -fx-font: 20px Tahoma;");
            
                 
             
                       Label dateComment = new Label("Date");
                     dateComment.setStyle("-fx-text-fill: #7f171f;-fx-font-weight: bold; -fx-font: 10px Tahoma;");
                   Label datecom = new Label (data.get(k).getDateComment().toString());
                     datecom.setStyle("-fx-text-fill:  #27313a;-fx-font-weight: bold; -fx-font: 20px Tahoma;");
                       
                         
   
                      
                         
               
                 JFXButton del= new JFXButton();
                        
                              del.setText("Delete ");
                del.setStyle("-fx-text-fill: hite;-fx-font: 11 'system'; -fx-background-radius: 5px; -padding-left: 50px;-fx-background-color:#c49e56;");
               del.setStyle("-fx-text-fill:#077F6F;-fx-font-weight: bold; -fx-font: 15px Tahoma;-fx-background-color: #C4CDCC;");
                del.prefWidth(80);
                del.setAccessibleHelp("Button");
                del.setAccessibleText(Integer.toString(data.get(0).getId()));
                        
                         
                      del.setOnAction(new EventHandler<ActionEvent>() {
                          @Override
                          public void handle(ActionEvent event) {
                          cs.RemoveComment(data.get(0).getId());
                                                   
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Confirm your action ?");
        alert.show();
        try {
        	
                                    
             Pane newLoadedPaneExp = FXMLLoader.load(getClass().getResource("/tn/redhats/network/view/Comment/Comment.fxml"));
             apComment.getChildren().clear();
             apComment.getChildren().add(newLoadedPaneExp);
       
           }
        
       catch (IOException ex) {
    	   
           Logger.getLogger(CommentController.class.getName()).log(Level.SEVERE, null, ex);
       }
                          }
                      });
                      
                      JFXButton affCom = new JFXButton();
                      grid.add(new VBox( id, l, p1), j, i);
                   vb.getChildren().addAll(l,contenupub,datecom,affCom);
                     vb1.getChildren().addAll(l1,contenue,dateComment,del );
       grid.add((vb1), 1, i);
         grid.add((vb), 2, i);                

                   k++;
                        scrollPaneComment.setContent(grid);
                      
                    }

                }

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
                                        
                                        
                                     //   recupid = Integer.valueOf(node1.getAccessibleText());
                                        Pane newLoadedPaneExp = FXMLLoader.load(getClass().getResource("/tn/redhats/network/view/Comment/Comment.fxml"));
                                        //   a.findMyannonce(recupid);
                                        apComment.getChildren().clear();
                                        apComment.getChildren().add(newLoadedPaneExp);
                                        
  
                                    } catch (IOException ex) {
                                        Logger.getLogger(rn.redhats.network.view.Comment.CommentController.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                  
                                });
                            }
                        }
                    }
                });


            }
    
    }    

    }    
    

