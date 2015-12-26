import java.util.Random;

/**
 * Created by yue on 2/19/2015.
 */
public class Circle {
    //Properties
    //1.mass
    private double mass;//range:0-10
    //2.radius of the circle
    public int radius;//range:20-35
    //3.position
    public int x, y;//range:x:100-500, y:100-400
    //4.velocity
    private int dx, dy;//range:-1 or 1
    private int speed;

    Circle(int aSpeed){
        Random r = new Random();
        mass = r.nextDouble()*10;
        radius = r.nextInt(15)+20;
        x = r.nextInt(400)+100; y = r.nextInt(300)+100;
        dx = r.nextInt(2); dy = r.nextInt(2);
        if(dx == 0) {dx = -1;}
        if(dy == 0) {dy = -1;}
        speed = aSpeed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public void nextSec(){
        x += dx*speed;
        y += dy*speed;
    }

    //collision test for two circles and change velocity vector accordingly
    public static void ballCollision(Circle c1, Circle c2){
        if((c1.dx>=0&&c2.dx>=0 || c1.dx<0&&c2.dx<0) && ((c1.dy>=0&&c2.dy<0 || c1.dy<0&&c2.dy>=0))){
            c1.dy = -c1.dy;
            c2.dy = -c2.dy;
        }
        else if((c1.dx>=0&&c2.dx<0 || c1.dx<0&&c2.dx>=0) && ((c1.dy>=0&&c2.dy>=0 || c1.dy<0&&c2.dy<0))){
            c1.dx = -c1.dx;
            c2.dx = -c2.dx;
        }
        else if((c1.dx>=0&&c2.dx<0 || c1.dx<0&&c2.dx>=0) && ((c1.dy>=0&&c2.dy<0 || c1.dy<0&&c2.dy>=0))){
            c1.dx = -c1.dx;
            c2.dx = -c2.dx;
            c1.dy = -c1.dy;
            c2.dy = -c2.dy;
        }
        else{
            c1.dx += c2.dx;
            c2.dx = c1.dx - c2.dx;
            c1.dx -= c2.dx;
            c1.dy += c2.dy;
            c2.dy = c1.dy - c2.dy;
            c1.dy -= c2.dy;
        }
    }
    //collision test for circle-and-wall and change velocity vector accordingly
    public void wallCollision(int edge){
        switch (edge){
            case 1:
                dy = -dy;
                break;
            case 2:
                dy = -dy;
                break;
            case 3:
                dx = -dx;
                break;
            case 4:
                dx = -dx;
                break;
            case 5:
                dx = -dx;
                dy = -dy;
                break;
        }
    }

    //check distance for 2 circles collision
    public static boolean distanceDetection(Circle c1, Circle c2){
        double distance = Math.sqrt(Math.pow((c1.x-c2.x), 2) + Math.pow((c1.y-c2.y), 2));
        if(distance <= c1.radius+c2.radius){
            return true;
        }
        else {
            return false;
        }
    }
    //check distance for circle and wall collision
    //return value represents the edge it collide with
    public int wallDetection(int wallx, int wally){
        if(Math.abs(x-0) <= radius){
            if(Math.abs(y-0) <= radius+50)
                return 5;
            else if(Math.abs(wally-y) <= radius)
                return 5;
            else
                return 3;
        }
        else if(Math.abs(wallx-x) <= radius){
            if(Math.abs(y-0) <= radius+50)
                return 5;
            else if(Math.abs(wally-y) <= radius)
                return 5;
            else
                return 4;
        }
        else if(Math.abs(y-0) <= radius+50)
            return 1;
        else if(Math.abs(wally-y) <= radius)
            return 2;
        else
            return 0;
    }
}
