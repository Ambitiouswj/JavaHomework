package homework.work.item_2;

import homework.InputErrorCheck;
import java.util.*;

public class GradeAdmin {
    private List<Grade> scores;
    private int numOfStudents;

    public GradeAdmin() {
        this.numOfStudents = 0;
        scores = new ArrayList<>();
    }

    public List<Grade> getScores() {
        return scores;
    }

    public void setScores(List<Grade> scores) {
        this.scores = scores;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }

    public void showMenu() {
        System.out.println();
        System.out.println("*********************");
        System.out.println("*\t成绩录入-----1\t*");
        System.out.println("*\t学生成绩打印--2\t*");
        System.out.println("*\t打印总成绩----3\t*");
        System.out.println("*\t成绩排序-----4\t*");
        System.out.println("*\t退出系统-----0\t*");
        System.out.println("*********************");
    }

    public void show() {
        while (true) {
            showMenu();
            int op = InputErrorCheck.inputIntegerErrorCheck();
            if (op == 0) break;
            else if (op == 1) {
                addGrade();
            } else if (op == 2) {
                printGrade();
            } else if (op == 3) {
                printAllGrade();
            } else if (op == 4) {
                rank();
            } else {
                System.out.println("无此选项，请重新输入！");
                continue;
            }
        }
    }
    public void addGrade() {
        System.out.print("请输入学生数量：");
        int num = InputErrorCheck.inputIntegerErrorCheck();

        for (int i = 1; i <= num; i++) {
            System.out.println("学生" + i);
            System.out.print("请输入姓名：");
            String name = InputErrorCheck.inputStringErrorCheck();
            System.out.print("请输入Java成绩：");
            double scoreOfJava = InputErrorCheck.inputDoubleErrorCheck();
            System.out.print("请输入SQL成绩：");
            double scoreOfSql = InputErrorCheck.inputDoubleErrorCheck();
            System.out.print("请输入Html成绩：");
            double scoreOfHtml = InputErrorCheck.inputDoubleErrorCheck();
            Grade newGrade = new Grade(name,scoreOfJava,scoreOfSql,scoreOfHtml);
            scores.add(newGrade);
            numOfStudents++;
        }
    }

    public void rank() {
        while (true) {
            System.out.print("请选择升序或降序（1.升序，2.降序，3.退出）：");
            int choose = InputErrorCheck.inputIntegerErrorCheck();
            if (choose == 1) {
                sortUp();
                break;
            }
            else if (choose == 2) {
                sortDown();
                break;
            } else {
                System.out.println("无此选项，请重新选择！");
                continue;
            }
        }
    }

    private void sortUp() {
        scores.sort(new Comparator<Grade>() {
            @Override
            public int compare(Grade o1, Grade o2) {
                if (o1.getSum() < o2.getSum()) return -1;
                else if (o1.getSum() > o2.getSum()) return 1;
                else {
                    if (o1.getScoreOfJava() < o2.getScoreOfJava()) return -1;
                    else if (o1.getScoreOfJava() > o2.getScoreOfJava()) return 1;
                    else {
                        if (o1.getScoreOfSql() < o2.getScoreOfSql()) return -1;
                        else if(o1.getScoreOfSql() > o2.getScoreOfSql()) return 1;
                        else {
                            if (o1.getScoreOfHtml() < o2.getScoreOfHtml()) return -1;
                            else if(o1.getScoreOfHtml() > o2.getScoreOfHtml()) return 1;
                            else return 0;
                        }
                    }
                }
            }
        });
    }

    private void sortDown() {
        scores.sort(new Comparator<Grade>() {
            @Override
            public int compare(Grade o1, Grade o2) {
                if (o1.getSum() > o2.getSum()) return -1;
                else if (o1.getSum() < o2.getSum()) return 1;
                else {
                    if (o1.getScoreOfJava() > o2.getScoreOfJava()) return -1;
                    else if (o1.getScoreOfJava() < o2.getScoreOfJava()) return 1;
                    else {
                        if (o1.getScoreOfSql() > o2.getScoreOfSql()) return -1;
                        else if(o1.getScoreOfSql() < o2.getScoreOfSql()) return 1;
                        else {
                            if (o1.getScoreOfHtml() > o2.getScoreOfHtml()) return -1;
                            else if(o1.getScoreOfHtml() < o2.getScoreOfHtml()) return 1;
                            else return 0;
                        }
                    }
                }
            }
        });
    }
    public void printGrade () {
        if (scores.size() == 0) {
            System.out.println("暂无学生！");
            return;
        }
        System.out.print("请输入姓名：");
        String posName = InputErrorCheck.inputStringErrorCheck();
        boolean flag = false;
        for (Grade item : scores) {
            if (item.getName().equals(posName)) {
                flag = true;
                System.out.println("姓名 \tJava\tSQL \tHtml\t总分 \t平均分");
                System.out.print(item.getName() + " \t");
                System.out.printf("%.1f\t", item.getScoreOfJava());
                System.out.printf("%.1f\t", item.getScoreOfSql());
                System.out.printf("%.1f\t", item.getScoreOfHtml());
                System.out.printf("%.1f\t", item.getSum());
                System.out.printf("%.1f\n", item.getAvg());
            }
        }
        if (!flag) {
            System.out.println("查无此人！");
        }
    }
    public void printAllGrade () {
        if (scores.size() == 0) {
            System.out.println("暂无学生！");
            return;
        }
        System.out.println("姓名 \tJava\tSQL \tHtml\t总分 \t平均分");
        for (Grade item : scores) {
            System.out.print(item.getName() + " \t");
            System.out.printf("%.1f\t", item.getScoreOfJava());
            System.out.printf("%.1f\t", item.getScoreOfSql());
            System.out.printf("%.1f\t", item.getScoreOfHtml());
            System.out.printf("%.1f\t", item.getSum());
            System.out.printf("%.1f\n", item.getAvg());
        }
    }
}
