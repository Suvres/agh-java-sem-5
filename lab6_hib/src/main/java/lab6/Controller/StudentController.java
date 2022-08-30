package lab6.Controller;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lab6.Main.SettingApplication;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    public TextField name;
    public TextField lastName;
    public TextField email;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(SettingApplication.student == null) {
            return;
        }

        this.name.setText(SettingApplication.student.getFirstName());
        this.lastName.setText(SettingApplication.student.getLastName());
        this.email.setText(SettingApplication.student.getEmail());
    }

    public void save(MouseEvent mouseEvent) {
        SettingApplication.student.setEmail(this.email.getText());
        SettingApplication.student.setFirstName(this.name.getText());
        SettingApplication.student.setLastName(this.lastName.getText());
        SettingApplication.dialog.close();

    }
}
