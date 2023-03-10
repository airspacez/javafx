import java.io.IOException;

import ObjectiveProgramming.ChildClasses.Human;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Controller {

    private Stage stage;
    private Parent root;
    private Scene scene;
    private Human<String> human;

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
    private Label textMapX;

    @FXML
    private Label textMapY;

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
    private Label textCharacterDamage;

    @FXML
    private Label textCharacterHP;

    @FXML
    private Label textCharacterMovespeed;

    @FXML
    private Label textCharacterName;

    @FXML
    private Button buttonSaveArtifact;

    @FXML
    private TextField fieldArtifactName;

    @FXML
    private TextField fieldArtifactRarity;

    @FXML
    private Label textArtifactName;

    @FXML
    private Label textArtifactRarity;

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
    private Label textHPInGame;

    @FXML
    private Label textMapXInGame;

    @FXML
    private Label textMapYInGame;

    @FXML
    private Label textMovespeedInGame;

    @FXML
    private Label textartifactXInGame;

    @FXML
    private Label textartifactYInGame;

    public void initialize() {
        human = new Human<String>("1", "Leo", 100, 100, 1);
        textDPSInGame.setText(String.valueOf(human.getDamage()));
    }

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////SceneStartMenu//////////////////////////////
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
    ////////////////////////////////SceneEditMap////////////////////////////////////
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
    //////////////////////////////SceneEditCharacter////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    @FXML
    void saveCharacter(ActionEvent event) {

    }

    ////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////SceneEditArtifact/////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    @FXML
    void saveArtifact(ActionEvent event) {

    }

    ////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////SceneGame////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    @FXML
    void down(ActionEvent event) {

    }

    @FXML
    void left(ActionEvent event) {

    }

    @FXML
    void right(ActionEvent event) {

    }

    @FXML
    void up(ActionEvent event) {

    }


}
