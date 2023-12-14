package entity;

import Item.DragonBallBeans;
import effect.ShadowEffect;
import effect.DiedEffect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

import static java.lang.Math.pow;
import static main.GamePanel.*;

public class Boss extends Monster {

    private boolean isAngry;

    public Boss() {
        super();
    }

    public Boss(Player player) {
        super(player);
        setEntityClass(Boss.class);
    }

    public void setDefaultValues(Player player) {

        setPlayer(player);

        setXY(Math.floor(Math.random() * (800)), Math.floor(Math.random() * (600)));

        setSpeed(0.4);
        setMaxHP(350 + player.getLevel() * 40);
        setHp(getMaxHP());
        setDamage(2 + player.getLevel() * 0.2);
        setDirection("down");
        setAngry(false);
        loadpic();
        setShadowEffect(new ShadowEffect(this));
        effects.add(getShadowEffect());

    }

    public void loadpic() {
        setUp1(new Image(String.valueOf(ClassLoader.getSystemResource("monster/boss_up_1.png"))));
        setUp2(new Image(String.valueOf(ClassLoader.getSystemResource("monster/boss_up_2.png"))));
        setUp3(new Image(String.valueOf(ClassLoader.getSystemResource("monster/boss_up_3.png"))));
        setDown1(new Image(String.valueOf(ClassLoader.getSystemResource("monster/boss_down_1.png"))));
        setDown2(new Image(String.valueOf(ClassLoader.getSystemResource("monster/boss_down_2.png"))));
        setDown3(new Image(String.valueOf(ClassLoader.getSystemResource("monster/boss_down_3.png"))));
        setLeft1(new Image(String.valueOf(ClassLoader.getSystemResource("monster/boss_left_1.png"))));
        setLeft2(new Image(String.valueOf(ClassLoader.getSystemResource("monster/boss_left_2.png"))));
        setLeft3(new Image(String.valueOf(ClassLoader.getSystemResource("monster/boss_left_3.png"))));
        setRight1(new Image(String.valueOf(ClassLoader.getSystemResource("monster/boss_right_1.png"))));
        setRight2(new Image(String.valueOf(ClassLoader.getSystemResource("monster/boss_right_2.png"))));
        setRight3(new Image(String.valueOf(ClassLoader.getSystemResource("monster/boss_right_3.png"))));

        setHPB(new Image(String.valueOf(ClassLoader.getSystemResource("player/hpdemored.png"))));

    }

    public void update(Player player) {
        // update

        setPlayer(player);

        if (getHp() <= 0) {

            delete();
            player.setExp(player.getExp() + 30);

        }

        boolean canWalk = true;

        if (pow((player.getX() - getX()), 2) + pow(player.getY() - getY(), 2) < 4000) {
            player.setHp(player.getHp() - getDamage());
            canWalk = false;
        }

        if (pow((player.getX() - getX()), 2) + pow(player.getY() - getY(), 2) < 70000) {
            setAngry(true);
            if (player.getWaitForStart() < 10) {
                if (canWalk) {
                    walk();
                    getAttacked();
                } else {
                    getCloseAttacked();
                }
            }
        } else {
            setAngry(false);
        }
        if (!isAngry()) {
            spriteNum = 1;
        }


        if (isAngry) {
            spriteCounter++;
            if (spriteCounter > 20) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                    //System.out.println(spriteNum);
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                    //System.out.println(spriteNum);
                } else if (spriteNum == 3) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }


