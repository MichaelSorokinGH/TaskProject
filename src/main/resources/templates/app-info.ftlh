<!DOCTYPE html>
<html>
<head>
    <title>APPS</title>
</head>
<body>
<h1>APPS</h1><hr>
<h4>Подробная информация о заявке</h4>
<b>Название заявки: </b>${app.title}<br>
<b>Описание заявки: </b>${app.description}<br>
<b>Цена: </b>${app.price}<br>
<b>Город: </b>${app.city}<br>
<b>Имя: </b><a href="/user/${app.user.id}">${app.user.name}</a><br>
<form action="/app/delete/${app.id}" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Удалить заявку"/>
</form>
</body>
</html>