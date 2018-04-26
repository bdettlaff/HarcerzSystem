package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class LoginController {

    @FXML
    private Label lblStatus;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextField tfLogin;

    public void Login(ActionEvent event){
        if(tfLogin.getText().equals("test") && pfPassword.getText().equals("zsq21wax")) {
            lblStatus.setText("Udalo sie zalogowac.");
        }
        else {
            lblStatus.setText("Logowanie nie powiodlo sie.");
        }
    }
}
