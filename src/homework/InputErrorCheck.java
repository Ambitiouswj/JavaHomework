package homework;

import java.util.*;

public class InputErrorCheck {
    public static int inputIntegerErrorCheck() {
        Scanner in = new Scanner(System.in);
        while(!in.hasNextInt()) {
            System.out.print("输入有误，重新输入：");
            in.nextLine();
        }
        return in.nextInt();
    }

    public static double inputDoubleErrorCheck() {
        Scanner in = new Scanner(System.in);
        while(!in.hasNextDouble()) {
            System.out.print("输入有误，重新输入：");
            in.nextLine();
        }
        return in.nextDouble();
    }

    public static String inputStringErrorCheck() {
        Scanner in = new Scanner(System.in);
        while(!in.hasNext()) {
            System.out.print("输入有误，重新输入：");
            in.nextLine();
        }
        return in.next();
    }
}
