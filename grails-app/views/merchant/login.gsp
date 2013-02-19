<%--
  Created by IntelliJ IDEA.
  User: gerhard
  Date: 2/14/13
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
    <ul>
        <li>
          <label>Email</label>
          <g:textField name="email"></g:textField>
        </li>
        <li>
            <label>Password</label>
            <g:passwordField name="password"></g:passwordField>
         </li>
        <li>
          <g:link controller="merchant">Can't remember your password</g:link>
        </li>
        <li>
          <g:submitButton name="Login"></g:submitButton>
        </li>
        <li>
            <g:hiddenField name="somehing hidding"></g:hiddenField>
        </li>
        <li>
            <g:submitButton name="No Account. Please Register "></g:submitButton>
        </li>

    </ul>
</body>
</html>