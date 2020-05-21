<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mastermind</title>
</head>
<body>
    <div class="form-header">
        <h2>Mastermind</h2>
    </div>
    <form:form action="" method="post" >
        <table border="0">
            <tr>
                <td>Current guess:</td>
            </tr>
            <tr>
                <td><form:input path="currentGuess" /></td>
            </tr>
                <td colspan="2" align="center"><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>