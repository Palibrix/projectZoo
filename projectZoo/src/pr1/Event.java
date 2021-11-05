package pr1;

public class Event extends Main{
        Human h = new Human();

private enum EventDescriptionEnum {
    NAME,
    LOCATION,
    TYPE;
}

    private EventDescriptionEnum eventDescription;

    Event(EventDescriptionEnum name, EventDescriptionEnum location, EventDescriptionEnum type){
        this.eventDescription = name;
        this.eventDescription = location;
        this.eventDescription = type;
    }

    void recruitPeople(){
    }

    void regestration() {
        if (Human.getAge() < 18) {
            int diff = 18 - Human.getAge();
            System.out.println("You're not allowed to buy a ticket, come back after " + diff + " years!");
            menu();
        } else {
            System.out.println("You're allowed to buy a ticket. How many do you want to buy?");
            first.buyTicket();
        }
    }
}
