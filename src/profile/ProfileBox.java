package profile;

import entity.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

import static scenes.SelectedScene.selectedCharacter;

public class ProfileBox {

    private Player player;

    private Image profileImage;
    private Image profileBoxImage;

    private int spriteCounter;
    private int spriteNum;
    private String profileImageURL;
    private String profileBoxURL;

    public ProfileBox() {
        setDefaultValues();
    }

    public void setDefaultValues() {

        setProfileImageURL("player/ProfileImage_1_1.png");
        if (Objects.equals(selectedCharacter, "1")) {
            setProfileBoxURL("player/ProfileBox_1.png");
        } else if (Objects.equals(selectedCharacter, "2")) {
            setProfileBoxURL("player/ProfileBox_2.png");
        }

        setProfileImage(new Image(String.valueOf(ClassLoader.getSystemResource(getProfileImageURL()))));
        setProfileBoxImage(new Image(String.valueOf(ClassLoader.getSystemResource(getProfileBoxURL()))));
        setPlayer(player);

    }


    public void draw(GraphicsContext gc) {
        gc.drawImage(getProfileBoxImage(), 0, 0);
        gc.drawImage(getProfileImage(), 0, 0);
    }

    public void update(Player player) {

        setPlayer(player);
        player.setCanWalkLeft(!(player.getY() < 118) || (player.getX() != 300
                                                        && player.getX() != 299
                                                        && player.getX() != 298
                                                        && player.getX() != 297
                                                        && player.getX() != 296));
        player.setCanWalkUp(!(player.getX() <= 300) || (player.getY() != 117
                                                        && player.getY() != 116
                                                        && player.getY() != 115
                                                        && player.getY() != 114
                                                        && player.getY() != 113));

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public String getProfileImageURL() {
        return profileImageURL;
    }

    public void setProfileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
    }

    public Image getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Image profileImage) {
        this.profileImage = profileImage;
    }

    public Image getProfileBoxImage() {
        return profileBoxImage;
    }

    public void setProfileBoxImage(Image profileBoxImage) {
        this.profileBoxImage = profileBoxImage;
    }

    public String getProfileBoxURL() {
        return profileBoxURL;
    }

    public void setProfileBoxURL(String profileBoxURL) {
        this.profileBoxURL = profileBoxURL;
    }
}
