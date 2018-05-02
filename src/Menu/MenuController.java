package Menu;

import Login.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import java.io.IOException;


public class MenuController {


    @FXML
    private Label lblZalogowany;

    @FXML
    private Button btnLoggedAs;

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




}
