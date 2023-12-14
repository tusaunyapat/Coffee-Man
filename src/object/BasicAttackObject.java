package object;


import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

import static scenes.SelectedScene.selectedCharacter;


public class BasicAttackObject extends AttackObject implements AttackObjectFunctionable {


    public BasicAttackObject(Player player) {

        setDefaultValues(player);

    }

    public void setDefaultValues(Player player) {

        setBaseRange(15);
        setX(player.getX());
        setY(player.getY());
        setVisible(false);
        setPlayer(player);
        setSpeed(1);
        setDamage(1);
        setRange(60);
        setDirection(player.getDirection());
        loadpic();
        setSizeX(32);
        setSizeY(32);

    }

    public void loadpic() {

        if (Objects.equals(selectedCharacter, "1")) {
            setUp1(new Image(String.valueOf(ClassLoader.getSystemResource("object/SwordAttack_up_1.png"))));
            setUp2(new Image(String.valueOf(ClassLoader.getSystemResource("object/SwordAttack_up_2.png"))));
            setDown1(new Image(String.valueOf(ClassLoader.getSystemResource("object/SwordAttack_down_1.png"))));
            setDown2(new Image(String.valueOf(ClassLoader.getSystemResource("object/SwordAttack_down_2.png"))));
            setLeft1(new Image(String.valueOf(ClassLoader.getSystemResource("object/SwordAttack_left_1.png"))));
            setLeft2(new Image(String.valueOf(ClassLoader.getSystemResource("object/SwordAttack_left_2.png"))));
            setRight1(new Image(String.valueOf(ClassLoader.getSystemResource("object/SwordAttack_right_1.png"))));
            setRight2(new Image(String.valueOf(ClassLoader.getSystemResource("object/SwordAttack_right_2.png"))));
        } else if (Objects.equals(selectedCharacter, "2")) {
            setUp1(new Image(String.valueOf(ClassLoader.getSystemResource("object/MagicAttack_up_1.png"))));
            setUp2(new Image(String.valueOf(ClassLoader.getSystemResource("object/MagicAttack_up_2.png"))));
            setDown1(new Image(String.valueOf(ClassLoader.getSystemResource("object/MagicAttack_down_1.png"))));
            setDown2(new Image(String.valueOf(ClassLoader.getSystemResource("object/MagicAttack_down_2.png"))));
            setLeft1(new Image(String.valueOf(ClassLoader.getSystemResource("object/MagicAttack_left_1.png"))));
            setLeft2(new Image(String.valueOf(ClassLoader.getSystemResource("object/MagicAttack_left_2.png"))));
            setRight1(new Image(String.valueOf(ClassLoader.getSystemResource("object/MagicAttack_right_1.png"))));
            setRight2(new Image(String.valueOf(ClassLoader.getSystemResource("object/MagicAttack_right_2.png"))));
        }

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

        setX(getPlayer().getX());
        setY(getPlayer().getY());
        setDirection(getPlayer().getDirection());
        if (getPlayer().isSuperSaiyan()) {
            setDamage(10);
        } else {
            setDamage(1);
        }

    }


    @Override
    public void draw(GraphicsContext gc) {
        Image playerimage = null;

        if (!isVisible()) {
            return;
        }

        if (Objects.equals(selectedCharacter, "1")) {
            switch (getDirection()) {
                case "up":
                    if (spriteNum == 1) {
                        playerimage = getUp1();
                        setY(getY() - (double) getRange() / 2 - 7);
                        //for mage now
                        //System.out.println(spriteNum);
                        //fix
                        setX(getX());
                    }
                    if (spriteNum == 2) {
                        setY(getY() - getRange() - 7);
                        playerimage = getUp2();
                        //for mage now
                        //System.out.println(spriteNum);
                        //fix
                        setX(getX());
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        playerimage = getDown1();
                        setY(getY() + (double) getRange() / 2 - 8);
                        //fix
                        setX(getX());
                    }
                    if (spriteNum == 2) {
                        setY(getY() + getRange() - 8);
                        playerimage = getDown2();
                        //fix
                        setX(getX());
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        playerimage = getRight1();
                        setX(getX() + (double) getRange() / 2);
                        //fix
                        setY(getY());
                    }
                    if (spriteNum == 2) {
                        setX(getX() + getRange());
                        playerimage = getRight2();
                        //fix
                        setY(getY());
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        playerimage = getLeft1();
                        setX(getX() - (double) getRange() / 2 - 10);
                        //fix
                        setY(getY());
                    }
                    if (spriteNum == 2) {
                        setX(getX() - getRange() - 10);
                        playerimage = getLeft2();
                        //fix
                        setY(getY());
                    }
                    break;
            }
        } else if (Objects.equals(selectedCharacter, "2")) {
            switch (getDirection()) {
                case "up":
                    if (spriteNum == 1) {
                        playerimage = getUp1();
                        setY(getY() - (double) getRange() / 2 - 15);
                        //fix
                        setX(getX() - 15);
                    }
                    if (spriteNum == 2) {
                        setY(getY() - getRange() - 15);
                        playerimage = getUp2();
                        //fix
                        setX(getX() - 15);
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        playerimage = getDown1();
                        setY(getY() + (double) getRange() / 2 - 8);
                        //fix
                        setX(getX() - 7);
                    }
                    if (spriteNum == 2) {
                        setY(getY() + getRange() - 8);
                        playerimage = getDown2();
                        //fix
                        setX(getX() - 7);
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        playerimage = getRight1();
                        setX(getX() + (double) getRange() / 2);
                        //fix
                        setY(getY() - 20);
                    }
                    if (spriteNum == 2) {
                        setX(getX() + getRange());
                        playerimage = getRight2();
                        //fix
                        setY(getY() - 20);
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        playerimage = getLeft1();
                        setX(getX() - (double) getRange() / 2 - 27);
                        //fix
                        setY(getY() - 20);
                    }
                    if (spriteNum == 2) {
                        setX(getX() - getRange() - 27);
                        playerimage = getLeft2();
                        //fix
                        setY(getY() - 20);
                    }
                    break;
            }
        }

        gc.drawImage(playerimage, getX(), getY());
        setDefaultValues(getPlayer());
    }


}