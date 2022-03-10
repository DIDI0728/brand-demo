package Web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//
//@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        String[] urls={"/login.jsp","Register.jsp","LoginError.jsp","RegisterSuccess.jsp","LoginServlet","RegisterServlet"};

        String url = req.getRequestURL().toString();
        for (String s : urls) {
            if(url.contains(s)){
                filterChain.doFilter(servletRequest,servletResponse);

                return;

            }

        }


        if(user!=null){
            filterChain.doFilter(servletRequest,servletResponse);

        }else {
            req.setAttribute("Login_Msg","您尚未登录！");
            req.getRequestDispatcher("/login.jsp").forward(req,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
