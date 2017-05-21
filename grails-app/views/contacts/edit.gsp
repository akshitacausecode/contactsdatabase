<html>
	<head>
        <meta name="layout" content="head.gsp">
	</head>
	<body>
	    <content tag="body">
            <div class="row">
                <div class="col-md-offset-1 col-md-8">
                    <h2>EDIT CONTACT DETAILS</h2><hr>
                </div>
            </div>
            <div class="col-md-offset-1 col-md-4 col-xs-12">
                <div class="well top-mrgn">
                    <div class="addContact">
                        <h3>ENTER DETAILS</h3>
                        <g:form controller="Contacts" action="update">

                            <input type="hidden" name="id" value="${editContact.id}">

                            <div class="form-group ${hasErrors(bean: user, field: 'firstName', 'has-error')}">
                                <g:textField name="firstName" placeholder="First Name" class="form-control"
                                    value="${editContact.firstName}" autofocus="firstName" required="true">
                                </g:textField>
                                <g:renderErrors bean="${user}" field="firstName" />
                            </div>
                            <div class="form-group ${hasErrors(bean: user, field: 'lastName', 'has-error')}">
                                <g:textField name="lastName" placeholder="Last Name" class="form-control"
                                    value="${editContact.lastName}" autofocus="lastName" required="true">
                                </g:textField>
                                <g:renderErrors bean="${user}" field="lastName" />
                            </div>
                            <div class="form-group ${hasErrors(bean: user, field: 'email', 'has-error')}">
                                <g:textField name="email" placeholder="Email" class="form-control"
                                value="${editContact.email}" autofocus="email" required="true">
                                </g:textField>
                                <g:renderErrors bean="${user}" field="email" />
                            </div>
                            <div class="form-group ${hasErrors(bean: user, field: 'phoneNumber', 'has-error')}">
                                <g:textField name="phoneNumber" placeholder="Phone Number" class="form-control"
                                value="${editContact.phoneNumber}" autofocus="phoneNumber" required="true">
                                </g:textField>
                                <g:renderErrors bean="${user}" field="phoneNumber" />
                            </div>
                            <div class="form-group ${hasErrors(bean: user, field: 'data', 'has-error')}">
                                <label>Select Date Of Birth :</label><input type="date" class="font-clr" name="date"
                                value="${editContact.dob}" required/>
                                <g:renderErrors bean="${user}" field="dob" />
                            </div>
                            <g:submitButton name="Update Details" class="btn btn-success"></g:submitButton>
                        </g:form>
                        </div>
                    </div>
                </div>
            </div>
        </content>
	</body>
</html>