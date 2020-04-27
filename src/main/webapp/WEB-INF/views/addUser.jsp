<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<spring:url value="/user" var="addUserUrl"/>
<spring:url value="/user/update" var="updateUserUrl"/>


<%--<form:form method="POST" action="${update ? updateUserUrl : addUserUrl}" modelAttribute="user">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--&lt;%&ndash;            <td><form:label path="username">Username</form:label></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><form:input path="username" readonly="${update}"/></td>&ndash;%&gt;--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><form:label path="firstName">First name</form:label></td>--%>
<%--            <td><form:input path="firstName"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><form:label path="lastName">Last name</form:label></td>--%>
<%--            <td><form:input path="lastName"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><input type="submit" value="Add"/></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form:form>--%>

<form:form class="was-validated" method="POST" action="${update ? updateUserUrl : addUserUrl}" modelAttribute="user">
    <div class="col-md-4 mb-3">
        <form:label for="validationUsernameArea" path="username">Username</form:label>

        <c:choose>
            <c:when test="${update==true}">
                <form:input class="form-control" id="validationUsernameArea" path="username" readonly="${update}"/>
            </c:when>
            <c:otherwise>
                <form:input class="form-control is-invalid" id="validationUsernameArea" path="username"
                            required="true"/>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="col-md-4 mb-3">
        <form:label for="validationFirstNameArea" path="firstName">First name</form:label>
        <form:input class="form-control is-invalid" id="validationFirstNameArea" path="firstName" required="true"/>
    </div>
    <div class="col-md-4 mb-3">
        <form:label for="validationLastNameArea" path="lastName">Last name</form:label>
        <form:input class="form-control is-invalid" id="validationLastNameArea" path="lastName" required="true"/>
    </div>


    <button class="btn btn-outline-primary" type="submit" value="Add">Submit form</button>

    <button class="btn btn-outline-primary" onclick="location.pathname ='/users'">Go back to users list</button>


    <%--    <input type="submit" value="Add"/>--%>
</form:form>


</body>
</html>