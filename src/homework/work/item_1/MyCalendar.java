package homework.work.item_1;

import homework.InputErrorCheck;
import java.util.*;

public class MyCalendar {
    public void printCalendar() {
        System.out.print("请输入年份：");
        int year = InputErrorCheck.inputIntegerErrorCheck();
        int month;
        while (true) {
            System.out.print("请输入月份：");
            month = InputErrorCheck.inputIntegerErrorCheck();
            if (month < 1 || month > 12) {
                System.out.println("您输入的月份无效，请重新输入！");
                continue;
            }
            else break;
        }
        System.out.println("--------------------------");
        System.out.println("\t\t" + year + "年" + month + "月");
        System.out.println("--------------------------");
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        int w = getWeek(year, month, 1);
        for (int i = 1; i < w; i++) {
            System.out.print("\t");
        }
        int num = getDayNum(year, month);
        for (int i = 1; i <= num; i++) {
            if (getWeek(year, month, i) == 7) System.out.printf("%2d\n", i);
            else System.out.printf("%2d\t", i);
        }
        System.out.println();
        System.out.println("--------------------------");
        System.console();
    }
    public void printYearCalender() {

    }
    private int getWeek(int y, int m, int d) {
        Calendar cal = new GregorianCalendar(y, m - 1, d);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    private int getDayNum(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) return 31;
        else if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
        else {
            if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) return 29;
            else return 28;
        }
    }
}
