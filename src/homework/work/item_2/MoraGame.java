package homework.work.item_2;

import homework.InputErrorCheck;

import java.util.*;

public class MoraGame {
    public static void playGame() {
        Random randNum = new Random();
        System.out.print("请输入游戏轮数：");
        String[] s = {"石头", "剪刀", "布"};
        int roundOfGame = InputErrorCheck.inputIntegerErrorCheck();
        for (int i = 1; i <= roundOfGame; i++) {
            System.out.printf("第%d轮游戏\n", i);
            int x = randNum.nextInt(3);
            System.out.println("请选择（0.石头，1.剪刀，2.布）：");
            int choose = InputErrorCheck.inputIntegerErrorCheck();
            while (choose < 0 || choose > 2) {
                System.out.print("无此选项！\n请重新输入：");
                choose = InputErrorCheck.inputIntegerErrorCheck();
            }
            int res = check(x, choose);
            System.out.println("电脑的选择：" + s[x]);
            System.out.println("你的选择：" + s[choose]);
            if (res == -1) System.out.println("你输了！");
            else if (res == 1) System.out.println("你赢了！");
            else System.out.println("平局.");
        }
    }

    private static int check(int computer, int player) {
        if (computer == 2 && player == 0 || player - computer == 1) return -1;
        else if (computer == player) return 0;
        else return 1;
    }
}
