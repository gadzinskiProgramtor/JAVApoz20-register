<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<body>
<h1>Filtruj po imieniu</h1>



    <form method="get" action="/users">
        <input type="text" name="firstName"/>
        <input type="submit"/>
        <input type="checkbox" class="form-check-input" id="matchExact" name="matchExact">
        <label class="form-check-label" for="matchExact">Check me out</label>
    </form>




</body>
</html>