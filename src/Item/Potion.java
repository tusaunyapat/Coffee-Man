package Item;

import entity.Monster;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static java.lang.Math.pow;
import static main.GamePanel.itemOnFloors;

public class Potion extends BaseItem implements ItemFunctionable {

    public Potion(int slotNumber) {
        super(slotNumber);
        setItemImage(new Image(String.valueOf(ClassLoader.getSystemResource("item/PurplePotion.png"))));
        setDropRange(1);

    }

    public Potion(Monster monster, Player player) {
        super(monster, player);
        setItemImage(new Image(String.valueOf(ClassLoader.getSystemResource("item/PurplePotion.png"))));
        setDropRange(1);
    }

    @Override
    public void use(Player player) {
        if (player != null) {
            player.setExp(player.getExp() + 10);
            deleteItem(player);
        }
    }

    @Override
    public void update(Player player) {

        if (spriteNum == 1) {
            setX(getX() - 0.4 * getDropDirection() * getDropRange());
            setY(getY() - 0.6);
        } else if (spriteNum == 2) {
            setX(getX() - 0.2 * getDropDirection() * getDropRange());
            setY(getY() + 0.8);
        } else if (spriteNum == 3) {
            if (player != null) {
                if (pow(player.getX() - getX(), 2) <= 60 && pow(player.getY() + 15 - getY(), 2) <= 500) {
                    addItem(player);
                }
            }
        }

        spriteCounter++;
        if (spriteCounter == 10) {
            spriteNum = 2;
        } else if (spriteCounter == 20) {
            spriteNum = 3;    // not use value
        }

        if (getPrepareDelete() == 1) {
            setDeleteCounter(getDeleteCounter() + 1);
            if (getDeleteCounter() == 30) {
                setWink(true);
            }
            if (getDeleteCounter() == 60) {
                setWink(false);
                setDeleteCounter(0);
            }
        }
        autoDelete();

    }

    @Override
    public void draw(GraphicsContext gc) {
        if (!isPicked() && !isWink()) {
            gc.drawImage(getItemImage(), getX(), getY());
        }
    }

    @Override
    public void addItem(Player player) {

        for (int i = 0; i < player.getInventoryBar().getItems().size(); i++) {
            if (player.getInventoryBar().getItems().get(i).getClass() == getItemClass()) {
                if (!isAdded() && player.getInventoryBar().getItems().get(i).getAmount() < 9) {
                    player.getInventoryBar().getItems().get(i).setAmount(player.getInventoryBar().getItems().get(i).getAmount() + 1);
                }
                setSlot(i);
                setAdded(true);
                setPicked(true);
                return;
            }
        }

        if (!isAdded()) {
            if (player.getInventoryBar().getItems().size() < 9) {
                player.getInventoryBar().getItems().add(this);
                setSlot(player.getInventoryBar().getItems().size() - 1);
                setAdded(true);
                setPicked(true);
            }
        }
    }


    @Override
    public void deleteItem(Player player) {
        for (int i = 0; i < player.getInventoryBar().getItems().size(); i++) {
            if (player.getInventoryBar().getItems().get(i).getAmount() != 0) {
                if (player.getInventoryBar().getItems().get(i).getClass() == getItemClass()) {
                    player.getInventoryBar().getItems().get(i).setAmount(player.getInventoryBar().getItems().get(i).getAmount() - 1);
                    if (player.getInventoryBar().getItems().get(i).getAmount() == 0) {
                        player.getInventoryBar().getItems().remove(i);
                    }
                    return;
                }
            }
        }
    }

    @Override
    public void autoDelete() {

        if (spriteCounter == 1200) {
            setPrepareDelete(1);
        }
        if (spriteCounter > 1700) {
            itemOnFloors.remove(this);
        }
    }


}
