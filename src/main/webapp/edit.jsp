<%--
  Created by IntelliJ IDEA.
  User: anezbudi
  Date: 4/27/2021
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
  <div class="container">
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
