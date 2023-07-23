package homework.work.item_1;

public class Staff {
    private int no;
    private String name;
    private int sex;
    private int age;
    private String department;

    public Staff() {
        this.no = 0;
        this.name = "0";
        this.sex = 0;
        this.age = 0;
        this.department = "0";
    }

    public Staff(int no, String name, int sex, int age, String department) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.department = department;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}