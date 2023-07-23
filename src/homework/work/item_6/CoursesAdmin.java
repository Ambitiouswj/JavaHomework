package homework.work.item_6;

import homework.InputErrorCheck;

import java.util.*;

public class CoursesAdmin {
    static Scanner reader = new Scanner(System.in);
//课程操作交互方法
    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("  课程信息管理");
            System.out.println("----------------");
            System.out.println("课程信息添加————1");
            System.out.println("课程信息修改————2");
            System.out.println("课程信息删除————3");
            System.out.println("课程信息查询————4");
            System.out.println("退出———————————0");
            int s = reader.nextInt();
            if (s == 1) {
                addCourse();
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

    public static void addCourse() throws Exception {
        System.out.println("请输入课程名称, 学分（,号隔开）");
        String[] s = (reader.next()).split(",");
        Course course = null;
        String name = s[0];
        double score = Double.parseDouble(s[1]);
        course = new Course(0, name, score);
        CourseDAO.insert(course);
        printCourses(CourseDAO.findCourse(""));
    }

    public static void delete() {
        System.out.println("请输入课程编号：");
        int no = InputErrorCheck.inputIntegerErrorCheck();
        Course s = CourseDAO.getOneByNo(no);
        if (s == null) {
            System.out.println("没有这个课程！");
        } else {
            CourseDAO.delete(no);
        }
        printCourses(CourseDAO.findCourse(""));
    }

    public static void edit() {
        System.out.println("请输入课程编号：");
        int no = InputErrorCheck.inputIntegerErrorCheck();
        Course c = CourseDAO.getOneByNo(no);
        if (c == null) {
            System.out.println("没有这个课程！");
        } else {
            System.out.println("请输入课程名称，学分（，号隔开）");
            String[] s1 = (reader.next()).split(",");
            String name = s1[0];
            double score = Double.parseDouble(s1[1]);
            Course course = new Course(c.getNo(), name, score);
            CourseDAO.update(course);
            printCourses(CourseDAO.findCourse(""));
        }
    }

    public static void search() {
        System.out.println("请输入查询条件");
        reader.nextLine();
        String key = reader.nextLine();
        printCourses(CourseDAO.findCourse(key));
    }

    public static void printCourses(List<Course> results) {
        System.out.println("编号\t\t课程\t\t学分");
        System.out.println("--------------------------------------------------");
        if (results.size() > 0) {
            Iterator<Course> iterator = results.iterator();
            while (iterator.hasNext()) {
                Course s = iterator.next();
                System.out.println(s);
            }
        } else {
            System.out.println("没有课程信息！！");
        }
        System.out.println("--------------------------------------------------");
    }
}