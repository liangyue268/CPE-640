import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yue on 3/17/2015.
 */
public class BallComponent extends JPanel {
    private static final int DEFAULT_WIDTH = 640;
    private static final int DEFAULT_HEIGHT = 480;

    private ArrayList<Ball> balls = new ArrayList<Ball>();

    BallComponent(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    /**
     * Add a ball to the component.
     * @param b the ball to add
     */
    public void add(Ball b)
    {
        balls.add(b);
    }

    public int ballSize(){
        return balls.size();
    }

    public void ballRemove(int i){
        balls.remove(i);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // erase background
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls)
        {
            g2.setColor(b.getColor());
            g2.fill(b.getShape());
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public ArrayList<Ball> getBalls(){
        return balls;
    }
}
