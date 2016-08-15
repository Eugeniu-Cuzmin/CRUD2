<%@page import="dao.DataAccess"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String ages = request.getParameter("age");
            int age = Integer.parseInt(ages);
            Student n = new Student(0, name, address, age);
            DataAccess da = new DataAccess();
            da.addNew(n);
            
            response.sendRedirect("../AllPost");
        %>
        
    </body>
</html>

