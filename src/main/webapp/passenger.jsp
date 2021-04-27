<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>--%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>T</title>
    <%--        <link href="${contextPath}/resource/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3>Passengers</h3>

    <form method="GET">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
<%--                <th scope="col">id</th>--%>
                <th scope="col">Name</th>
                <th scope="col">Last Name</th>
<%--                <th scope="col">Birth Date</th>--%>
                <th scope="col">Edit</th>
                <th scope="col">Remove</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="passenger" items="${passengerList}">
                <tr>
                    <th scope="row">1</th>
<%--                    <td>${passenger.id}</td>--%>
                    <td>${passenger.passengerName}</td>
                    <td>${passenger.passengerLastName}</td>
<%--                    <td>${passenger.passengerBirthDate}</td>--%>
                    <td>
                        <form action="startedit">
                            <button type="submit" class="btn btn-success">Edit</button>
                            <input type="hidden" name="passengerID" value="${passenger.id}">
                        </form>
                    </td>
                    <td>
                        <form action="deletepassenger">
                            <button type="submit" class="btn btn-secondary">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-basket2" viewBox="0 0 16 16">
                                    <path d="M4 10a1 1 0 0 1 2 0v2a1 1 0 0 1-2 0v-2zm3 0a1 1 0 0 1 2 0v2a1 1 0 0 1-2 0v-2zm3 0a1 1 0 1 1 2 0v2a1 1 0 0 1-2 0v-2z"/>
                                    <path d="M5.757 1.071a.5.5 0 0 1 .172.686L3.383 6h9.234L10.07 1.757a.5.5 0 1 1 .858-.514L13.783 6H15.5a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-.623l-1.844 6.456a.75.75 0 0 1-.722.544H3.69a.75.75 0 0 1-.722-.544L1.123 8H.5a.5.5 0 0 1-.5-.5v-1A.5.5 0 0 1 .5 6h1.717L5.07 1.243a.5.5 0 0 1 .686-.172zM2.163 8l1.714 6h8.246l1.714-6H2.163z"/>
                                </svg>
                            </button>
                            <input type="hidden" name="passengerID" value="${passenger.id}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>


        </table>

        <div class="input-group mb-1">
            <span class="input-group-text">First and last name</span>
            <input class="form-control" placeholder="Passenger name" aria-label="Passenger name" name="passengerName"/>
            <input class="form-control" placeholder="Passenger Last Name" aria-label="Passenger Last Name"
                   name="passengerLastName"/>
            <button type="submit" class="btn btn-success" formaction="submitpassenger">Submit</button>
        </div>
    </form>
</div>
</body>
</html>
