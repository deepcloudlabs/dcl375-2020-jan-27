<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" 
   uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="items" type="java.util.Collection"
	rtexprvalue="true" required="true"%>

<%@ attribute name="columns" rtexprvalue="false" required="true"%>

<%@ attribute name="fields" rtexprvalue="false" required="true"%>

<c:if test="${not empty items}">
	<table>
		<thead>
			<tr>
				<c:forEach items="${fn:split(columns,',')}"
				           var="column">
					<th>${column}*</th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${items}" var="item">
				<tr>
					<c:forEach items="${fn:split(fields,',')}"
				           var="field">
					   <td>${item[field]}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
