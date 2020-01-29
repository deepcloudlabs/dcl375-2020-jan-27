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
    <c:url var="actionUrl" value="/countries/list"/>
	<form  method="post">
		<util:select name="continent" 
		             label="Continent" 
		             options="${continents}"></util:select>
		<button formaction="${actionUrl}">List</button>
	</form>
    <util:table fields="code,name,surfaceArea,population" 
                items="${countries}" 
                columns="Code,Name,Surface Area,Population"></util:table>
</body>
</html>




