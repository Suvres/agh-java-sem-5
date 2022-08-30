package lab6.PropertyFactory;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import lab6.Student.StudentMark;

import java.nio.file.attribute.AclFileAttributeView;
import java.text.DateFormat;
import java.util.Date;

public class StudentMarksFactoryModel {
    @FXML
    public DoubleProperty mark;

    @FXML
    public StringProperty date;

    public static StudentMarksFactoryModel createFromMark(StudentMark mark) {
        StudentMarksFactoryModel self = new StudentMarksFactoryModel();
        self.mark = new SimpleDoubleProperty(mark.mark);
        self.date = new SimpleStringProperty(DateFormat.getDateInstance().format(mark.date));

        return self;
    }

    public double getMark() {
        return mark.get();
    }

    public DoubleProperty markProperty() {
        return mark;
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }
}
