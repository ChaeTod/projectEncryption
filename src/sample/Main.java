package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Encryption");


        //FileChooser fileChooser = new FileChooser();

        //Button button = new Button("Select File");
        //button.setOnAction(e -> {
        //    File selectedFile = fileChooser.showOpenDialog(primaryStage);
        //});

        //VBox vBox = new VBox(button);
        //Scene scene = new Scene(vBox, 960, 600);


        primaryStage.setScene(new Scene(root, 600, 200));

        //primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
