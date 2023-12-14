package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ChristmasTree extends BaseProp implements PropFunctionable {
    public ChristmasTree(int x, int y) {

        super(x, y);
        setPropClass(ChristmasTree.class);
        setPropImage(new Image(String.valueOf(ClassLoader.getSystemResource("prop/ChristmasTree.png")), 150, 150, false, false));

    }

    public void update() {
        // if you want to update something
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getPropImage(), getX(), getY());
    }

}
