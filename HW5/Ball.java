import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yue on 3/17/2015.
 */
public class Ball {
    //Properties
    //1.mass
    private double mass;//range:5-10
    //2.radius of the circle
    private double diameter;//range:20-35
    //3.position(upper-left corner)
    private double x, y;//range:x:100-500, y:100-400
    //4.velocity
    private double dx, dy;//product of direction and quantity value
    private double theta;
    private double speed;//range:1-3
    //5.color
    private Color color;

    Ball(){
        Random r = new Random();
        mass = r.nextDouble()*5+5;
        diameter = r.nextDouble()*15 + 20;
        x = r.nextDouble()*400 + 100; y = r.nextDouble()*300 + 100;
        theta = r.nextDouble()*2* Math.PI;
        speed = r.nextDouble()*2+1;
        dx = Math.cos(theta)*speed; dy = Math.sin(theta)*speed;
        /*if(dx == 0) {dx = -1;}
        if(dy == 0) {dy = -1;}*/
        color = new Color(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(256));
    }

    /**
     * Moves the ball to the next position, reversing direction if it hits one of the edges
     */
    public void move(Rectangle2D bounds, ArrayList<Ball> balls)
    {
        x += Math.cos(theta)*speed;//dx;
        y += Math.sin(theta)*speed;//dy;
        wallCollision(bounds);
        ballCollision(balls);
    }
    
    private synchronized void ballCollision(ArrayList<Ball> balls) {
        /*for (Ball b : balls) {
            if (b == this)
                continue;
            double distance = Math.sqrt(Math.pow((this.getShape().getCenterX() - b.getShape().getCenterX()), 2) +
                    Math.pow((this.getShape().getCenterY() - b.getShape().getCenterY()), 2));
            if (distance <= (this.diameter + b.diameter) / 2) {
                if ((this.dx >= 0 && b.dx >= 0 || this.dx < 0 && b.dx < 0) && ((this.dy >= 0 && b.dy < 0 || this.dy < 0 && b.dy >= 0))) {
                    this.dy = -this.dy;
                    //b.dy = -b.dy;
                } else if ((this.dx >= 0 && b.dx < 0 || this.dx < 0 && b.dx >= 0) && ((this.dy >= 0 && b.dy >= 0 || this.dy < 0 && b.dy < 0))) {
                    this.dx = -this.dx;
                    //b.dx = -b.dx;
                } else if ((this.dx >= 0 && b.dx < 0 || this.dx < 0 && b.dx >= 0) && ((this.dy >= 0 && b.dy < 0 || this.dy < 0 && b.dy >= 0))) {
                    this.dx = -this.dx;
                    //b.dx = -b.dx;
                    this.dy = -this.dy;
                    //b.dy = -b.dy;
                }
                else {

                }
            }
        }*/
        for(Ball b: balls){
            if(b == this)
                continue;
            double vx=x-b.x+diameter/2-b.diameter/2;
            double vy=y-b.y+diameter/2-b.diameter/2;
            if(vx*vx+vy*vy<=(diameter/2+b.diameter/2)*(diameter/2+b.diameter/2)){
                ballCollisionProcessing(b, vx, vy);
                break;
            }
        }
    }
    
    private void ballCollisionProcessing(Ball b, double dx, double dy){
        double angv=Math.atan2(dy, dx);
        if(angv<0)
            angv+=2*Math.PI;
        double angp=angv+Math.PI/2;
        if(angp>Math.PI*2)
            angp-=Math.PI*2;
        if(angp>Math.PI)
            angp-=Math.PI;
        double massb=b.mass;
        double fv=speed*(Math.cos(angv)*Math.cos(theta)+Math.sin(angv)*Math.sin(theta));
        double fp=speed*(Math.cos(angp)*Math.cos(theta)+Math.sin(angp)*Math.sin(theta));
        double bv=b.speed;
        double sv=bv*(Math.cos(angv)*Math.cos(b.theta)+Math.sin(angv)*Math.sin(b.theta));
        double sp=bv*(Math.cos(angp)*Math.cos(b.theta)+Math.sin(angp)*Math.sin(b.theta));
        double newfv=((mass-massb)*fv+2*massb*sv)/(mass+massb);
        double newsv=((massb-mass)*sv+2*mass*fv)/(mass+massb);
        if(newsv-newfv<=0&&sv-fv>0){
            this.speed = Math.sqrt(fp*fp+newfv*newfv);
            b.speed = Math.sqrt(sp*sp+newsv*newsv);
            double newxa=newfv*Math.cos(angv)+fp*Math.cos(angp);
            double newya=newfv*Math.sin(angv)+fp*Math.sin(angp);
            double newxb=newsv*Math.cos(angv)+sp*Math.cos(angp);
            double newyb=newsv*Math.sin(angv)+sp*Math.sin(angp);
            double newanga=Math.atan2(newya, newxa);
            if(newanga<0)
                newanga+=2*Math.PI;
            double newangb=Math.atan2(newyb, newxb);
            if(newangb<0)
                newangb+=2*Math.PI;
            this.theta = newanga;
            b.theta = newangb;
        }
    }
    
    private void wallCollision(Rectangle2D bounds){
        if (x < bounds.getMinX())
        {
            x = bounds.getMinX();
            //dx = -dx;
            if(Math.cos(theta)<0)
                theta=Math.PI-theta;

        }
        if (x + diameter >= bounds.getMaxX())
        {
            x = bounds.getMaxX() - diameter;
            //dx = -dx;
            if(Math.cos(theta)>0)
                theta=Math.PI-theta;
        }
        if (y < bounds.getMinY())
        {
            y = bounds.getMinY();
            //dy = -dy;
            if(Math.sin(theta)<0)
                theta=2*Math.PI-theta;
        }
        if (y + diameter >= bounds.getMaxY())
        {
            y = bounds.getMaxY() - diameter;
            //dy = -dy;
            if(Math.sin(theta)>0)
                theta=2*Math.PI-theta;
        }
    }

    /**
     * Gets the shape of the ball at its current position.
     */
    public Ellipse2D getShape()
    {
        return new Ellipse2D.Double(x, y, diameter, diameter);
    }

    public Color getColor(){
        return color;
    }
    public double getMass() {return mass;}
    public double getSpeed() {return speed;}
}
