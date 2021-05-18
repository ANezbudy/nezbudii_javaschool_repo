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
            <h4 style="text-align:center">Station name: ${resultDTO.stationName}</h4>
        </div>

    <form class="row">
        <p>
            ${resultDTO.message}
        </p>

<%--        <c:if test="${ scheduleDTOList.size() > 0 }">--%>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Train Number</th>
                    <th scope="col">Departure Time</th>
                </tr>
                </thead>

                <tbody>
                    <tr>
                        <td type="date">${resultDTO.trainNumber}</td>
                        <td>${resultDTO.departureTime}</td>
                    </tr>
                </tbody>
            </table>
<%--        </c:if>--%>
    </form>
</div>
</body>
</html>