package homework.work.item_4;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Worker {
    private Queue<CallBack> taskQueue;
    public static final Lock lock = new ReentrantLock();
    public Worker() {
        this.taskQueue = new ArrayDeque<>();
    }

    public void Working() {
        for (long startTime = System.currentTimeMillis(); System.currentTimeMillis() - startTime <= 20000; lock.unlock()) {
            while (this.taskQueue.isEmpty()) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            lock.lock();
            CallBack back = (CallBack)this.taskQueue.poll();
            int second = (int)(Math.random() * 10.0) + 1;
            try {
                Thread.sleep(500);
                back.finishTask(second);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void receiveTask(CallBack back) {
        lock.lock();
        this.taskQueue.add(back);
        lock.unlock();
    }
}