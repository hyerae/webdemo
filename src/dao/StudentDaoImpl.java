package dao;

import pojo.Student;
import utils.JdbcUtil;
import utils.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements IStudentDao{
    @Override
    public List<Student> getAll() {
        return JdbcUtil.executeQuery("select * from student", new RowMap<Student>() {
            @Override
            public Student RowMapping(ResultSet rs) {
                Student student = new Student();
                try {
                    student.setSno(rs.getString("sno"));
                    student.setSname(rs.getString("sname"));
                    student.setSsex(rs.getString("ssex"));
                    student.setSage(rs.getInt("sage"));
                    student.setDept(rs.getString("dept"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return student;
            }
        },null);
    }

    @Override
    public int insert(Student student) {
        return JdbcUtil.executeUpdate(
                "insert into student(sno, sname, ssex, sage, dept) values(?,?,?,?,?)",
                student.getSno(), student.getSname(), student.getSsex(), student.getSage(), student.getDept());
    }

    @Override
    public int delete(String sno) {
        return JdbcUtil.executeUpdate(
                "delete from student where sno=?",sno
        );
    }

    @Override
    public Student getOneBySno(String sno) {
        return JdbcUtil.queryOne("select * from student where sno = ?", new RowMap<Student>() {
            @Override
            public Student RowMapping(ResultSet rs) {
                Student student = new Student();
                try {
                    student.setSno(sno);
                    student.setSname(rs.getString("sname"));
                    student.setSsex(rs.getString("ssex"));
                    student.setSage(rs.getInt("sage"));
                    student.setDept(rs.getString("dept"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return student;
            }
        }, sno);
    }

    @Override
    public int update(Student student) {
        return JdbcUtil.executeUpdate(
                " update student set sname=?,ssex=?,sage=?,dept=? where sno=?",
                student.getSname(), student.getSsex(), student.getSage(), student.getDept(), student.getSno()
        );
    }

}
