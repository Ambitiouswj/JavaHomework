package homework.work.item_3;

import homework.InputErrorCheck;

public class Customer {
    private String name;
    private int age;
    private Goods[] good;
    private int numOfGoodTypes;
    private double total;

    public Customer(String name, int age, int numOfGoodTypes) {
        this.name = name;
        this.age = age;
        this.numOfGoodTypes = numOfGoodTypes;
        this.good = new Goods[numOfGoodTypes + 1];
        for (int i = 1; i <= numOfGoodTypes; i++) {
            System.out.println("货物" + i);
            System.out.print("请输入货物名称：");
            String nameOfGood = InputErrorCheck.inputStringErrorCheck();
            System.out.print("请输入货物数量：");
            int numOfGoods = InputErrorCheck.inputIntegerErrorCheck();
            System.out.print("请输入货物单价：");
            double price = InputErrorCheck.inputDoubleErrorCheck();
            good[i] = new Goods(nameOfGood, numOfGoods, price);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Goods[] getGood() {
        return good;
    }

    public void setGood(Goods[] good) {
        this.good = good;
    }

    public int getNumOfGoodTypes() {
        return numOfGoodTypes;
    }

    public void setNumOfGoodTypes(int numOfGoodTypes) {
        this.numOfGoodTypes = numOfGoodTypes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void print() {
        System.out.println("姓名：" + name + "\t年龄：" + age);
        System.out.println("------------------------------------------");
        for (int i = 1; i <= numOfGoodTypes; i++) {
            System.out.print("品名：" + good[i].getName() + "\t");
            System.out.print("单价：" + good[i].getPrice() + "\t");
            System.out.print("购买数量：" + good[i].getNum() + "\t");
            System.out.print("总计：" + good[i].getTotalPrice() + "\n");
        }
    }
}
