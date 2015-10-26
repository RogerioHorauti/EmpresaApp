<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionário</title>
    </head>
    <body>
        <h3>Funcionários</h3>
        <a href="${pageContext.request.contextPath}/principal?command=Func.formulario">inserir</a> |
        <a href="${pageContext.request.contextPath}">principal</a>
        <br>
        <br>
        
        <table border="1">
             <tr>
                <th>Codigo</th>
                <th>Nome</th>
                <th>Cargo</th>
                <th>Departamento</th>
                <th>Data de Contratação</th>
            </tr>
            <c:forEach var="func" items="${funcs}">
                <tr>
                    <td>${func.codigo}</td> 
                    <td>${func.nome}</td>
                    <td>${func.cargo.nome}</td>
                    <td>${func.departamento.nome}</td>  
                    <!--    Note que eu chamei o método .time, pois o atributo dataContratacao do func é do tipo Calendar 
                    e a tag formatDate espera um objeto do tipo Date. -->
                    <td> <fmt:formatDate pattern="dd/MM/yyyy" value="${func.dataContratacao.time}"/> </td>
                    <td> <a href="${pageContext.request.contextPath}/principal?command=Func.alterar">alterar</a> </td>
                    <td> <a href="${pageContext.request.contextPath}/principal?command=Func.remover">remover</a> </td>
                </tr>  
            </c:forEach>
        </table>
    </body>
</html>
