package homework.work.item_4;

import homework.InputErrorCheck;
import java.math.BigInteger;

public class BigIntHandle {
    private BigInteger[] nums;
    public BigIntHandle() {
        this.nums = new BigInteger[10];
    }
    public void inputNums() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("请输入第%2d个数字：", i + 1);
            String str = InputErrorCheck.inputStringErrorCheck();
            nums[i] = new BigInteger(str);
        }
    }
    public void checkBigInteger() {
        inputNums();
        for (BigInteger x : nums) {
            MyPrimeThread checkThread = new MyPrimeThread(x);
            checkThread.start();
        }
        boolean st = true;
        while(true) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (Thread.activeCount() <= 2) {
                System.out.println("判断结束！");
                break;
            }
        }
    }
    public static boolean isPrime(BigInteger integer) {
        for(BigInteger i = new BigInteger("2"); i.compareTo(integer.sqrt()) < 0;
            i = i.add(new BigInteger("1"))) {
            if(integer.mod(i).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }
}

class MyPrimeThread extends Thread {
    private BigInteger myInteger;
    public MyPrimeThread(BigInteger x) {
        this.myInteger = x;
    }
    @Override
    public void run() {
        BigIntHandle bigIntHandle = new BigIntHandle();
        try {
            if (bigIntHandle.isPrime(myInteger)) {
                System.out.println(myInteger + "是素数");
            } else {
                System.out.println(myInteger + "不是素数");
            }
        } catch (Exception e) {
            System.out.println("输入有误！请重新输入：");
            e.printStackTrace();
        }
    }
}