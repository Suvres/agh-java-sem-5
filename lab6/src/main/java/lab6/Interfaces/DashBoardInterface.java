package lab6.Interfaces;

import javafx.scene.layout.Pane;

import java.io.IOException;

public interface DashBoardInterface {
    Pane coursesItemClick(String name) throws IOException;
}
