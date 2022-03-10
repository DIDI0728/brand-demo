package Web.user;

import Pojo.User;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private  final UserService userService =new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password=req.getParameter("password");
        String ifRemember = req.getParameter("IfRemember");


        User user = userService.select(username, password);

        if(user==null){
            req.setAttribute("Error_Msg","用户名或密码错误！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else {
//            Cookie cookie = new Cookie("username",username);
//            cookie.setMaxAge(7*24*60);
//            resp.addCookie(cookie);
            //将数据存入Request域中，转发到下一个Servlet,再存，再转发到jsp页面，麻烦。。。

            //采用Session 一次会话中多次请求共享数据
//            req.setAttribute("username",username);
//            req.getRequestDispatcher("/SelectAllServlet").forward(req,resp);

            if(Objects.equals(ifRemember, "remember")){

                Cookie cookie1 = new Cookie("username",username);
                cookie1.setMaxAge(60*60);
                Cookie cookie2 = new Cookie("password",password);
                cookie2.setMaxAge(60*60);

                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
            }

            HttpSession session = req.getSession();
            session.setAttribute("user",user);

            resp.sendRedirect("/brand_demo/SelectAllServlet");

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
