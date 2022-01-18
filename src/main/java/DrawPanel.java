import com.company.Boundry;
import com.company.QuadTree;
import com.company.QuadTreePoint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {
    private QuadTree quadTree;
    private QuadTreePoint searchingPoint;

    public DrawPanel(QuadTree quadTree) {
        this.quadTree = quadTree;
    }

    public QuadTree getQuadTree() {
        return quadTree;
    }

    public void setQuadTree(QuadTree quadTree) {
        this.quadTree = quadTree;
    }

    public QuadTreePoint getSearchingPoint() {
        return searchingPoint;
    }

    public void setSearchingPoint(QuadTreePoint searchingPoint) {
        this.searchingPoint = searchingPoint;
    }

    @Override
    protected void paintComponent(Graphics origG) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);

        printQuadTree(g, quadTree);

        origG.drawImage(bi, 0, 0, null);
        g.dispose();
    }

    private void printQuadTree(Graphics g, QuadTree tree) {
        if (tree == null)
            return;

        Boundry boundry = tree.getBoundry();
        int xMin = boundry.getXMin();
        int yMin = boundry.getYMin();
        int xMax = boundry.getXMax();
        int yMax = boundry.getYMax();
        g.drawRect(xMin, yMin, xMax - xMin, yMax - yMin);

        QuadTreePoint point = tree.getPoint();
        if (point != null) {
            Color prevColor = g.getColor();
            if (searchingPoint == point) {
                g.setColor(Color.GREEN);
            }

            int x = point.getX();
            int y = point.getY();
            int value = point.getValue();
            g.fillOval(x - 5, y - 5, 10, 10);

            String pointValues = "(" + x + "; " + y + ") " + value;
            drawCenteredString(g, pointValues, new Rectangle(x - 50, y + 10, 100, 20),
                    new Font("Calibri", Font.ITALIC, 15));

            g.setColor(prevColor);
        }

        printQuadTree(g, tree.getNorthWest());
        printQuadTree(g, tree.getNorthEast());
        printQuadTree(g, tree.getSouthWest());
        printQuadTree(g, tree.getSouthEast());
    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(font);
        g.drawString(text, x, y);
    }
}
