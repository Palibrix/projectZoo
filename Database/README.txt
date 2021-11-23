How to start database(DB) on your PC:

1. Open MySQL Workbench;
2. Test your connection(we did it previously);
3. Create new field (by pressing "+" button);
4. Type "create database projectZoo;" and press yellow lightning;
5. Open project;
6. Start with : DB_Main database = new DB_Main(username, password, URL, className);
                        database.TestConnection();
                        database.firstEntry();
7. Type your login and password ("root" is default username, but password you should not forget);

8. After successful compilation REMOVE or COMMENT "database.firstEntry();"!!!!!!!


Here is some possible troubles:

1. SSL Error in MySQL:
    1. Open cmd(Admin);
    2. type: netstat -ano | findstr :3306
    3. type: taskkill /F /PID (id here)

2. Unable to connect to localhost:
    1. Open MySQL Installer;
    2. Open "Reconfiguration";
    3. Follow "Next" links;
    4. Done;


Methods instruction:
1. firstEntry - loading all databases on your PC;
2. Cleaning - clean "People" database; use it after launching program;
3. TestConnection - testing if everything okay with database and driver;
4. getAllPeople - get everyone;
5. addNewUser(name, surname, passport) - create new user;
6. removeUser(name, UID);
7. getZooWhereIsAnimal(Animal name), returning: ArrayList of locations

In progress:

1. updateZoo(remove/add, name);

Exit codes:
1. -20 — call ended, everything correct;