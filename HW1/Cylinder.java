/**
 * Created by yue on 2/19/2015.
 */
// Class Cylinder, subclass of CircularShapeWithHeight Represents a cylinder shape.
public class Cylinder extends CircularShapeWithHeight{
    Cylinder(double aRadius, double aHeight){
        radius = aRadius;
        height = aHeight;
    }

    @Override
    public double getArea() {
        double area = 2*Math.PI*Math.pow(radius, 2) + 2*Math.PI*radius*height;
        return area;
    }

    @Override
    public double getVolume() {
        double volume = Math.PI*Math.pow(radius, 2)*height;
        return volume;
    }

    @Override
    public String toString() {
        String info = String.format("For this cylinder the radius = %.1f and the height = %.1f", radius, height);
        return info;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cylinder && ((Cylinder) obj).radius == radius && ((Cylinder) obj).height == height){
            return true;
        }
        else{
            return false;
        }
    }
}
