<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        table, th, td
        {
            border: none;
        }
        table
        {
            margin: 0 auto;
        }
        th, td
        {
            height: 20px;
            font-weight: bold;
        }
        h2
        {
            margin: 0;
        }
        .form-header
        {
            height: 60px;
            color: white;
            text-align: center;
            background-color: #99ccff;
            margin-bottom: 40px;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .signup
        {
            width: 350px;
            height: 380px;
            border: 1px solid #99ccff;
            margin: 40px auto;
            border-radius: 4px;
        }
        input[type=text], input[type=password]
        {
            height: 30px;
            width: 300px;
            padding: 12px 20px;
            margin: 8px 0 20px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type=submit]
        {
            width: 100%;
            background-color: #3399ff;
            color: white;
            padding: 14px 20px;
            margin: 20px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="signup" >
        <%--@elvariable id="user" type="kz.iitu.mastermind.model.User"--%>
        <div class="form-header">
            <h2>Sign up</h2>
        </div>
        <form:form action="saveSignUpForm/" method="post" modelAttribute="user">
            <table border="0">
                <tr>
                    <td>Username:</td>
                </tr>
                <tr>
                    <td><form:input path="username" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                </tr>
                <tr>
                    <td><form:password path="password" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>