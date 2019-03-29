package networkClient.main;

import java.io.IOException;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
    
    public static Stage pStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CoursesClient.fxml"));
            Scene scene = new Scene( root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Ergacia");
            pStage = primaryStage;
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}