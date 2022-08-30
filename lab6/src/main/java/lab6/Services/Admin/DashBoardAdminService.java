package lab6.Services.Admin;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lab6.Interfaces.DashBoardInterface;

public class DashBoardAdminService implements DashBoardInterface {
    @Override
    public Pane coursesItemClick(String name) {
        return new VBox();
    }
}
