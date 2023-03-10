<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>APPS</title>
</head>
<body>
<h1>APPS</h1>
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
<#else>
    <a href="/login">Войти</a></h1>
</#if>
<hr>
<h4>Все заявки</h4>
<form action="/" method="get">
    Поиск по названию заявки: <input type="text" name="title">
    <input type="submit" value="Поиск"/>
</form>
<#list apps as app>
    <div>
        <p><b>${app.title}</b> ${app.price} руб. | <a href="/app/${app.id}">Подробности...</a></p>
    </div>
<#else>
    <h3/>Заявок нет</h3>
</#list>
<#if user.email??>
    <hr>
    <h3>Создать новую заявку</h3>
    <form action="/app/create" method="post">
        Название заявки: <input type="text" name="title"/><br><br>
        Описание заявки: <input type="text" name="description"/><br><br>
        Цена: <input type="number" name="price"/><br><br>
        Город: <input type="text" name="city"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить заявку"/>
    </form>
</#if>
</body>
</html>