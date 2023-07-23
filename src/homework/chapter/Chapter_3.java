package homework.chapter;

import homework.InputErrorCheck;
import homework.work.item_3.CustomerGoodsAdmin;

public class Chapter_3 {
    public void chooseWork_3() {
        System.out.println();
        System.out.println("第三章作业目录");
        System.out.println("题目1.客户选购信息管理系统----1");
        System.out.println("退出-----------------------0");
        System.out.print("请选择：");
    }
    public void chapterMenu_3() {
        while (true) {
            chooseWork_3();
            int op= InputErrorCheck.inputIntegerErrorCheck();
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
        System.out.println("作业3-1.客户选购信息管理系统");
        CustomerGoodsAdmin cga1 = new CustomerGoodsAdmin();
        cga1.show();
    }
}
