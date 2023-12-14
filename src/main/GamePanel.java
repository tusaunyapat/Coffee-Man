package main;

import background.Background;
import Item.BaseItem;
import effect.BaseEffect;
import entity.*;
import font.Number;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class GamePanel extends Canvas {

    public static Number number = new Number();
    public static ArrayList<Monster> monsters = new ArrayList<>();
    public static ArrayList<BaseEffect> effects = new ArrayList<>();
    public static ArrayList<BaseItem> itemOnFloors = new ArrayList<>();
    public static ArrayList<BaseProp> props = new ArrayList<>();
    public static boolean isGameOver = false;
    public Player player = new Player();
    public Monster monster = new Monster(player);
    public BaseEffect effect = new BaseEffect(monster, player);
    public BaseItem baseItemOnFloor = new BaseItem(monster, player);
    public BaseProp baseProp = new BaseProp(0, 0);
    public Background background = new Background();

    public GraphicsContext gc = this.getGraphicsContext2D();

    public GamePanel(double width, double height) {
        super(width, height);
        this.setVisible(true);
        addKeyListener();


        gc.setFill(Color.BLACK);

        //fix shadow
        effects.remove(monster.getShadowEffect());
        setAllProp();

    }


    public void addKeyListener() {
        this.setOnKeyPressed((KeyEvent event) -> KeyHandler.setKeyPressed(event.getCode(), true));

        this.setOnKeyReleased((KeyEvent event) -> KeyHandler.setKeyPressed(event.getCode(), false));

    }

    public void update() throws InterruptedException {
        // update

        if (player != null) {
            player.update();
            monster.updateAll(monsters);
            effect.updateAll(player);
            baseItemOnFloor.updateAll(player);
            baseProp.updateAll();
        }

    }

    public void paintComponent() {

        if (player != null) {
            background.draw(gc);
            baseItemOnFloor.drawAll(gc);
            effect.drawAll(gc);
            monster.drawAll(monsters, gc);
            player.draw(gc);
            player.getInventoryBar().draw(gc);
            baseProp.drawAll(gc);
        }

    }

    public void setAllProp() {
        props.add(new ChristmasTree(-55, 450));
        props.add(new ChristmasTree(-70, 300));
        props.add(new ChristmasTree(-80, 120));
        props.add(new Gift(25, 575));
        props.add(new Gift2(5, 570));
        props.add(new ChristmasTree(700, 450));
        props.add(new Gift(780, 574));
        props.add(new Gift2(765, 570));
        props.add(new Snowman(670, 502));

    }

    public void setAllDefaultValues() {
        player = null;
        monsters.clear();
        effects.clear();
        itemOnFloors.clear();
        props.clear();
    }


}
