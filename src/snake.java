import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Snake extends JFrame implements KeyListener{
    public ArrayList<Coordinate> body;
    public Coordinate prev;
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

    public Snake move(String direction){
        if (direction == "up"){
            Coordinate coordinates = this.body.get(0);
            this.prev = coordinates;
            Coordinate newCoordinate = new Coordinate(coordinates.getX(),coordinates.getY()-1);
            this.body.set(0, newCoordinate);
            this.repaint();
        }
        if (direction == "down"){
            Coordinate coordinates = this.body.get(0);
            Coordinate newCoordinate = new Coordinate(coordinates.getX(),coordinates.getY()+1);
            ArrayList newSnake = new ArrayList<Coordinate>();
            newSnake.add(newCoordinate);
            return new Snake(newSnake);
        }
        if (direction == "right"){
            Coordinate coordinates = this.body.get(0);
            Coordinate newCoordinate = new Coordinate(coordinates.getX()+1,coordinates.getY());
            ArrayList newSnake = new ArrayList<Coordinate>();
            newSnake.add(newCoordinate);
            return new Snake(newSnake);
        }
        if (direction == "left"){
            Coordinate coordinates = this.body.get(0);
            Coordinate newCoordinate = new Coordinate(coordinates.getX()-1,coordinates.getY());
            ArrayList newSnake = new ArrayList<Coordinate>();
            newSnake.add(newCoordinate);
            return new Snake(newSnake);
        }
        return this;

    }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                this.move("up");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void paint(Graphics g)
        {
            if(prev != null){
                g.setColor(new Color(253, 250, 247));
                g.drawRect(this.prev.getX(), this.prev.getY(), 5, 5);
            }
            for (Coordinate coordinate : this.body) {
                g.setColor(new Color(2, 3, 2));
                g.drawRect(coordinate.getX(), coordinate.getY(), 5, 5);
            }
        }

        public static void main(String[] args) {
            ArrayList<Coordinate> cords = new ArrayList<Coordinate>();
            Coordinate c1 = new Coordinate(100, 100);
            cords.add(c1);
            Snake m = new Snake(cords);
            m.repaint();
            m.addKeyListener(m);
        }

    }
