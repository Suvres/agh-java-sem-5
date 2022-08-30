package lab6.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import lab6.Data.Data;
import lab6.Interfaces.DashBoardInterface;
import lab6.Main.SettingApplication;
import lab6.Services.Admin.DashBoardAdminService;
import lab6.Services.CoursesListCellUpdate;
import lab6.Services.DashBoardService;
import lab6.Student.StudentCourse;
import lab6.Student.StudentMark;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    public ListView courses;
    public TextField searchPane;
    public Text username;
    public Text admin;
    public static BorderPane pane;
    public Text marksAvg;

    private DashBoardInterface dashBoardService;

    public static void createDashboard() throws IOException {
        DashboardController.pane = FXMLLoader.load(DashboardController.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(DashboardController.pane, 800, 600);

        SettingApplication.stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> data = FXCollections.observableList(Data.courseContainer.getGroupsNames());

        FilteredList<String> list = new FilteredList<>(data, s -> true);
        this.searchPane.textProperty().addListener(obs -> {
            String filter = this.searchPane.getText();
            if(filter == null || filter.length() < 3) {
                list.setPredicate(s -> true);
            } else {
                list.setPredicate(s -> s.contains(filter));
            }
        });

        this.courses.setItems(list);

        this.courses.setCellFactory((Callback<ListView, ListCell>) listView -> new CoursesListCellUpdate());

        this.username.setText(SettingApplication.User);

        if(SettingApplication.isLoginAdmin) {
            this.admin.setText("**ADMIN**");
        }


        if(SettingApplication.student != null) {
            this.admin.setText("**STUDENT**");
        }

        if(SettingApplication.student != null) {

            double m = 0;
            int count = 0;
            for (StudentCourse c: Data.courseContainer.getGroups().values()) {
                for(StudentMark _m: c.getStudentsMarks(SettingApplication.student)) {
                    m += _m.mark;
                    count++;
                }
            }

            this.marksAvg.setText(String.format("%.2f", m / (double) count));

        }

        dashBoardService = SettingApplication.isLoginAdmin ? new DashBoardAdminService() : new DashBoardService();
    }

    public void clicked(MouseEvent mouseEvent) {
        String item = this.courses.getSelectionModel().getSelectedItem().toString();
        try {
            DashboardController.pane.setCenter(this.dashBoardService.coursesItemClick(item));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void change(MouseEvent mouseEvent) {
        SettingApplication.dialog = new Stage();
        SettingApplication.dialog.initModality(Modality.APPLICATION_MODAL);
        SettingApplication.dialog.initOwner(SettingApplication.stage);
        GridPane dialogVbox = null;
        try {
            dialogVbox = FXMLLoader.load(StudentController.class.getResource("student.fxml"));
            Scene dialogScene = new Scene(dialogVbox, 300, 400);
            SettingApplication.dialog.setScene(dialogScene);
            SettingApplication.dialog.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
