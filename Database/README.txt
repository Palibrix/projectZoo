How to start database(DB) on your PC:

1. Open MySQL Workbench
2. Test your connection(we did it previously)
3. Open project
4. Start with : DB_Main database = new DB_Main(username, password, URL, className);
                        database.TestConnection();
                        database.firstEntry();
5. Type your login and password ("root" is default username, but password you should not forget)

6. After successful compilation REMOVE or COMMENT "database.firstEntry();"!!!!!!!



Here is some possible troubles:

1. SSL Error in MySQL:
    1. Open cmd(Admin)
    2. type: netstat -ano | findstr :3306
    3. type: taskkill /F /PID (id here)

2. Unable to connect to localhost:
    1. Open MySQL Installer
    2. Open "Reconfiguration"
    3. Follow "Next" links
    4. Done