package pr1;

import java.util.Random;

public class RandomQuantity extends Main {
    RandomQuantity(){}
    Random rd = new Random();

    int random(){
        double i = rd.nextInt(10);

        return ((int) i);
    }

}
