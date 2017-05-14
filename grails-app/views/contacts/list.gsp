<html>
	<head>
        <meta name="layout" content="head.gsp">
	</head>
	<body>
        <content tag="body">

            <g:if test="${flash.message}" style="display: block">
                <div class="text-center bg-primary">
                    ${flash.message}
                </div>
            </g:if>

            <div class="row">
                <div class="col-md-offset-1 col-md-8">
                    <h2>LIST OF CONTACTS</h2><hr>
                    <table class="table table-bordered text-center top-mrgn">
                        <thead>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Phone Number</th>
                        <th>Date of Birth</th>
                    </thead>
                    <g:if test="${allCreatedContacts}">
                        <g:each in="${allCreatedContacts}" var="personDetail">
                            <tr>
                                <td>${personDetail.firstName}</td>
                                <td>${personDetail.lastName}</td>
                                <td>${personDetail.email}</td>
                                <td>${personDetail.phoneNumber}</td>
                                <td>${personDetail.dob}</td>
                                <td>
                                <g:link controller="Contacts" action="edit" id="${personDetail.id}"
                                class="text-color">Edit</g:link>
                                </td>
                            </tr>
                        </g:each>
                    </g:if>
                    <g:else><h3>OOPS!!!!!! DATABASE IS EMPTY!!!!</h3></g:else>
                    </table>
                </div>
            </div>

        </content>
	</body>
</html>
