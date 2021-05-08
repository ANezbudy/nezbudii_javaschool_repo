<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <title>Trains</title>


</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Train Number</th>
            <th scope="col">Time</th>
            <th scope="col">Edit</th>
            <th scope="col">Remove</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="scheduleDTO" items="${scheduleDTOList}">
            <tr>
                <th scope="row">1</th>
                <td>${scheduleDTO.trainNumber}</td>
                <td>${scheduleDTO.time}</td>
                <td>
                    <form action="starteditschedule">
                        <button type="submit" class="btn btn-success">Edit</button>
                        <input type="hidden" name="trainNumber" value="${scheduleDTO.id}">
                    </form>
                </td>
                <td>
                    <form action="deleteschedule">
                        <button type="submit" class="btn btn-secondary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-basket2" viewBox="0 0 16 16">
                                <path d="M4 10a1 1 0 0 1 2 0v2a1 1 0 0 1-2 0v-2zm3 0a1 1 0 0 1 2 0v2a1 1 0 0 1-2 0v-2zm3 0a1 1 0 1 1 2 0v2a1 1 0 0 1-2 0v-2z"/>
                                <path d="M5.757 1.071a.5.5 0 0 1 .172.686L3.383 6h9.234L10.07 1.757a.5.5 0 1 1 .858-.514L13.783 6H15.5a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-.623l-1.844 6.456a.75.75 0 0 1-.722.544H3.69a.75.75 0 0 1-.722-.544L1.123 8H.5a.5.5 0 0 1-.5-.5v-1A.5.5 0 0 1 .5 6h1.717L5.07 1.243a.5.5 0 0 1 .686-.172zM2.163 8l1.714 6h8.246l1.714-6H2.163z"/>
                            </svg>
                        </button>
                        <input type="hidden" name="trainNumber" value="${scheduleDTO.id}">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>


    </table>
    <%--    </form>--%>

<%--    <form>--%>
<%--        <div class="input-group mb-1">--%>
<%--            <span class="input-group-text">Train Number</span>--%>
<%--            <input class="form-control" placeholder="Train Number" aria-label="Train Number" name="trainNumber"/>--%>
<%--            <input class="form-control" placeholder="Number of places" aria-label="Number of places"--%>
<%--                   name="numPlaces"/>--%>
<%--            <button type="submit" class="btn btn-success" formaction="submittrain">Submit</button>--%>
<%--        </div>--%>
<%--    </form>--%>
</div>
</body>
</html>