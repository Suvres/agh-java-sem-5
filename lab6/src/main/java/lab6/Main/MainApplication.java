package lab6.Main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lab6.Controller.LoginController;
import lab6.Controller.StudentController;
import lab6.Data.Data;
import lab6.Services.CoursesSerializable;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Data.testInit();
        SettingApplication.stage = stage;

        GridPane gridPane = FXMLLoader.load(LoginController.class.getResource("login.fxml"));
        Scene scene = new Scene(gridPane, 300, 170);

        SettingApplication.stage.setTitle("SSOS");
        SettingApplication.stage.setScene(scene);
        SettingApplication.stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}