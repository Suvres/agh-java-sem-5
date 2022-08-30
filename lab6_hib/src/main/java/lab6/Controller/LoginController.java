package lab6.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import lab6.Data.Data;
import lab6.Main.SettingApplication;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class LoginController {

    public TextField userLogin;
    public PasswordField userPassword;

    public void userLogin(ActionEvent actionEvent) {
        Arrays.asList(SettingApplication.users).forEach((_user) -> {

            if(_user[0].equals(userLogin.getText()) && _user[1].equals(userPassword.getText())) {
                System.out.printf("\nTEST\n");

                if(_user[0].equals("admin")) {
                    SettingApplication.isLoginAdmin = true;
                }

                SettingApplication.isLogin = true;
                SettingApplication.User = _user[0];
                SettingApplication.student = Data.courseContainer.getStudents(SettingApplication.users[1][0]);

                try {
                    DashboardController.createDashboard();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }


}
