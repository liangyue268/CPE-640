/**
 * Created by yue on 2/19/2015.
 */
// Class CircularShape. Implements Shape3D. ABSTRACT CLASS --> no objects of this type!
// An abstract superclass for shapes with a circular cross-section.
public abstract class CircularShape implements Shape3D{
    protected double radius;

    @Override
    public double getArea() {
        return 0.0;
    }

    @Override
    public double getVolume() {
        return 0.0;
    }

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object obj);
}
