<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: 赵应朗
  Date: 2022/3/4
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑品牌</title>
</head>
<body>
    <h3>编辑品牌</h3>

    <form action="/brand_demo/UpdataServlet" method="post" name="brand">

        <input type="hidden" name="id" value="${brand.id}">
    <label>品牌名称</label> <input name="brandname" value="${brand.brand_name}"><br>
    <label>企业名称</label> <input name="companyname" value="${brand.company_name}"><br>
    <label>排序</label> <input name="ordered" value="${brand.ordered}"><br>
    <label>描述</label> <textarea cols="20" rows="5" name="description"  >${brand.description}</textarea><br>
    <label>状态</label>
    <input type="radio" name="status" value="1">  启用
    <input type="radio" name="status" value="0" checked>  禁用<br>

    <input type="submit"><br>

</form>






</body>
</html>