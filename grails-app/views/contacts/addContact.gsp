<html>
	<head>
        <meta name="layout" content="head.gsp">
	</head>
	<body>
	    <content tag="body">
            <div class="row">
                <div class="col-md-offset-1 col-md-8">
                    <h2>CREATE CONTACT</h2><hr>
                </div>
            </div>
            <div class="col-md-offset-1 col-md-4 col-xs-12">
                <div class="well top-mrgn">
                    <div class="addContact">
                        <h3>ENTER DETAILS</h3>
                        <g:form controller="Contacts" action="Saving">
                            <div class="form-group ${hasErrors(bean: user, field: 'firstName', 'has-error')}">
                                <g:textField name="firstName" placeholder="First Name" class="form-control"
                                    value="${user.firstName}" autofocus="firstName" required="true">
                                </g:textField>
                                <g:renderErrors bean="${user}" field="firstName" />
                            </div>
                            <div class="form-group ${hasErrors(bean: user, field: 'lastName', 'has-error')}">
                                <g:textField name="lastName" placeholder="Last Name" class="form-control"
                                    value="${user.lastName}" autofocus="lastName" required="true">
                                </g:textField>
                                <g:renderErrors bean="${user}" field="lastName" />
                            </div>
                            <div class="form-group ${hasErrors(bean: user, field: 'email', 'has-error')}">
                                <g:textField name="email" placeholder="email" class="form-control" value="${user.email}"
                                    autofocus="email" required="true">
                                </g:textField>
                                <g:renderErrors bean="${user}" field="email" />
                            </div>
                           <div class="form-group col-md-6 col-sm-6 col-xs-12 ${hasErrors(bean: user, field:'markData',
                            'has-error')}">
                                <label for="markData">Marking</label>
                                <select name="markData" id="markData" class="form-control" value="${user.markData}">
                                    <option value="Regular"> Mark contact as</option>
                                    <option value="Favorite">Favorite</option>
                                    <option value="Vip">VIP</option>
                                    <option value="Friend">Friend</option>
                                    <option value="Regular"> Regular</option>
                                </select>
                                <g:renderErrors bean="${user}" field="markData"/>
                            </div>
                            <div class="form-group ${hasErrors(bean: user, field: 'phoneNumber', 'has-error')}">
                                <g:textField name="phoneNumber" placeholder="Phone Number" class="form-control"
                                    value="${user.phoneNumber}" autofocus="phoneNumber" required="true">
                                </g:textField>
                                <g:renderErrors bean="${user}" field="phoneNumber" />
                            </div>
                            <div class="form-group ${hasErrors(bean: user, field: 'data', 'has-error')}">
                                <label>Select Date Of Birth :</label><input type="date" class="font-clr" name="date" value="${user.dob}" required/>
                                <g:renderErrors bean="${user}" field="dob" />
                            </div>
                            <g:submitButton name="Add User" class="btn btn-success"></g:submitButton>
                        </g:form>
                    </div>
                </div>
            </div>
        </content>
	</body>
</html>