package web;

import pojo.Student;
import service.IStudentService;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoUpdateServlet extends HttpServlet {

    private IStudentService service = new StudentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student student = new Student();
        student.setSno(req.getParameter("sno"));
        student.setSname(req.getParameter("sname"));
        student.setSage(Integer.parseInt( req.getParameter("sage")));
        student.setSsex(  req.getParameter("ssex"));
        student.setDept( req.getParameter("dept"));
        service.update(student);
        resp.sendRedirect("all"); // 重定向到"all"页面
    }
}
