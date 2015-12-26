/**
 * Created by yue on 2/18/2015.
 */
// Class Sphere. Implements Shape3D. Represents a perfect sphere.
public class Sphere implements Shape3D{
    private double radius;
    Sphere(double aRadius){
        radius = aRadius;
    }

    @Override
    public double getArea() {
        double area = 4*Math.PI* Math.pow(radius,2);
        return area;
    }

    @Override
    public double getVolume() {
        double volume = 4*Math.PI* Math.pow(radius,3)/3;
        return volume;
    }

    @Override
    public String toString() {
        String info = String.format("The radius of this sphere = %.1f", radius);
        return info;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Sphere && ((Sphere) obj).radius==radius){
            return true;
        }
        else{
            return false;
        }
    }
}
