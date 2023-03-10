import java.io.IOException;

import ObjectiveProgramming.ChildClasses.Artifact;
import ObjectiveProgramming.ChildClasses.Human;
import ObjectiveProgramming.ParentClasses.Surface;
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
    static Surface surface;
    static Human<String> human;
    static Artifact artifact;

    @Override
    public void start(Stage stage) throws IOException {
        surface = new Surface(10, 10);
        human = new Human<String>("1", "Leo", 100, 100, 1);
        artifact = new Artifact("Mirror", "rare", 20, 30, (int) (Math.random() * surface.getX()),
                (int) (Math.random() * surface.getY()));
        Parent root = FXMLLoader.load(getClass().getResource("Scenes/SceneStartMenu.fxml"));
        Scene scene1 = new Scene(root);
        stage.setTitle("В поисках артефактов");
        stage.getIcons().add(new Image("Resources/artifact.png"));
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}