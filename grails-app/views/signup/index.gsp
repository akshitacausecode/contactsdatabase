<html>
    <head>
        <title></title>
        <meta name="layout" content="head.gsp">
    </head>
    <body>
        <content tag="body">
            <g:form controller="Signup" action="Saving">
                <div class="form-group">
                    <g:textField name="username" placeholder="your email id" class="form-control"
                     autofocus="username" required="true">
                    </g:textField>
                </div>
                <div class="form-group">
                    <g:textField name="password" placeholder="password" class="form-control"
                    required="true">
                    </g:textField>
                </div>
                <g:submitButton name="Save User" class="btn btn-success"></g:submitButton>
            </g:form>
        </content>
    </body>
</html>
