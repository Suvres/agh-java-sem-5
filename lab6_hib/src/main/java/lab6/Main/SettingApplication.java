package lab6.Main;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lab6.Student.Student;

public class SettingApplication {
    @FXML
    public static BorderPane borderPane;

    @FXML
    public static Stage stage;

    @FXML
    public static Stage dialog;

    public static boolean isLoginAdmin;
    public static boolean isLogin;
    public static String User = null;
    public static Student student = null;

    public static final String[][] users = new String[][]{
            new String[]{"admin", "admin"},
            new String[]{"user", "user"}
    };
}
