package homework.work.item_2;

public class Grade {
    private String name;
    private double scoreOfJava;
    private double scoreOfSql;
    private double scoreOfHtml;
    private double sum;
    private double avg;

    public Grade() {
        this.name = "";
        this.scoreOfJava = 0;
        this.scoreOfSql = 0;
        this.scoreOfHtml = 0;
        this.sum = 0;
        this.avg = 0;
    }
    public Grade(String name, double scoreOfJava, double scoreOfSql, double scoreOfHtml) {
        this.name = name;
        this.scoreOfJava = scoreOfJava;
        this.scoreOfSql = scoreOfSql;
        this.scoreOfHtml = scoreOfHtml;
        this.sum = scoreOfJava + scoreOfSql + scoreOfHtml;
        this.avg = sum / 3.0;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getScoreOfJava() { return scoreOfJava; }

    public void setScoreOfJava(double scoreOfJava) { this.scoreOfJava = scoreOfJava; }

    public double getScoreOfSql() { return scoreOfSql; }

    public void setScoreOfSql(double scoreOfSql) { this.scoreOfSql = scoreOfSql; }

    public double getScoreOfHtml() { return scoreOfHtml; }

    public void setScoreOfHtml(double scoreOfHtml) { this.scoreOfHtml = scoreOfHtml; }

    public double getSum() { return sum; }

    public void setSum(double sum) { this.sum = sum; }

    public double getAvg() { return avg; }

    public void setAvg(double avg) { this.avg = avg; }
}
