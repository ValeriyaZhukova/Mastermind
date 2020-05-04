<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <style>
        table, th, td
        {
            border: 1px solid black;
        }
        table
        {
            width: 40%;
            border-collapse: collapse;
        }
        th, td
        {
            height: 40px;
            text-align: center;
            font-size: 1.5rem;
        }
    </style>
</head>
<body>
    <h1>Users</h1>

    <br/>
    
    <div>
        <table >
            <tr>
                <th>Username</th>
                <th>Won</th>
                <th>Lost</th>
                <th>Best score</th>
                <th>Games played</th>
            </tr>
            <jsp:useBean id="users" scope="request" type="java.util.List"/>
            <c:forEach  items="${users}" var ="user">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.score.won}</td>
                    <td>${user.score.lost}</td>
                    <td>${user.score.bestScore}</td>
                    <td><a href="/games/${user.id}">games</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>