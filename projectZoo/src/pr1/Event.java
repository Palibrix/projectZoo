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

    Event(String name, String location, String type) {
        this.name = name;
        this.location = location;
        this.type = type;
    }

}
