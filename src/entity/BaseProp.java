package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static main.GamePanel.props;

public class BaseProp extends Prop {

    public BaseProp(int x, int y) {

        setDefaultValues(x, y);

    }

    public void setDefaultValues(int x, int y) {

        setPropClass(BaseProp.class);
        setX(x);
        setY(y);
        setPropImage(new Image(String.valueOf(ClassLoader.getSystemResource("prop/ChristmasTree.png"))));

    }

    public void updateAll() {
        if (!props.isEmpty()) {
            for (int i = 0; i < props.size(); i++) {
                switch (String.valueOf(props.get(i).getClass())) {
                    case "class entity.ChristmasTree":
                        ((ChristmasTree) props.get(i)).update();
                        break;
                    case "class entity.Gift":
                        ((Gift) props.get(i)).update();
                        break;
                    case "class entity.Gift2":
                        ((Gift2) props.get(i)).update();
                        break;
                    case "class entity.Snowman":
                        ((Snowman) props.get(i)).update();
                        break;
                }
            }
        }
    }

    public void drawAll(GraphicsContext gc) {
        if (!props.isEmpty()) {
            for (int i = 0; i < props.size(); i++) {
                switch (String.valueOf(props.get(i).getClass())) {
                    case "class entity.ChristmasTree":
                        ((ChristmasTree) props.get(i)).draw(gc);
                        break;
                    case "class entity.Gift":
                        ((Gift) props.get(i)).draw(gc);
                        break;
                    case "class entity.Gift2":
                        ((Gift2) props.get(i)).draw(gc);
                        break;
                    case "class entity.Snowman":
                        ((Snowman) props.get(i)).draw(gc);
                        break;
                }
            }
        }
    }


}
