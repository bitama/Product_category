<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <div class="container">
		     <div class="d-flex">
		                        <div>
		         <h1>${thisProduct.id}</h1>
			     <h1>${thisProduct.name}</h1>
			     <h3>${thisProduct.description}</h3>
			      <ul>
            <c:forEach var="category" items="${categoriesInProduct}">
                <li>${category.name}</li>
            </c:forEach>
            
        </ul>
		     </div>
	     </div><br>
	     <div class>
	       <form action="/viewProduct/${thisProduct.id}/addCategory" method="post">
	           <select name="category_Id">
		            <c:forEach items="${allCategories}" var="C">
		                 <option value="${C.id}">${C.name}</option>
		            </c:forEach>
		      </select>
		      <input type="submit" value="Add category" class="btn btn-sm btn-primary" />
	      </form>
		 </div>
     </div>
</body>
</html>