<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
 
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Me</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <h1>Edit Burger</h1>
   <a href="/home">Go Back</a>
   <form:form action="/burger/${burger.id}" method="post" modelAttribute="burger">
   		<input type="hidden" name="_method" value="put"/>
   		<form:hidden path="id" value="${burger.id}"/>
   		<div>
   			<form:label path="name">Name: </form:label>
   			<form:input path="name" value="${burger.name}"></form:input>
   			<form:errors path="name"></form:errors>
   		</div>
   		<div>
   			<form:label path="restaurantName">Restaurant Name: </form:label>
   			<form:input path="restaurantName" value="${burger.restaurantName}"></form:input>
   			<form:errors path="restaurantName"></form:errors>
   		</div>
   		<div>
   			<form:label path="rating">Rating: </form:label>
   			<form:input path="rating" value="${burger.rating}"></form:input>
   			<form:errors path="rating"></form:errors>
   		</div>
   		<div>
   			<form:label path="notes">Notes: </form:label>
   			<form:input path="notes" value="${burger.notes}"></form:input>
   			<form:errors path="notes"></form:errors>
   		</div>
   		<div>
   			<button>Submit</button>
   		</div>
   </form:form>
</body>
</html>
