/**
 * Created by yue on 2/19/2015.
 */
// Class Cube, subclass of RectangularPrism Represents a perfect cube.
public class Cube extends RectangularPrism{
    Cube(double aLength){
        super(aLength,aLength,aLength);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double getVolume() {
        return super.getVolume();
    }

    @Override
    public String toString() {
        String info = String.format("For this cube all sides = %.1f", super.length);
        return info;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cube && ((Cube) obj).length == length){
            return true;
        }
        else {
            return false;
        }
    }
}