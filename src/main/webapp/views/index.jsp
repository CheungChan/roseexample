<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
上传一个文件<br>
<form action="/hello/doUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"><br>
    <input type="submit" value="上传">
</form>
上传多个文件<br>
<form action="/hello/doUploads" method="post" enctype="multipart/form-data">
    <input type="file" name="file1"><br>
    <input type="file" name="file2"><br>
    <input type="file" name="file3"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
