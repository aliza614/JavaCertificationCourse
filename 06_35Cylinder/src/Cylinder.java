public class Cylinder extends Circle{
    private double height;


    public Cylinder(double radius, double height) {
        super(radius);
        this.height = Math.max(0.0, height);

    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return height*this.getArea();
    }

}
