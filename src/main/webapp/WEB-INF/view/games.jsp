<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Games</title>
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
<h1>User games</h1>

<br/>

<div>
    <table >
        <tr>
            <th>Username</th>
            <th>Secret number</th>
            <th>Score</th>
            <th>Number of guesses</th>
            <th>Won</th>
        </tr>
        <jsp:useBean id="games" scope="request" type="java.util.List"/>
        <c:forEach  items="${games}" var ="game">
            <tr>
                <td>${game.user.username}</td>
                <td>${game.secretNumber}</td>
                <td>${game.score}</td>
                <td>${game.numberOfGuesses}</td>
                <td>${game.win}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>