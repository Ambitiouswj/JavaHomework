package homework;

import homework.chapter.*;

public class Menu {
    public static void chooseChapter() {
        System.out.println();
        System.out.println("章节目录");
        System.out.println("第一章----1");
        System.out.println("第二章----2");
        System.out.println("第三章----3");
        System.out.println("第四章----4");
        System.out.println("第五章----5");
        System.out.println("第六章----6");
        System.out.println("退出------0");
        System.out.print("请选择章节：");
    }
    public static void showChapterMenu() {
        while (true) {
            chooseChapter();
            int op = InputErrorCheck.inputIntegerErrorCheck();
            if (op == 0) {
                break;
            } else if (op == 1) {
                Chapter_1 ch1 = new Chapter_1();
                ch1.chapterMenu_1();
            } else if (op == 2) {
                Chapter_2 ch2 = new Chapter_2();
                ch2.chapterMenu_2();
            } else if (op == 3) {
                Chapter_3 ch3 = new Chapter_3();
                ch3.chapterMenu_3();
            } else if (op == 4) {
                Chapter_4 ch4 = new Chapter_4();
                ch4.chapterMenu_4();
            } else if (op == 5) {
                Chapter_5 ch5 = new Chapter_5();
                ch5.chapterMenu_5();
            } else if (op == 6) {
                Chapter_6 ch6 = new Chapter_6();
                ch6.chapterMenu_6();
            } else {
                System.out.println("无此章节，请重新选择");
                continue;
            }
        }
    }
}
