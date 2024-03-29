import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ObjectiveProgramming.ChildClasses.Artifact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private Button buttonEditArtifact;

    @FXML
    private Button buttonEditCharacter;

    @FXML
    private Button buttonEditMap;

    @FXML
    private Button buttonQuit;

    @FXML
    private Button buttonStartGame;

    @FXML
    private Button buttonBackMap;

    @FXML
    private Button buttonSaveMap;

    @FXML
    private Label textMapX = new Label();

    @FXML
    private Label textMapY = new Label();

    @FXML
    private Button buttonSaveCharacter;

    @FXML
    private TextField fieldCharacterDamage;

    @FXML
    private TextField fieldCharacterHP;

    @FXML
    private Label textArtifactDamage = new Label();

    @FXML
    private Label textArtifactHP = new Label();

    @FXML
    private TextField fieldCharacterMovespeed;

    @FXML
    private TextField fieldCharacterName;

    @FXML
    private Label textCharacterDamage = new Label();

    @FXML
    private Label textCharacterHP = new Label();

    @FXML
    private Label textCharacterMovespeed = new Label();

    @FXML
    private Label textCharacterName = new Label();

    @FXML
    private Button buttonSaveArtifact;

    @FXML
    private TextField fieldArtifactName;

    @FXML
    private TextField fieldArtifactRarity;

    @FXML
    private TextField fieldArtifactHP;

    @FXML
    private TextField fieldArtifactDamage;

    @FXML
    private Label textArtifactName = new Label();

    @FXML
    private Label textArtifactRarity = new Label();

    @FXML
    private Button buttonDown;

    @FXML
    private Button buttonLeft;

    @FXML
    private Button buttonUp;

    @FXML
    private Button buttorRight;

    @FXML
    private Label textDPSInGame = new Label();

    @FXML
    private Label textHPInGame = new Label();

    @FXML
    private Label textMapXInGame = new Label();

    @FXML
    private Label textMapYInGame = new Label();

    @FXML
    private Label textMovespeedInGame = new Label();

    @FXML
    private Label textartifactXInGame = new Label();

    @FXML
    private Label textartifactYInGame = new Label();

    @FXML
    private TextArea console = new TextArea();

    @FXML
    private TextField fieldMapX;

    @FXML
    private TextField fieldMapY;

    @FXML
    public void initialize() { // render
        textDPSInGame.setText(String.valueOf(Game.human.getDamage()));
        textHPInGame.setText(String.valueOf(Game.human.getHealth()));
        textMovespeedInGame.setText(String.valueOf(Game.human.getSpeed()));

        textArtifactHP.setText(String.valueOf(Game.artifact.getHealth()));
        textArtifactName.setText(Game.artifact.getName());
        textArtifactRarity.setText(Game.artifact.getRarity());
        textArtifactDamage.setText(String.valueOf(Game.artifact.getDamage()));

        textartifactXInGame.setText(String.valueOf(Game.artifact.getX()));
        textartifactYInGame.setText(String.valueOf(Game.artifact.getY()));

        textMapXInGame.setText(String.valueOf(Game.surface.getX()));
        textMapYInGame.setText(String.valueOf(Game.surface.getY()));

        textMapX.setText(String.valueOf(Game.surface.getX()));
        textMapY.setText(String.valueOf(Game.surface.getY()));

        textCharacterName.setText(String.valueOf(Game.human.getName()));
        textCharacterHP.setText(String.valueOf(Game.human.getHealth()));
        textCharacterDamage.setText(String.valueOf(Game.human.getDamage()));
        textCharacterMovespeed.setText(String.valueOf(Game.human.getSpeed()));

        console.appendText("Начальные координаты игрока: x: " + Game.human.getX() + " y: "
                + Game.human.getY() + "\n");
    }

    static public void Client() {
        Runnable runnable = () -> {
            Socket socket;
            try {
                socket = new Socket("localhost", 8888);
                String previousMsg = "";
                while (true) {
                    String getXY = "x: " + String.valueOf(Game.human.getX()) + " y: "
                            + String.valueOf(Game.human.getY());
                    if (!getXY.equals(previousMsg)) {
                        var msg = "Координаты " + Game.human.getName() + " изменены. Теперь: " + getXY + "";
                        System.out.println(msg);

                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write(msg.getBytes());

                        previousMsg = getXY;
                    }
                    Thread.sleep(300); 
                }}
            catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService thread1 = Executors.newSingleThreadExecutor();
        thread1.execute(runnable);
    }
    

    //////////////////////////////////////////////////////////////////////////
    ////////////////////////////// SceneStartMenu//////////////////////////////
    //////////////////////////////////////////////////////////////////////////

    @FXML
    void openWindowEditArtifact(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scenes/SceneEditArtifact.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openWindowEditCharacter(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scenes/SceneEditCharacter.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openWindowEditMap(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scenes/SceneEditMap.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openWindowStartGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scenes/SceneGame.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void closeWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    ////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////// SceneEditMap////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    @FXML
    void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scenes/SceneStartMenu.fxml"));
        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void saveMap(ActionEvent event) throws IOException {
        String mapX = fieldMapX.getText();
        String mapY = fieldMapY.getText();

        int x = Integer.parseInt(mapX);
        int y = Integer.parseInt(mapY);

        textMapX.setText(mapX);
        textMapY.setText(mapY);

        Game.surface.setX(x);
        Game.surface.setY(y);
        back(event);
    }

    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////// SceneEditCharacter////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    @FXML
    void saveCharacter(ActionEvent event) throws IOException {
        String nameCharacter = fieldCharacterName.getText();
        String healthCharacter = fieldCharacterHP.getText();
        String damageCharacter = fieldCharacterDamage.getText();
        String speedCharacter = fieldCharacterMovespeed.getText();

        int health = Integer.parseInt(healthCharacter);
        int damage = Integer.parseInt(damageCharacter);
        int speed = Integer.parseInt(speedCharacter);

        textCharacterName.setText(nameCharacter);
        textCharacterHP.setText(healthCharacter);
        textCharacterDamage.setText(damageCharacter);
        textCharacterMovespeed.setText(speedCharacter);

        Game.human.setName(nameCharacter);
        Game.human.setHealth(health);
        Game.human.setDamage(damage);
        Game.human.setSpeed(speed);
        back(event);
    }

    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////// SceneEditArtifact////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    @FXML
    void saveArtifact(ActionEvent event) throws IOException {
        String artifactName = fieldArtifactName.getText();
        String artifactRarity = fieldArtifactRarity.getText();
        String artifactHP = fieldArtifactHP.getText();
        String artifactDamage = fieldArtifactDamage.getText();

        int hp = Integer.parseInt(artifactHP);
        int damage = Integer.parseInt(artifactDamage);

        textArtifactName.setText(artifactName);
        textArtifactRarity.setText(artifactRarity);
        textArtifactHP.setText(artifactHP);
        textArtifactDamage.setText(artifactDamage);

        Game.artifact.setName(artifactName);
        Game.artifact.setRarity(artifactRarity);
        Game.artifact.setHealth(hp);
        Game.artifact.setDamage(damage);
        back(event);
    }

    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////// SceneGame////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    @FXML
    void down(ActionEvent event) {
        Game.human.setY(Game.human.getY() - Game.human.getSpeed());
        console.setText(
                "Вниз. Текущие координаты игрока x: " + Game.human.getX() + " y: " + Game.human.getY() + "\n");
        findArtifact();
    }

    @FXML
    void left(ActionEvent event) {
        Game.human.setX(Game.human.getX() - Game.human.getSpeed());
        console.setText(
                "Налево. Текущие координаты игрока x: " + Game.human.getX() + " y: " + Game.human.getY() + "\n");
        findArtifact();
    }

    @FXML
    void right(ActionEvent event) {
        Game.human.setX(Game.human.getX() + Game.human.getSpeed());
        console.setText(
                "Направо. Текущие координаты игрока x: " + Game.human.getX() + " y: " + Game.human.getY() + "\n");
        findArtifact();
    }

    @FXML
    void up(ActionEvent event) {
        Game.human.setY(Game.human.getY() + Game.human.getSpeed());
        console.setText(
                "Вверх. Текущие координаты игрока x: " + Game.human.getX() + " y: " + Game.human.getY() + "\n");
        findArtifact();
    }

    void findArtifact() {
        if (Game.human.getX() == Game.artifact.getX() && Game.human.getY() == Game.artifact.getY()) {
            console.appendText("Найден артефакт!");
            Game.human.pickUpArtifact(Game.artifact);
            textHPInGame.setText(String.valueOf(Game.human.getHealth()));
            textDPSInGame.setText(String.valueOf(Game.human.getDamage()));
            textArtifactHP.setText(String.valueOf(Game.artifact.getHealth()));
            textArtifactName.setText(Game.artifact.getName());
            textArtifactRarity.setText(Game.artifact.getRarity());
            textArtifactDamage.setText(String.valueOf(Game.artifact.getDamage()));
            Game.artifact = null;
            Game.artifact = new Artifact("test", "rare", 100, 100, (int) (Math.random() * Game.surface.getX()),
                    (int) (Math.random() * Game.surface.getY()));
            textartifactXInGame.setText(String.valueOf(Game.artifact.getX()));
            textartifactYInGame.setText(String.valueOf(Game.artifact.getY()));
        }
    }
}
