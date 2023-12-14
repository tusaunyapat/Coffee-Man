package scenes;

import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.GamePanel;

public class GameScene extends Scene {

    public GameScene(Stage stage) {
        super(new StackPane(), 800, 600);
        System.out.println("Selected Character: " + SelectedScene.getSelectedCharacter());

        StackPane root = (StackPane) getRoot();
        GamePanel gamePanel = new GamePanel(800, 600);

        // Create retry pane
        VBox retryPane = createRetryPane(stage);
        retryPane.setVisible(false);

        // Add gamePanel and retryPane to the root stack pane
        root.getChildren().addAll(gamePanel, retryPane);

        gamePanel.requestFocus();

        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long l) {
                try {
                    gamePanel.update();
                    if (GamePanel.isGameOver) {
                        GamePanel.isGameOver = false;
                        System.out.println("Game Over. Showing Retry Pane.");
                        retryPane.setVisible(true);
                        gamePanel.setAllDefaultValues();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                gamePanel.paintComponent();
            }
        };

        animation.start();
    }

    private VBox createRetryPane(Stage stage) {
        VBox retryPane = new VBox(10);

        retryPane.setAlignment(Pos.CENTER);

        Text loseText = new Text("You Lose!!");
        loseText.setFont(Font.font("Courier New", FontWeight.BOLD, 40));

        Button retryButton = createRetryButton(stage);

        retryPane.getChildren().addAll(loseText, retryButton);

        return retryPane;
    }

    private Button createRetryButton(Stage stage) {
        Button retryButton = new Button("TRY AGAIN");
        retryButton.setFont(Font.font("Courier New", FontWeight.BOLD, 25));
        retryButton.setPrefSize(250, 80);
        retryButton.setStyle("-fx-background-color: transparent;" +
                "-fx-background-image: url(res/element/player.png);" +
                "-fx-background-size: cover;" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-size: contain;");

        retryButton.setOnAction(event -> {
            GamePanel.isGameOver = false;
            stage.setScene(new StartScene(stage));
        });


        return retryButton;
    }
}
