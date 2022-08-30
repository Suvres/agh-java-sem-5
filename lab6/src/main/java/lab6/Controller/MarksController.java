package lab6.Controller;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lab6.Data.Data;
import lab6.Main.SettingApplication;
import lab6.Services.CoursesSerializable;
import lab6.Student.StudentCourse;
import lab6.Student.StudentMark;

import java.net.URL;
import java.util.EventListener;
import java.util.List;
import java.util.ResourceBundle;

public class MarksController implements Initializable, EventListener{
    public TableView marksTable;
    public Text marksAvg;
    public static String nameCourse;
    public TextField newMark;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(SettingApplication.student == null) {
            return;
        }

        this.makeTable();
    }

    private void makeTable() {
        StudentCourse course = Data.courseContainer.getClass(MarksController.nameCourse);
        List<StudentMark> marksS = course.getStudentsMarks(SettingApplication.student);

        double m_tmp = 0;
        for(StudentMark mark: marksS) {
            m_tmp += mark.mark;
        }

        this.marksTable.setItems(FXCollections.observableList(Data.courseContainer.getClass(MarksController.nameCourse).
                getStudentsMarksModels(SettingApplication.student)));
        this.marksAvg.setText(String.format("%.2f", m_tmp / (double) marksS.size()));
    }

    public void newMark(MouseEvent mouseEvent) {
        Data.courseContainer.getClass(MarksController.nameCourse)
                .addMark(SettingApplication.student, Double.parseDouble(this.newMark.getText()));

        this.newMark.setText("");
        this.makeTable();
        CoursesSerializable.save(Data.courseContainer);
    }
}
