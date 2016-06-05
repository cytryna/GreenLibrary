<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Książka</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Rezerwacja</h1>
        </div>
        <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">wyloguj</a>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <h3>${book.title}</h3>
            <p>${book.author}</p>
            <p>
                Dokonano rezerwacji książki ${book.title} na czas 2 tygodni
                <a href="<spring:url value="/books/all" />" class="btn btn-default">
                    <span class="glyphicon-hand-left glyphicon"></span> powrót
                </a>
            </p>
        </div>
    </div>
</section>
</body>
</html>
