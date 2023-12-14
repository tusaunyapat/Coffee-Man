package background;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Background {

    private final Image background = new Image(String.valueOf(ClassLoader.getSystemResource("background/background.gif")));

    public void draw(GraphicsContext gc) {
        gc.drawImage(background, 0, 0);
    }

}
