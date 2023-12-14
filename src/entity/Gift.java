package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Gift extends BaseProp implements PropFunctionable {
    public Gift(int x, int y) {
        super(x, y);
        setPropClass(Gift.class);
        setPropImage(new Image(String.valueOf(ClassLoader.getSystemResource("prop/Gift.png"))));
    }

    public void update() {
        // if you want to update something
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getPropImage(), getX(), getY());
    }

}
