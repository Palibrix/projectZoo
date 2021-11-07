package pr1;

import java.util.Random;

public class RandomQuantity extends Main {
    RandomQuantity() {
    }
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

    int rdHumanName() {
        double i = rd.nextInt(20);
        return ((int) i);
    }

    int rdHumanAge() {
        int a = rd.nextInt(50);
        return ((int) a);
    }

//    String rdPassport() {
//        for (int j = 0; j < 9; j++) {
//            int i = rd.nextInt(9);
//            String.valueOf(i);
//            Human.passport = Human.passport + i;
//        }
//        Human.passport = Human.passport +" ";
//        return Human.passport;
//    }
}
