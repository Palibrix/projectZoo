package pr1;

import java.io.File;
import java.io.IOException;

public class Settings{
    File file = new File("D:\\FirstZooStart");
    Zoo z = new Zoo();
    Main m = new Main();
    boolean firstRun = false;

    void firstRunCheck() throws IOException {
        if (!file.exists()) {
            firstRun = true;
            file.createNewFile();
        }
        if (firstRun) {
            System.out.println("OH, LOOK! A NEW USER! Hello and welcome in our Zoo! Today it's" +
                    " called "+m.names[m.random.rdName()]+"!");
        } else {
            System.out.println("Hello and welcome! We're happy to see you in our Zoo AGAIN!" +
                    "Today it's called "+m.names[m.random.rdName()]+"!");
        }
    }
}
