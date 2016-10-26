<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>Yahoo!!</title>
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
    
    
    <form:form action="welcome" modelAttribute="form" method="post">

		 Imie: 
		 <form:input path="name" id="name" value="Ala"></form:input>
		 <c:if test="${pageContext.request.method=='POST'}"><form:errors path="name" cssclass="error" /></c:if>
		 <br />
		
		 Adres email: 
		 <form:input path="email" id="email" value="ala@gmail.com"></form:input>
		 <c:if test="${pageContext.request.method=='POST'}"><form:errors path="email" cssclass="error" /></c:if>
		 <br />
		
		 Wiek:
		 <form:input path="age" id="age" value=22></form:input>
		 <c:if test="${pageContext.request.method=='POST'}"><form:errors path="age" cssclass="error" /></c:if>
		 <br />
		
		 <input type="submit" />
	</form:form>
</body>
</html>