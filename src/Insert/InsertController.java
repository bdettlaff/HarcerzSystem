package Insert;

import Database.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class InsertController {
    @FXML
    private TextField tfImie;
    @FXML
    private TextField tfNazwisko;
    @FXML
    private TextField tfPESEL;
    @FXML
    private TextField tfNrTelefonu;
    @FXML
    private TextField tfMiejscowosc;
    @FXML
    private TextField tfNrDomu;
    @FXML
    private TextField tfUlica;
    @FXML
    private Label lblStatus;
/*
    private String Imie;
    private String Nazwisko;
    private String PESEL;
    private String NrTelefonu;
    private String Miejscowosc;
    private String NrDomu;
    private String Ulica;
    */
    public void dodajHarcerza(MouseEvent event) throws SQLException {

        DatabaseConnection polaczenie = new DatabaseConnection();

        if(sprawdzLitery(tfImie.getText()) &&
           sprawdzLitery(tfNazwisko.getText()) &&
           sprawdzCyfry(tfPESEL.getText()) &&
           sprawdzPESEL(tfPESEL.getText()) &&
           sprawdzLitery(tfUlica.getText()) &&
           sprawdzCyfry(tfNrDomu.getText()) &&
           sprawdzLitery(tfMiejscowosc.getText())&&
           sprawdzCyfry(tfNrTelefonu.getText()) &&
           sprawdzNumerTelefonu(tfNrTelefonu.getText())){

            polaczenie.doStatement("INSERT INTO harcerze (Imie, Nazwisko, PESEL, Ulica, NumerDomu, Miejscowosc, NumerTelefonu) " +
                    "VALUES ("+"'"+tfImie.getText()+"'"+", "+"'"+tfNazwisko.getText()+"'"+", "+"'"+tfPESEL.getText()+"'"+", "+"'"+tfUlica.getText()+"'"+", "+"'"+tfNrDomu.getText()+"'"+", "+"'"+tfMiejscowosc.getText()+"'"+", "+"'"+tfNrTelefonu.getText()+"'"+");");
        }
/*
        INSERT INTO harcerze (Imie, Nazwisko, PESEL, Ulica, NumerDomu, Miejscowosc, NumerTelefonu)
        VALUES (value1, value2, value3, ...);

        */
        polaczenie.closeConnection();
    }

    public void wyczysc(){
        tfImie.setText(" ");
        tfNazwisko.setText(" ");
        tfPESEL.setText(" ");
        tfUlica.setText(" ");
        tfNrDomu.setText(" ");
        tfMiejscowosc.setText(" ");
        tfNrTelefonu.setText(" ");
    }

    public boolean sprawdzPESEL(String pesel){

        if(pesel.length()==11) {
            return true;
        }
        else{
            lblStatus.setText("Zly PESEL");
            return false;
        }
    }

    public boolean sprawdzNumerTelefonu(String numerTelefonu){
        if(numerTelefonu.length()==9) {
            return true;
        }
        else{
            lblStatus.setText("Zly Numer Telefonu");
            return false;
        }
    }

    public boolean sprawdzLitery(String element)
    {
        Pattern wzorLitery = Pattern.compile("[a-zA-Z]+\\.?");;
        wzorLitery.matcher(element).matches();
        if(wzorLitery.matcher(element).matches()){
            return true;
        }
        else{
            lblStatus.setText("Blad: " + element);
            return false;
        }
    }

    public boolean sprawdzCyfry(String element)
    {
        Pattern wzorCyfry = Pattern.compile("[0-9]+\\.?");
        if(wzorCyfry.matcher(element).matches()){
            return true;
        }
        else{
            lblStatus.setText("Blad: " + element);
            return false;
        }

    }
}
