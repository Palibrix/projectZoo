package pr1;

import java.util.Date;

public class Human {
    String name;
    Date dateOfBirth;
    String cityOfBirth;
    String coutryOfBirth;
    int age;

    String [] humanNames = {"Emily","Vasya","Penny","Benny","Paolo","Andriy","Alex"};
    String [] humanCitiesOfBirth = {"Kyjiv","Moscow","Bangladesh","Warsaw","Washington","Ankara","London"};
    String [] humanCountriesOfBirth = {"Ukraine","Russia","India","Poland","USA","Greece","Great Britain"};

    Human(String name,Date dateOfBirth,String cityOfBirth,String coutryOfBirth,int age){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.cityOfBirth = cityOfBirth;
        this.coutryOfBirth = coutryOfBirth;
        this.age = age;
    }


}
