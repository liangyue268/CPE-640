import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by yue on 2/19/2015.
 */
public class SpeedControlPanel extends JPanel implements ChangeListener{
    JSlider s1;
    ArrayList<Circle> myCircles;
    final int CIRCLENUM = 5;
    final int WIDTH = 640, HEIGHT = 480;
    public SpeedControlPanel(){
        final int MINVAL = 0, MAXVAL = 20, INITVAL = 10;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        s1 = new JSlider(JSlider.HORIZONTAL, MINVAL, MAXVAL, INITVAL);
        s1.setMajorTickSpacing(10);
        s1.setMinorTickSpacing(1);
        s1.setPaintTicks(true);
        s1.setPaintLabels(true);
        add(s1);
        s1.addChangeListener(this);
        repaint();

        myCircles = new ArrayList<Circle>();
        for(int i = 0; i<CIRCLENUM; i++){
            Circle c = new Circle(s1.getValue());
            myCircles.add(c);
        }

        repaint();
        //fresh circle position in a certain period of time and change velocity accordingly
        fresh();
    }

    private void fresh(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (int i = 0; i < CIRCLENUM; i++) {
                        for (int j = i + 1; j < CIRCLENUM; j++) {
                            Circle c1 = myCircles.get(i), c2 = myCircles.get(j);
                            if (Circle.distanceDetection(c1, c2)) {
                                Circle.ballCollision(c1, c2);
                            }
                            myCircles.set(i, c1);
                            myCircles.set(j, c2);
                        }
                    }
                    for (int i = 0; i < CIRCLENUM; i++) {
                        Circle c = myCircles.get(i);
                        int num = c.wallDetection(WIDTH, HEIGHT);
                        c.wallCollision(num);
                        myCircles.set(i, c);
                    }
                    for (Circle c : myCircles) {
                        c.nextSec();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        });
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cSize = myCircles.size();
        int cid = 0x00ff0000;
        g.setColor(new Color(cid));
        for(int i=0; i<cSize; i++){
            Circle c = myCircles.get(i);
            g.fillOval(c.getX()-c.getRadius(), c.getY()-c.getRadius(), 2*c.getRadius(), 2*c.getRadius());
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider js1 = (JSlider)e.getSource();
        for(Circle c: myCircles){
            c.setSpeed(js1.getValue());
        }
    }
}