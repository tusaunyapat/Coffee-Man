package Item;

import entity.Player;
import javafx.scene.image.Image;

public abstract class Item {

    public int spriteCounter;
    public int spriteNum;
    private Player player;
    private Image itemImage;
    private String itemImageURL;
    private double x;
    private double y;
    private int slot;
    private int amount;
    private boolean isAdded;
    private boolean isUsed;
    private boolean isPicked;
    private int deleteCounter;
    private boolean isWink;

    private int prepareDelete;

    private Object itemClass;

    private int dropDirection;
    private int dropRange;


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

    public Image getItemImage() {
        return itemImage;
    }

    public void setItemImage(Image itemImage) {
        this.itemImage = itemImage;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public boolean isPicked() {
        return isPicked;
    }

    public void setPicked(boolean picked) {
        isPicked = picked;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

    public String getItemImageURL() {
        return itemImageURL;
    }

    public void setItemImageURL(String itemImageURL) {
        this.itemImageURL = itemImageURL;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getPrepareDelete() {
        return prepareDelete;
    }

    public void setPrepareDelete(int prepareDelete) {
        this.prepareDelete = prepareDelete;
    }

    public int getDeleteCounter() {
        return deleteCounter;
    }

    public void setDeleteCounter(int deleteCounter) {
        this.deleteCounter = deleteCounter;
    }

    public boolean isWink() {
        return isWink;
    }

    public void setWink(boolean wink) {
        isWink = wink;
    }

    public Object getItemClass() {
        return itemClass;
    }

    public void setItemClass(Object itemClass) {
        this.itemClass = itemClass;
    }

    public int getDropDirection() {
        return dropDirection;
    }

    public void setDropDirection(int dropDirection) {
        this.dropDirection = dropDirection;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDropRange() {
        return dropRange;
    }

    public void setDropRange(int dropRange) {
        this.dropRange = dropRange;
    }
}
