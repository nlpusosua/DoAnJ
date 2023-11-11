package entities;

public class House {
    private static int autoId;
    private int id;
    private String address;
    private double area;
    private String interior;
    private double price;

    public House(String address, double area, String interior, double price) {
        this.id = ++autoId;
        this.address = address;
        this.area = area;
        this.interior = interior;
        this.price = price;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        House.autoId = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", interior='" + interior + '\'' +
                ", price=" + price +
                '}';
    }
}
