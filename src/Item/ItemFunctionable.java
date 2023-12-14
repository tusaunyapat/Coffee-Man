package Item;

import entity.Player;
import javafx.scene.canvas.GraphicsContext;

public interface ItemFunctionable {

    void use(Player player);

    void update(Player player);

    void draw(GraphicsContext gc);

    void addItem(Player player);

    void deleteItem(Player player);

    void autoDelete();


}
