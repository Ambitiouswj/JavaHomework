package homework.work.item_2;

public class Phone {
    private String brand;
    private String OS;
    private int numOfCPU;
    private double price;
    public Phone() {
        this.brand = "0";
        this.OS = "0";
        this.numOfCPU = 0;
        this.price = 0.0;
    }
    public Phone(String brand, String OS, int numOfCPU, double price) {
        this.brand = brand;
        this.OS = OS;
        this.numOfCPU = numOfCPU;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getNumOfCPU() {
        return numOfCPU;
    }

    public void setNumOfCPU(int numOfCPU) {
        this.numOfCPU = numOfCPU;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void printInformationOfPhone() {
        System.out.println("手机品牌：" + brand);
        System.out.println("操作系统：" + OS);
        System.out.printf("CPU数：%d\n", numOfCPU);
        System.out.printf("价格：%.1f\n", price);
    }
}
