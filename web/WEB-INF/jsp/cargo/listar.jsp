<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargo</title>
    </head>
    <body>
        <h3>lista de cargos</h3>
        <!-- Chama o formulario inserir nomeado como formulario -->
        <a href="${pageContext.request.contextPath}/principal?command=Cargo.formulario">inserir</a> |
        <a href="${pageContext.request.contextPath}">principal</a>
        <br/>
        <br/>
        <table border="1">
            <thead>               
                <tr>
                    <th>Codigo</th>
                    <th>Nome</th>
                </tr>
            </thead>
            <tbody>
                <!-- Recebe a lista de cargos em cargos -->
                <c:forEach var="cargo" items="${cargos}">
                <tr>
                    <td>${cargo.codigo}</td>
                    <td>${cargo.nome}</td>
                    <td><a href="${pageContext.request.contextPath}/principal?command=Cargo.formAlterar&codigo=${cargo.codigo}">alterar</a></td>
                    <td><a href="${pageContext.request.contextPath}/principal?command=Cargo.remover&codigo=${cargo.codigo}">remover</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
