<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h1>Available Users</h1>
<br>
<table class="table table-hover">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Username</th>
        <th scope="col">Details</th>
        <th scope="col">Delete</th>
        <th scope="col">Modify</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user}</td>
            <td><a href="/users/${user}">Details</a></td>
            <td><a href="/users/delete/${user}">Delete</a></td>
            <td><a href="/user/update/${user}">Modify</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<spring:url value="/user/add" var="addUserFormUrl"/>
<button class="btn btn-outline-primary" onclick="location.href='${addUserFormUrl}'">Add user</button>

<spring:url value="/users/search" var="userSearch"/>
<button class="btn btn-outline-primary" onclick="location.href='${userSearch}'">User search</button>

<c:if test="${param.firstName!=null}">
     <button class="btn btn-outline-danger" onclick="location.replace('/users')">Clear search</button>
</c:if>

</body>
</html>