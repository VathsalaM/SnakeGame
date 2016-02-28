import javax.swing.*;
import java.awt.*;

/**
 * Created by vathsala on 27/02/16.
 */
public class Board extends JFrame {
    private Coordinate dimension;

    public Board(Coordinate d) {
        this.dimension = d;
    }

    public Coordinate getDimension() {
        return dimension;
    }

    @Override
    public void paint(Graphics g) {
        System.out.println(" paint called");
        g.setColor(new Color(255, 3, 2));
        g.fillRect(50, 50, 5, 5);
    }

    public void fillColour(){
        Coordinate boardCords = new Coordinate(100, 100);
        Board b = new Board(boardCords);
        Graphics g = b.getGraphics();
        b.paint(g);
    }
}