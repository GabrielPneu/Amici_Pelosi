<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <jsp:include page="part/head.jsp"/>
    <title>Esqueci Minha Senha</title>
</head>
<jsp:include page="part/header.jsp"/>
<body>
<form action="/changePassword" method="post">
    <input type="hidden" name="token" value="${token}"/>
    <div class="modal-body">
        <div class="form-group row">
            <label class="col-md-4 control-label">Nova Senha:</label>
            <div class="col-md-4">
                <input class="form-control" type="password"
                       name="newPassword" placeholder="Digite a nova senha">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-md-4 control-label">Confirmar Senha:</label>
            <div class="col-md-4">
                <input class="form-control" type="password"
                       name="confirmPassword" placeholder="Confirme a nova senha">
            </div>
        </div>

        <button class="btn nut1 col-md-2" type="submit">Alterar Senha</button>
        <br/>  <br/>

    </div>
</form>

</body>
<jsp:include page="part/footer.jsp"/>
<jsp:include page="part/modal.jsp"/>
<jsp:include page="part/script.jsp"/>
</html>
