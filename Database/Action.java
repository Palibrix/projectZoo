package Database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Action extends DB_Main{

    private ArrayList locations = new ArrayList();

    public ArrayList getZooWhereIsAnimal(String name){
        try {
            Class.forName(className);
            String findZooWhereIsAnimal = "select zoo.name from zoo, animals where animals.name like \""+name+"\" and zoo.ZooID = animals.ZooID;";
            con = DriverManager.getConnection(URL, username, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(findZooWhereIsAnimal);
            while(rs.next()){
                locations.add(rs.getString("name"));
            }
            stmt.close();
            rs.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    };

}
