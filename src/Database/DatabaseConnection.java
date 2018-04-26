package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class DatabaseConnection {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:Harcerz.db";

    private Connection conn;
    private Statement stat;
    private String createLogowanie = "CREATE TABLE IF NOT EXISTS logowanie (idLogowanie INTEGER PRIMARY KEY AUTOINCREMENT, login varchar(255), haslo varchar(255))";
    private String login;
    private String password;

    public DatabaseConnection() {
        try {
            Class.forName(DatabaseConnection.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }

        doStatemant(createLogowanie);
    }

    public boolean doStatemant(String command){
        try {
            stat.execute(command);
        } catch (SQLException e) {
            System.err.println("Blad przy wykonaniu polecenia.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean selectDataFromDB(String command){
        try {
            ResultSet rs = stat.executeQuery(command);

            while(rs.next()){
                login = rs.getString("login");
                password = rs.getString("haslo");

                System.out.println("Login: " + login);
                System.out.println("Hasło: " + password);
            }
        } catch (SQLException e) {
            System.err.println("Blad przy pobieraniu danych z BD");
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
