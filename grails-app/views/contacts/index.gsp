<!doctype html>
<html>
    <head>
        <meta name="layout" content="head"/>
    </head>
    <body>
        <content tag="body">
        <div class="container-fluid well">
            <h3 align="center">CONTACT DATABASE</h1>
        </div>
        <h4 align="center">Welcome, ${user.username} !</h4>
        <hr>
        <div class="box-model main-padding">
            <div class="col-md-offset-1 col-md-5 col-xs-offset-1 col-xs-11 well">
                <div class="aln-ctr">
                    <h3>Click Below To add a contact</h3>
                    <a href="/contacts/addContact">
                        <button type="button" class="btn btn-success btn-lg"> ADD CONTACT </button>
                    </a>
                </div>
            </div>
            <div class="col-md-offset-1 col-md-5 col-xs-offset-1 col-xs-11 well">
                <div class="aln-ctr">
                    <h3>Click Below To List</h3>
                    <a href="/contacts/list">
                        <button type="button" class="btn btn-success btn-lg"> LIST
                        </button>
                    </a>
                </div>
            </div>
        </div>
        </content>
    </body>
</html>
