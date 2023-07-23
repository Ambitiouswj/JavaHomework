package homework.work.item_4;

import java.util.*;

public class WareHouse {
    public static int[] wares;
    public static void init() {
        wares = new int[101];
        for (int i = 0; i <= 100; i++) {
            wares[i] = 1000;
        }
    }
    public static void operate() {
        SellThread s1 = new SellThread();
        for (int i = 1; i <= 3; i++) {
            Thread t1 = new Thread(s1);
            t1.setName("销售点" + i);
            t1.start();
        }
        CheckThread c1 = new CheckThread();
        new Thread(c1).start();
        while (true) {
            if (Thread.activeCount() <= 2) {
                System.out.println("售货结束！");
                break;
            }
        }
    }
    public static void sell() {
        Random random = new Random();
        int no = random.nextInt(100) + 1;
        int num = random.nextInt(1000) + 1;
        if (wares[no] < num) {
            System.out.printf("货物%3d 数量不足，正在补货中……\n", no);
            add(no);
        }
        wares[no] -= num;
        System.out.printf("货物%3d 卖出%4d 件，剩余 %4d 件\n", no, num, wares[no]);
    }
    public static void add(int no) {
        wares[no] += 1000;
        System.out.printf("货物%3d 成功补货 %4d 件，剩余 %4d 件\n", no, 1000, wares[no]);
    }
}

class SellThread implements Runnable {
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis()-startTime > 2e5) break;
            WareHouse.sell();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class CheckThread implements Runnable {
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - startTime > 2e4) break;
            for (int i = 1; i <= 100; i++) {
                if (WareHouse.wares[i] <= 20) {
                    AddThread at = new AddThread(i);
                    new Thread(at).start();
                }
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class AddThread implements Runnable {
    int no;

    public AddThread(int no) {
        this.no = no;
    }
    @Override
    public void run() {
        WareHouse.add(no);
    }
}