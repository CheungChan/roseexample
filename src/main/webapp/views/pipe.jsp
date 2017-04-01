<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rosepipe" uri="http://paoding.net/rose/pipe"%>
<html>
<head>
    <title>portal/pipe演示信息</title>
    <script type='text/javascript' src='/js/rosepipe.js'></script>
</head>
<body>
portal/pipe演示信息：
<br>
<div id="p1"></div>
<br>
<div id="p2"></div>
</body>
</html>
<rosepipe:write>${p1}</rosepipe:write>
<rosepipe:write>${p2}</rosepipe:write>
