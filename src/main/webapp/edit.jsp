<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
  <title>Passenger Edit</title>
  <%--    header --%>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.82.0">

  <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/headers/">

  <style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }
  </style>

  <%--    header  --%>
</head>
<body>
  <div class="container">
    <%--    header --%>
    <div class="container">
      <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
        </a>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
          <li><a href="/" class="nav-link px-2 link-secondary">Home</a></li>
          <li><a href="/" class="nav-link px-2 link-dark">Passengers</a></li>
          <li><a href="/trains" class="nav-link px-2 link-dark">Trains</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">FAQs</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">About</a></li>
        </ul>

        <div class="col-md-3 text-end">
          <button type="button" class="btn btn-outline-primary me-2">Login</button>
          <button type="button" class="btn btn-primary">Sign-up</button>
        </div>
      </header>
    </div>
    <%--    header --%>


    <form method="GET">
      <div class="mb-1">
        <h3>Edit</h3>
      </div>
      <div class="input-group mb-1">
        <span class="input-group-text">First and last name</span>
        <input class="form-control" placeholder="Passenger name" aria-label="Passenger name" name="passengerName" value="${passenger.passengerName}"/>
        <input class="form-control" placeholder="Passenger Last Name" aria-label="Passenger Last Name" name="passengerLastName" value="${passenger.passengerLastName}"/>
        <input type="hidden" name="passengerID" value="${passenger.id}">
        <input class="form-control" placeholder="Passenger Birth Date" aria-label="Passenger Birth Date"
               name="passengerBirthDate" value="${passenger.passengerBirthDate}"/>
        <button type="submit" class="btn btn-success" formaction="submitedit">Submit</button>
      </div>
    </form>
  </div>

</body>
</html>
