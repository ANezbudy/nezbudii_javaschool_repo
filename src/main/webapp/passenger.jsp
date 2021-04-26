<%--
  Created by IntelliJ IDEA.
  User: anezbudi
  Date: 4/14/2021
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <title>T</title>
    </head>
    <body>
<%--        ${person.name}--%>
        <h3>Passengers</h3>
        <form method="GET">
            <table>
                <tr>
                    <th>id</th>
                    <th>name</th>
                </tr>
                <c:forEach var="passenger" items="${passengerList}">
                    <tr>
                        <td>${passenger.id}</td>
                        <td>${passenger.passengerName}</td>
                        <td>${passenger.passengerLastName}</td>
                        <td>${passenger.passengerBirthDate}</td>
                    </tr>
                </c:forEach>
            </table>

<%--            <input type="text" name="personName"/>--%>
<%--            <input formaction="submit" type="submit"/>--%>
<%--            <br>--%>
<%--            <br>--%>
<%--            <input type="text" name="personID" />--%>
<%--            <button formaction="delete">Delete</button>--%>
<%--            <br>--%>
<%--            <br>--%>
<%--            <input type="text" name="changePersonID"/>--%>
<%--            <input type="text" name="newPersonName"/>--%>
<%--            <button formaction="update">Change</button>--%>
        </form>
    </body>
</html>
