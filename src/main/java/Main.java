import com.company.Boundry;
import com.company.QuadTree;
import com.company.QuadTreePoint;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        QuadTree quadTree = new QuadTree(0, new Boundry(0, 0, 400, 400), null);
        quadTree.insert(50, 50, 1);
        quadTree.insert(250, 350, 2);
        quadTree.insert(325, 225, 3);
        quadTree.insert(325, 275, 4);
        DrawPanel drawPanel = new DrawPanel(quadTree);
        MainWindow mainWindow = new MainWindow(drawPanel);
        mainWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainWindow.setSize(450, 450);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
        ButtonsFrame buttonsFrame = new ButtonsFrame(drawPanel);
        buttonsFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        buttonsFrame.setSize(100, 200);
        buttonsFrame.setVisible(true);
    }

//    public static void main(String[] args) {
//        QuadTree quadTree = new QuadTree(0, new Boundry(0, 0, 800, 800), null);
//        quadTree.insert(100, 100, 1);
//        quadTree.insert(500, 700, 2);
//        Utils.printQuadTree(quadTree);
//        System.out.println("\n-------------------------");
//
//        quadTree.insert(650, 450, 3);
//        quadTree.insert(650, 550, 4);
//        Utils.printQuadTree(quadTree);
//        System.out.println("\n-------------------------");
//
//        QuadTreePoint point = quadTree.findPoint(650, 450);
//        Utils.printPoint(point);
//        System.out.println("\n-------------------------");
//
//        quadTree.delete(650, 450);
//        point = quadTree.findPoint(650, 450);
//        Utils.printPoint(point);
//        Utils.printQuadTree(quadTree);
//        System.out.println("\n-------------------------");
//    }
}
