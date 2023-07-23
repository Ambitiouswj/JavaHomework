package homework.work.item_4;

import homework.InputErrorCheck;
import java.util.*;

public class StudentsAdmin {
    private List<Student> MyStudents;

    public StudentsAdmin() {
        MyStudents = new ArrayList<>();
    }

    public void menu() {
        System.out.println("-----学生信息管理-----");
        System.out.println("---------------------");
        System.out.println("学生信息添加---------1");
        System.out.println("学生信息修改---------2");
        System.out.println("学生信息删除---------3");
        System.out.println("学生信息查询---------4");
        System.out.println("学生信息打印---------5");
        System.out.println("退出----------------0");
    }

    public void show() {

        while (true) {
            menu();
            int op = InputErrorCheck.inputIntegerErrorCheck();
            if (op == 0) {
                break;
            } else if (op == 1) {
                addStudents();
            } else if (op == 2) {
                alterStudent();
            } else if (op == 3) {
                deleteStudent();
            } else if (op == 4) {
                findStdents();
            } else if (op == 5) {
                print();
            } else {
                System.out.println("无此选项，请重新输入：");
                continue;
            }
        }
    }

    public void addStudents() {
        while (true) {
            System.out.print("请输入学号：");
            int no;
            while (true) {
                boolean flag = false;
                no = InputErrorCheck.inputIntegerErrorCheck();
                for (Student theStudent: MyStudents) {
                    if (theStudent.getNo() == no) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) break;
                else System.out.println("已存在该学生，请重新输入：");
            }
            System.out.print("请输入姓名：");
            String name = InputErrorCheck.inputStringErrorCheck();
            System.out.print("请输入年龄：");
            int age = InputErrorCheck.inputIntegerErrorCheck();
            System.out.print("请输入专业：");
            String major = InputErrorCheck.inputStringErrorCheck();
            MyStudents.add(new Student(no, name, age, major));
            System.out.print("是否继续添加（1.是，2.否）：");
            int op;
            while (true) {
                op = InputErrorCheck.inputIntegerErrorCheck();
                if (op == 1 || op == 2) break;
                else System.out.println("无此选项，请重新输入：");
            }
            if (op == 2) break;
        }
    }

    public void findStdents() {
        System.out.print("请选择查询方式（1.学号，2.姓名）：");
        while (true) {
            int op = InputErrorCheck.inputIntegerErrorCheck();
            if (op == 1) {
                findStdentsByNo();
                break;
            }
            else if (op == 2) {
                findStdentsByName();
                break;
            }
            else System.out.print("无此选项，请重新输入：");
        }
    }

    public Student findStdentsByNo() {
        boolean flag = false;
        System.out.print("请输入学号：");
        int posNo = InputErrorCheck.inputIntegerErrorCheck();
        for (Student theStudent : MyStudents) {
            if (theStudent.getNo() == posNo) {
                flag = true;
                System.out.println("查询到1位学生");
                System.out.println("学号\t姓名\t年龄\t专业");
                System.out.println(theStudent);
                return theStudent;
            }
        }
        if (!flag) {
            System.out.println("查无此人！");
        }
        return null;
    }

    public void findStdentsByName() {
        List<Student> res = new ArrayList<>();
        System.out.print("请输入姓名：");
        String posName = InputErrorCheck.inputStringErrorCheck();
        for (Student theStudent : MyStudents) {
            if (theStudent.getName().equals(posName)) {
                res.add(theStudent);
            }
        }
        if (res.size() == 0) {
            System.out.println("查无此人！");
            return;
        }
        System.out.printf("查询到%d位学生\n", res.size());
        System.out.println("学号\t姓名\t年龄\t专业");
        for (Student theStudent : res) {
            System.out.println(theStudent);
        }
    }

    public void alterStudent() {
        boolean flag = false;
        System.out.print("请输入学号：");
        int posNo = InputErrorCheck.inputIntegerErrorCheck();
        for (Student theStudent : MyStudents) {
            if (theStudent.getNo() == posNo) {
                flag = true;
                System.out.println("查询到1位学生");
                System.out.println("学号\t姓名\t年龄\t专业");
                System.out.println(theStudent);
                System.out.print("是否进行修改（1.是，2.否）？");
                while (true) {
                    int op = InputErrorCheck.inputIntegerErrorCheck();
                    if (op == 1) {
                        System.out.print("请输入学号：");
                        int no = InputErrorCheck.inputIntegerErrorCheck();
                        theStudent.setNo(no);
                        System.out.print("请输入姓名：");
                        String name = InputErrorCheck.inputStringErrorCheck();
                        theStudent.setName(name);
                        System.out.print("请输入年龄：");
                        int age = InputErrorCheck.inputIntegerErrorCheck();
                        theStudent.setAge(age);
                        System.out.print("请输入专业：");
                        String major = InputErrorCheck.inputStringErrorCheck();
                        theStudent.setMajor(major);
                        System.out.println("修改成功！");
                    }
                    else if (op == 2) {
                        System.out.println("放弃修改");
                        break;
                    }
                    else System.out.print("无此选项，请重新输入：");
                }
            }
        }
        if (!flag) {
            System.out.println("查无此人！");
        }
    }

    public void deleteStudent() {
        boolean flag = false;
        System.out.print("请输入学号：");
        int posNo = InputErrorCheck.inputIntegerErrorCheck();
        for (Student theStudent : MyStudents) {
            if (theStudent.getNo() == posNo) {
                flag = true;
                System.out.println("查询到1位学生");
                System.out.println("学号\t姓名\t年龄\t专业");
                System.out.println(theStudent);
                System.out.print("是否进行删除（1.是，2.否）？");
                while (true) {
                    int op = InputErrorCheck.inputIntegerErrorCheck();
                    if (op == 1) {
                        MyStudents.remove(theStudent);
                        System.out.println("删除成功！");
                    }
                    else if (op == 2) {
                        System.out.println("取消删除");
                        break;
                    }
                    else System.out.print("无此选项，请重新输入：");
                }
            }
        }
        if (!flag) {
            System.out.println("查无此人！");
        }
    }

    public void print() {
        if (MyStudents.size() == 0) {
            System.out.println("暂无学生！");
            return;
        }
        System.out.printf("共有%d位学生\n", MyStudents.size());
        for (Student theStudent : MyStudents) {
            System.out.println(theStudent);
        }
    }
}
