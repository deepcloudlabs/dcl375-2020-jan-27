<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>World Countries</title>
</head>
<body>
	<form action="list" method="post">
		<label for="continent">Continent:</label> <select id="continent"
			name="continent">
			<c:forEach items="${continents}" var="continent">
				<c:choose>
					<c:when test="${param.continent eq continent}">
						<option selected>${continent}</option>
					</c:when>
					<c:otherwise>
						<option>${continent}</option>
					</c:otherwise>

				</c:choose>
			</c:forEach>
		</select>
		<button>List</button>
	</form>
    <util:table fields="code,name,population,surfaceArea,gnp" 
                items="${countries}" 
                columns="Code,Name,Population,Surface Area,GNP"></util:table>
</body>
</html>




