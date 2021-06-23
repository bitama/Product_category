<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		     <div class="d-flex">
		                        <div>
		         <h1>${thisCategory.id}</h1>
			     <h1>${thisCategory.name}</h1>
			      <ul>
            <c:forEach var="product" items="${productsInCategory}">
                <li>${product.name}</li>
            </c:forEach>
            
        </ul>
		     </div>
	     </div><br>
	     <div class>
	       <form action="/viewCategory/${thisCategory.id}/addProduct" method="post">
	           <select name="product_Id">
		            <c:forEach items="${allProducts}" var="P">
		                 <option value="${P.id}">${P.name}</option>
		            </c:forEach>
		      </select>
		      <input type="submit" value="Add product" class="btn btn-sm btn-primary" />
	      </form>
		 </div>
     </div>
</body>
</html>