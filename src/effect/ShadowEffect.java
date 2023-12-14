package effect;

import entity.Monster;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

import static main.GamePanel.effects;

public class ShadowEffect extends BaseEffect implements EffectFunctionable {

    public ShadowEffect(Player player) {
        super(player);
        setEffectClass(ShadowEffect.class);

    }

    public ShadowEffect(Monster monster) {
        super(monster);
        setEffectClass(ShadowEffect.class);

    }

    public void loadPicture() {

        setEffect1(new Image(String.valueOf(ClassLoader.getSystemResource("effect/shadow_1_1.png"))));
        setEffect2(new Image(String.valueOf(ClassLoader.getSystemResource("effect/shadow_1_2.png"))));
        setEffect3(new Image(String.valueOf(ClassLoader.getSystemResource("effect/shadow_2_1.png"))));
        setEffect4(new Image(String.valueOf(ClassLoader.getSystemResource("effect/shadow_2_2.png"))));

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

        if (Objects.equals(getOwner(), "player")) {
            if (Objects.equals(player.getDirection(), "down") || Objects.equals(player.getDirection(), "up")) {
                setPhase("phaseA");
            } else {
                setPhase("phaseB");
            }
        } else if (Objects.equals(getOwner(), "monster")) {
            if (Objects.equals(monster.getDirection(), "down") || Objects.equals(monster.getDirection(), "up")) {
                setPhase("phaseA");
            } else {
                setPhase("phaseB");
            }
        }

        if (Objects.equals(getOwner(), "player")) {
            setX(player.getX() - 17);
            setY(player.getY() - 22);
        } else if (Objects.equals(getOwner(), "monster")) {
            setX(monster.getX() - 17);
            setY(monster.getY() - 22);
        }

        if (Objects.equals(getPhase(), "phaseDelete")) {
            delete();
        }

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
            case "phaseB":
                if (spriteNum == 1) {
                    setCurrentImage(getEffect3());
                } else if (spriteNum == 2) {
                    setCurrentImage(getEffect4());
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
