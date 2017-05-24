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
                    <g:form name="filter" id="1" controller="Contacts" action="filterResult" style="display:inline-flex">
                        <g:textField name="value" placeholder="search here:" class="form-control"/>
                        <g:submitButton name="search" class="btn btn-primary btn-style" value="Search"/>
                    </g:form>
                    <g:form name="groupValue" id="2" controller="Contacts" action="groupContact" style="display:inline-flex">
                        <g:textField name="value" placeholder="Group Contacts by marking:" class="form-control"/>
                        <g:submitButton name="search for group" class="btn btn-primary btn-style" value="Search"/>
                    </g:form>
                    <table class="table table-bordered text-center top-mrgn">
                        <thead>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Marking</th>
                        <th>Phone Number</th>
                        <th>Date of Birth</th>
                        <th>EDIT</th>
                        <th>DELETE</th>
                        <th>Created By:</th>
                    </thead>
                    <g:if test="${allCreatedContacts}">
                        <g:each in="${allCreatedContacts}" var="personDetail">
                            <tr>
                                <td>${personDetail.firstName}</td>
                                <td>${personDetail.lastName}</td>
                                <td>${personDetail.email}</td>
                                <td>${personDetail.markData}</td>
                                <td>${personDetail.phoneNumber}</td>
                                <td>${personDetail.dob}</td>
                                <td>
                                <g:link controller="Contacts" action="edit" id="${personDetail.id}"
                                class="text-color">Edit</g:link>
                                </td>
                                <td>
                                  <g:link controller="Contacts" action="delete" id="${personDetail.id}"
                                  class="text-color" onclick="return confirm ('Are you sure?')">Delete</g:link>
                                </td>
                                <td>${personDetail.userInstance.username}</td>
                            </tr>
                        </g:each>
                    </g:if>
                    <g:else><h3>ENTER VALID CONTENT!!!!</h3></g:else>
                    </table>
                </div>
            </div>
        </content>
	</body>
</html>
