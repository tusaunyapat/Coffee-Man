package effect;

import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

import static main.GamePanel.effects;

public class SuperSaiyan extends BaseEffect implements EffectFunctionable {
    public SuperSaiyan(Player player) {
        super(player);
        setEffectClass(SuperSaiyan.class);
        setPhase("phaseA");
    }

    public void loadPicture() {

        setEffect1(new Image(String.valueOf(ClassLoader.getSystemResource("effect/SuperSeiya_1.png"))));
        setEffect2(new Image(String.valueOf(ClassLoader.getSystemResource("effect/SuperSeiya_2.png"))));

    }

    public void update() {
        // update

        spriteCounter++;
        if (spriteCounter > 20) {
            if (spriteNum == 1) {
                spriteNum = 2;
                //System.out.println(spriteNum);
            } else if (spriteNum == 2) {
                spriteNum = 1;
                //System.out.println(spriteNum);
            }
            spriteCounter = 0;
        }

        if (Objects.equals(getPhase(), "phaseDelete")) {
            delete();
        }

        setX(player.getX());
        setY(player.getY());

        if (getPlayer().getMana() < 1) {
            delete();
        }

        getPlayer().setMana(getPlayer().getMana() - 3);


    }

    @Override
    public void draw(GraphicsContext gc) {
        boolean delete = false;

        setCurrentImage(getEffect1());

        switch (getPhase()) {
            case "phaseA":
                if (spriteNum == 1) {
                    setCurrentImage(getEffect1());
                } else if (spriteNum == 2) {
                    setCurrentImage(getEffect2());
                }
                break;
            case "phaseDelete":
                delete = true;
                break;
        }

        if (!delete) {
            gc.drawImage(getCurrentImage(), getX() - 22, getY() - 42);
        }
    }

    public void delete() {
        effects.remove(this);
    }

}
