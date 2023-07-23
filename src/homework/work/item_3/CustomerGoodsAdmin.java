package homework.work.item_3;

import homework.InputErrorCheck;

import java.util.*;

public class CustomerGoodsAdmin {
    private Customer[] customers;
    int numOfCustomers;

    public CustomerGoodsAdmin() {
        customers = new Customer[10002];
        this.numOfCustomers = 0;
    }

    public CustomerGoodsAdmin(int numOfCustomers) {
        customers = new Customer[numOfCustomers];
        this.numOfCustomers = numOfCustomers;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public int getNumOfCustomers() {
        return numOfCustomers;
    }

    public void setNumOfCustomers(int numOfCustomers) {
        this.numOfCustomers = numOfCustomers;
    }

    public void showMenu() {
        System.out.println();
        System.out.println("*************************");
        System.out.println("*\t客户信息录入-----1\t*");
        System.out.println("*\t查询客户信息-----2\t*");
        System.out.println("*\t打印客户信息-----3\t*");
        System.out.println("*\t退出系统--------0\t*");
        System.out.println("*************************");
    }

    public void show() {
        while (true) {
            showMenu();
            System.out.print("请选择：");
            int op = InputErrorCheck.inputIntegerErrorCheck();
            if (op == 0) break;
            else if (op == 1) {
                inputCustomerInfo();
            } else if (op == 2) {
                findCustomer();
            } else if (op == 3) {
                print();
            } else {
                System.out.println("无此选项，请重新输入！");
                continue;
            }
        }
    }

    public void inputCustomerInfo() {
        System.out.print("请输入客户数：");
        int num = InputErrorCheck.inputIntegerErrorCheck();
        for (int i = 0; i < num; i++) {
            System.out.println("客户" + (++numOfCustomers));
            System.out.print("请输入客户姓名：");
            String name = InputErrorCheck.inputStringErrorCheck();
            System.out.print("请输入客户年龄：");
            int age = InputErrorCheck.inputIntegerErrorCheck();
            System.out.print("请输入客户所购买的货物种类数：");
            int numOfGoodTypes = InputErrorCheck.inputIntegerErrorCheck();
            customers[numOfCustomers] = new Customer(name, age, numOfGoodTypes);
        }
    }

    public void findCustomer() {
        System.out.print("请输入客户姓名：");
        Scanner reader = new Scanner(System.in);
        String posName = reader.nextLine();
        if (posName.equals(" ")) {
            print();
            return;
        }
        boolean flag = false;
        for (int i = 1; i <= numOfCustomers; i++) {
            if (posName.equals(customers[i].getName())) {
                flag = true;
                customers[i].print();
            }
        }
        if (!flag) {
            System.out.println("查无此人！");
        }
    }

    public void print() {
        System.out.println("------------------------------------------");
        for (int i = 1;i <= numOfCustomers; i++) {
            customers[i].print();
        }
        System.out.println("------------------------------------------");
    }
}
