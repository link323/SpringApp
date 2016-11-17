<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<link rel="stylesheet" type="text/css"
      href="http://yegor256.github.io/tacit/tacit.min.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="web.layout.top.title" /></title>
</head>
<body>
    <form:form action="confirm" modelAttribute="form" method="post">

		 Imie: 
		 <form:input path="name" id="name" value="Ala"></form:input>
		 <c:if test="${pageContext.request.method=='POST'}"><form:errors path="name" cssclass="error" /></c:if>
		 <br />
		
		 Adres email: 
		 <form:input path="email" id="email" value="ala@gmail.com"></form:input>
		 <c:if test="${pageContext.request.method=='POST'}"><form:errors path="email" cssclass="error" /></c:if>
		 <br />
		
		 Wiek:
		 <form:input path="age" id="age" value="22"></form:input>
		 <c:if test="${pageContext.request.method=='POST'}"><form:errors path="age" cssclass="error" /></c:if>
		 <br />
		
		 <input type="submit" />
	</form:form>
</body>
</html>