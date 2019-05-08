package network.client.view.main;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tn.redhats.network.view.login.LoginController;

public class mainView extends Application{
	 private static Stage primaryStageObj;
	  //public static LoginController con;

	  
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		 {   
			
		       Parent  root = FXMLLoader.load(getClass().getResource("/tn/redhats/network/view/login/Login.fxml"));
		     //con = root.<LoginController>getController();
		       Scene scene = new Scene(root);
		       scene.setRoot(root);
		        primaryStage.setResizable(false);
		        primaryStage.setScene(scene);
		        primaryStageObj = primaryStage;
		        primaryStage.show();
		        primaryStage.setOnCloseRequest(e -> Platform.exit());
		    }
		       
		   }
	public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return primaryStageObj;
    }

		
	}


