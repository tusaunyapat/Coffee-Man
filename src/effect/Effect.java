package effect;

import entity.Monster;
import entity.Player;
import javafx.scene.image.Image;

public abstract class Effect {

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Monster monster;
    public Player player;
    private double x, y;
    private String owner;
    private Image up1, up2;
    private Image effect1, effect2, effect3, effect4;
    private Image currentImage;
    private String phase;
    private Object effectClass;


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

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public Image getUp1() {
        return up1;
    }

    public void setUp1(Image up1) {
        this.up1 = up1;
    }

    public Image getUp2() {
        return up2;
    }

    public void setUp2(Image up2) {
        this.up2 = up2;
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public void setEffectClass(Object effectClass) {
        this.effectClass = effectClass;
    }

    public Image getEffect1() {
        return effect1;
    }

    public void setEffect1(Image effect1) {
        this.effect1 = effect1;
    }

    public Image getEffect2() {
        return effect2;
    }

    public void setEffect2(Image effect2) {
        this.effect2 = effect2;
    }

    public Image getEffect3() {
        return effect3;
    }

    public void setEffect3(Image effect3) {
        this.effect3 = effect3;
    }

    public Image getEffect4() {
        return effect4;
    }

    public void setEffect4(Image effect4) {
        this.effect4 = effect4;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
