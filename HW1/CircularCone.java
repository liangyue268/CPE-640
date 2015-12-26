/**
 * Created by yue on 2/19/2015.
 */
// Class CircularCone, subclass of CircularShapeWithHeight //Represents cones with a circular base.
public class CircularCone extends CircularShapeWithHeight{
    CircularCone(double aRadius, double aHeight){
        radius = aRadius;
        height = aHeight;
    }

    @Override
    public double getArea() {
        double area = Math.PI*radius*Math.sqrt(Math.pow(radius, 2)+ Math.pow(height, 2)) + Math.PI*Math.pow(radius, 2);
        return area;
    }

    @Override
    public double getVolume() {
        double volume = Math.PI* Math.pow(radius, 2)*height/3;
        return volume;
    }

    @Override
    public String toString() {
        String info = String.format("For this circular cone the radius = %.1f and the height = %.1f"
        , radius, height);
        return info;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CircularCone && ((CircularCone) obj).radius == radius && ((CircularCone) obj).height == height){
            return true;
        }
        else{
            return false;
        }
    }
}
