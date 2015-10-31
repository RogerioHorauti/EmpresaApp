<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargo</title>
    </head>
    <body>
        <h3>Alterar cargo</h3>
        <form action="${pageContext.request.contextPath}/principal" method="POST">
           
                <!-- Aqui envia o valor Cargo.inserir, e o nome do imput é command -->
                <input type="hidden" name="command" value="Cargo.alterar"/>
                <label for="nome">Codigo: </label>
                <!--
                    Um exemplo de como pegamos o valor passado via GET
                    <input value="${param.codigo}" type="text" name="codigo" size="30"/>    
                    <input value="${param.nome}" type="text" name="nome" size="30"/>
                -->
                <input value="${cargo.codigo}" type="text" name="codigo" size="30"/><br/><br/>
                <label for="nome">Nome: </label>              
                <input value="${cargo.nome}" type="text" name="nome" size="30"/>
              
            <br/>
            <br/>
            <input type="submit" value="Enviar"/>
            <a href="${pageContext.request.contextPath}/principal?command=Cargo.listar">Cancelar</a>
        </form>
    </body>
</html>
