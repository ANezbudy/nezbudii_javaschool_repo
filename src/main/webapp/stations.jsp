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

    <h3>Stations</h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Station Name</th>
            <th scope="col">Open</th>
            <sec:authorize access="hasRole('ADMIN')">
                <th scope="col">Remove</th>
            </sec:authorize>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="stationDTO" items="${stationDTOList}" varStatus="theCount">
            <tr>
                <th scope="row">
                    ${theCount.count}
                </th>
                <td>${stationDTO.stationName}</td>
                <td>
                    <form action="stationedit">
                        <button type="submit" class="btn btn-success">Open</button>
                        <input type="hidden" name="stationId" value="${stationDTO.id}">
                    </form>
                </td>
                <sec:authorize access="hasRole('ADMIN')">
                    <td>
                        <form action="deletestation">
                            <button type="submit" class="btn btn-secondary">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-basket2" viewBox="0 0 16 16">
                                    <path d="M4 10a1 1 0 0 1 2 0v2a1 1 0 0 1-2 0v-2zm3 0a1 1 0 0 1 2 0v2a1 1 0 0 1-2 0v-2zm3 0a1 1 0 1 1 2 0v2a1 1 0 0 1-2 0v-2z"/>
                                    <path d="M5.757 1.071a.5.5 0 0 1 .172.686L3.383 6h9.234L10.07 1.757a.5.5 0 1 1 .858-.514L13.783 6H15.5a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-.623l-1.844 6.456a.75.75 0 0 1-.722.544H3.69a.75.75 0 0 1-.722-.544L1.123 8H.5a.5.5 0 0 1-.5-.5v-1A.5.5 0 0 1 .5 6h1.717L5.07 1.243a.5.5 0 0 1 .686-.172zM2.163 8l1.714 6h8.246l1.714-6H2.163z"/>
                                </svg>
                            </button>
                            <input type="hidden" name="stationId" value="${stationDTO.id}">
                        </form>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>


    </table>

    <sec:authorize access="hasRole('ADMIN')">
        <form>
            <div class="input-group mb-1">
                <span class="input-group-text">Station Name</span>
                <input class="form-control" placeholder="Station name" aria-label="Station name name" name="stationName"/>
                <button type="submit" class="btn btn-success" formaction="stationsubmit">Save new station</button>
            </div>
        </form>
    </sec:authorize>
</div>
</body>
</html>