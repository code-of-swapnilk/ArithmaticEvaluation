<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<html>
<head>
<title>Arithmatic Expression Evaluation</title>
</head>
<body>

<form:form method="post" commandName="inputDataForm" action="inputPage" name="inputDataForm">

	<h3>Arithmatic Expression Evaluation</h3>
	<fieldset>
		<legend>Input Field</legend>
		<label>Input Expression :</label>
		<form:input id="field1" path="field1" readonly="true"/>
	</fieldset>

	<fieldset>
		<legend>Result</legend>
		<form:input id="field2" path="field2" readonly="true" />
	</fieldset>
	
	<fieldset>
		<legend>Button</legend>
		<input type="submit" value="Go to Homepage" />
	</fieldset>
</form:form>
</body>
</html>