package pr1;

import java.util.Random;

public class RandomQuantity extends Main {
    RandomQuantity(){}
    Random rd = new Random();

    int random(){
        double i = rd.nextInt(10);
        return ((int) i);
    }
    int rdName(){
        double i = rd.nextInt(5);
        return ((int) i);
    }
    int rdLocation(){
        double i = rd.nextInt(6);
        return ((int) i);
    }
    int rdAnimalAction(){
        double i = rd.nextInt(4);
        return ((int) i);
    }
    int rdAnimalName(){
        double i = rd.nextInt(5);
        return ((int) i);
    }
    int rdAnimalAge(){
        double i = rd.nextInt(30);
        return ((int) i);
    }
}
