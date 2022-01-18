import com.company.QuadTree;
import com.company.QuadTreePoint;

import javax.swing.*;
import java.awt.*;

public class ButtonsFrame extends JFrame {
    private JLabel inputLabel = new JLabel("Input: ");
    private JTextField inputTextField = new JTextField("", 100);
    private JButton searchButton = new JButton("search");
    private JButton insertButton = new JButton("insert");
    private JButton deleteButton = new JButton("delete");
    private DrawPanel drawPanel;

    public ButtonsFrame(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5, 1, 2, 2));
        container.add(inputLabel);
        container.add(inputTextField);
        container.add(searchButton);
        container.add(insertButton);
        container.add(deleteButton);

        searchButton.addActionListener(e -> {
            QuadTree quadTree = drawPanel.getQuadTree();
            String inputText = inputTextField.getText();
            String[] pointValues = inputText.split("\s+");
            QuadTreePoint point = quadTree.findPoint(Integer.parseInt(pointValues[0]),
                    Integer.parseInt(pointValues[1]));
            drawPanel.setSearchingPoint(point);
            drawPanel.repaint();
        });

        insertButton.addActionListener(e -> {
            QuadTree quadTree = drawPanel.getQuadTree();
            String inputText = inputTextField.getText();
            String[] pointValues = inputText.split("\s+");
            quadTree.insert(Integer.parseInt(pointValues[0]),
                            Integer.parseInt(pointValues[1]),
                            Integer.parseInt(pointValues[2]));
            drawPanel.repaint();
        });

        deleteButton.addActionListener(e -> {
            QuadTree quadTree = drawPanel.getQuadTree();
            String inputText = inputTextField.getText();
            String[] pointValues = inputText.split("\s+");
            quadTree.delete(Integer.parseInt(pointValues[0]),
                    Integer.parseInt(pointValues[1]));
            drawPanel.repaint();
        });
    }
}
