<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin" action="registration">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="emailId">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="email" path="emailId" class="form-control" placeholder="Email ID"
                            autofocus="true"></form:input>
                <form:errors path="emailId"></form:errors>
            </div>
        </spring:bind>
        
                <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" class="form-control" placeholder="First Name"
                            autofocus="true"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>
        
        
                <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="lastName" class="form-control" placeholder="Last Name"
                            autofocus="true"></form:input>
                <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>
        
        

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>


        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>