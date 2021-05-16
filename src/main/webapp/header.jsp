<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
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
          <sec:authorize access="hasRole('ADMIN')">
            <li><a href="/admin/stations" class="nav-link px-2 link-dark">Stations</a></li>
            <li><a href="/admin/passenger" class="nav-link px-2 link-dark">Passengers</a></li>
            <li><a href="/admin/trains" class="nav-link px-2 link-dark">Trains</a></li>
          </sec:authorize>
          <sec:authorize access="hasRole('USER')">
            <li><a href="/user/select" class="nav-link px-2 link-dark">Routes</a></li>
            <li><a href="/user/stations" class="nav-link px-2 link-dark">Stations</a></li>
          </sec:authorize>
        </ul>

        <div class="col-md-3 text-end">
<%--          <button type="button" class="btn btn-outline-primary me-2">Login</button>--%>
          <a href="<c:url value="/logout" />" class="btn btn-primary" tabindex="-1" role="button">Logout</a>
<%--          <button type="button" class="btn btn-primary" >Logout</button>--%>
        </div>
      </header>
    </div>
    <%--    header --%>
</body>
</html>
