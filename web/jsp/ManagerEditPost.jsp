<%-- 
    Document   : ManagerEditPost
    Created on : Aug 8, 2015, 11:10:38 PM
    Author     : Thang
--%>

<%@page import="dao.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
    </head>
    <body>
        <%
            String idTemp = request.getParameter("id");
            int id = Integer.parseInt(idTemp);
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String ageTemp = request.getParameter("age");
            int age = Integer.parseInt(ageTemp);
            
            DataAccess da = new DataAccess();
            da.edit(id, name, address, age);
            
            response.sendRedirect("../AllPost");
        %>
    </body>
</html>
