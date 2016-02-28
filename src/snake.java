import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Snake extends JFrame implements KeyListener {
    public ArrayList<Coordinate> body;
    public Coordinate prev;
    private Timer currentTimer;

    public ArrayList<Coordinate> getBody() {
        return body;
    }

    public Snake(ArrayList<Coordinate> body) {
        this.body = body;
        setSize(300, 400);
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Snake move(String direction) {
        Coordinate coordinates = this.body.get(0);
        this.prev = coordinates;
        Coordinate newCoordinate = null;
        if (direction == "up") {
            newCoordinate = new Coordinate(coordinates.getX(), coordinates.getY() - 1);
        }
        if (direction == "down") {
            newCoordinate = new Coordinate(coordinates.getX(), coordinates.getY() + 1);
        }
        if (direction == "right") {
            newCoordinate = new Coordinate(coordinates.getX() + 1, coordinates.getY());
        }
        if (direction == "left") {
            newCoordinate = new Coordinate(coordinates.getX() - 1, coordinates.getY());
        }
        this.body.set(0, newCoordinate);
        this.repaint();
        return this;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (currentTimer != null)
            currentTimer.cancel();
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.move("up");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.move("down");
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.move("right");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.move("left");
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        final Snake snake = this;
        Timer timer = new Timer();
        currentTimer = timer;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (e.getKeyCode() == 38)
                    snake.move("up");
                if (e.getKeyCode() == 40)
                    snake.move("down");
                if (e.getKeyCode() == 39)
                    snake.move("right");
                if (e.getKeyCode() == 37)
                    snake.move("left");
            }
        }, 1, 15);
    }

    @Override
    public void paint(Graphics g) {
        if (prev != null) {
            g.clearRect(this.prev.getX(), this.prev.getY(), 5, 5);
        }
        for (Coordinate coordinate : this.body) {
            g.setColor(new Color(2, 3, 2));
            g.fillRect(coordinate.getX(), coordinate.getY(), 5, 5);
        }
    }

    public static void main(String[] args) {
        ArrayList<Coordinate> cords = new ArrayList<Coordinate>();
        Coordinate c1 = new Coordinate(100, 100);
        cords.add(c1);
        Snake m = new Snake(cords);
//        Coordinate boardCords = new Coordinate(100, 100);
//        Board b = new Board(boardCords);
//        System.out.println("calling repaint........");
//        b.fillColour();
        m.repaint();
        m.addKeyListener(m);
    }

}
