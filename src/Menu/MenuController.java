package Menu;

import Database.DatabaseConnection;
import Login.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.ResultSet;


public class MenuController {

    @FXML
    private Label lblZalogowany;

    @FXML
    private Button btnLoggedAs;

    @FXML
    private TableView tableSelect;

    @FXML
    private TableColumn colImie;
    @FXML
    private TableColumn colNazwisko;
    @FXML
    private TableColumn colPESEL;
    @FXML
    private TableColumn colUlica;
    @FXML
    private TableColumn colNumerDomu;
    @FXML
    private TableColumn colMiejscowosc;
    @FXML
    private TableColumn colNumerTelefonu;

    @FXML
    public void setZalogowany(){
        lblZalogowany.setText("Zalogowany jako ");
        btnLoggedAs.setDisable(true);
    }

    public void panelInsert(MouseEvent event2) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("/Insert/Insert.fxml"));
        Scene newSceneWindow1 = new Scene(window1);
        Stage mainStage;
        mainStage = Main.getPrimaryStage();
        mainStage.setScene(newSceneWindow1);
        mainStage.show();
    }

    public void panelDelete(MouseEvent event2) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("/Delete/Delete.fxml"));
        Scene newSceneWindow1 = new Scene(window1);
        Stage mainStage;
        mainStage = Main.getPrimaryStage();
        mainStage.setScene(newSceneWindow1);
        mainStage.show();
    }

    public void panelUpdate(MouseEvent event2) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("/Update/Update.fxml"));
        Scene newSceneWindow1 = new Scene(window1);
        Stage mainStage;
        mainStage = Main.getPrimaryStage();
        mainStage.setScene(newSceneWindow1);
        mainStage.show();
    }

    public void panelSelect(){
        DatabaseConnection polaczenie = new DatabaseConnection();


    }




}
