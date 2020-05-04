<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
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
        .signin
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
    <div class="signin" >
        <%--@elvariable id="user" type="kz.iitu.mastermind.model.User"--%>
        <div class="form-header">
            <h2>Sign in</h2>
        </div>
        <form name='login' action="login" method='POST' modelAttribute="user">
            <table>
                <tr>
                    <td>Username:</td>
                </tr>
                <tr>
                    <td><input type='text' id="username" name='username' value=''></td>
                </tr>
                <tr>
                    <td>Password:</td>
                </tr>
                <tr>
                    <td><input type='password' id="password" name='password' /></td>
                </tr>
                <tr>
                    <td><input type="submit" id="submit" name="submit"  value="Login" /></td>
                </tr>
            </table>
        </form>
    </div>

    <script>
        jQuery(document).ready(function($)
        {
            $("#submit").click(function()
            {
                var userData = {};
                userData["username"] = $("#username").val();
                userData["password"] = $("#password").val();
                console.log("userdata:" + userData);
                $.ajax({
                    type : "POST",
                    contentType : "application/json;charset=UTF-8",
                    url : "login",
                    data : JSON.stringify(userData),
                    dataType : 'json',
                    success : function(data) {
                        return data;
                    }
                });
            });

        });
    </script>
</body>
</html>