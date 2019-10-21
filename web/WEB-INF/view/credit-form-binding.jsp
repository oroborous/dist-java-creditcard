<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Credit Form w/Data Binding</title>
</head>
<body>

<form:form modelAttribute="card" action="done3">
    Name: <form:input path="name"/>
    <br/>
    Card number: <form:input path="number"/>
    <br/>
    Exp date: <form:input path="expDate"/>
    <br/>
    Sec code: <form:input path="secCode"/>
    <br/>
    <input type="submit"/>
</form:form>
</body>
</html>
