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

<%--    <jsp:include page="header.jsp" />--%>

    <h3>Station:</h3>

            <form class="row g-3">
                <div class="col-auto">
                    <input type="text" class="form-control" id="validationCustom01" value="${resultStationDTO.stationName}" required name = "stationName">
                    <div class="valid-feedback">
                        Looks good!
                    </div>
                </div>

                <div class="col-auto">
                    <button type="submit" class="btn btn-success" formaction="stationsubmitedit">Submit</button>
                    <input type="hidden" name="stationId" value="${resultStationDTO.id}">
                </div>
            </form>


<c:if test="${ scheduleDTOList.size() > 0 }">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Train Number</th>
            <th scope="col">Arrival Time</th>
            <th scope="col">Departure Time</th>
            <th scope="col">Edit</th>
            <th scope="col">Remove</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="scheduleDTO" items="${scheduleDTOList}" varStatus="theCount">
            <tr>
                <th scope="row">${theCount.count}</th>
                <td>${scheduleDTO.trainNumber}</td>
                <td>${scheduleDTO.arrivalTime}</td>
                <td>${scheduleDTO.departureTime}</td>
                <td>
                    <form action="edittrainschedule">
                        <button type="submit" class="btn btn-success">Edit</button>
                        <input type="hidden" name="scheduleID" value="${scheduleDTO.id}">
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
                        <input type="hidden" name="scheduleID" value="${scheduleDTO.id}">
                        <input type="hidden" name="stationId" value="${resultStationDTO.id}">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

    <form>
        <div class="input-group mb-1">
            <label class="input-group-text" for="inputGroupSelect01">Trains</label>
            <select class="form-select" name="trainNumber" id="inputGroupSelect01">
                <option selected>Choose...</option>
                <c:forEach var="trainDTO" items="${trainDTOList}">
                    <option value="${trainDTO.trainNumber}">${trainDTO.trainNumber}</option>
                </c:forEach>
            </select>
        </div>
        <div class="input-group mb-1">
            <span class="input-group-text">Train arrival</span>
            <input class="form-control" type="datetime-local" aria-label="Time" name="arrivalTime"/>
        </div>
        <div class="input-group mb-1">
            <span class="input-group-text">Train departure</span>
            <input class="form-control" type="datetime-local" aria-label="Hour" name="departureTime"/>
        </div>

        <div class="input-group mb-1">
            <input type="hidden" name="stationId" value="${resultStationDTO.id}">
            <button type="submit" class="btn btn-success" formaction="schedulesubmit">Add new train for station</button>
        </div>
    </form>
</div>
</body>
</html>