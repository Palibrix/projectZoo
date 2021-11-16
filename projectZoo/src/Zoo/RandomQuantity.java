package Zoo;

import java.util.Random;

public class RandomQuantity{
    Random rd = new Random();

    int random() {
        double i = rd.nextInt(10);
        return ((int) i);
    }

    int rdName() {
        double i = rd.nextInt(5);
        return ((int) i);
    }

    int rdLocation() {
        double i = rd.nextInt(6);
        return ((int) i);
    }

    int rdVisitorAge(){
        int min = 18;
        int max = 50;
        double i = rd.nextInt(max-min)+min;
        return ((int) i);
    }
}
