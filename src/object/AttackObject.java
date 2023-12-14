package object;

import entity.Player;
import javafx.scene.image.Image;


public abstract class AttackObject {

    public int spriteCounter = 0;
    public int spriteNum = 1;
    private double x, y;
    private double sizeX, sizeY;
    private double speed;
    private double damage;
    private int range;
    private int baseRange;
    private Player player;
    private boolean visible;
    private boolean destroyed;
    private Image up1, up2, down1, down2, left1, left2, right1, right2;
    private String direction;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }


    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setBaseRange(int baseRange) {
        this.baseRange = baseRange;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }


    public void setSizeX(double size) {
        this.sizeX = size;
    }

    public double getSizeY() {
        return sizeY;
    }

    public void setSizeY(double sizeY) {
        this.sizeY = sizeY;
    }

    public Image getRight2() {
        return right2;
    }

    public void setRight2(Image right2) {
        this.right2 = right2;
    }

    public Image getRight1() {
        return right1;
    }

    public void setRight1(Image right1) {
        this.right1 = right1;
    }

    public Image getLeft2() {
        return left2;
    }

    public void setLeft2(Image left2) {
        this.left2 = left2;
    }

    public Image getLeft1() {
        return left1;
    }

    public void setLeft1(Image left1) {
        this.left1 = left1;
    }

    public Image getDown2() {
        return down2;
    }

    public void setDown2(Image down2) {
        this.down2 = down2;
    }

    public Image getDown1() {
        return down1;
    }

    public void setDown1(Image down1) {
        this.down1 = down1;
    }

    public Image getUp2() {
        return up2;
    }

    public void setUp2(Image up2) {
        this.up2 = up2;
    }

    public Image getUp1() {
        return up1;
    }

    public void setUp1(Image up1) {
        this.up1 = up1;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }


}
