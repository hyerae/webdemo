package web;

import pojo.Student;
import service.IStudentService;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {

    private IStudentService service = new StudentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String sno = req.getParameter("sno");
       /* 根据sno 查询出对应的对象 */
       /* 带到下一个要修改的页面中*/
        Student student = service.getOneBySno(sno);
        req.setAttribute("stu", student);
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }
}
