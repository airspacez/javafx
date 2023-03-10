import java.io.IOException;

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
    public void initialize() {
        textDPSInGame.setText(String.valueOf(Game.human.getDamage()));
        textHPInGame.setText(String.valueOf(Game.human.getHealth()));
        textMovespeedInGame.setText(String.valueOf(Game.human.getSpeed()));

        textartifactXInGame.setText(String.valueOf(Game.artifact.getX()));
        textartifactYInGame.setText(String.valueOf(Game.artifact.getY()));

        textMapXInGame.setText(String.valueOf(Game.surface.getX()));
        textMapYInGame.setText(String.valueOf(Game.surface.getY()));

        console.appendText("Начальные координаты игрока: x: " + Game.human.getX() + " y: "
                + Game.human.getY() + "\n");
        System.out.println("second");
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
    void saveMap(ActionEvent event) {

    }

    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////// SceneEditCharacter////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    @FXML
    void saveCharacter(ActionEvent event) {

    }

    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////// SceneEditArtifact////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    @FXML
    void saveArtifact(ActionEvent event) {

    }

    ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////// SceneGame////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    @FXML
    void down(ActionEvent event) {
        Game.human.setY(Game.human.getY() - Game.human.getSpeed());
        console.appendText(
                "Вниз. Текущие координаты игрока x: " + Game.human.getX() + " y: " + Game.human.getY() + "\n");
        findArtifact();
    }

    @FXML
    void left(ActionEvent event) {
        Game.human.setX(Game.human.getX() - Game.human.getSpeed());
        console.appendText(
                "Налево. Текущие координаты игрока x: " + Game.human.getX() + " y: " + Game.human.getY() + "\n");
        findArtifact();
    }

    @FXML
    void right(ActionEvent event) {
        Game.human.setX(Game.human.getX() + Game.human.getSpeed());
        console.appendText(
                "Направо. Текущие координаты игрока x: " + Game.human.getX() + " y: " + Game.human.getY() + "\n");
        findArtifact();
    }

    @FXML
    void up(ActionEvent event) {
        Game.human.setY(Game.human.getY() + Game.human.getSpeed());
        console.appendText(
                "Вверх. Текущие координаты игрока x: " + Game.human.getX() + " y: " + Game.human.getY() + "\n");
        findArtifact();
    }

    void findArtifact() {
        if (Game.human.getX() == Game.artifact.getX() && Game.human.getY() == Game.artifact.getY()) {
            console.appendText("Найден артефакт!");
            Game.human.pickUpArtifact();
            textHPInGame.setText(String.valueOf(Game.human.getHealth()));
            textDPSInGame.setText(String.valueOf(Game.human.getDamage()));
            Game.artifact = null;
            Game.artifact = new Artifact("test", "rare", (int) (Math.random() * Game.surface.getX()),
                    (int) (Math.random() * Game.surface.getY()));
            textartifactXInGame.setText(String.valueOf(Game.artifact.getX()));
            textartifactYInGame.setText(String.valueOf(Game.artifact.getY()));
        }
    }
}
