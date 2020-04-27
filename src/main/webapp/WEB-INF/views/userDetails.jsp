<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%--<table class="table table-striped">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>Username</th>--%>
<%--        <th>First name</th>--%>
<%--        <th>Last name</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tr>--%>
<%--        <td>${user.username}</td>--%>
<%--        <td>${user.firstName}</td>--%>
<%--        <td>${user.lastName}</td>--%>
<%--    </tr>--%>
<%--</table>--%>
<%--<a href="/users">Go back to users list</a>--%>

<dl class="row">
    <dt class="col-sm-3">Username</dt>
    <dd class="col-sm-9">${user.username}</dd>
    <dt class="col-sm-3">First name</dt>
    <dd class="col-sm-9">${user.firstName}</dd>
    <dt class="col-sm-3">Last name</dt>
    <dd class="col-sm-9">${user.lastName}</dd>
</dl>

<button class="btn btn-outline-primary" onclick="location.pathname ='/users'">Go back to users list</button>

</body>
</html>