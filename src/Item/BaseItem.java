package Item;

import entity.Monster;
import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static main.GamePanel.itemOnFloors;

public class BaseItem extends Item {

    public BaseItem(int slotNumber) {
        setDefaultValues(slotNumber);
    }

    public BaseItem(Monster monster, Player player) {
        setDefaultValues(monster, player);
    }

    // For add start item
    public void setDefaultValues(int slotNumber) {
        setItemClass(Potion.class);
        setSlot(slotNumber);
        setAdded(true);
        setPicked(true);
        setUsed(false);
        setPrepareDelete(0);
        setWink(false);
        setDropRange(1);
        setDeleteCounter(0);
        setItemImageURL("item/RedPotion.png");
        setItemImage(new Image(String.valueOf(ClassLoader.getSystemResource(getItemImageURL()))));
        setSpriteNum(1);
        setAmount(1);
        setSpriteCounter(0);
    }


    // For item drop from monster
    public void setDefaultValues(Monster monster, Player player) {

        setPlayer(player);
        setX(monster.getX());
        setY(monster.getY());
        setItemClass(Potion.class);
        setDropDirection(1);
        setSlot(-1);
        setAdded(false);
        setPicked(false);
        setUsed(false);
        setAmount(1);
        setDropRange(1);
        setPrepareDelete(0);
        setWink(false);
        setDeleteCounter(0);
        setItemImageURL("item/RedPotion.png");
        setItemImage(new Image(String.valueOf(ClassLoader.getSystemResource(getItemImageURL()))));
        setSpriteNum(1);
        setSpriteCounter(0);

    }

    public void updateAll(Player player){
        if(!itemOnFloors.isEmpty()){
            for(int i=0;i<itemOnFloors.size();i++){
                switch (String.valueOf(itemOnFloors.get(i).getClass())){
                    case "class Item.Potion" :
                        ((Potion) itemOnFloors.get(i)).update(player);
                        break;
                    case "class Item.BluePotion" :
                        ((BluePotion) itemOnFloors.get(i)).update(player);
                        break;
                    case "class Item.RedPotion" :
                        ((RedPotion) itemOnFloors.get(i)).update(player);
                        break;
                    case "class Item.CoffeePotion" :
                        ((CoffeePotion) itemOnFloors.get(i)).update(player);
                        break;
                    case "class Item.DragonBallBeans" :
                        ((DragonBallBeans)itemOnFloors.get(i)).update(player);

                        // Add more item here
                }
            }
        }
    }
    public void drawAll(GraphicsContext gc){
        if(!itemOnFloors.isEmpty()){
            for(int i=0;i<itemOnFloors.size();i++){
                switch (String.valueOf(itemOnFloors.get(i).getClass())){
                    case "class Item.Potion" :
                        ((Potion) itemOnFloors.get(i)).draw(gc);
                        break;
                    case "class Item.BluePotion" :
                        ((BluePotion) itemOnFloors.get(i)).draw(gc);
                        break;
                    case "class Item.RedPotion" :
                        ((RedPotion) itemOnFloors.get(i)).draw(gc);
                        break;
                    case "class Item.CoffeePotion" :
                        ((CoffeePotion) itemOnFloors.get(i)).draw(gc);
                        break;
                    case "class Item.DragonBallBeans" :
                        ((DragonBallBeans)itemOnFloors.get(i)).draw(gc);

                        // Add more item here
                }
            }
        }
    }


}
