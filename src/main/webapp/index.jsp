<%--
  Created by IntelliJ IDEA.
  User: Eldarian
  Date: 09.12.2019
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userbank</title>
</head>
<body>
    <%@ page import="com.eldarian.userbanklist.service.*" %>
    <%
        Service service = new ServiceImpl();
        String richestUserName = "Richest user";
        String accountsSum = "Accounts sum";
        if (request.getParameter("needRichest") != null && request.getParameter("needRichest").equals("true")) {
            richestUserName = service.getRichestUser();
        }
        if(request.getParameter("needAccountSum") !=null && request.getParameter("needAccountSum").equals("true")) {
            accountsSum = Integer.toString(service.getAccountsSum());
        }
    %>
    <form id="getForm" method="get" action="">
        <div id="richest" style="width: 200px; height: 20px; border: solid black 1px; float: left">
            <%=richestUserName%>
        </div>
        <button type="submit" name="needRichest" value="true">Get</button>

        <br>

        <div id="accountsum" style="width: 200px; height: 20px; border: solid black 1px; float: left">
            <%=accountsSum%>
        </div>
        <button type="submit" name="needAccountSum" value="true">Get</button>
    </form>
</body>
</html>
