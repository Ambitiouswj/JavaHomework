package homework.chapter;

import homework.InputErrorCheck;
import homework.work.item_4.BigIntHandle;
import homework.work.item_4.MultiTask;
import homework.work.item_4.StudentsAdmin;
import homework.work.item_4.WareHouse;

public class Chapter_4 {
    public void chooseWork_4() {
        System.out.println();
        System.out.println("第四章作业目录");
        System.out.println("题目1.判断大整数是否为素数----1");
        System.out.println("题目2.仓库出货系统-----------2");
        System.out.println("题目3.工作任务模拟-----------3");
        System.out.println("题目4.学生信息管理系统-------4");
        System.out.println("退出------------------------0");
        System.out.print("请选择：");
    }
    public void chapterMenu_4() {
        while (true) {
            chooseWork_4();
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
            } else {
                System.out.println("无此题目，请重新选择");
                continue;
            }
        }
    }
    private void Work_1() {
        System.out.println("作业4-1.判断大整数是否为素数");
        BigIntHandle bigIntHandle = new BigIntHandle();
        bigIntHandle.checkBigInteger();
    }
    private void Work_2() {
        System.out.println("作业4-2.仓库出货系统");
        WareHouse.init();
        WareHouse.operate();
    }
    private void Work_3() {
        System.out.println("作业4-3.工作任务模拟");
        MultiTask multiTask = new MultiTask();
        multiTask.takeTasks();
    }
    private void Work_4() {
        System.out.println("作业4-4.学生信息管理系统");
        StudentsAdmin sa1 = new StudentsAdmin();
        sa1.show();
    }
}

