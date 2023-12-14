package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Gift2 extends BaseProp implements PropFunctionable {
    public Gift2(int x, int y) {
        super(x, y);
        setPropClass(Gift2.class);
        setPropImage(new Image(String.valueOf(ClassLoader.getSystemResource("prop/Gift2.png"))));
    }

    public void update() {
        // if you want to update something
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getPropImage(), getX(), getY());
    }

}
