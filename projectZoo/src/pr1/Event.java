package pr1;

public class Event extends Main {
    enum EventEnum {
        NAME,
        LOCATION,
        TYPE;
    }

    static String name;
    static String location;
    static String type;
    Person h = new Person();

    Event(String name, String location, String type) {
        this.name = name;
        this.location = location;
        this.type = type;
    }

    void theFirstStage() {
        System.out.println("AAAAANDDD NOOOOOOWWWW we're nearly going to start our program! Please, come and pass" +
                "the registration and who knows, maybe you we'll even be able to see the show!");
    }

}
