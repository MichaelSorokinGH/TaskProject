<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
<#--    <title>TASKS</title>-->
<#--</head>-->
<#--<body>-->
<#--<h1>TASKS</h1>-->
<#--<hr>-->
<#--<h4>Панель исполнителя</h4>-->
<#--<table border="1">-->
<#--    <tr>-->
<#--        <th>Название заявки</th>-->
<#--        <th>Детали обращения</th>-->
<#--        <th>Цена</th>-->
<#--        <th>Адрес</th>-->
<#--        <th>Филиал</th>-->
<#--        <th>Отдел</th>-->
<#--        <th>Исполнитель</th>-->
<#--        <th>Статус заявки</th>-->
<#--        <th>Имя</th>-->
<#--        <th>Подробная информация</th>-->
<#--    </tr>-->
<#--    <#list tasks as task>-->
<#--        <tr>-->
<#--            <th>${task.title}</th>-->
<#--            <th>${task.description}</th>-->
<#--            <th>${task.price}</th>-->
<#--            <th>${task.address}</th>-->
<#--            <th>${task.branch}</th>-->
<#--            <th>${task.department}</th>-->
<#--            <th>${user.name}</th>-->
<#--            <th><a href="/user/${user.id}">Подробная информация</a></th>-->
<#--        </tr>-->
<#--    <#else>-->
<#--        <h3>Пользователей нет</h3>-->
<#--    </#list>-->
<#--</table>-->
<#--</body>-->
<#--</html>-->