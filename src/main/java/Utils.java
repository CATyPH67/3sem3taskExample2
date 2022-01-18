import com.company.QuadTree;
import com.company.QuadTreePoint;

public class Utils {
    public static void printQuadTree(QuadTree tree) {
        if (tree == null)
            return;

        System.out.printf("\nLevel=%d [X1=%d Y1=%d] \t[X2=%d Y2=%d] ",
                tree.getLevel(), tree.getBoundry().getXMin(), tree.getBoundry().getYMin(),
                tree.getBoundry().getXMax(), tree.getBoundry().getYMax());

        if (tree.getPoint() != null) {
            System.out.printf(" \n\t x=%d y=%d value=%d", tree.getPoint().getX(),
                    tree.getPoint().getY(), tree.getPoint().getValue());
        } else {
            if (tree.getNorthWest() == null) {
                System.out.print("\n\t empty");
            } else {
                System.out.print("\n\t leaf");
            }
        }

        printQuadTree(tree.getNorthWest());
        printQuadTree(tree.getNorthEast());
        printQuadTree(tree.getSouthWest());
        printQuadTree(tree.getSouthEast());
    }

    public static void printPoint(QuadTreePoint point) {
        if (point != null) {
            System.out.printf("\n search point: x=%d y=%d value=%d", point.getX(), point.getY(), point.getValue());
        } else {
            System.out.print("\n searching point doesn't exist");
        }
    }
}
