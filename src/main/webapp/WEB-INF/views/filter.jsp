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
<h1>Filtruj po imieniu</h1>
<br>


<%--    <form method="get" action="/users">--%>
<%--        <input type="text" name="firstName"/>--%>
<%--        <input type="submit"/>--%>
<%--&lt;%&ndash;        <input type="checkbox" class="form-check-input" id="matchExact" name="matchExact">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <label class="form-check-label" for="matchExact">Check me out</label>&ndash;%&gt;--%>
<%--    </form>--%>

<form method="get" action="/users">
    <div class="form-row">
        <div class="form-group mx-sm-3 mb-2">
            <input type="text" class="form-control" id="inputFirstName" placeholder="Search by first name"
                   name="firstName">
        </div>
        <div>
            <button type="submit" class="btn btn-primary mb-2">
                <ion-icon name="paper-plane-outline"></ion-icon>
            </button>
        </div>
    </div>
    <div class="form-group mx-sm-3">
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="matchExact" name="matchExact">
            <label class="form-check-label" for="matchExact">Search exactly</label>
        </div>
    </div>
</form>

<button class="btn btn-outline-primary" onclick="location.pathname ='/users'">Go back to users list</button>


<script src="https://unpkg.com/ionicons@5.0.0/dist/ionicons.js"></script>
</body>
</html>