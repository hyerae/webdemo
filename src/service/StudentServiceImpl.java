package service;

import dao.IStudentDao;
import dao.StudentDaoImpl;
import pojo.Student;

import java.util.List;

public class StudentServiceImpl implements  IStudentService{
    private IStudentDao dao = new StudentDaoImpl();
    @Override
    public List<Student> getAll() {
        return dao.getAll();
    }

    @Override
    public int insert(Student student) {
        return dao.insert(student);
    }

    @Override
    public int delete(String sno) {
        return dao.delete(sno);
    }

    @Override
    public Student getOneBySno(String sno) {
        return dao.getOneBySno(sno);
    }

    @Override
    public int update(Student student) {
        return dao.update(student);
    }
}
