package pojo;

import java.util.Objects;

public class Student {
    private String sno;
    private String sname;
    private String ssex;
    private  Integer sage;
    private String dept;

    public String getSno() {
        return sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", dept='" + dept + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getSno(), student.getSno()) &&
                Objects.equals(getSname(), student.getSname()) &&
                Objects.equals(getSsex(), student.getSsex()) &&
                Objects.equals(getSage(), student.getSage()) &&
                Objects.equals(getDept(), student.getDept());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSno(), getSname(), getSsex(), getSage(), getDept());
    }
}
