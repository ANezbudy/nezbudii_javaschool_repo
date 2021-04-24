<%--
  Created by IntelliJ IDEA.
  User: anezbudi
  Date: 4/14/2021
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>T</title>
    </head>
    <body>
<%--        ${person.name}--%>
        <h3>Persons</h3>
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

        <input>
    </body>
</html>
