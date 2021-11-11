package Zoo;

public class Person extends Main {
    int countOfVisitors; //for creating existing people

    String name;
    String surname;

    int yearOB;
    int monthOB;
    int dayOB;

    String passportNumber;
    String cityOfBirth;
    String countryOfBirth;
    //___________________________
    int id;
    int visitorAge;

    Person(){}
    Person(int id,int visitorAge){
        this.id = id;
        this.visitorAge = visitorAge;

    }
}