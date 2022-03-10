package Web.brand;

import Pojo.Brand;
import Service.BrandService;
import com.alibaba.fastjson.JSON;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet("/SelectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private final BrandService brandService=new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        for (Cookie cookie : request.getCookies()) {
//            if("username".equals(cookie.getName()))
//                request.setAttribute("username",cookie.getValue());
//        }

//        Object username = request.getAttribute("username");
//

        request.setCharacterEncoding("UTF-8");
        List<Brand> brands = brandService.selectAll();

        String jsonString= JSON.toJSONString(brands);

        System.out.println(jsonString);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
//        response.sendRedirect("/Brands.html");


//        request.setAttribute("brands",brands);
//
//        request.getRequestDispatcher("/Brands.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
