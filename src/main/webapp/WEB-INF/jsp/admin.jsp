<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Log in with your account</title>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>

<h4><a href="/add">Добавить</a></h4>

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
                      <td>
                        <form action="${pageContext.request.contextPath}/admin/delete" method="POST">
                          <input type="hidden" name="name" value="${publication.name}"/>
                          <input type="hidden" name="isbn" value="${publication.isbn}"/>
                          <input type="hidden" name="author" value="${publication.author}"/>
                          <input type="hidden" name="publisher" value="${publication.publisher}"/>
                          <input type="hidden" name="action" value="delete"/>
                          <button type="submit">Delete</button>
                        </form>

                      </td>
            </tr>
          </c:forEach>
        </table>

  <a href="/">Главная</a>
</div>
</body>
</html>