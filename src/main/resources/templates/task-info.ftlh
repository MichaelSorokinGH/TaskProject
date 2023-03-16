<!DOCTYPE html>
<html>
<head>
    <title>TASKS</title>
</head>
<body>
<h1>TASKS</h1><hr>
<h4>Подробная информация о заявке</h4>
<b>Название заявки: </b>${task.title}<br>
<b>Детали обращения: </b>${task.description}<br>
<b>Цена: </b>${task.price}<br>
<b>Адрес: </b>${task.address}<br>
<b>Имя: </b><a href="/user/${task.user.id}">${task.user.name}</a><br>
<form action="/task/delete/${task.id}" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Удалить заявку"/>

</form>
</body>
</html>