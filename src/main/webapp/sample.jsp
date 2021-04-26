<%--
  Created by IntelliJ IDEA.
  User: anezbudi
  Date: 4/14/2021
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <title>T</title>
    </head>
    <body>
<%--        ${passenger.name}--%>
        <h3>Passengers</h3>
        <table>
            <c:if test="${fn:length(passengersList) == 0}">
                There is no passengers!
            </c:if>
            <c:if test="${fn:length(passengersList) > 0}">
                <tr>
                    <th>id</th>
                    <th>name</th>
                </tr>
                <c:forEach var="passenger" items="${passengersList}">
                    <tr>
                        <td>${passenger.id}</td>
                        <td>${passenger.name}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
        <form action="processForm" method="GET">
            <input type="text" name="passengerName"/>
            <input formaction="submit" type="submit"/>
            <br>
            <br>
            <input type="text" name="passengerID" />
            <button formaction="delete">Delete</button>
            <br>
            <br>
            <input type="text" name="changePassengerID"/>
            <input type="text" name="newPassengerName"/>
            <button formaction="update">Change</button>
        </form>
    </body>
</html>
