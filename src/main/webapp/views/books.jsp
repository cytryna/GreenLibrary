<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Produkt</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Green Library</h1>
            <p>Wyszukiwanie</p>
        </div>
    </div>
</section>

<section class="container">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                        <form action="<c:url value="/books${title}" />" class="navbar-form navbar-left" role="search" method="get">
                            Tytuł
                            <div class="form-group">
                                <input type="text" class="form-control" name="title"/>
                            </div>
                            <button type="submit" class="btn btn-default">
                                Szukaj
                            </button>
                        </form>
                    </div>

                </nav>
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>
                                    Tytuł
                                </th>
                                <th>
                                    Autor
                                </th>
                                <th>
                                    Status
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${books}" var="c">
                                <tr class="active">
                                    <td>
                                            ${c.title}
                                    </td>
                                    <td>
                                            ${c.author}
                                    </td>
                                    <td>
                                            ${c.reserved}
                                        <a href=" <spring:url value="/books/${c.id}"/> " class="btn btn-primary"> Wybierz
                                        </a>

                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
