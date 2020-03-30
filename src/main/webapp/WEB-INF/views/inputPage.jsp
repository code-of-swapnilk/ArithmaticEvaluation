<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Arithmatic Expression Evaluation</title>
</head>

<script type="text/javascript">
function onClick()
{
	var field1 = document.getElementById('field1').value;
	if(field1 != ""){
		document.getElementById('inputDataForm').submit();
	} else {
		alert('Kindly enter input expression first!')
	}
}
</script>

<body>
<form:form method="post" commandName="inputDataForm" action="evaluateExpr" name="inputDataForm">

<h3>Arithmatic Expression Evaluation</h3>
	<fieldset>
	 	<legend>Input Field</legend>
		<p>
			<label>Input Expression :</label>
				<form:input id="field1" path="field1" maxlength="100" />
			<br>
		</p>
	</fieldset>
	<fieldset>
	 	<legend>Button</legend>
	 	<input type="button" value="Evaluate Expression" onclick="onClick()"/>
	</fieldset>
</form:form>		

</body>
</html>