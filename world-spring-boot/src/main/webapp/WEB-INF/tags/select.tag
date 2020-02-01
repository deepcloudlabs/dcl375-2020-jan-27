<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="options" type="java.util.Collection" required="true"
              rtexprvalue="true" %>

<%@ attribute name="name" required="true" rtexprvalue="false" %>

<%@ attribute name="label" required="true" rtexprvalue="false" %>
<div class="form-group">
    <label for="${name}">${label}</label> <select id="${name}"
                                                  class="form-control" name="${name}">
    <c:forEach items="${options}" var="opt">
        <c:choose>
            <c:when test="${opt eq param[name]}">
                <option selected label="${opt}" value="${opt}">${opt}</option>
            </c:when>
            <c:otherwise>
                <option label="${opt}" value="${opt}">${opt}</option>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</select>
</div>
