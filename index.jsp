<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<h2>User Input Form</h2>
	<form method="post" action="EmployeePage">
		<fieldset>
			<legend>Personal Particular</legend>
			Name: <input type="text" name="username" /><br />
			<br /> ID: <input type="id" name="id" /><br />
			<br /> AGE: <input type="age" name="age" /><br /> 
			<br /> Gender: <input type="radio" name="gender" value="m" checked />Male
			<input type="radio" name="gender" value="f" />Female<br />
		</fieldset>
		
		<fieldset>
			<legend>Education BackGround</legend>
			<textarea rows="5" cols="30" name="instruction"></textarea>
		</fieldset>

		<fieldset>
			<legend>Roles for which You want to Apply</legend>
			<input type="checkbox" name="post" value="software engineer" checked />Software Engineer <input
				type="checkbox" name="post" value="manager" /> Manager<input
				type="checkbox" name="post" value="marketing team" />Marketing Team
		</fieldset>

		<input type="hidden" name="secret" value="888" /> <input
			type="submit" value="SEND" /> <input type="reset" value="CLEAR" />
	</form>
</body>
</html>
