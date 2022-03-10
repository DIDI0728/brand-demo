package Web.brand;

import Pojo.Brand;
import Service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
    private final BrandService brandService=new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
//        int id=Integer.parseInt(request.getParameter("id"));
        String brand_name=request.getParameter("brandname");
        String company_name=request.getParameter("companyname");
        String description=request.getParameter("description");
        int  ordered=Integer.parseInt(request.getParameter("ordered"));
        int  status=Integer.parseInt(request.getParameter("status"));


        Brand brand = new Brand();
        brand.setBrand_name(brand_name);
        brand.setCompany_name(company_name);
        brand.setOrdered(ordered);
        brand.setStatus(status);
        brand.setDescription(description);


        brandService.add(brand);
        request.getRequestDispatcher("/SelectAllServlet").forward(request,response);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
