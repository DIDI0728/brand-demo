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
    <title>注册页面</title>
</head>
<body>


<div align="middle" >
    <form action="/brand_demo/RegisterServlet" method="post" >


        <label>${RegFailMsg}</label><br>
        <label>
            username<br>
            <input name="username" ><br>
        </label><br>
        <label>
            password<br>
            <input name="password"><br>
        </label><br>

        <input type="submit" value="创建"><br>

    </form>

</div>

</body>
</html>
