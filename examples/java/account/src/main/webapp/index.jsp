<%@ page session="false" %>
<% String hostname = java.net.InetAddress.getLocalHost().getHostName() ; %>
<html>
<head>
<title>Hystrix example application</title>
</head>
<body>
Hystrix example application<br>
<a href="swagger">Swagger API</a><br>
<a href="http://hystrix:8080/hystrix-dashboard/monitor/monitor.html?stream=http%3A%2F%2F<%=hostname%>:8080%3A4280%2Fturbine%2Fturbine.stream">Monitor with Turbine</a><br>
<a href="http://hystrix:8080/hystrix-dashboard/monitor/monitor.html?stream=http%3A%2F%<%=hostname%>:8080%3A4280%2Fhystrixapp%2Fhystrix.stream">Monitor directly</a>
</body>
</html>
