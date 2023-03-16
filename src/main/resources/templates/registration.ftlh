<!DOCTYPE html>
<html>
<head>
    <title>TASKS</title>
</head>
<body>
<h1>TASKS</h1><hr>
<h4>Регистрация</h4>
<form action="/registration" method="post">
    Имя пользователя: <input type="text" name="name"><br><br>
    Фамилия: <input type="text" name="surname"><br><br>
    Эл. почта: <input type="email" name="email"><br><br>
    Номер телефона: <input type="text" name="phoneNumber"><br><br>
    Лицевой счёт: <input type="text" name="personalAccount"><br><br>
    Площадь помещения: <input type="text" name="roomArea"><br><br>
    Адрес: <input type="text" name="userAddress"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Зарегистрироваться"/>
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>