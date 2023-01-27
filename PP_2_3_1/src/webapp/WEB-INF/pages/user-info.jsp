<!DOCTYPE html>
<html lang="en"  xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>User info</h2>
<form action="saveUser" modelattribute="user">
    <input type="hidden" th:value="${user.getId}" th:attr="name='id'"/>

    <label for="name">Name: </label>
    <input type="text" th:field="*{user.name}" id="name"/>
    <br/>
    <label for="name">Surname: </label>
    <input type="text" th:field="surname" id="surname"/>
    <br/>
    <label for="age">Age: </label>
    <input type="number" min="1" max="150" th:field="age" id="age"/>
    <br/>
    <label for="email">Email: </label>
    <input type="text" th:field="*{email}" id="email"/>
    <br/>

    <input type="submit" value="OK">

</form>
</body>
</html>