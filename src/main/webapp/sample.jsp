<%--
  Created by IntelliJ IDEA.
  User: anezbudi
  Date: 4/14/2021
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>T</title>
    </head>
    <body>
        <h2>Persons</h2>
        <table>
            <tr>
                <th>id</th>
                <th>name</th>
            </tr>
            <c:forEach var="person" items="${personsList}">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
