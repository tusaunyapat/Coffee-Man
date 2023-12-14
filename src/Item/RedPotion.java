package Item;

import entity.Monster;
import entity.Player;
import javafx.scene.image.Image;

public class RedPotion extends Potion {

    public RedPotion(int slotNumber) {
        super(slotNumber);
        setItemImage(new Image(String.valueOf(ClassLoader.getSystemResource("item/RedPotion.png"))));
        setItemClass(RedPotion.class);
        setDropDirection(-1);
        setDropRange(2);

    }

    public RedPotion(Monster monster, Player player) {
        super(monster, player);
        setItemImage(new Image(String.valueOf(ClassLoader.getSystemResource("item/RedPotion.png"))));
        setItemClass(RedPotion.class);
        setDropDirection(-1);
        setDropRange(2);
    }

    @Override
    public void use(Player player) {
        if (player != null) {
            player.setHp(player.getHp() + 600);
            deleteItem(player);
        }
    }

}
