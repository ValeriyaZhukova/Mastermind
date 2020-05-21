<%--
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div  >
    &lt;%&ndash;@elvariable id="userInformation" type="kz.iitu.mastermind.model.UserInformation"&ndash;%&gt;
    <div>
        <div class="form-header">
            <h2>Add new user info</h2>
        </div>
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
</div>
</body>
</html>--%>
