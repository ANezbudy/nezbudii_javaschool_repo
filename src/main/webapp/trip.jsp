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
    <jsp:include page="header.jsp" />

    <h3>Found trips:</h3>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Departure Station Name</th>
            <th scope="col">Departure Time</th>
            <th scope="col">Arrival Station Name</th>
            <th scope="col">Arrival Time</th>
            <th scope="col">Train Number</th>
            <th scope="col">Buy</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="tripDTO" items="${tripDTOList}" varStatus="theCount">
            <tr>
                <th scope="row">
                        ${theCount.count}
                </th>
                <td>${tripDTO.departureStationName}</td>
                <td>${tripDTO.departureTime}</td>
                <td>${tripDTO.arrivalStationName}</td>
                <td>${tripDTO.arrivalTime}</td>
                <td>${tripDTO.trainNumber}</td>
                <td>
                    <form action="initbooking">
                        <button type="submit" class="btn btn-success">Buy</button>
                        <input type="hidden" name="scheduleId" value="${tripDTO.scheduleId}">
                        <input type="hidden" name="departureStationName" value="${tripDTO.departureStationName}">
                        <input type="hidden" name="trainNumber" value="${tripDTO.trainNumber}">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>


    </table>
</div>
</body>
</html>