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
    <title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <h1>Here be burgers!</h1>
   <!-- table for burger name, restaurant name, and rating out of 5 -->
   <table>
   		<thead>
   			<tr>
   				<th>Burger Name</th>
   				<th>Restaurant</th>
   				<th>Rating</th>
   				<th>Actions</th>
   			</tr>
   		</thead>
   		<tbody>
   		<c:forEach var="burger" items="${allBurgers}">
   		<tr>
   			<td>
   				<c:out value="${burger.id}"></c:out>
   			</td>
   			<td>
   				<a href="/burger/${burger.id}"><c:out value="${burger.name}"></c:out></a>
   			</td>
   			<td><c:out value="${burger.restaurantName}"></c:out></td>
   			<td><c:out value="${burger.rating}"></c:out></td>
   			<td><a href="/burger/${burger.id}"><button>Burger Page</button></a></td>
   			<td><a href="/burger/${burger.id}/edit"><button>Edit Burger Page</button></a></td>
   		</tr>
   		</c:forEach>
   		</tbody>
   </table>
   <h2>Add a Burger</h2>
   <!-- burger form:
   	burger name
   	restaurant name
   	rating out of 5
   	notes-->
   	<form:form action="/burger/create" method="POST" modelAttribute="burgers">
   		<div>
   			<form:label path="name">Name: </form:label>
   			<form:input path="name" placeholder="name"></form:input>
   			<form:errors path="name"></form:errors>
   		</div>
   		<div>
   			<form:label path="restaurantName">Restaurant Name: </form:label>
   			<form:input path="restaurantName" placeholder="Restaurant name"></form:input>
   			<form:errors path="restaurantName"></form:errors>
   		</div>
   		<div>
   			<form:label path="rating">Rating: </form:label>
   			<form:input path="rating" ></form:input>
   			<form:errors path="rating"></form:errors>
   		</div>
   		<div>
   			<form:label path="notes">Notes: </form:label>
   			<form:input path="notes" placeholder="Anything to say?"></form:input>
   			<form:errors path="notes"></form:errors>
   		</div>
   		<div>
   			<button>Submit</button>
   		</div>
   </form:form>
   <!-- git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/e-t-trudell/burgerTracker.git
git push -u origin main -->
   
</body>
</html>
