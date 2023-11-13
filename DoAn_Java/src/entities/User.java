package entities;

public class User {
    private static int autoId;
    private int id;
    private String name;
    private int age;
    private String tele;
    private String address;
    private double bank=0;

    public User( String name, int age, String tele, String address, double bank) {
        this.id = ++autoId;
        this.name = name;
        this.age = age;
        this.tele = tele;
        this.address = address;
        this.bank = bank;
    }

    public User(String name, int age, String tele, String address) {
    }

    public User() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        User.autoId = autoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBank() {
        return bank;
    }

    public void setBank(double bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", tele='" + tele + '\'' +
                ", address='" + address + '\'' +
                ", bank=" + bank +
                '}';
    }
}
