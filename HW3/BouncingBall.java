import javax.swing.*;

/**
 * Created by yue on 2/19/2015.
 */
public class BouncingBall {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        myFrame.getContentPane().add(new SpeedControlPanel());
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        myFrame.pack();
    }
}
