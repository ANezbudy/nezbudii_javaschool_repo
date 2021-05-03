<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Train</title>
  <head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <title>Passenger Edit</title>

</head>
<body>
  <div class="container">

    <jsp:include page="header.jsp" />

    <form method="GET">
      <div class="mb-1">
        <h3>Edit Train #${train.trainNumber}</h3>
      </div>
      <div class="input-group mb-1">
        <span class="input-group-text">Number of places </span>
        <input class="form-control" placeholder="Number Of Places" aria-label="Number Of Places" name="numPlaces" value="${train.numPlaces}"/>
        <input type="hidden" name="trainNumber" value="${train.trainNumber}">
        <button type="submit" class="btn btn-success" formaction="submitedittrain">Submit</button>
      </div>
    </form>
  </div>

</body>
</html>
