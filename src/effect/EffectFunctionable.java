package effect;

import javafx.scene.canvas.GraphicsContext;

public interface EffectFunctionable {

    void draw(GraphicsContext gc);

    void update();

}
