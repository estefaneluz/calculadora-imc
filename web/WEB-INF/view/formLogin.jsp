<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="entrada?txtAcao=Login" var="linkLogin"></c:url>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Acesso a Calculadora</h1>
        <form action="${linkLogin}" method="POST">
            <label>Login</label>
            <input type="text" name="txtLogin"/>
            <label>Senha</label>
            <input type="password" name="txtSenha" />
            <input type="submit" name="btnLogin" value="Login"/>
        </form>
    </body>
</html>
