<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mastermind</title>
    <style>
        .sign-in, .sign-up
        {
            width: 350px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        a, p
        {
            font-size: 1.5rem;
            color: black;
        }
    </style>
</head>
<body>
    <h1>Welcome to mastermind game</h1>
    <div class="sign-in">
        <p>Do you have an account?</p>
        <div class="auth-btn">
            <a href="/showSignInForm">Login</a>
        </div>
    </div>

    <div class="sign-up">
        <p>Create new account</p>
        <div class="auth-btn">
            <a href="/showSignUpForm">Register</a>
        </div>
    </div>

    <div class="list-users">
        <div class="auth-btn">
            <a href="/list-users">List users</a>
        </div>
    </div>

    <div class="play">
        <div class="play-btn">
            <a href="/mastermind">Play</a>
        </div>
    </div>



</body>
</html>