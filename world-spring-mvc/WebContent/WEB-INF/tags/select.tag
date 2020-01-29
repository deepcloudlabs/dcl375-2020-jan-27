<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="options" 
              type="java.util.Collection"
	          rtexprvalue="true" required="true"%>

<%@ attribute name="label" rtexprvalue="false" 
              required="true"%>

<%@ attribute name="name" rtexprvalue="false" 
              required="true"%>

<label for="${name}">${label}:</label> 
<select id="${name}" name="${name}">
	<c:forEach items="${options}" var="option">
		<c:choose>
			<c:when test="${param[name] eq option}">
				<option selected>${option}</option>
			</c:when>
			<c:otherwise>
				<option>${option}</option>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</select>