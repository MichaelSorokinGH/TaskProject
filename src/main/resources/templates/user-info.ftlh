<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>APPS</h1><hr>
<h3>Информация о пользователе ${user.name}</h3>
<b>Номер телефона: </b> ${user.phoneNumber}<br>
<b>Эл. почта": </b> ${user.email}<br>
<h4>Заявки пользователя${user.name}</h4>
<#list apps as app>
    <div>
        <p><b>${app.title}</b> ${app.price} руб. | <a href="/app/${app.id}">Подробности...</a></p>
    </div>
    <#else>
    <h3>Заявок не найдено</h3>
</#list>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>