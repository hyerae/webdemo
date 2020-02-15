package service;

import pojo.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getAll();
    public int insert(Student student);
    public int delete(String sno);
    public Student getOneBySno(String sno);
    public int update(Student student);
}
