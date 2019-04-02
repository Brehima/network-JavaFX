/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkClient.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import tn.redhats.network.networkServer.entities.Course_chapters;

/**
 * FXML Controller class
 *
 * @author Emir Fattoum
 */
public class Media_playerController implements Initializable {
    @FXML
    private Button play;
    @FXML
    private Button stop;
    @FXML
    private Button close_player;
    @FXML
    private MediaView mediaplayer;
    
    MediaPlayer player;
	private Status PLAYING;
    
    public static Course_chapters ch =new Course_chapters()  ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
        // TODO
    	System.out.println(Chapter_modelController.path);
    	Media media = new Media(Chapter_modelController.path);
    	player = new MediaPlayer(media);
    	mediaplayer.setFitHeight(400);
    	mediaplayer.setFitWidth(550);
    	mediaplayer.setMediaPlayer(player);
    	
    }    
    
    
    public static void setparameters (Course_chapters c)
    {
    	Chapter_modelController.ch = c ;
    }


    @FXML
    private void play_player(ActionEvent event) {
    	if (player.getStatus()==PLAYING)
    	{
    		player.stop(); 
    		player.play();
    	}else
    	{
    	player.play();
    	}
    }

    @FXML
    private void stop_player(ActionEvent event) {
    	player.stop();
    }

    @FXML
    private void close_player(ActionEvent event) {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	primaryStage.close();
    }
    
}
