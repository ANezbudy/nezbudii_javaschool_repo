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
    <form>
        <h3>Schedule for station: ${resultScheduleDTO.stationId}</h3>
        <h4>Train number: ${resultScheduleDTO.trainNumber}</h4>
        <div class="input-group mb-1">
            <span class="input-group-text">Train arrival</span>
            <input class="form-control" type="datetime-local" aria-label="Time" name="arrivalTime" value="${resultScheduleDTO.arrivalTime}"/>
        </div>
        <div class="input-group mb-1">
            <span class="input-group-text">Train departure</span>
            <input class="form-control" type="datetime-local" aria-label="Hour" name="departureTime" value="${resultScheduleDTO.departureTime}"/>
        </div>

        <div class="input-group mb-1">
            <input type="hidden" name="trainNumber" value="${resultScheduleDTO.trainNumber}">
            <input type="hidden" name="stationId" value="${resultScheduleDTO.stationId}">
            <input type="hidden" name="id" value="${resultScheduleDTO.id}">
            <button type="submit" class="btn btn-success" formaction="schduleeditsubmit">Submit</button>
        </div>
    </form>
</div>
</body>
</html>