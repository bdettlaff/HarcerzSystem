package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Database.DatabaseConnection;
import javafx.scene.image.Image;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginPanel.fxml"));
        primaryStage.getIcons().add(new Image("file:H:///Test/test.png"));
        primaryStage.setTitle("Harcerz System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {

        // String INSERT INTO logowanie (login,haslo) values ('deti27', 'zsq21wax')
        String select = "select * from logowanie";
        DatabaseConnection baza = new DatabaseConnection();
        baza.selectDataFromDB(select);

        launch(args);
    }
}
