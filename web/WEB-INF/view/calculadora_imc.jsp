<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="entrada?txtAcao=Calculadora" var="linkCalculadora"></c:url>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora IMC</title>
    </head>
    <body>
        <p> 
            Usuario Logado: ${usuarioLogado.login} 
            <%@include file="logout.jsp" %>
        </p>
        <h1>Calculadora IMC</h1>
        <form action="${linkCalculadora}" method="POST">
            <label>Peso (em kg)</label></br> 
            <input type="text" name="txtPeso" placeholder="ex: 65"/>
            </br> 
            </br>
            
            <label>Altura (em metros)</label></br> 
            <input type="text" name="txtAltura" placeholder="ex: 1.75"/>
            </br> 
            </br>
            
            <input type="submit" name="btnCalcular" value="Calcular"/>
        </form>
            
        <p>
            <fmt:formatNumber 
                maxFractionDigits="2" 
                var="imcFmt" 
                value="${imc.calcular()}" 
            />
            ${imcFmt}
        </p>
        <p>
            ${imc.classificacao()}
        </p>
    </body>
</html>
