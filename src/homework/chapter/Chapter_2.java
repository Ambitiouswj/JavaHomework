package homework.chapter;

import homework.InputErrorCheck;
import homework.work.item_1.*;
import homework.work.item_2.*;

public class Chapter_2 {
    public void chooseWork_2() {
        System.out.println();
        System.out.println("第二章作业目录");
        System.out.println("题目1.手机信息录入----------------1");
        System.out.println("题目2.获取最大值最小值、测试方法----2");
        System.out.println("题目3.判断三角形------------------3");
        System.out.println("题目4.打印乘法表------------------4");
        System.out.println("题目5.猜拳游戏--------------------5");
        System.out.println("题目6.打印日历--------------------6");
        System.out.println("题目7.学生成绩管理系统-------------7");
        System.out.println("退出-----------------------------0");
        System.out.print("请选择：");
    }
    public void chapterMenu_2() {
        while (true) {
            chooseWork_2();
            int op= InputErrorCheck.inputIntegerErrorCheck();
            if (op == 0) {
                break;
            } else if (op == 1) {
                Work_1();
            } else if (op == 2) {
                Work_2();
            } else if (op == 3) {
                Work_3();
            } else if (op == 4) {
                Work_4();
            } else if (op == 5) {
                Work_5();
            } else if (op == 6) {
                Work_6();
            } else if (op == 7) {
                Work_7();
            } else {
                System.out.println("无此题目，请重新选择");
                continue;
            }
        }
    }
    private void Work_1() {
        System.out.println("作业2-1.手机信息录入");
        String brand, OS;
        int numOfCPU;
        double price;
        System.out.print("手机品牌：");
        brand = InputErrorCheck.inputStringErrorCheck();
        System.out.print("操作系统：");
        OS = InputErrorCheck.inputStringErrorCheck();
        System.out.print("CPU数：");
        numOfCPU = InputErrorCheck.inputIntegerErrorCheck();
        System.out.print("价格：");
        price = InputErrorCheck.inputDoubleErrorCheck();
        Phone myPhone = new Phone(brand, OS, numOfCPU, price);
        myPhone.printInformationOfPhone();
    }
    private void Work_2() {
        System.out.println("作业2-2.获取最大值最小值、测试方法");

        System.out.printf("byte类型数据总数：%d\n",(int)Byte.MAX_VALUE - (int)Byte.MIN_VALUE + 1);
        System.out.printf("byte的取值范围：%d ~ %d\n",Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("将字符串\"127\"转为byte类型：%d\n",Byte.parseByte("127"));
        System.out.println();
        System.out.println("int的数据总数：" + ((long)Integer.MAX_VALUE - (long)Integer.MIN_VALUE) + 1);
        System.out.printf("int的取值范围：%d ~ %d\n",Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("将字符串\"5000\"转为int类型：%d\n",Integer.parseInt("5000"));
        System.out.println("16转换为2进制：" + Integer.toBinaryString(16));
        System.out.printf("16转换为16进制数：%X\n", 16);
    }
    private void Work_3() {
        System.out.println("作业2-3.判断三角形");
        double a, b, c;
        System.out.print("请输入第一条边长度：");
        a = InputErrorCheck.inputDoubleErrorCheck();
        while (a < 0) {
            System.out.print("输入有误，重新输入：");
            a = InputErrorCheck.inputDoubleErrorCheck();
        }
        System.out.print("请输入第二条边长度：");
        b = InputErrorCheck.inputDoubleErrorCheck();
        while (b < 0) {
            System.out.print("输入有误，重新输入：");
            b = InputErrorCheck.inputDoubleErrorCheck();
        }
        System.out.print("请输入第三条边长度：");
        c = InputErrorCheck.inputDoubleErrorCheck();
        while (c < 0) {
            System.out.print("输入有误，重新输入：");
            c = InputErrorCheck.inputDoubleErrorCheck();
        }
        Triangle myTriangle = new Triangle(a, b, c);
        int flag = myTriangle.checkTriangle();
        if (flag == -1) System.out.println("不构成三角形");
        else if (flag == 0) System.out.println("直角三角形");
        else if (flag == 1) System.out.println("锐角三角形");
        else System.out.println("钝角三角形");
    }
    private void Work_4() {
        System.out.println("作业2-4.打印乘法表");
        System.out.println("1.左上三角");
        System.out.println("2.左下三角");
        System.out.println("3.右上三角");
        System.out.println("4.右下三角");
        System.out.println("5.矩形");
        System.out.println("0.退出");
        while (true) {
            System.out.print("请选择：");
            int choose = InputErrorCheck.inputIntegerErrorCheck();
            if (choose == 0) {
                break;
            } else if (choose == 1) {
                MutiplyTable.printLeftUp();
            } else if (choose == 2) {
                MutiplyTable.printLeftDown();
            } else if (choose == 3) {
                MutiplyTable.printRightUp();
            } else if (choose == 4) {
                MutiplyTable.printRightDown();
            } else if (choose == 5) {
                MutiplyTable.printAll();
            } else {
                System.out.println("无此选项！");
                continue;
            }
        }
    }
    private void Work_5() {
        System.out.println("作业2-5.猜拳游戏");
        MoraGame.playGame();
    }
    private void Work_6() {
        System.out.println("作业2-6.打印日历");
        MyCalendar myCalendar_2 = new MyCalendar();
        myCalendar_2.printCalendar();
    }
    private void Work_7() {
        System.out.println("作业2-7.学生成绩管理系统");
        GradeAdmin myGradeAdmin = new GradeAdmin();
        myGradeAdmin.show();
    }
}