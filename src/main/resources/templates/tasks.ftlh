<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>TASKS</title>
</head>
<body>
<h1>TASKS</h1>
<hr>
<#if user.email??>
    <h3>Имя пользователя: <i>${user.name}</i></h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти"/>
    </form>
    <#if user.isAdmin()>
        <a href="/admin">Панель администратора</a>
    </#if>
    <#if user.isExecutor()>
        <a href="/executor">Панель исполнителя</a>
    </#if>
<#else>
    <a href="/login">Войти</a></h1>
</#if>
<hr>
<h4>Все заявки</h4>
<form action="/" method="get">
    Поиск по названию заявки: <input type="text" name="title">
    <input type="submit" value="Поиск"/>
</form>
<#list tasks as task>
    <div>
        <p><b>${task.title}</b> ${task.price} руб. | <a href="/task/${task.id}">Подробности...</a></p>
    </div>
<#else>
    <h3/>Заявок нет</h3>
</#list>
<#if user.email??>
    <hr>
    <h3>Создать новую заявку</h3>
    <form action="/task/create" method="post">
        Название заявки: <input type="text" name="title"/><br><br>
        Детали обращения: <input type="text" name="description"/><br><br>
        Цена: <input type="number" name="price"/><br><br>
        Адрес: <input type="text" name="address"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить заявку"/>
    </form>
</#if>
</body>
</html>