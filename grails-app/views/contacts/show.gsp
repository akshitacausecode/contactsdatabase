<html>
	<head>
        <meta name="layout" content="head.gsp">
	</head>
	<body>
	    <content tag="body">
            <div class="row">
                <div class="col-md-offset-1 col-md-8">
                    <h2>DISPLAYING CONTACT DETAILS</h2><hr>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <dl class="list-group-item dl-horizontal">
                        <dt>First Name:</dt>
                        <dd>${contactDisplay.firstName}</dd>
                        <dt>Last Name:</dt>
                        <dd>${contactDisplay.lastName}</dd>
                        <dt>E-mail:</dt>
                        <dd>${contactDisplay.email}</dd>
                        <dt>Phone Number:</dt>
                        <dd>${contactDisplay.phoneNumber}</dd>
                        <dt>Date Of Birth:</dt>
                        <dd>${contactDisplay.dob}</dd>
                    </dl>
        </content>
	</body>
</html>