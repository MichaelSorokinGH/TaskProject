<!DOCTYPE html>
<html>
<head>
    <title>TASKS</title>
</head>
<body>
<h1>TASKS</h1>
<hr>
<h4>Панель администратора</h4>
<table border="1">
    <tr>
        <th>Эл. почта</th>
        <th>Номер телефона</th>
        <th>Активность</th>
        <th>Подробная информация</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th>${user.phoneNumber}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><a href="/user/${user.id}">Подробная информация</a></th>
        </tr>
    <#else>
        <h3>Пользователей нет</h3>
    </#list>
</table>
</body>
</html>