<%@ page session="false" %>
<html>
<head>
	<title>Hello Emp world!</title>
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
	</style>
</head>
<body>
	<img id="logo" src="logo.png" />
	<h1>Simple Employee app</h1>
	  <a href="select.jsp">Select</a><br/>
		<a href="insert.jsp?empid=104&age=2&first=Emil&last=McKinsey">Insert</a><br/>
		<a href="update.jsp&empid=104&age=3">Update Age</a><br/>
		<a href="delete.jsp?empid=104">Delete</a><br/>
	<h2>You have the infrabricks line power!</h2>
</body>
</html>
