import com.company.QuadTree;
import com.company.QuadTreePoint;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private DrawPanel drawPanel;

    public MainWindow(DrawPanel drawPanel) throws HeadlessException {
        this.drawPanel = drawPanel;
        this.add(drawPanel);
    }
}
