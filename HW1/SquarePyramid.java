/**
 * Created by yue on 2/18/2015.
 */
// Class SquarePyramid. Implements Shape3D Represents a pyramid with a square as its base.
public class SquarePyramid implements Shape3D{
    private double length, height;
    SquarePyramid(double aLength, double aHeight){
        length = aLength;
        height = aHeight;
    }

    @Override
    public double getArea() {
        double squareArea = length*length;
        double triangleArea = length*Math.sqrt(Math.pow(height,2)+Math.pow(length,2)/4)/2;
        return squareArea + 4*triangleArea;
    }

    @Override
    public double getVolume() {
        double squareArea = length*length;
        double volume = squareArea*height/3;
        return volume;
    }

    @Override
    public String toString() {
        String info = String.format("For this square pyramid the base has the length = %.1f and the height = %.1f", length, height);
        return info;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SquarePyramid && ((SquarePyramid) obj).height==height && ((SquarePyramid) obj).length==length){
            return true;
        }
        else{
            return false;
        }
    }
}