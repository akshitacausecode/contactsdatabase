<html>
	<head>
		<title>create</title>
		<asset:stylesheet href="bootstrap.css"/>
		<asset:stylesheet href="font-awesome.min.css"/>
		<asset:stylesheet src="jquery.css"/>
		<asset:stylesheet src="bootstrap.min.js"/>
	</head>
	<body>
		<table class="table table-bordered text-center">
		    <thead>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone Number</th>
            </thead>
            <g:each in="${allCreatedContacts}" var="personDetail">
                <tr>
                    <td>${personDetail.firstName}</td>
                    <td>${personDetail.lastName}</td>
                    <td>${personDetail.email}</td>
                    <td>${personDetail.phoneNumber}</td>
                </tr>
            </g:each>
        </table>
	</body>
</html>
