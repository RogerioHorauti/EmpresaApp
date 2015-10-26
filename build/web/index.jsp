<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
    </head>
    <body>
        <h2>Arquitetura e projeto de sistemas</h2>
        <br/>
        <a href="${pageContext.request.contextPath}/principal?command=Cargo.listar">Cargo</a> | 
        <a href="${pageContext.request.contextPath}/principal?command=Dep.listar">Departamento</a> | 
        <a href="${pageContext.request.contextPath}/principal?command=Func.listar">Funcionario</a> | 
    </body>
</html>
