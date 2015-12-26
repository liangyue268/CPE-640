/**
 * Created by yue on 2/18/2015.
 */
//Client to test them all!
public class Shape3D_Client {
    public static void main(String[] args) {
        Sphere mySphere = Sphere.getInstance();
        System.out.print("\nThis is a sphere. ");

        System.out.printf("Area = %.2f", mySphere.getArea());
        System.out.printf(". Volume = %.2f\n", mySphere.getVolume());
        System.out.println("Output calling the method printInfo - polymorphism at work!");
        printInfo(mySphere);
        System.out.println("------------------------------------------");
        }

    public static void printInfo(Shape3D s) {
        System.out.println(s);
        System.out.printf("Area = %.2f", s.getArea());
        System.out.printf(". Volume = %.2f\n", s.getVolume());
    }
}
