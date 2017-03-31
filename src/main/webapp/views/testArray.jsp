<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>testArray</title>
</head>
<body>
    <c:forEach var="item" items="${array}" varStatus="status">
        打印：${item}<br>
    </c:forEach>
</body>
</html>
