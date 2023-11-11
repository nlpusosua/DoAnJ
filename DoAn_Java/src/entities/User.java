package entities;

public class User {
    private String name;
    private String tele;
    private String address;
    private double bank;

    public User(String name, String tele, String address, double bank) {
        this.name = name;
        this.tele = tele;
        this.address = address;
        this.bank = bank;
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
                "name='" + name + '\'' +
                ", tele='" + tele + '\'' +
                ", address='" + address + '\'' +
                ", bank=" + bank +
                '}';
    }
}
