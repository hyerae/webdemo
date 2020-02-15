package test;

import pojo.Student;
import utils.JdbcUtil;
import utils.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class JdbcTest {
    public static void main(String[] args) {

/*
        String sql = "select * from student";

        List<Student> list = JdbcUtil.executeQuery(sql,new RowMap() {
            @Override
            public Object RowMapping(ResultSet rs) {
                Student student = new Student();
                try {
                    student.setSno(rs.getString("Sno"));
                    student.setSname(rs.getString("Sname"));
                    student.setSage(rs.getInt("Sage"));
                    student.setSsex(rs.getString("Ssex"));
                    student.setDept(rs.getString("Dept"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return student;
            }
        });
        for (Student s:list
        ) {
            System.out.println(s);
        }
    }*/

        String sql = "update student set sname=?,sage=?,ssex=?,dept=? where sno=? ";
        Student student = new Student();
        student.setSno("100013");
        student.setSname("qwee");
        student.setSage(13);
        student.setSsex("女");
        student.setDept("计算机");
        JdbcUtil.executeUpdate(sql, student.getSname(), student.getSage(), student.getSsex(), student.getDept(),student.getSno());

    }

}
