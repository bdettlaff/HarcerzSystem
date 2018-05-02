package Login;

import Database.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.SQLException;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class LoginController {
    @FXML
    public Pane paneLogin;

    @FXML
    private Label lblStatus;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextField tfLogin;

    private String login;
    @FXML
    public void Login(MouseEvent event) throws SQLException, IOException {

        DatabaseConnection polaczenie = new DatabaseConnection();
        polaczenie.selectDataFromDB("select * from logowanie");

        if(tfLogin.getText().equals(polaczenie.getLogin()) && pfPassword.getText().equals(polaczenie.getPassword())) {
           lblStatus.setText("Udalo sie zalogowac.");

            Parent window1;
            window1 = FXMLLoader.load(getClass().getResource("/Menu/Menu.fxml"));
            this.login =tfLogin.toString();
            Scene newSceneWindow1 = new Scene(window1);
            Stage mainStage;
            mainStage = Main.getPrimaryStage();
            mainStage.setScene(newSceneWindow1);
            mainStage.show();
        }
        else {
            lblStatus.setText("Logowanie nie powiodlo sie.");
        }
        polaczenie.closeConnection();
    }

    public String getLogin()
    {
        return this.login;
    }

}
