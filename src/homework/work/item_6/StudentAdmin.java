package homework.work.item_6;

import homework.InputErrorCheck;
import java.util.*;

public class StudentAdmin {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("  学生信息管理");
            System.out.println("----------------");
            System.out.println("学生信息添加————1");
            System.out.println("学生信息修改————2");
            System.out.println("学生信息删除————3");
            System.out.println("学生信息查询————4");
            System.out.println("退出———————————0");
            int s = InputErrorCheck.inputIntegerErrorCheck();
            if (s == 1) {
                addStudent();
            } else if (s == 3) {
                delete();
            } else if (s == 2) {
                edit();
            } else if (s == 4) {
                search();
            } else if (s == 0) {
                break;
            }
        }
    }
//学生信息的新增
    public static void addStudent() throws Exception {
        System.out.println("请输入学生姓名, 专业（,号隔开）");
        String[] s = (reader.next()).split(",");
        Student student = null;
        String name = s[0];
        String major = s[1];
        student = new Student(0, name, major);
        StudentDAO.insert(student);
        printStudents(StudentDAO.findStudent(""));
    }
//学生信息的删除
    public static void delete() {
        System.out.println("请输入学生编号：");
        int no = reader.nextInt();
        Student s= StudentDAO.getOneByNo(no);
        if (s == null) {
            System.out.println("没有这个学生！");
        } else {
            StudentDAO.delete(no);
        }
        printStudents(StudentDAO.findStudent(""));
    }
//一个学生信息的编辑
    public static void edit() {
        System.out.println("请输入学生编号：");
        int no = reader.nextInt();
        Student s= StudentDAO.getOneByNo(no);
        if (s == null) {
            System.out.println("没有这个学生！");
        } else {
            System.out.println("请输入学生姓名，专业（，号隔开）");
            String[] s1 = (reader.next()).split(",");
            s.setName(s1[0]);
            s.setMajor(s1[1]);
            StudentDAO.update(s);
            printStudents(StudentDAO.findStudent(""));
        }
    }
//学生信息的查询显示
    public static void search() {
        System.out.println("请输入查询条件:");
        //输入空格查询所有
        reader.nextLine(); //用一个nextLine消除前一个输入后面的回车
        String key = reader.nextLine();
        printStudents(StudentDAO.findStudent(key));
    }
//学生信息的打印显示
    public static void printStudents(List<Student> results) {
        System.out.println("编号\t\t姓名\t\t专业");
        System.out.println("--------------------------------");
        if (results.size() > 0) {
            Iterator<Student> iterator=results.iterator();
            while(iterator.hasNext()) {
                Student s=iterator.next();
                System.out.println(s);
            }
        } else {
            System.out.println("没有学生信息！！");
        }
        System.out.println("--------------------------------");
    }
}
