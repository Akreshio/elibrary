<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; harset=utf-8">
<title>New Customer</title>
</head>
<body>
    <div align="center">
    <h2>New Customer</h2>
    <form:form action="save" method="post" modelAttribute="publication">
    <table border="0" cellpadding="5">
        <tr>
            <td>Name: </td>
            <td><form:input path="name" /></td>
        </tr><tr>
            <td>isbn: </td>
            <td><form:input path="isbn" /></td>
        </tr><tr>
            <td>Author: </td>
            <td><form:input path="author" /></td>
        </tr><tr>
            <td>Type: </td>
            <td><form:input path="type" /></td>
        </tr><tr>
            <td>Page: </td>
            <td><form:input path="page" /></td>
        </tr><tr>
            <td>Count: </td>
            <td><form:input path="count" /></td>
        </tr><tr>
            <td>Publisher: </td>
            <td><form:input path="publisher" /></td>
        </tr><tr>
        <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
    </table>
    </form:form>
    </div>
</body>
</html>