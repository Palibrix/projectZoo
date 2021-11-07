package pr1;

public class Event extends Main {
    String name;
    String location;
    String type;

    Event(String NAME, String LOCATION, String TYPE) {
        this.name = NAME;
        this.location = LOCATION;
        this.type = TYPE;
    }

    public enum EventDescriptionEnum {
        NAME(),
        LOCATION(),
        TYPE;

        public static EventDescriptionEnum getName() {
            return NAME;
        }

        public EventDescriptionEnum getLocation() {
            return LOCATION;
        }

        public EventDescriptionEnum getType() {
            return TYPE;
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
}
