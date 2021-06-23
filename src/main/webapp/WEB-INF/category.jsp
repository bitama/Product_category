<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
        <div>
            <h1>Create a Category</h1>
        <form:form action="/categories/create" method="post" modelAttribute="category">
             <div class="form-group">
                <form:label path="name">Name</form:label>
                <form:errors path="name"/>
                <form:input type="text" path="name" class="form-control"/>
             </div>
             <div>
             <input type="submit" value="Add a category" class="btn btn-primary mt-3">
             </div>
          </form:form>
        </div>
        <div>
            <h4><a href="/">Create Product</a></h4>
            <h4><a href="/showAll">View All Products</a></h4>
        </div>
     </div>
</body>
</html>