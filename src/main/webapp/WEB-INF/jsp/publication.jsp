<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Новости</title>
</head>
<body>
<div>
    <h2>Публикации</h2>
<div>
       <table>
          <thead>
          <th>Name</th>
          <th>isbn</th>
          <th>Author</th>
          <th>Type</th>
          <th>Page</th>
          <th>Count</th>
          <th>Publisher</th>
          </thead>
          <c:forEach items="${allPublication}" var="publication">
            <tr>
              <td>${publication.name}</td>
              <td>${publication.isbn}</td>
              <td>${publication.author}</td>
              <td>${publication.type}</td>
              <td>${publication.page}</td>
              <td>${publication.count}</td>
              <td>${publication.publisher}</td>
            </tr>
          </c:forEach>
        </table>
        </div>
    <a href="/">Главная</a>
</div>
</body>
</html>