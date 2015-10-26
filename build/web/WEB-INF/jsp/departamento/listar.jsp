<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Departamento</title>
    </head>
    <body>
        <h3>Lista dos departamentos</h3>
        <a href="${pageContext.request.contextPath}/principal?command=Dep.formulario">inserir</a> | 
        <a href="${pageContext.request.contextPath}">principal</a>
        <br>
        <br>
        <table border="1">
             <thead>               
                <tr>
                    <th>Codigo</th>
                    <th>Nome</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="departamento" items="${deps}">
                <tr>
                    <td>${departamento.codigo}</td>
                    <td>${departamento.nome}</td>
                    <td><a href="${pageContext.request.contextPath}/principal?command=Dep.formAlterar&codigo=${departamento.codigo}">alterar</a></td>
                    <td><a href="${pageContext.request.contextPath}/principal?command=Dep.remover&codigo=${departamento.codigo}">remover</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
