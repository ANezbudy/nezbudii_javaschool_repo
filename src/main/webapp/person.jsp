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
        <h3>Persons</h3>
        <form action="processForm" method="GET">
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



            <input type="text" name="personName"/>
            <input formaction="submit" type="submit"/>
            <br>
            <br>
            <input type="text" name="personID" />
            <button formaction="delete">Delete</button>
            <br>
            <br>
            <input type="text" name="changePersonID"/>
            <input type="text" name="newPersonName"/>
            <button formaction="update">Change</button>
        </form>
    </body>
</html>
