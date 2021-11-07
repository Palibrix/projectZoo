package pr1;

import java.io.File;
import java.io.IOException;

public class Settings extends Main {
    File file = new File("D:\\КОД\\JAVAPROJECT\\projectZoo\\src\\pr1\\FirstStart");
    boolean firstRun = false;

    void firstRunCheck() throws IOException {
        if (!file.exists()) {
            firstRun = true;
            file.createNewFile();
        }
        if (firstRun) {
            System.out.println("OH, LOOK! A NEW USER! Hello and welcome in our Zoo," +
                    " called "+Zoo.names[random.rdName()]+"!");
        } else {
            System.out.println("Hello and welcome! We're happy to see you again!");
        }
    }
}
