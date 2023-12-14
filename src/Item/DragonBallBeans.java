package Item;

import entity.Monster;
import entity.Player;
import javafx.scene.image.Image;

public class DragonBallBeans extends RedPotion {

    public DragonBallBeans(int slotNumber) {
        super(slotNumber);
        setItemImage(new Image(String.valueOf(ClassLoader.getSystemResource("item/DragonBallBeans.png"))));
        setDropRange(1);

    }

    public DragonBallBeans(Monster monster, Player player) {
        super(monster, player);
        setItemImage(new Image(String.valueOf(ClassLoader.getSystemResource("item/DragonBallBeans.png"))));
        setItemClass(DragonBallBeans.class);
        setDropDirection(-1);
        setDropRange(2);
    }

    public void use(Player player) {
        if (player != null) {
            player.setHp(player.getMaxHP());
            deleteItem(player);
        }
    }

}
