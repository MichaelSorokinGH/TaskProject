<!DOCTYPE html>
<html>
<head>
    <title>TASKS</title>
</head>
<body>
<h1>TASKS</h1><hr>
<h3>Информация о пользователе ${user.name}</h3>
<b>Номер телефона: </b> ${user.phoneNumber}<br>
<b>Эл. почта: </b> ${user.email}<br>
<b>Адрес: </b> ${user.userAddress}<br>
<b>Лицевой счёт: </b> ${user.personalAccount}<br>
<b>Площадь помещения: </b> ${user.roomArea} м²<br>
<h4>Заявки пользователя ${user.name}</h4>
<#list tasks as task>
    <div>
        <p><b>${task.title}</b> ${task.price} руб. | <a href="/task/${task.id}">Подробности...</a></p>
    </div>
    <#else>
    <h3>Заявок не найдено</h3>
</#list>
<form action="/admin/user/delete/${user.id}" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Удалить пользователя"/>
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>