package homework.work.item_1;

import java.util.*;

public class Personnel {
    private int numOfStaff;
    private List<Staff> myStaffs;

    public Personnel() {
        this.numOfStaff = 0;
        this.myStaffs = new ArrayList<>();
    }

    public int getNumOfStaff() {
        return numOfStaff;
    }

    public void choose() {
        System.out.println();
        System.out.println("*****************");
        System.out.println("*\t添加用户--1\t*");
        System.out.println("*\t查询用户--2\t*");
        System.out.println("*\t退出系统--0\t*");
        System.out.println("*****************");
    }
    public void showMenu() {
        System.out.println();
        System.out.println("*****************");
        System.out.println("*\t人事管理系统\t*");
        System.out.println("*****************");
        Scanner sc = new Scanner(System.in);
        while (true) {
            choose();
            int op = sc.nextInt();
            if (op == 0) {
                break;
            } else if (op == 1) {
                addStaff();
            } else if (op == 2) {
                findStaff();
            } else {
                System.out.println("无此选项，请重新选择");
                continue;
            }
        }
    }
    public void addStaff() {
        Scanner reader = new Scanner(System.in);
        System.out.print("请输入员工编号：");
        int no = reader.nextInt();

        System.out.print("请输入员工姓名：");
        String name = reader.next();

        System.out.print("请选择员工性别（1.男 2.女）：");
        int sex = reader.nextInt();

        System.out.print("请输入员工年龄：");
        int age = reader.nextInt();

        System.out.print("请输入员工所属部门：");
        String department = reader.next();

        Staff newStaff = new Staff(no, name, sex, age, department);
        myStaffs.add(newStaff);
        numOfStaff ++;
        System.out.println("添加成功！");
    }

    public void findStaff() {
        if (myStaffs.size() == 0) {
            System.out.println("暂无人员");
            return;
        }
        System.out.println("请选择查找依据（1.编号 2.姓名）：");
        Scanner reader = new Scanner(System.in);
        while (true) {
            int wayOfFind = reader.nextInt();
            if(wayOfFind == 1) {
                boolean flag = false;
                System.out.print("请输入编号：");
                int posNo = reader.nextInt();
                for (Staff theStaff : myStaffs) {
                    if (posNo == theStaff.getNo()) {
                        flag = true;
                        System.out.println("\t查询到此人");
                        System.out.println("编号\t姓名\t性别\t年龄\t部门");
                        System.out.print(theStaff.getNo()+"\t");
                        System.out.print(theStaff.getName()+"\t");
                        if (theStaff.getSex() == 1) System.out.print("男\t");
                        else System.out.print("女\t");
                        System.out.print(theStaff.getAge()+"\t");
                        System.out.println(theStaff.getDepartment());
                    }
                }
                if (!flag) System.out.println("查无此人！");
                break;
            } else if (wayOfFind == 2) {
                System.out.print("请输入姓名：");
                String posName = reader.next();
                List<Staff> posStaffs = new ArrayList<>();
                for (Staff theStaff : myStaffs) {
                    if (posName.equals(theStaff.getName())) {
                        posStaffs.add(theStaff);
                    }
                }
                if (posStaffs.size() == 0) System.out.println("查无此人！");
                else {
                    System.out.println("    查询到" + posStaffs.size() + "人");
                    System.out.println("编号\t姓名\t性别\t年龄\t部门");
                    for (Staff theStaff : posStaffs) {
                        System.out.print(theStaff.getNo()+"\t");
                        System.out.print(theStaff.getName()+"\t");
                        if (theStaff.getSex() == 1) System.out.print("男\t");
                        else System.out.print("女\t");
                        System.out.print(theStaff.getAge()+"\t");
                        System.out.println(theStaff.getDepartment());
                    }
                }
                break;
            } else {
                System.out.println("无此选项，请重新选择！");
                continue;
            }
        }
    }
    public void printStaffList() {
        System.out.println("   共有" + numOfStaff + "人");
        System.out.println("编号\t姓名\t性别\t年龄\t部门");
        for (Staff theStaff : myStaffs) {
            System.out.print(theStaff.getNo()+"\t");
            System.out.print(theStaff.getName()+"\t");
            if (theStaff.getSex() == 1) System.out.print("男\t");
            else System.out.print("女\t");
            System.out.print(theStaff.getAge()+"\t");
            System.out.println(theStaff.getDepartment());
        }
    }
}
