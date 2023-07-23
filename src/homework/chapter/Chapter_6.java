package homework.chapter;

import homework.InputErrorCheck;

public class Chapter_6 {
    public void chooseWork_6() {
        System.out.println();
        System.out.println("第六章作业目录");
        System.out.println("题目1.学生选课与成绩管理系统----1");
        System.out.print("请选择：");
    }
    public void chapterMenu_6() {
        while (true) {
            chooseWork_6();
            int op = InputErrorCheck.inputIntegerErrorCheck();
            if (op == 0) {
                break;
            } else if (op == 1) {
                Work_1();
            } else {
                System.out.println("无此题目，请重新选择");
                continue;
            }
        }
    }
    private void Work_1() {
        System.out.println("作业6-1.学生选课与成绩管理系统");
    }
}
