package Login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Main extends Application {
    private static Stage primaryStage;

    private void setPrimaryStage(Stage stage) {
        Main.primaryStage = stage;
    }

    static public Stage getPrimaryStage() {
        return Main.primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader firstPaneLoader = new FXMLLoader(getClass().getResource("LoginPanel.fxml"));
        Parent firstPane = firstPaneLoader.load();
        Scene firstScene = new Scene(firstPane);
        primaryStage.getIcons().add(new Image("file:C:///Users/Bartek/Desktop/HarcerzSystem-master/test.png"));
        primaryStage.setTitle("Harcerz System");
        primaryStage.setScene(firstScene);
        primaryStage.setResizable(false);
        this.setPrimaryStage(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

}
