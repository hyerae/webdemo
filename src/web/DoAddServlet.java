package web;

import pojo.Student;
import service.IStudentService;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoAddServlet extends HttpServlet {

    private IStudentService service = new StudentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* form 地址  submit  有form表单中的参数，只要是跟请求相关的在request中 */
        String sno = req.getParameter("sno");
        String sname = req.getParameter("sname");
        Integer sage = Integer.parseInt(req.getParameter("sage"));
        String ssex = req.getParameter("ssex");
        String dept = req.getParameter("dept");
       /* 添加的数据 */
        Student s = new Student();
        s.setSno(sno);
        s.setSname(sname);
        s.setSage(sage);
        s.setSsex(ssex);
        s.setDept(dept);
        service.insert(s);
        // 重定向  插入完成后，列表页，显示全部数据
        resp.sendRedirect("all");

        // 表单（输入数据，input -> name） --> 重新发送请求，携带参数（action） --> dao  service web --> 重定向
    }
}
