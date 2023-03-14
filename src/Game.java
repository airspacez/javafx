import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

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
    static Human<Integer> human;
    static Artifact artifact;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scenes/SceneStartMenu.fxml"));
        Scene scene1 = new Scene(root);
        stage.setTitle("В поисках артефактов");
        stage.getIcons().add(new Image("Resources/artifact.png"));
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        surface = new Surface(10, 10);
        human = new Human<Integer>(1, "Leo", 100, 100, 1);
        artifact = new Artifact("Mirror", "rare", 20, 20, (int) (Math.random() * surface.getX()),
                (int) (Math.random() * surface.getY()));
        Thread launchThread = new Thread(() -> {
            launch(args);
        });
        launchThread.start();
        try (var sc = new Scanner(System.in)) {
            try (Socket socket = new Socket("localhost", 8888)) {
                Thread socketThread = new Thread(() -> {
                    try {
                        String previousMsg = "";
                        while (true) {
                            String getXY = "x: " + String.valueOf(human.getX()) + " y: " + String.valueOf(human.getY());
                            if (!getXY.equals(previousMsg)) {
                                var msg = "Координаты " + human.getName() + " изменены. Теперь: " + getXY + "";
                                System.out.println(msg);

                                OutputStream outputStream = socket.getOutputStream();
                                outputStream.write(msg.getBytes());

                                previousMsg = getXY;
                            }
                            Thread.sleep(300);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                socketThread.start();
                launchThread.join();
                socketThread.join();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}