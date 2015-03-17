<html>
<head>
<title>QR Code</title>
<style>
body, input{
	font-family: Calibri, Arial;
	margin: 0px;
	padding: 0px;
}
a {
	color: #0254EB
}
a:visited {
	color: #0254EB
}
#header h2 {
	color: white;
	background-color: #ED8108;
	margin:0px;
	padding: 5px;
	height: 40px;
	padding: 15px;
}

html, body, #container { height: 100%; }
body > #container { height: auto; min-height: 100%; }

#footer {
	font-size: 12px;
	clear: both;
	position: relative;
	z-index: 10;
	height: 3em;
	margin-top: -3em;
	text-align:center;
}
#content { padding-bottom: 3em; padding: 10px;}


input {
	font-size: 15px;
}
.style1 {
	border: 3px solid #ffaa00;
	font-size: 20px;
}

.style2 {
	border: 2px solid #aaff77;
	font-size: 18px;
}

</style>
</head>

<body>

<div id="container">
<div id="header">
<h2>
	<a href="http://www.infrabricks.de"><img border="0px" src="Logo320x210.png" align="left"/></a>
	Create QR Code
</b2>
</div>
<div id="content">

	<form action="qr" method="get">
		<p>Enter Text to create QR Code</p>
		<input type="text" name="code" />
		<input type="submit" value="Generate QR Code" />
	</form>

<br/>

</div>
<div id="footer">
	Copyright &copy; <a href="http://www.bee42.com">www.bee42.com</a> 2015
</div>

</body>
</html>
