import javax.swing.*;
import java.awt.*;

/**
 * Created by vathsala on 27/02/16.
 */
public class Board extends JFrame {
    private Dimension dimension;

    public Board(Dimension d) {
        this.dimension = d;
    }

    public Dimension getDimension() {
        return dimension;
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
        System.out.println("function called");
        g.setColor(Color.orange);
        g.fillRect(35,45,75,95);
        g.setColor(Color.black);
        g.drawRect(35, 45, 75, 95);
    }

    public void fillColour(){
        System.out.println(" fill called");
        this.repaint();
    }

}
