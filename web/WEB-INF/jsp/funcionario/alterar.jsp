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
        <h3>Alterar o funcionário</h3>
        
        <form action="${pageContext.request.contextPath}/principal" method="POST">
            
            <c:forEach var="funcionario" items="${funcs}">
                <!-- Aqui envia o valor Func.inserir, e o nome do imput é command -->
                <input type="hidden" name="command" value="Func.alterar"/>
                <label>Codigo: </label>
                <input value="${funcionario.codigo}" type="text" name="codigo"/>
                <br/>
                <br/>
                <label>Nome: </label>
                <input value="${funcionario.nome} "type="text" name="nome"/>
                <br/>
                <br/>
                <label>Cargo: </label>
                <input value="${funcionario.cargo.codigo} "type="text" name="cargoCodigo"/>
                <input value="${funcionario.cargo.nome} "type="text" name="cargoNome"/>
                <br/>
                <br/>
                <label>Departamento: </label>
                <input value="${funcionario.departamento.codigo} "type="text" name="depCodigo"/>
                <input value="${funcionario.departamento.nome} "type="text" name="depNome"/>
                <br/>
                <br/>
                <label>Data de contratação: </label>               
                <!--Quando se utiliza o calendar precisa colocar o .time para converter para Date, A tag fmt trabalha com o tipo Date-->
                <input value="<fmt:formatDate value="${funcionario.dataContratacao.time}" type="date" pattern="dd/MM/yyyy"/>" type="text" name="dt_contratacao"/>
                
                <br/>
                <br/>
                <input type="submit" value="Enviar"/>   
                <a href="${pageContext.request.contextPath}/principal?command=Func.listar">Cancelar</a>
             </c:forEach>
             
        </form>      
    </body>
</html>
