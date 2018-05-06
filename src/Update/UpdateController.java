package Update;

import Login.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateController {

    public void cofnij(MouseEvent event) throws IOException {
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("/Menu/Menu.fxml"));
        Scene newSceneWindow1 = new Scene(window1);
        Stage mainStage;
        mainStage = Main.getPrimaryStage();
        mainStage.setScene(newSceneWindow1);
        mainStage.show();
    }
}
