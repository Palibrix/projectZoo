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
    String [] humanProperties = {humanNames[random.rdHumanName()],String.valueOf(random.rdHumanAge())};

    //ХешМапа, де ключем є число(id),а параметром -список;
    HashMap <Integer, String[]> humans = new HashMap<>();

    void debuggingUsersCheck(){
        System.out.println("ALL"+humanProperties);
        System.out.println("NAME "+humanNames[random.rdName()]);
        System.out.println("AGE "+random.rdHumanAge());
    }

    void setHumans(){
        for(int i = 0;i<11;i++){
            debuggingUsersCheck();
            humanProperties[0] = humanNames[random.rdHumanName()];
            humanProperties[1] = String.valueOf(random.rdHumanAge());
            humans.put(i, humanProperties);
            System.out.println("Now we have 10 visitors: ");
            System.out.println(humans);
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





