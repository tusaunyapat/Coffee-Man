package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Snowman extends BaseProp implements PropFunctionable {
    public Snowman(int x, int y) {

        super(x, y);
        setPropClass(Snowman.class);
        setPropImage(new Image(String.valueOf(ClassLoader.getSystemResource("prop/Snowman.png"))));

    }

    public void update() {
        // if you want to update something
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getPropImage(), getX(), getY());
    }

}
