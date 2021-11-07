package pr1;

public class Event extends Main{
    static String name;
    static String location;
    static String type;

public enum EventDescriptionEnum {
    NAME(),
    LOCATION,
    TYPE;

    private String name;
    private String location;
    private String type;


    EventDescriptionEnum(String name, String location, String type){
        this.name = name;
        this.location = location;
        this.type = type;
    }

    public static EventDescriptionEnum getName() {
        return NAME;
    }

    public EventDescriptionEnum getLocation() {
        return LOCATION;
    }

    public EventDescriptionEnum getType() {
        return TYPE;
    }

//    EventDescriptionEnum(EventDescriptionEnum NAME, EventDescriptionEnum LOCATION, EventDescriptionEnum TYPE){
//
//    }
}

    Event(String name, String location, String type) {
        this.name = name;
        this.location = location;
        this.type = type;
    }

//    void registration() {
//        if (Human.getAge() < 18) {
//            int diff = 18 - Human.getAge();
//            System.out.println("You're not allowed to buy a ticket, come back after " + diff + " years!");
//            menu();
//        } else {
//            System.out.println("You're allowed to buy a ticket. How many do you want to buy?");
//            first.buyTicket();
//        }
//    }
}
