<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 赵应朗
  Date: 2022/3/3
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Brands</title>
</head>
<body>

<h1>${user.username},欢迎您!!!</h1>

<br>

<hr>
<input type="button" value="新增" id="add">

<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>

    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr>

            <td>${status.count}</td>
            <td>${brand.brand_name}</td>
            <td>${brand.company_name}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status==1}">
                <td>启用</td>
            </c:if>
            <c:if test="${brand.status!=1}">
                <td>禁用</td>
            </c:if>

            <td><a href="/brand_demo/SelectByIdServlet?id=${brand.id}" >修改</a>   <a href="/brand_demo/DeleteServlet?id=${brand.id}" >删除</a></td>
        </tr>


    </c:forEach>


</table>


<script>
    document.getElementById("add").onclick=function (){
        location.href="AddBrand.html";
    }

</script>

</body>
</html>
