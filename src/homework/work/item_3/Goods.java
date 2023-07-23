package homework.work.item_3;

public class Goods {
    private String name;
    private int num;
    private double price;
    private double totalPrice;

    public Goods() {
        this.name = "";
        this.num = 0;
        this.price = 0.0;
        this.totalPrice = 0.0;
    }

    public Goods(String name, int num, double price) {
        this.name = name;
        this.num = num;
        this.price = price;
        this.totalPrice = num * price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
