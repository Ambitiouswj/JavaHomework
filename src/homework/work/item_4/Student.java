package homework.work.item_4;

public class Student {
    private int no;
    private String name;
    private int age;
    private String major;

    public Student() {
        this.no = 0;
        this.name = "";
        this.age = 0;
        this.major = "";
    }

    public Student(int no, String name, int age, String major) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.major = major;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        String ans = no + "\t" + name +"\t" + age + "\t" + major;
        return ans;
    }
}
