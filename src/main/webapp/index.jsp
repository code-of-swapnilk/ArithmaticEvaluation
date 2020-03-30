<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Hello World</title>

<script>
function doOnLoad()
{
	document.getElementById('inputDataForm').submit();
}
</script>

</head>
<body onLoad=doOnLoad();>
<form:form method="post" commandName="inputDataForm"  action="inputPage" name="inputDataForm" />
</body>
</html>