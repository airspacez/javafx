import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Game extends Application {
    Stage stage;
    Scene scene;
    Parent root;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SceneStartMenu.fxml"));
        Scene scene1 = new Scene(root);
        stage.setTitle("В поисках артефактов");
        stage.getIcons().add(new Image("artifact.png"));
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}