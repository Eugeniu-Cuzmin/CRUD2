<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
    </head>
    <body>
        <h1>Edit</h1>
        <div style="width: 900px; margin-left: auto; margin-right: auto">
            <c:forEach items="${getNewsById}" var="p">
                <form action="jsp/ManagerEditPost.jsp" method="post">
                    <input type="hidden" name="id" value="${p.id}">
                    Name<br>
                    <input type="text" value="${p.name}" name="name" style="width: 200px"><br>
                    Address<br>
                    <input type="text" value="${p.address}" name="address" style="width: 200px"><br>
                    Age<br>
                    <input type="text" value="${p.age}" name="age" style="width: 200px"><br>
                    <input type="submit" value="Submit">
                </form>
            </c:forEach>

        </div>
    </body>
</html>
