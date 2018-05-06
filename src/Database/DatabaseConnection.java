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
    private String login;
    private String password;
/*
    private String colImie;
    private String colNazwisko;
    private String colPESEL;
    private String colUlica;
    private String colNumerDomu;
    private String colMiejscowosc;
    private String colNumerTelefonu;

    public String getColImie() {
        return colImie;
    }

    public String getColNazwisko() {
        return colNazwisko;
    }

    public String getColPESEL() {
        return colPESEL;
    }

    public String getColUlica() {
        return colUlica;
    }

    public String getColNumerDomu() {
        return colNumerDomu;
    }

    public String getColMiejscowosc() {
        return colMiejscowosc;
    }

    public String getColNumerTelefonu() {
        return colNumerTelefonu;
    }

    public void setColImie(String colImie) {
        this.colImie = colImie;
    }

    public void setColMiejscowosc(String colMiejscowosc) {
        this.colMiejscowosc = colMiejscowosc;
    }

    public void setColNazwisko(String colNazwisko) {
        this.colNazwisko = colNazwisko;
    }

    public void setColNumerDomu(String colNumerDomu) {
        this.colNumerDomu = colNumerDomu;
    }

    public void setColNumerTelefonu(String colNumerTelefonu) {
        this.colNumerTelefonu = colNumerTelefonu;
    }

    public void setColPESEL(String colPESEL) {
        this.colPESEL = colPESEL;
    }

    public void setColUlica(String colUlica) {
        this.colUlica = colUlica;
    }
*/
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

    }

    public boolean doStatement(String command){
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
            }
        } catch (SQLException e) {
            System.err.println("Blad przy pobieraniu danych z BD");
            e.printStackTrace();
            return false;
        }
        return true;
    }
/*
    public boolean selectMenu(String command){
        try {
            ResultSet rs = stat.executeQuery(command);

            while(rs.next()){
                colImie=rs.getString("Imie");
                colNazwisko=rs.getString("Nazwisko");
                colPESEL=rs.getString("PESEL");
                colUlica=rs.getString("Ulica");
               // col.
            }
        } catch (SQLException e) {
            System.err.println("Blad przy pobieraniu danych z BD");
            e.printStackTrace();
            return false;
        }
        return true;
    }
*/
    public String getLogin(){
        return this.login;
    }

    public String getPassword(){
        return this.password;
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

}
