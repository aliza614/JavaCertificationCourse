public class Floor {
    private double width, length;

    public Floor(double width, double length) {
        this.width = Math.max(0.0, width);
        this.length = Math.max(0.0, length);
    }

    public double getArea() {
        return width*length;
    }
}
