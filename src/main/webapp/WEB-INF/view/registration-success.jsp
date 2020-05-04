<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        table, th, tr
        {
            border: 1px solid #ccc;
        }
        table
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

    <a href="/">Home</a>
</body>
</html>