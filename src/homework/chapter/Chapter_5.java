package homework.chapter;

import homework.InputErrorCheck;
import homework.work.item_5.DownloadPicture;
import homework.work.item_5.FileReadAndWrite;
import homework.work.item_5.WeatherSearch;

public class Chapter_5 {
    public void chooseWork_5() {
        System.out.println();
        System.out.println("第五章作业目录");
        System.out.println("题目1.读取和写入txt文件----1");
        System.out.println("题目2.下载图片------------2");
        System.out.println("题目3.天气查询-------------3");
        System.out.println("退出----------------------0");
        System.out.print("请选择：");
    }
    public void chapterMenu_5() {
        while (true) {
            chooseWork_5();
            int op= InputErrorCheck.inputIntegerErrorCheck();
            if (op == 0) {
                break;
            } else if (op == 1) {
                Work_1();
            } else if (op == 2) {
                Work_2();
            } else if (op == 3) {
                Work_3();
            } else {
                System.out.println("无此题目，请重新选择");
                continue;
            }
        }
    }
    private void Work_1() {
        System.out.println("作业4-1.读取和写入txt文件");
        FileReadAndWrite.readAndWrite();
    }
    private void Work_2() {
        DownloadPicture.startDownload();
    }
    private void Work_3() {
        System.out.println("作业4-3.天气查询");
        WeatherSearch.showWeather();
    }
}
