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
            <h3 style="text-align:center">Find your route</h3>
        </div>

        <form class="row">
            <div class="row">
                <div class="col">
                    <div class="input-group mb-1">
                        <label class="input-group-text" for="inputGroupSelect01">Departure Station:</label>
                        <select class="form-select" name="stationAiD" id="inputGroupSelect01">
                            <option selected>Choose...</option>
                            <c:forEach var="stationDTO" items="${stationDTOList}">
                                <option value="${stationDTO.id}">${stationDTO.stationName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-group mb-1">
                        <span class="input-group-text">Departure time:</span>
                        <input class="form-control" type="datetime-local" aria-label="Time" name="departureTimeA"/>
                    </div>
                </div>

                <div class="col">
                    <div class="input-group mb-1">
                        <label class="input-group-text" for="inputGroupSelect02">Arrival Station:</label>
                        <select class="form-select" name="stationBiD" id="inputGroupSelect02">
                            <option selected>Choose...</option>
                            <c:forEach var="stationDTO" items="${stationDTOList}">
                                <option value="${stationDTO.id}">${stationDTO.stationName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-group mb-1">
                        <span class="input-group-text">Arrival time:</span>
                        <input class="form-control" type="datetime-local" aria-label="Time" name="arrivalTimeB"/>
                    </div>
                </div>
            </div>

            <div class="d-grid gap-2 col-6 mx-auto">
                <button type="submit" class="btn btn-success" formaction="findtrip">Find the train</button>
            </div>
        </form>
</div>
</body>
</html>