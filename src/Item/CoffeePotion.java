package Item;

import entity.Monster;
import entity.Player;
import javafx.scene.image.Image;

public class CoffeePotion extends Potion {
    public CoffeePotion(int slotNumber) {
        super(slotNumber);
        setItemImage(new Image(String.valueOf(ClassLoader.getSystemResource("item/CoffeePotion.png"))));
        setItemClass(CoffeePotion.class);
        //fix
        setDropDirection(1);
        setDropRange(6);
    }

    public CoffeePotion(Monster monster, Player player) {
        super(monster, player);
        setItemImage(new Image(String.valueOf(ClassLoader.getSystemResource("item/CoffeePotion.png"))));
        setItemClass(CoffeePotion.class);
        // have to fix
        setDropDirection(1);
        setDropRange(6);
    }

    @Override
    public void use(Player player) {
        if (player != null) {
            player.setSleepiness(player.getSleepiness() - 800);
            deleteItem(player);
        }
    }
}
