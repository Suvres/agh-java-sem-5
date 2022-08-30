package lab6.Services;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lab6.Data.Data;
import lab6.Main.SettingApplication;
import lab6.Student.StudentCourse;
import lab6.Student.StudentMark;

import java.util.List;

public class CoursesListCellUpdate extends ListCell<String> {
    @Override
    protected void updateItem(String s, boolean b) {
        super.updateItem(s, b);
        if(s == null) return;

        StudentCourse c = Data.courseContainer.getClass(s);

        List<StudentMark> marks = c.getStudentsMarks(SettingApplication.student);

        double ls = 0;
        for(StudentMark m: marks) {
            ls += m.mark;
        }

        String _s = String.format("Oceny: %d, Stan Studenta: %s, Średnia: %.2f",
                marks.size(), SettingApplication.student.getCondition(), ls / (double) marks.size());

        setText(s);
        setTooltip(new Tooltip(_s));

        setOnMouseClicked(mouseEvent -> {
            if(mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getClickCount() == 2) {
                SettingApplication.dialog = new Stage();
                SettingApplication.dialog.initModality(Modality.APPLICATION_MODAL);
                SettingApplication.dialog.initOwner(SettingApplication.stage);
                VBox dialogVbox = new VBox(20);
                dialogVbox.getChildren().add(new Text(_s));
                Scene dialogScene = new Scene(dialogVbox, 400, 20);
                SettingApplication.dialog.setScene(dialogScene);
                SettingApplication.dialog.show();
            }
        });
    }


}
