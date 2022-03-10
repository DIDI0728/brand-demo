<%--
  Created by IntelliJ IDEA.
  User: 赵应朗
  Date: 2022/3/5
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>


<div align="middle" >
    <form action="/brand_demo/LoginServlet" method="post" >


        <label>${Error_Msg} ${RegisterSuccess_msg} ${Login_Msg}</label><br>
        <label>
            username<br>
            <input name="username" value="${cookie.username.value}"><br>
        </label><br>
        <label>
            password<br>
            <input name="password" value="${cookie.password.value}"><br>
        </label><br>

        <input type="submit" value="登录"><br>

       Remember me?<input type="radio" name="IfRemember" value="remember" ><br>
        <a href="/brand_demo/Register.jsp">没有账号？创建一个...</a><br>
    </form>

</div>

</body>
</html>
