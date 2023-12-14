package font;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Number {

    public Image number0 = new Image(String.valueOf(ClassLoader.getSystemResource("number/0.png")));
    public Image number1 = new Image(String.valueOf(ClassLoader.getSystemResource("number/1.png")));
    public Image number2 = new Image(String.valueOf(ClassLoader.getSystemResource("number/2.png")));
    public Image number3 = new Image(String.valueOf(ClassLoader.getSystemResource("number/3.png")));
    public Image number4 = new Image(String.valueOf(ClassLoader.getSystemResource("number/4.png")));
    public Image number5 = new Image(String.valueOf(ClassLoader.getSystemResource("number/5.png")));
    public Image number6 = new Image(String.valueOf(ClassLoader.getSystemResource("number/6.png")));
    public Image number7 = new Image(String.valueOf(ClassLoader.getSystemResource("number/7.png")));
    public Image number8 = new Image(String.valueOf(ClassLoader.getSystemResource("number/8.png")));
    public Image number9 = new Image(String.valueOf(ClassLoader.getSystemResource("number/9.png")));

    public ArrayList<Image> numbers;


    public Number() {

        numbers = new ArrayList<Image>();

        numbers.add(number0);
        numbers.add(number1);
        numbers.add(number2);
        numbers.add(number3);
        numbers.add(number4);
        numbers.add(number5);
        numbers.add(number6);
        numbers.add(number7);
        numbers.add(number8);
        numbers.add(number9);

    }

    public Image getNumberImage(int number) {
        if (number > 9) {
            number = 9;
        }
        return numbers.get(number);
    }


}
