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
				<h1>Książka</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${book.title}</h3>
				<p>${book.authorsString}</p>
				<%--<p>--%>
					<%--<strong>ISBN: </strong><span class="label label-warning">${book.bookId}</span>--%>
				<%--</p>--%>
				<%--<h4>${book.unitPrice} PLN</h4>--%>
				<p>
					<a href="<spring:url value="/books/reservation?id=${book.id}" />" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"></span> Zarezerwuj
					</a>
					<a href="<spring:url value="/books/all" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> powrót
					</a>
				</p>
			</div>
		</div>
	</section>
</body>
</html>
