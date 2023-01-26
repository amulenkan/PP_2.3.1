<!DOCTYPE html>
<html lang="en"  xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>User info</h2>
<form action="saveUser" modelattribute="user">
    <form:hidden path="id"/>

    <label for="name">Name: </label>
    <input type="text" name="name" id="name">
    <br/>
    <label for="name">Surname: </label>
    <input type="text" name="surname" id="surname">
    <br/>
    <label for="age">Age: </label>
    <input type="number" min="1" max="150" name ="age" id="age"/>
    <br/>
    <label for="email">Email: </label>
    <input type="text" name="email" id="email">
    <br/>

    <input type="submit" value="OK">

</form>
</body>
</html>