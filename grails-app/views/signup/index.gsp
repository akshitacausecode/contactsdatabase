<html>
    <head>
        <title></title>
        <meta name="layout" content="head.gsp">
    </head>
    <body>
        <content tag="body">
            <div class="row">
                <div class="col-md-offset-1 col-md-8">
                    <h2>SIGN UP</h2><hr>
                </div>
            </div>
            <div class="col-md-offset-1 col-md-4 col-xs-12">
                <div class="well top-mrgn">
                    <div class="addContact">
                        <h3>ENTER DETAILS</h3>
                        <g:form controller="Signup" action="Saving">
                            <div class="form-group ${hasErrors(bean: user, field: 'username', 'has-error')}">
                                <g:textField name="username" placeholder="your email id" class="form-control"
                                  autofocus="username" required="true">
                                </g:textField>
                                <g:renderErrors bean="${user}" field="username" />
                            </div>
                            <div class="form-group ${hasErrors(bean: user, field: 'password', 'has-error')}">
                                <g:textField name="password" placeholder="password" class="form-control"
                                 required="true">
                                </g:textField>
                                <g:renderErrors bean="${user}" field="password" />
                            </div>
                            <g:submitButton name="Save User" class="btn btn-success"></g:submitButton>
                        </g:form>
                    </div>
                </div>
                <center><a href="/login/" class="btn btn-primary" role="button">already have an account? login!</a></center>
            </div>
        </content>
    </body>
</html>
