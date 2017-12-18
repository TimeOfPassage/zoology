<html>
	<head>
		<title>freemarker</title>
	</head>
	<body>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Password</th>
				</tr>
			</thead>		
			<tbody>
				<#list userList as l >
				<tr>
					<td>${l.id }</td>
					<td>${l.userName }</td>
					<td>${l.password }</td>
				</tr>
				</#list>
			</tbody>
		</table>
	</body>
</html>