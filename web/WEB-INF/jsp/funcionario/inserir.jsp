<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionário</title>
    </head>
    <body>
        <h3>Novo funcionário</h3>
        <form method="POST" action="${pageContext.request.contextPath}/principal">
            
            <!-- Aqui envia o valor Func.inserir, e o nome do imput é command -->
            <input type="hidden" name="command" value="Func.inserir"/>
            
            <label for="nome">Nome: </label>
            <input type="text" name="nome" size="30"/>
            <br/>
            <br/>
            <label for="cargo">Cargo: </label>
            <select name="codigoCargo">
                <c:forEach items="${cargos}" var="cargo" >
                  <option value="${cargo.codigo }" >${cargo.nome }</option>
                </c:forEach>
            </select>
            <br/>
            <br/>
            <label for="dep">Departamento: </label>
            <select name="codigoDep">
                <c:forEach items="${deps}" var="dep" >
                  <option value="${dep.codigo }" >${dep.nome }</option>
                </c:forEach>
            </select>
            <br/>
            <br/>
            <label for="nome">Data de contratação: </label>
            <input type="text" name="dt_contratacao"/>
            <br/>
            <br/>
            <input type="submit" value="Enviar"/>
            <a href="${pageContext.request.contextPath}/principal?command=Func.listar">Cancelar</a>
        </form>
    </body>
</html>
