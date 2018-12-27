<%--
  Created by IntelliJ IDEA.
  User: кирилл
  Date: 08.11.2018
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation Details</title>
</head>
<body>
<h2>Flight Details:</h2>
Airlines: ${reservation.flight.operatingAirlines}<br/>
Flight No: ${reservation.flight.flightNumber}<br/>
Departure City: ${reservation.flight.departureCity}<br/>
Arrival City: ${reservation.flight.arrivalCity}<br/>
Date of Departure: ${reservation.flight.dateOfDeparture}<br/>
Estimate Departure Time: ${reservation.flight.estimatedDepartureTime}<br/>


<h2>Passenger Details:</h2>
First Name: ${reservation.passenger.firstName}<br/>
Last Name: ${reservation.passenger.lastName}<br/>
Email: ${reservation.passenger.email}<br/>
Phone: ${reservation.passenger.phone}<br/>

<form action="completeCheckIn" method="post">
Enter the number of bags You want to check in:<input type="text" name="numberOfBags" />
    <input type="hidden" value="${reservation.id}" name="reservationId"/>
    <input type="submit" value="Check In"/>


</form>

</body>
</html>
