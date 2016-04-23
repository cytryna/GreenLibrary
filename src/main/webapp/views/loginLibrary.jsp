<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Авторизація</title>


    <link href="../../resources/bootstrap-dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../resources/css/signin.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <spring:url var="authUrl" value="/static/j_spring_security_check" />
    <form class="form-signin" method="post" action="${authUrl}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <h2 class="form-signin-heading">Авторизуйтеся</h2>
        <label for="inputUsername" class="sr-only">Логін</label>
        <input type="text" id="inputUsername" name="j_username"
               class="form-control" placeholder="Логін" required autofocus>
        <label for="inputPassword" class="sr-only">Пароль</label>
        <input type="password" id="inputPassword" name="j_password"
               class="form-control" placeholder="Пароль" required>
        <div class="checkbox">
            <label>
                <input type="checkbox"
                       name="_spring_security_remember_me"
                       value="remember-me">Залишатися авторизованим
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Увійти</button>
    </form>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../resources/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
