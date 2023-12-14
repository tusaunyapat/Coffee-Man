package effect;

import entity.Monster;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

import static main.GamePanel.effects;

public class DiedEffect extends BaseEffect implements EffectFunctionable {


    public Monster monster;

    int count = 0;


    public DiedEffect(Monster monster, Player player) {
        super(monster, player);
        setEffectClass(DiedEffect.class);

    }

    public void loadPicture() {

        setUp1(new Image(String.valueOf(ClassLoader.getSystemResource("monster/monster_up_1.png"))));
        setUp2(new Image(String.valueOf(ClassLoader.getSystemResource("monster/monster_up_2.png"))));
        setEffect1(new Image(String.valueOf(ClassLoader.getSystemResource("effect/spawn_1.png"))));
        setEffect2(new Image(String.valueOf(ClassLoader.getSystemResource("effect/spawn_2.png"))));

    }

    public void update() {
        // update

        spriteCounter++;
        if (spriteCounter > 5) {
            if (spriteNum == 1) {
                spriteNum = 2;
                //System.out.println(spriteNum);
            } else if (spriteNum == 2) {
                spriteNum = 1;
                //System.out.println(spriteNum);
            }
            spriteCounter = 0;
            count++;
        }


        if (count < 3) {
            setPhase("phaseA");
        } else if (count < 5) {
            setPhase("phaseB");
        } else {
            setPhase("phaseDelete");
        }

        if (Objects.equals(getPhase(), "phaseB")) {
            setY(getY() - 5);
        }

        if (Objects.equals(getPhase(), "phaseDelete")) {
            delete();
        }

    }


    @Override
    public void draw(GraphicsContext gc) {

        boolean delete = false;

        switch (getPhase()) {
            case "phaseA":
                if (spriteNum == 1) {
                    setCurrentImage(getEffect1());
                }
                if (spriteNum == 2) {
                    setCurrentImage(getEffect2());
                }
                break;
            case "phaseB":
                if (spriteNum == 1) {
                    setCurrentImage(getUp1());
                }
                if (spriteNum == 2) {
                    setCurrentImage(getUp2());
                }
                break;
            case "phaseDelete":
                delete = true;
                break;

        }

        if (!delete) {
            gc.drawImage(getCurrentImage(), getX(), getY());
        }

    }

    public void delete() {
        effects.remove(this);
    }


}
