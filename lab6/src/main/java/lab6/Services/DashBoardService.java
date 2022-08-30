package lab6.Services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lab6.Controller.MarksController;
import lab6.Interfaces.DashBoardInterface;

import java.io.IOException;

public class DashBoardService implements DashBoardInterface {
    @Override
    public Pane coursesItemClick(String name) throws IOException {
        MarksController.nameCourse = name;
        return FXMLLoader.load(DashBoardService.class.getResource("marks.fxml"));
    }
}
