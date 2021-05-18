<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        <div class="row">
            <h3 style="text-align:center">Train number: ${bookingDTO.trainNumber}</h3>
            <h4 style="text-align:center">Station name: ${bookingDTO.stationName}</h4>
        </div>

        <form class="row">
            <div class="input-group mb-1">
                <span class="input-group-text">First and last name</span>
                <input class="form-control" placeholder="Passenger name" aria-label="Passenger name" name="passengerName"/>
                <input class="form-control" placeholder="Passenger Last Name" aria-label="Passenger Last Name"
                       name="passengerLastName"/>
                <input class="form-control" type="date" placeholder="Passenger Birth Date" aria-label="Passenger Birth Date"
                       name="passengerBirthDate"/>
            </div>

            <div class="d-grid gap-2 col-6 mx-auto">
                <button type="submit" class="btn btn-success" formaction="bookTicket">Book a ticket to ride!!!</button>
                <input type="hidden" name="trainNumber" value="${bookingDTO.trainNumber}">
                <input type="hidden" name="scheduleId" value="${bookingDTO.scheduleId}">
                <input type="hidden" name="scheduleId" value="${bookingDTO.stationName}">
            </div>
        </form>
</div>
</body>
</html>