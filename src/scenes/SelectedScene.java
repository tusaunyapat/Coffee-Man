package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SelectedScene extends Scene {
    public static String playerName = "";
    public static String selectedCharacter = "1";

    public SelectedScene(Stage stage) {
        super(createSelectedScene(stage), 800, 600);
    }

    private static VBox createSelectedScene(Stage stage) {
        Text playerText = new Text("PLAYER");
        playerText.setFont(new Font("Courier New", 40));

        StackPane header = new StackPane();
        ImageView backgroundRectangle = new ImageView(new Image("element/player.png"));
        header.getChildren().addAll(backgroundRectangle, playerText);

        TextField textField = createPlayerNameTextField();
        VBox characterPane = createCharacterPane();

        Button playButton = createPlayButton(stage);

        VBox root = new VBox(20);
        root.getChildren().addAll(header, textField, characterPane, playButton);
        root.setAlignment(Pos.CENTER);
        setRootStyle(root);

        return root;
    }

    private static TextField createPlayerNameTextField() {
        TextField textField = new TextField("Enter Player's name ...");
        textField.setAlignment(Pos.CENTER);
        setTextFieldStyle(textField);
        textField.setOnAction(event -> playerName = textField.getText());
        return textField;
    }

    private static VBox createCharacterPane() {
        VBox characterPane = new VBox(20);
        characterPane.setAlignment(Pos.CENTER);

        Button character1 = createCharacterButton("player/CharAwithFrame.gif", "player/CharA.gif");
        Button character2 = createCharacterButton("player/CharB.gif", "player/CharBwithFrame.gif");

        setCharacterSelectionActions(character1, character2);

        HBox charSelection = new HBox(50);
        charSelection.setAlignment(Pos.CENTER);
        charSelection.getChildren().addAll(character1, character2);

        characterPane.getChildren().addAll(charSelection);
        return characterPane;
    }

    private static Button createCharacterButton(String defaultImage, String selectedImage) {
        Button characterButton = new Button();
        characterButton.setPrefSize(200, 250);
        characterButton.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(" + defaultImage + ");" +
                "-fx-background-size: cover;");
        return characterButton;
    }

    private static void setCharacterSelectionActions(Button character1, Button character2) {
        character1.setOnAction(event -> {
            selectedCharacter = "1";
            updateCharacterButtonStyles(character1, character2, true);
        });

        character2.setOnAction(event -> {
            selectedCharacter = "2";
            updateCharacterButtonStyles(character1, character2, false);
        });
    }

    private static void updateCharacterButtonStyles(Button character1, Button character2, boolean selectCharacter1) {
        character1.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(player/CharA" +
                (selectCharacter1 ? "withFrame" : "") + ".gif);" +
                "-fx-background-size: cover;");

        character2.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(player/CharB" +
                (selectCharacter1 ? "" : "withFrame") + ".gif);" +
                "-fx-background-size: cover;");
    }

    private static Button createPlayButton(Stage stage) {
        Button playButton = new Button("LET'S PLAY !");
        playButton.setPrefSize(300, 60);
        playButton.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        setPlayButtonStyle(playButton);
        playButton.setOnAction(event -> stage.setScene(new GameScene(stage)));
        return playButton;
    }

    private static void setRootStyle(VBox root) {
        root.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(element/BackgroundHome.jpg);" +
                "-fx-background-size: cover;");
        root.setAlignment(Pos.CENTER);
    }

    private static void setTextFieldStyle(TextField textField) {
        textField.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(element/ENTER.png);" +
                "-fx-background-size: contain;");
        textField.setMaxWidth(320);
        textField.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
    }

    private static void setPlayButtonStyle(Button playButton) {
        playButton.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(element/shortBox.png);" +
                "-fx-background-size: cover;" + "-fx-background-repeat: no-repeat;");
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static String getSelectedCharacter() {
        return selectedCharacter;
    }
}
