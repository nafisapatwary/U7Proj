public class Package {
    private Address origin;
    private Address destination;
    private double weight;
    private double length;
    private double height;
    private double width;


    public Package(Address o, Address d, double lbs, double l, double h, double w){
        this.origin = o;
        this.destination = d;
        this.weight = lbs;
        this.length = l;
        this.height = h;
        this.width = w;
    }

    public Address getOrigin() {
        return origin;
    }

    public void setOrigin(Address origin) {
        this.origin = origin;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
