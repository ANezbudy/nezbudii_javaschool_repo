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
    <h3>Station: ${resultStationDTO.stationName}</h3>

    <form>
        <div class="accordion" id="accordionExample">
            <div class="accordion-item">
                <h2 class="accordion-header" id="headingOne">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        Add new train to schedule
                    </button>
                </h2>
                <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                    <div class="accordion-body">
                        <div class="input-group mb-1">
                            <label class="input-group-text" for="inputGroupSelect01">Trains</label>
                            <select class="form-select" id="inputGroupSelect01">
                                <option selected>Choose...</option>
                                <c:forEach var="train" items="${trains}">
                                    <option name="trainNumber" value="${train.trainNumber}">${train.trainNumber}</option>
                                </c:forEach>
                            </select>
                            <span class="input-group-text">Train time</span>
                            <input class="form-control" placeholder="Arrival time" aria-label="Train time" name="trainTime"/>
                            <button type="submit" class="btn btn-success" formaction="stationsubmit">Add new train for station</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </form>
</div>
</body>
</html>