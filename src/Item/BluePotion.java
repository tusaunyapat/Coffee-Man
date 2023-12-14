package Item;

import entity.Monster;
import entity.Player;
import javafx.scene.image.Image;

public class BluePotion extends Potion {

    public BluePotion(int slotNumber) {
        super(slotNumber);
        setItemImage(new Image(String.valueOf(ClassLoader.getSystemResource("item/BluePotion.png"))));
        setItemClass(BluePotion.class);
        setDropDirection(1);
        setDropRange(3);
    }

    public BluePotion(Monster monster, Player player) {
        super(monster, player);
        setItemImage(new Image(String.valueOf(ClassLoader.getSystemResource("item/BluePotion.png"))));
        setItemClass(BluePotion.class);
        setDropDirection(1);
        setDropRange(3);
    }

    @Override
    public void use(Player player) {
        if (player != null) {
            player.setMana(player.getMana() + 600);
            deleteItem(player);
        }
    }

}
