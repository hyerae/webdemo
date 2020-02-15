package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 具有处理请求的能力 成为一个servlet  类（servlet组件）
// 类 处理请求 放在tomcat服务器上（servlet容器 ---> 容纳servlet组件）
public class Test extends HttpServlet{
    //初始化
    @Override
    public void init(ServletConfig config) throws ServletException{
        // 第一次创建对象，赋值，初始化
        // 第一次访问时，对象进行创建，并且初始化
        System.out.println("对象进行了初始化!");
    }

   // 处理哪一个请求
    @Override
    protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        // 不用手动调用，自动调用  service
        // main：入口函数
        // 发送、创建请求对象，请求request 跟请求相关内容
        // response 响应对象，浏览器
        System.out.println("This is a request");
        System.out.println(req.getServerPort());
        System.out.println(req.getServerName());
        System.out.println(req.getProtocol());

        // 服务器向浏览器响应内容，以流的方式
        // resp：将内容响应到浏览器上
        PrintWriter writer = resp.getWriter();
        writer.println("This is Yuan!");
        req.getRequestDispatcher("a.jsp").forward(req,resp);
    }

    @Override
    public void destroy() { // 一个销毁的过程
        // 关闭服务器，销毁对象
        System.out.println("对象销毁!");
    }

    // 对象创建到销毁的过程 ---> 对象的生命周期， servlet 生命周期
    // 类 加载服务器， init() service() destroy()
    // 类 对象

}
