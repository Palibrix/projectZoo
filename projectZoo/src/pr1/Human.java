package pr1;

import java.util.*;

public class Human extends Main {
    String name;
    Date dateOfBirth;
    String cityOfBirth;
    String countryOfBirth;
    int age;
    static String[] humanNames = {"Alex", "John", "Theo", "Morty", "Rick", "Jesus", "Kurt", "Dave", "Ibrahim", "Freddy",
            "Maria", "Ann", "Rose", "Ellie", "Penny", "Sophie", "Jill", "Olivia", "Chloe", "Emily"};

    Date date = new Date();
    RandomQuantity random = new RandomQuantity();
    Human(){}
    Human(String name, int age){}

    //Список з усіма даними людини(ім'я, вік...);
    String [] humanProperties = {humanNames[random.rdHumanName()], String.valueOf(random.rdHumanAge())};

    //ХешМапа, де ключем є число(id),а параметром -список;
    HashMap <Integer, String[]> humans = new HashMap<>();

    protected void setHuman(){
        for(int i = 0;i<11;i++){
            int rdHumanName = random.rdHumanName();
            humans.put(i, humanProperties);
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





