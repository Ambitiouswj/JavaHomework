package homework.chapter;

import homework.work.item_1.*;
import java.util.*;

public class Chapter_1 {
    public void chooseWork_1() {
        System.out.println();
        System.out.println("第一章作业目录");
        System.out.println("题目1.打印日历-------1");
        System.out.println("题目2.人事管理系统----2");
        System.out.println("退出-----0");
        System.out.print("请选择：");
    }
    public void chapterMenu_1() {
        Scanner reader = new Scanner(System.in);
        while (true) {
            chooseWork_1();
            int op= reader.nextInt();
            if (op == 0) {
                break;
            } else if (op == 1) {
                Work_1();
            } else if (op == 2) {
                Work_2();
            } else {
                System.out.println("无此题目，请重新选择");
                continue;
            }
        }
    }
    private void Work_1() {
        System.out.println("题目1-1.打印日历");
        MyCalendar myCalendar_1 = new MyCalendar();
        myCalendar_1.printCalendar();
    }
    private void Work_2() {
        System.out.println("题目1-2.人事管理系统");
        Personnel person_1 = new Personnel();
        person_1.showMenu();
    }
}
