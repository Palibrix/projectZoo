package pr1;

import java.util.ArrayList;
import java.util.Date;

public class Human extends Main {
    String name;
    Date dateOfBirth;
    String cityOfBirth;
    String countryOfBirth;
    static int age = 10;
    Date date = new Date();
    ArrayList<Object> humansList = new ArrayList<>();

    static int getAge() {
        return age;
    }
}

//    void createHumans() {                      //створює десять об'єктів людей
//        Integer indexOfHuman = 1;
//        for (int i = 0; i < 10; i++) {
//            indexOfHuman.toString();
//
//            humansList.add(new Human("Human"+indexOfHuman,date,"Ivano-Frankivsk", "Ukraine",10));
//            indexOfHuman++;
//
//        }
//    }
