<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Departamento</title>
    </head>
    <body>
        <h3>Aterar o departamento</h3>
        <form method="POST" action="${pageContext.request.contextPath}/principal">
            <!-- Aqui envia o valor Cargo.inserir, e o nome do imput é command -->
            <input type="hidden" name="command" value="Dep.alterar"/>
            <label for="nome">Codigo: </label>
            <input value="${dep.codigo}" type="text" name="codigo" size="30"/><br/><br/>
            <label for="nome">Nome: </label>
            <input value="${dep.nome}" type="text" name="nome" size="30"/>
            <br/>
            <br/>
            <input type="submit" value="Enviar"/>
            <a href="${pageContext.request.contextPath}/principal?command=Dep.listar">Cancelar</a>
        </form>
    </body>
</html>
