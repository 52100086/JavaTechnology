<%--
  Created by IntelliJ IDEA.
  User: Win 10
  Date: 3/1/2023
  Time: 8:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <h3 class="text-center text-secondary mt-5 mb-3">User Login</h3>
            <% if (session.getAttribute("flash_message") != null) { %>
            <div class="alert alert-danger">
                <%= session.getAttribute("flash_message") %>
            </div>
            <% } %>
            <form action = "/login" method = "post" class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input name = "username" id="username" type="text" class="form-control" placeholder="Username" value="${cookie.username != null ? cookie.username.value : ''}">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input name = "password" id="password" type="password" class="form-control" placeholder="Password" value="${cookie.password != null ? cookie.password.value : ''}">
                </div>
                <div class="form-group">
                    <input type="checkbox" id = "check1" name = "check1" value = "remember">
                    <label for="check1"> Remember username & password</label>
                </div>

                <div class="form-group">
                    <button class="btn btn-success px-5">Login</button>
                </div>

                <div class = "form-group">
                    <p>Don't have account, <a href="jsp/register.jsp">click here</a> to sign up</p>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>

