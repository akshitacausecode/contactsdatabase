<html>
	<head>
		<title>CREATE CONTACT DATABASE</title>
		<asset:stylesheet href="bootstrap.css"/>
		<asset:stylesheet href="font-awesome.min.css"/>
		<asset:stylesheet src="jquery.css"/>
		<asset:stylesheet src="font-awesome.min.css"/>
		<asset:stylesheet src="bootstrap.min.js"/>
		<style>
		.well{
		background-color:blue;
		}
		.h1{color:"golden"
		}
		</style>
	</head>
	<body>
        <nav class="navbar navbar-default">
          <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
            <a class="navbar-brand" href="#">Brand</a>
                </div>
                </nav>


    	    <nav class="navbar navbar-default navbar-fixed-top">
              <div class="container">


              </div>
            </nav>

                <div class="col-md-offset-4 col-md-4 col-xs-offset-4 col-xs-12 well">
                    <div>
                        <h3>ENTER DETAILS</h3>
                        <g:form controller="Contacts" action="Saving">
                            <div class="form-group ${hasErrors(bean: user, field: 'firstName', 'has-error')}">
                                <g:textField name="firstName" placeholder="First Name" class="form-control" value="${user.firstName}"
                                    autofocus="firstName">
                                </g:textField>
                                <g:renderErrors bean="${user}" field="firstName" />
                            </div>
                            <div class="form-group ${hasErrors(bean: user, field: 'lastName', 'has-error')}"">
                                <g:textField name="lastName" placeholder="Last Name" class="form-control" value="${user.lastName}" 									autofocus="lastName">
                                </g:textField>
                                <g:renderErrors bean="${user}" field="lastName" />
                            </div>
                            <div class="form-group ${hasErrors(bean: user, field: 'email', 'has-error')}"">
                                <g:textField name="email" placeholder="Email" class="form-control" value="${user.email}"
                                     autofocus="email">
                                </g:textField>
                                <g:renderErrors bean="${user}" field="email" />
                            </div>
                            <div class="form-group ${hasErrors(bean: user, field: 'phoneNumber', 'has-error')}"">
                                <g:textField name="phoneNumber" placeholder="Phone Number" class="form-control" value="${user.phoneNumber}" 								autofocus="phoneNumber">
                                </g:textField>
                                <g:renderErrors bean="${user}" field="phoneNumber" />
                            </div>
                            <div class="form-group">

                                <%--<g:datePicker name="fromDate" value="${params?.fromDate?: new Date().clearTime()}"
                                precision="day" noSelection="['':'-Choose-']"/>--%>
                                <input type="date" name="date"/>
                            </div>

                            <g:submitButton name="click here" class="btn btn-md"></g:submitButton>
                        </g:form>
                    </div>
                </div>
            </div>
        </div>

	</body>

