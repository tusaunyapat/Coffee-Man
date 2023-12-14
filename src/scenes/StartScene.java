package scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.MusicController;

public class StartScene extends Scene {
    public StartScene(Stage stage) {
        super(createStartScene(stage), 800, 600);
    }

    private static VBox createStartScene(Stage stage) {

        VBox root = new VBox(20);

        //Start Button
        Button btnStart = createButton("PLAY GAME", "element/longBox.png");
        btnStart.setFont(new Font(30));
        btnStart.setPrefSize(540, 60);
        btnStart.setOnAction(event -> {
            stage.setScene(new SelectedScene(stage));
        });

        //Menu
        HBox menu = new HBox(10);
        menu.setAlignment(Pos.TOP_CENTER);
        //setting
        Button btnSetting = createButton("SETTING", "element/shortBox.png");
        HBox control = MusicController.createMusicControllerPopup();
        btnSetting.setOnAction(event -> {
            control.setVisible(!control.isVisible());
        });
        //how to play
        VBox rules = createRules();
        rules.setVisible(false);
        Button btnHowToPlay = createButton("HOW TO PLAY", "element/shortBox.png");
        btnHowToPlay.setOnAction(event -> rules.setVisible(!rules.isVisible()));

        //exit
        Button btnExit = createButton("EXIT", "element/shortBox.png");
        btnExit.setOnMouseClicked(event -> {
            stage.close();
        });

        //detailed
        HBox detail = new HBox(20);
        detail.setAlignment(Pos.CENTER);
        detail.getChildren().addAll(control, rules);
        menu.getChildren().addAll(btnSetting, btnHowToPlay, btnExit);

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(200, 0, 0, 0));
        root.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(element/background.gif);" +
                "-fx-background-size: cover;");
        root.getChildren().addAll(btnStart, menu, detail);

        return root;
    }

    private static Button createButton(String string, String imagePath) {
        Button button = new Button(string);
        button.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        button.setOnMouseEntered(event -> {
            button.setCursor(Cursor.HAND);
        });
        button.setOnMouseExited(event -> {
            button.setCursor(Cursor.DEFAULT);
        });
        button.setPrefWidth(230);
        button.setPrefHeight(45);
        button.setStyle("-fx-background-color: transparent;" + "-fx-background-image: url(" + imagePath + ");" + "-fx-background-size: cover;");
        return button;
    }

    private static Text rule(String rule) {
        Text text = new Text(rule);
        text.setFont(Font.font("Courier New", 12));
        return text;
    }


    private static VBox createRules() {
        VBox rules = new VBox(3);

        Text text = new Text("RULES");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 12));
        Text rule1 = rule("1.Enter the player's name and choose a character.");
        Text rule2 = rule("2.Move:ASWD Select:Q,E USE:J Attack:K Transform:V");
        Text rule3 = rule("3.Battle starts when a player approaches a monster.");
        Text rule4 = rule("4.You'll get an item when the monster dies.");
        Text rule5 = rule("5.Game ends when health runs out/sleepiness is 100%.");

        rules.getChildren().addAll(text, rule1, rule2, rule3, rule4, rule5);
        rules.setAlignment(Pos.BASELINE_LEFT);
        rules.setVisible(false);
        rules.setPadding(new Insets(10, 0, 20, 10));
        rules.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(element/ruleBox.png);" +
                "-fx-background-size: cover;" + "-fx-background-size: contain;" + "-fx-background-repeat: no-repeat;");

        return rules;
    }

}