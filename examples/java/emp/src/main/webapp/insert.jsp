<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page session="false" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%
String db_url = "jdbc:mysql://mysql:3306/" + System.getenv("MYSQL_DATABASE");
String db_user = System.getenv("MYSQL_USER");
String db_pass = System.getenv("MYSQL_PASSWORD");
pageContext.setAttribute("db_url", db_url);
pageContext.setAttribute("db_user", db_user);
pageContext.setAttribute("db_pass", db_pass);
%>

<html>
  <head>
  	<title>INSERT Operation</title>
  	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
  	<style>
  	body {
  		background-color: white;
  		text-align: center;
  		padding: 50px;
  		font-family: "Open Sans","Helvetica Neue",Helvetica,Arial,sans-serif;
  	}

  	#logo {
  		margin-bottom: 40px;
  	}
    table, td, th {
      border: 1px solid #ED8109;
    }

    th {
      background-color: #5D5E60;
      color: white;
    }
  	</style>
  </head>
  <body>
  	<img id="logo" src="logo.png" />


<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="${db_url}"
     user="${db_user}"
     password="${db_pass}"/>


<sql:update dataSource="${snapshot}" var="result">
INSERT INTO Employees VALUES ( ?,?,?,?)
<sql:param value="${param.empid}" />
<sql:param value="${param.age}" />
<sql:param value="${param.first}" />
<sql:param value="${param.last}" />
</sql:update>

<sql:query dataSource="${snapshot}" var="result">
SELECT * from Employees;
</sql:query>

<table border="1" width="100%">
<tr>
   <th>Emp ID</th>
   <th>First Name</th>
   <th>Last Name</th>
   <th>Age</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.id}"/></td>
   <td><c:out value="${row.first}"/></td>
   <td><c:out value="${row.last}"/></td>
   <td><c:out value="${row.age}"/></td>
</tr>
</c:forEach>
</table>

</body>
</html>
