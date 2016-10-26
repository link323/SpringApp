<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title><spring:message code="web.layout.top.title" /></title>
</head>
<body>
	<a href="?language=en_us"><spring:message code="web.layout.top.languag_en" /></a>|
	<a href="?language=pl"><spring:message code="web.layout.top.languag_pl" /></a>
    <p><font color="red">${errorMessage}</font></p>
    <form action="welcome" method="T">
        <spring:message code="web.layout.top.name" /> : 
        <input name="name" type="text" value="in28Minutes"/> 
        <spring:message code="web.layout.top.passwd" /> : 
        <input name="password" type="password" value="dummy"/> 
        <input type="submit" value="<spring:message code="web.layout.top.buttonSend" />"/>
    </form>
</body>
</html>