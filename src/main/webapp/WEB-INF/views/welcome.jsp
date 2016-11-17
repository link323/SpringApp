<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>

<head>
<link rel="stylesheet" type="text/css"
      href="http://yegor256.github.io/tacit/tacit.min.css"/>
<title><spring:message code="web.layout.top.title" /></title>
</head>
<body>
	Welcome ${name}
	<form action="logout" method="get">
		<input type="submit" value="Log out" />
	</form>
    <!--<form action="welcome" method="POST">
        Name : 
        <input name="name" type="text" value="jan"/> 
        Email : 
        <input name="email" type="email" value="jan@gmail.com"/> 
        Age : 
        <input name="age" type="age" value="16"/> 
        <input type="submit" />
    </form>-->
    <a href="form">Go to form</a>
    

</body>
</html>