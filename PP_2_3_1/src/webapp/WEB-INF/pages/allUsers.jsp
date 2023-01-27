<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:c="http://java.sun.com/xml/ns/javaee">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<h2>All users</h2>

<table>

    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>Email</th>
        <th>Operations</th>
    </tr>



    <c:forEach var="user" items="${users}">
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="userId" value="${user.id}"/>
        </c:url>
        <tr>
            <td th:text="${user.name}"/>
            <td th:text="${user.surname}"/>
            <td th:text="${user.age}"/>
            <td th:text="${user.email}"/>
        <td>
            <input type="button" value="Update"
                   onclick="window.location.href = 'updateUser'"/>
        </td>
        </tr>
    </c:forEach>


</table>
<br>
<input type="button" value="Add"
       onclick="window.location.href = 'addNewUser' ">

</body>
</html>