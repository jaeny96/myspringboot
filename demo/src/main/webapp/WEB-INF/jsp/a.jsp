<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello</title>
</head>
<body>
a.jsp입니다
<hr>
jstl도 잘 됩니다
<c:set var="test" value="JSTL입니다"></c:set>
${test}
</body>
</html>