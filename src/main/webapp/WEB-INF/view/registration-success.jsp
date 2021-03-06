<%--@elvariable id="user" type="kz.iitu.mastermind.model.User"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .table, .table th, .table tr
        {
            border: 1px solid #ccc;
        }
        .table
        {
            width: 25%;
            border-collapse: collapse;
            margin-bottom: 40px;
        }
        td
        {
            height: 40px;
            width: 50%;
            font-size: 1.2rem;
            text-align: center;
        }
        a
        {
            font-size: 1.2rem;
            color: black;
        }
    </style>
</head>
<body>
    <table class="table table-striped table-bordered">
        <h2>Registration completed successfully</h2>
        <jsp:useBean id="user" scope="request" type="kz.iitu.mastermind.model.User"/>
        <tr>
            <td><b>Username</b>: </td>
            <td>${user.username}</td>
        </tr>
        <tr>
            <td><b>Best score</b>:</td>
            <td>${user.score.bestScore}</td>
        </tr>
        <tr>
            <td><b>Won</b>:</td>
            <td>${user.score.won}</td>
        </tr>
        <tr>
            <td><b>Lost</b>:</td>
            <td>${user.score.lost}</td>
        </tr>
    </table>

    <div>
        <div class="form-header">
            <h2>Add new user info</h2>
        </div>
        <%--@elvariable id="userInformation" type="kz.iitu.mastermind.model.UserInformation"--%>
        <form:form action="/user-info/add/" method="post" modelAttribute="userInformation">
            <table border="0">
                <tr>
                    <td>First name:</td>
                </tr>
                <tr>
                    <td><form:input path="firstName" /></td>
                </tr>
                <tr>
                    <td>Last name:</td>
                </tr>
                <tr>
                    <td><form:input path="lastName" /></td>
                </tr>
                <tr>
                    <td>Email:</td>
                </tr>
                <tr>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td>Birth date:</td>
                </tr>
                <tr>
                    <td><form:input path="birthDate" /></td>
                </tr>
                <tr>
                    <td>Gender:</td>
                </tr>
                <tr>
                    <td><form:input path="gender" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form:form>
    </div>


    <a href="/">Home</a>
</body>
</html>