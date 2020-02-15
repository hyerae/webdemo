package web;

import pojo.Student;
import service.IStudentService;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetStudentServlet extends HttpServlet {

    private IStudentService service = new StudentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 把数据库中的全部数据进行查询，显示在页面上
        // jdbc拿数据  ---> service逻辑处理 ---> web数据显示
        List<Student> stus = service.getAll();

        // 集合 ----> 页面显示
        // 数据显示：printWriter() 拼接标签
        // jsp 模板技术，固定的内容   文字（servlet）
        // servlet 连接 jsp：转发，给jsp进行页面显示；
        // 在servlet中向jsp绑定数据----request
        req.setAttribute("stus",stus);
        req.getRequestDispatcher("all.jsp").forward(req,resp);

        // 页面上出入数据，在后台进行接收（servlet），向数据库插入这条数据（web）--> service --> dao(通过dao层进行数据库插入)
        // 在页面上点击，页面跳转（a标签进行跳转<a href="">文字</a>），数据的输入
        // 自己的项目页面中：地址---> servlet ---> jsp
        // 数据的输入：input

        // 作用域： 有效的作用范围: pageContext --> request --> session --> application (从小到大，只限当前文档)

    }
}
