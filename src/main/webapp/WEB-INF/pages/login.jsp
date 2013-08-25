<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h2>Login</h2>
        <form method="post">
            <p>${errorMessage}<p/>
            <label for="username">Username:
            </label>
            <br/>
            <input type="text" name="username"/>
            <br/>

            <label for="username">Password:
            </label>
            <br/>

            <input type="password" name="password"/>
            <br/>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
