import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yue on 3/17/2015.
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new BounceFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * The frame with ball component and buttons.
 */
class BounceFrame extends JFrame{
    private BallComponent comp;
    private JSlider s1;
    private JLabel l1;

    /**
     * Constructs the frame with the component for showing the bouncing ball and Start and Close
     * buttons
     */
    public BounceFrame(){
        final int MIN_VAL = 0, MAX_VAL = 100, INIT_VAL = 0;
        setTitle("Bounce");
        setSize(640, 480);

        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);

        s1 = new JSlider(JSlider.HORIZONTAL, MIN_VAL, MAX_VAL, INIT_VAL);
        s1.setMajorTickSpacing(10);
        s1.setMinorTickSpacing(1);
        s1.setPaintTicks(true);
        s1.setPaintLabels(true);
        s1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(comp.ballSize() < s1.getValue()){
                    for(int i=comp.ballSize(); i < s1.getValue(); i++)
                        addBall();
                }
                else{
                    for(int i=comp.ballSize()-1; i >= s1.getValue(); i--)
                        removeBall(i);
                }
            }
        });

        l1 = new JLabel();
        JPanel panel = new JPanel(new GridLayout(2,1));
        panel.add(l1);
        panel.add(s1);
        add(panel, BorderLayout.SOUTH);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    ArrayList<Ball> balls = comp.getBalls();
                    double energy = 0;
                    for(Ball b: balls){
                        energy += 0.5*b.getMass()*b.getSpeed()*b.getSpeed();
                    }
                    l1.setText("Total energy: " + (int)energy);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();

        /*class labelRefresh implements Runnable{
            private BounceFrame bf;
            labelRefresh(BounceFrame bf){
                this.bf = bf;
            }
            public void run(){
                bf.l1.setText();
            }
        }*/
    }

    public void addBall(){
        Ball b = new Ball();
        comp.add(b);
        Runnable r = new BallRunnable(comp, b);
        Thread t = new Thread(r);
        t.start();
    }

    public void removeBall(int i){
        comp.ballRemove(i);
    }
}

class BallRunnable implements Runnable{
    private BallComponent comp;
    private Ball ball;
    //private Lock ballLock = new ReentrantLock();

    public BallRunnable(BallComponent comp, Ball ball){
        this.comp = comp;
        this.ball = ball;
    }

    public void run()
    {
        try
        {
            while(true)
            {
                ball.move(comp.getBounds(), comp.getBalls());
                comp.repaint();
                Thread.sleep(15);
            }
        }
        catch (InterruptedException e)
        {
        }
    }
}