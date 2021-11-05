package pr1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Human extends Main {
    Date date = new Date();
    RandomQuantity random = new RandomQuantity();
    Human(){}
    Human(String name, int age){}

    String name;
    Date dateOfBirth;
    String cityOfBirth;
    String countryOfBirth;
    static int age = 10;
    HashMap<Integer, String> humans = new HashMap<>();
    static String[] humanNames = {"Alex", "John", "Theo", "Morty", "Rick", "Jesus", "Kurt", "Dave", "Ibrahim", "Freddy",
            "Maria", "Ann", "Rose", "Ellie", "Penny", "Sophie", "Jill", "Olivia", "Chloe", "Emily"};

    protected void setHumanNames() {
        for(int i = 0;i<11;i++){
            int rdHumanName = random.rdHumanName();
            humans.put(i, Human.humanNames[rdHumanName]);
        }
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





