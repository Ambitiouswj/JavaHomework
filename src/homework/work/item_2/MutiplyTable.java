package homework.work.item_2;

public class MutiplyTable {
    public static void printLeftUp() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9 - i + 1; j++) {
                System.out.printf("%d *%2d =%2d\t", i, j, i * j);
            }
            System.out.println();
        }
    }
    public static void printLeftDown() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d *%2d =%2d\t", i, j, i * j);
            }
            System.out.println();
        }
    }
    public static void printRightUp() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j < i) System.out.printf("            ");
                else System.out.printf("%d *%2d =%2d\t", i, j, i * j);
            }
            System.out.println();
        }
    }
    public static void printRightDown() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j <= 9 - i) System.out.printf("            ");
                else System.out.printf("%d *%2d =%2d\t", i, j, i * j);
            }
            System.out.println();
        }
    }
    public static void printAll() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d *%2d =%2d\t", i, j, i * j);
            }
            System.out.println();
        }
    }
}
