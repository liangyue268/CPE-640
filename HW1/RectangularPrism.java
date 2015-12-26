/**
 * Created by yue on 2/19/2015.
 */
// Class RectangularPrism. Implements Shape3D Represents a three-dimensional rectangular shape.
public class RectangularPrism implements Shape3D{
    protected double length, width, height;
    RectangularPrism(double aLength, double aWidth, double aHeight){
        length = aLength;
        width = aWidth;
        height = aHeight;
    }

    @Override
    public double getArea() {
        double area = 2*length*width + 2*length*height + 2*width*height;
        return area;
    }

    @Override
    public double getVolume() {
        double volume = length*width*height;
        return volume;
    }

    @Override
    public String toString() {
        String info = String.format("For this rectangular prism the base has the length = %.1f and the width = %.1f\n" +
                "The height of the prism = %.1f", length, width, height);
        return info;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RectangularPrism && ((RectangularPrism) obj).height == height
                && ((RectangularPrism) obj).width == width && ((RectangularPrism) obj).length == length){
            return true;
        }
        else{
            return  false;
        }
    }
}