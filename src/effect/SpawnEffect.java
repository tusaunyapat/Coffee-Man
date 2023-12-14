package effect;

import entity.Monster;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

import static main.GamePanel.effects;

public class SpawnEffect extends BaseEffect implements EffectFunctionable {


    public Player player;
    public Monster monster;

    int count = 0;

    public SpawnEffect(Player player) {

        super(player);
        setEffectClass(SpawnEffect.class);
        setX(getX() - 15);
        // for spawn player

    }

    public SpawnEffect(Monster monster) {

        super(monster);
        setEffectClass(SpawnEffect.class);
        // for spawn player

    }

    public SpawnEffect(Player player, Monster monster) {

        super(monster, player);
        setEffectClass(SpawnEffect.class);
        // for spawn player or monster but have more effects to another
    }

    public void loadPicture() {

        setEffect1(new Image(String.valueOf(ClassLoader.getSystemResource("effect/spawn_1.png"))));
        setEffect2(new Image(String.valueOf(ClassLoader.getSystemResource("effect/spawn_2.png"))));


    }

    public void update() {
        // update

        spriteCounter++;
        if (spriteCounter > 10) {
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

        if (count < 1) {
            setPhase("phaseA");
            setY(getY() - 2);
        } else if (count < 3) {
            setPhase("phaseDelete");
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
                    //System.out.println(spriteNum);

                }
                if (spriteNum == 2) {
                    setCurrentImage(getEffect2());
                    //System.out.println(spriteNum);

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
