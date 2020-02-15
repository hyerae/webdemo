package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// servlet 生命周期  类加载过程init()  service() destroy()
public class Demo extends HttpServlet{

    // 服务器启动时，对象初始化  执行init()方法中的内容 在服务器启动时执行
    // 对象初始化  值初始化 ------> username、admin
    // 对象的创建-----> 发送第一次请求时------>创建对象，对象初始化（等待时间较长）
    // 启动服务器(将对象创建)-----> 把对象进行提前创建，初始化----> 用户访问（节省一点时间）
    // 服务器启动变慢 ----> 管理员等待时间较长 ----> 用户不用等待
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(config.getServletName());
        System.out.println(config.getInitParameter("username"));
        System.out.println("Demo 初始化过程!");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 入口方法，逻辑代码
        // 涉及中文---> 修改编码集  response默认编码集：ISO-8859-1---> 不能解析中文
        // resp.setCharacterEncoding("utf-8"); // 将response默认编码集修改为中文utf-8，此步骤只是设置response的编码集，无法设置html中的
        resp.setContentType("text/html; charset=utf-8"); // 设置往外响应的文档类型----->html,再将html编码集设置为utf-8
        PrintWriter writer = resp.getWriter();
        writer.write("中文响应!");

        // 网页页面进行行与行的拼接----> jsp(拼接页面)，在web下jsp可以直接被访问
        // 将servlet的数据data放入jsp中显示
        String str = "ServletData";
        req.setAttribute("test",str);

        // jsp进行页面拼接，servlet进行转发（转发"文件"类型--->必须在当前项目中），响应给浏览器
        // 一次请求，浏览器地址不会发生变化，request请求对象的行为
//        req.getRequestDispatcher("myjsp.jsp").forward(req,resp);

        // 重定向：把请求转出，发起二次请求，浏览器地址栏发生变化，两个request、response对象，重定向到地址--->response的行为
        resp.sendRedirect("a");
        // 从servlet（逻辑代码）到jsp（页面）跳转的过程

        System.out.println("请求ing");

        // 可以把数据库中的数据进行读取，并把数据转到页面中进行显示
        // java ---> mysql ---> javaweb ---> jsp ---> 数据在前台页面输出显示

    }

    @Override
    public void destroy() {
        System.out.println("销毁ing");
    }
}
