/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.redhats.network.view.consultMsg;
import javafx.animation.Animation.Status;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import network.client.view.main.mainView;
import networkClient.main.main;
import tn.redhats.network.networkServer.entities.Comment;
import tn.redhats.network.networkServer.entities.Message;
import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services.MessageServiceRemote;
import tn.redhats.network.networkServer.services.UserServiceRemote;
import tn.redhats.network.networkServer.services_impl.MessageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import java.util.logging.Logger;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.sun.javafx.property.adapter.PropertyDescriptor.Listener;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ConsultMessageController implements Initializable {
	@FXML
    private BorderPane bpMsg;

    @FXML
    private JFXListView<?> chatPane;

    @FXML
    private JFXTextArea MsgBox;

    @FXML
    private JFXButton btnSendMsg;

    @FXML
    private HBox onlineUsersHbox;

    @FXML
    private Label onlineCountLabel;

    @FXML
    private JFXListView<?> userList;

    @FXML
    private ImageView userImageView;

    @FXML
    private Label usernameLabel;

    @FXML
    private ComboBox<?> statusComboBox;
    //public static Message createMessage = new Message();
    //private double xOffset;
   // private double yOffset;
    //@SuppressWarnings("restriction")
	Logger logger = LoggerFactory.getLogger(ConsultMessageController.class);

	//private Message m;
	 List<Message> listMsg= new ArrayList<Message>();
	public static Message createMessage = new Message();
	ObservableList<Message> data = FXCollections.observableArrayList();
    //public static MessageService msgService = new MessageService();
	@FXML
    void sendButtonAction(ActionEvent event) throws Exception{
		
		/*String jndiMessage = "networkServer-ear/networkServer-ejb/MessageService!tn.redhats.network.networkServer.services.MessageServiceRemotee";
		Context context =  new InitialContext();
		MessageServiceRemote proxyMessage = (MessageServiceRemote) context.lookup(jndiMessage);*/
		
		//Message createMessage = proxyMessage.AddMessage(m);
		String m = MsgBox.getText();
		  
        if (m.isEmpty())
        {
        	
        	 Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	 alert.setTitle("Notice");
        	 alert.setHeaderText(null);
        	 alert.setContentText("Write something");
        	 alert.showAndWait();
        }
        else 
        {
        	//ObservableList<Comment> MsgData = FXCollections.observableArrayList();
        createMessage.setMessage(m);
   		 main.getMessageProxy().AddMessage(createMessage);
   		 Date date = new Date();
 		long time = date.getTime();
 		Timestamp ts = new Timestamp(time);
        createMessage.setDateMessage(ts);
        MsgBox.clear();
        //ObservableList<Message> MsgData = FXCollections.observableArrayList();
        //listMsg=main.getMessageProxy().findAllMessage();
       // MsgData.addAll(listMsg);
        }
    	
	}
		
	/*public void addToChat(Message message) {
        Task<HBox> othersMessages = new Task<HBox>() {
    	//HBox othersMessages = new HBox() {
            
            public HBox call() throws Exception {
                Image image = new Image(getClass().getClassLoader().getResource("/consultMsg/" + message.getPicture().toLowerCase() + ".png").toString());
                ImageView profileImage = new ImageView(image);
                profileImage.setFitHeight(32);
                profileImage.setFitWidth(32);
               Label bl6 = new Label();
               
                    bl6.setText(message.getUsers() + ": " + message.getMessage());                
                bl6.setBackground(new Background(new BackgroundFill(Color.WHITE,null, null)));
                HBox x = new HBox();
                bl6.setAlignment(Pos.CENTER_LEFT);
                x.getChildren().addAll(profileImage, bl6);
                logger.debug("ONLINE USERS: " + Integer.toString(message.getUserList().size()));
                setOnlineLabel(Integer.toString(message.getOnlineCount()));
             
                return x;
            
        }
        };

        othersMessages.setOnSucceeded(event -> {
        	//HBox values = othersMessages.getValue();
        	
            chatPane.getItems().add(othersMessages.getValue());
        	//chatPane.getItems().addAll(othersMessages.getValue());
        });

        //Task<HBox> yourMessages = new Task<HBox>() {
        HBox yourMessages = new HBox() {
            
            public HBox call() throws Exception {
                Image image = userImageView.getImage();
                ImageView profileImage = new ImageView(image);
                profileImage.setFitHeight(32);
                profileImage.setFitWidth(32);

                Label bl6 = new Label();
                 bl6.setText(message.getMessage());
                bl6.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN,
                        null, null)));
                HBox x = new HBox();
                x.setMaxWidth(chatPane.getWidth() - 20);
                x.setAlignment(Pos.TOP_RIGHT);
                bl6.setAlignment(Pos.CENTER_RIGHT);
                x.getChildren().addAll(bl6, profileImage);

                setOnlineLabel(Integer.toString(message.getOnlineCount()));
                return x;
            }
        };
        yourMessages.setOnSucceeded(event -> chatPane.getItems().add(yourMessages.getValue()));

        if (Integer.toString(message.getId()).equals(usernameLabel.getText())) {
            Thread t2 = new Thread(yourMessages);
            t2.setDaemon(true);
            t2.start();
        } else {
            Thread t = new Thread(othersMessages);
            t.setDaemon(true);
            t.start();
        }
        }
     public void setOnlineLabel(String usercount) {
            Platform.runLater(() -> onlineCountLabel.setText(usercount));
        }

    /*@FXML
   void sendMethod(KeyEvent event) throws Exception {
    	 if (event.getCode() == KeyCode.ENTER) {
             sendButtonAction();
         }
    }
   /* public void setImageLabel() throws IOException {
        this.userImageView.setImage(new Image(getClass().getClassLoader().getResource("Esprit/Semestre 2/PI sem2/imen.png").toString()));
    }*/


    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
    	MsgBox.setStyle("-fx-text-inner-color: white;");
        
    }
    }
        /*try {
            setImageLabel();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
                /* Drag and Drop */
      /* bpMsg.setOnMousePressed(event -> {
           // xOffset = mainView.getPrimaryStage().getX() - event.getScreenX();
            //yOffset = mainView.getPrimaryStage().getY() - event.getScreenY();
            bpMsg.setCursor(Cursor.CLOSED_HAND);
        });

        bpMsg.setOnMouseDragged(event -> {
            //mainView.getPrimaryStage().setX(event.getScreenX() + xOffset);
            //mainView.getPrimaryStage().setY(event.getScreenY() + yOffset);

        });

        bpMsg.setOnMouseReleased(event -> {
            bpMsg.setCursor(Cursor.DEFAULT);
        });

        //statusComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    //Listener.sendStatusUpdate(Status.valueOf(newValue.toUpperCase()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
  
        /* Added to prevent the enter from adding a new line to inputMessageBox */
        /*MsgBox.addEventFilter(KeyEvent.KEY_PRESSED, ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                try {
                    sendButtonAction();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ke.consume();
            }
        });

    }*/

   /* public void setImageLabel(String selectedPicture) {
        switch (selectedPicture) {
            case "Dominic":
                this.userImageView.setImage(new Image(getClass().getClassLoader().getResource("Esprit/Semestre 2/PI sem2/imen.png").toString()));
                break;
            /*case "Sarah":
                this.userImageView.setImage(new Image(getClass().getClassLoader().getResource("images/sarah.png").toString()));
                break;*/
            /*case "Default":
                this.userImageView.setImage(new Image(getClass().getClassLoader().getResource("Esprit/Semestre 2/PI sem2/profile-icon-9").toString()));
                break;
        }
    }

    public void logoutScene() {
        Platform.runLater(() -> {
            FXMLLoader fmxlLoader = new FXMLLoader(getClass().getResource("/views/LoginView.fxml"));
            Parent window = null;
            try {
                window = (Pane) fmxlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = mainView.getPrimaryStage();
            Scene scene = new Scene(window);
            stage.setMaxWidth(350);
            stage.setMaxHeight(420);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.centerOnScreen();
        });
    }*/

