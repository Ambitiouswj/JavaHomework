package homework.work.item_6;

import homework.InputErrorCheck;


public class Student {
    static int count=0;
    private String name;
    private int no;
    private String major;

    public Student(int no,String name,String major) {
        this.no = no;
        this.name = name;
        this.major = major;
    }

    public Student() throws Exception{
        // TODO Auto-generated constructor stub
        System.out.println("输入学生姓名：");
        String name = InputErrorCheck.inputStringErrorCheck();
        System.out.println("输入学生专业：");
        String major = InputErrorCheck.inputStringErrorCheck();
        count ++;
        this.no = count;
        this.major = major;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String toString() {
        return this.no + "\t\t" + this.name + "\t\t" + this.major;
    }
}