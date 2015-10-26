<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargo</title>
    </head>
    <body>
        <h3>Novo cargo</h3>
        <form method="POST" action="${pageContext.request.contextPath}/principal">
            <!-- Aqui envia o valor Cargo.inserir, e o nome do imput é command -->
            <input type="hidden" name="command" value="Cargo.inserir"/>
            <label for="nome">Nome: </label>
            <input type="text" name="nome" size="30"/>
            <br/>
            <br/>
            <input type="submit" value="Enviar"/>
            <a href="${pageContext.request.contextPath}/principal?command=Cargo.listar">Cancelar</a>
        </form>

    </body>
</html>
