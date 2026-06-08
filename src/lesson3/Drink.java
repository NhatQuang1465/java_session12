package lesson3;

public abstract class Drink implements IPromotion {

    private String id;
    private String name;
    private double price;

    public Drink(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void applyDiscount(double percentage) {
        price = price - (price * percentage / 100);
    }

    public abstract void prepare();

    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Tên món: " + name);
        System.out.println("Giá: " + price);
    }
}