        //System.out.println(getHP());

    }

    public void walk(){
        if (player.getY() < getY()) {
            setY(getY() - getSpeed());
            setDirection("up");
        }
        if (player.getX() < getX()) {
            setX(getX() - getSpeed());
            setDirection("left");
        }
        if (player.getY() > getY()) {
            setY(getY() + getSpeed());
            setDirection("down");
        }
        if (player.getX() > getX()) {
            setX(getX() + getSpeed());
            setDirection("right");
        }
    }

    public void getAttacked(){
        if (Objects.equals(player.getDirection(), "right")) {
            if (getX() >= player.getAttackObj().getX() && getX() <= player.getAttackObj().getX() + player.getAttackObj().getRange() && getY() >= player.getAttackObj().getY() && getY() <= player.getAttackObj().getY() + player.getAttackObj().getSizeY() / 2 && player.getAttackObj().isVisible()) {
                setHp(getHp() - player.getAttackObj().getDamage());
            }
        } else if (Objects.equals(player.getDirection(), "left")) {
            if (getX() <= player.getAttackObj().getX() && getX() >= player.getAttackObj().getX() - player.getAttackObj().getRange() && getY() >= player.getAttackObj().getY() && getY() <= player.getAttackObj().getY() + player.getAttackObj().getSizeY() / 2 && player.getAttackObj().isVisible()) {
                setHp(getHp() - player.getAttackObj().getDamage());
            }
        } else if (Objects.equals(player.getDirection(), "down")) {
            if (getX() <= player.getX() + 10 && getX() >= player.getX() - 10 && getY() >= player.getY() && getY() <= player.getY() + player.getAttackObj().getRange() && player.getAttackObj().isVisible()) {
                setHp(getHp() - player.getAttackObj().getDamage());
            }
        } else if (Objects.equals(player.getDirection(), "up")) {
            if (getX() <= player.getX() + 20 && getX() >= player.getX() - 20 && getY() <= player.getY() && getY() >= player.getY() - player.getAttackObj().getRange() && player.getAttackObj().isVisible()) {
                setHp(getHp() - player.getAttackObj().getDamage());
            }
        }
    }

    public void getCloseAttacked(){
        if (getX() < player.getX()) {
            if (player.getAttackObj().isVisible() && Objects.equals(player.getDirection(), "left")) {
                setHp(getHp() - player.getAttackObj().getDamage());
            }
        }
        if (getX() > player.getX()) {
            if (player.getAttackObj().isVisible() && Objects.equals(player.getDirection(), "right")) {
                setHp(getHp() - player.getAttackObj().getDamage());
            }
        }
        if (getY() < player.getY()) {
            if (player.getAttackObj().isVisible() && Objects.equals(player.getDirection(), "up")) {
                setHp(getHp() - player.getAttackObj().getDamage());
            }
        }
        if (getY() > player.getY()) {
            if (player.getAttackObj().isVisible() && Objects.equals(player.getDirection(), "down")) {
                setHp(getHp() - player.getAttackObj().getDamage());
            }
        }
    }

    @Override
    public void draw(GraphicsContext gc) {

        switch (getDirection()) {
            case "up":
                if (spriteNum == 1) {
                    setCurrentImage(getUp1());
                    //System.out.println(spriteNum);
                }
                if (spriteNum == 2) {
                    setCurrentImage(getUp2());
                    //System.out.println(spriteNum);
                }
                if (spriteNum == 3) {
                    setCurrentImage(getUp3());
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    setCurrentImage(getDown1());
                }
                if (spriteNum == 2) {
                    setCurrentImage(getDown2());
                }
                if (spriteNum == 3) {
                    setCurrentImage(getDown3());
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    setCurrentImage(getRight1());
                }
                if (spriteNum == 2) {
                    setCurrentImage(getRight2());
                }
                if (spriteNum == 3) {
                    setCurrentImage(getRight3());
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    setCurrentImage(getLeft1()
                    );
                }
                if (spriteNum == 2) {
                    setCurrentImage(getLeft2());
                }
                if (spriteNum == 3) {
                    setCurrentImage(getLeft3());
                }
                break;
        }

        gc.drawImage(getCurrentImage(), getX() - 50, getY() - 50);
        drawHp(gc);

    }

    public void delete() {
        effects.add(new DiedEffect(this, player));
        itemOnFloors.add(new DragonBallBeans(this, player));
        if (player.getMonsterDied() == 5) {
            player.setMonsterDied(0);
            monsters.add(new Boss(player));
        }
        effects.remove(getShadowEffect());
        monsters.remove(this);
        player.setPoint(player.getPoint() + 40);
        player.setMonsterDied(player.getMonsterDied() + 1);
    }

    public void setXY(double x, double y) {
        while (x < 330 && y < 130) {
            x = Math.floor(Math.random() * (800));
            y = Math.floor(Math.random() * (600));
        }
        if (x > 670) {
            x = 670;
        }
        if (x < 130) {
            x = 130;
        }
        if (y < 130) {
            y = 130;
        }
        if (y > 480) {
            y = 480;
        }
        setX(x);
        setY(y);
    }

    @Override
    public boolean isAngry() {
        return isAngry;
    }

    @Override
    public void setAngry(boolean angry) {
        isAngry = angry;
    }
}
