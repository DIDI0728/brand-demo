package Web.user;

import Pojo.User;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private  final UserService userService =new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        if(userService.select(username,password)==null){
            userService.add(user);
            req.setAttribute("RegisterSuccess_msg","注册成功，请登录！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else {
            String RegFailMsg="创建失败！用户已存在。。";
            req.setAttribute("RegFailMsg",RegFailMsg);
            req.getRequestDispatcher("/Register.jsp").forward(req,resp);

        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
