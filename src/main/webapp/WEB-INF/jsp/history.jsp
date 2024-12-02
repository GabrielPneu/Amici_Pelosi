<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <jsp:include page="part/head.jsp"/>
    <title>Histórico de Pedidos</title>
</head>
<jsp:include page="part/header.jsp"/>
<body>
<section class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb__text">
                    <h4>Histórico de Transações</h4>
                    <div class="breadcrumb__links">
                        <a href="/">Início</a>
                        <span>Histórico de Transações</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<br>
<div style="text-align:center;">
    <h3>HISTÓRICO DE TRANSAÇÕES</h3>
</div>
<table class="content-table">
    <thead>
    <tr>
        <th>Código do Pedido</th>
        <th>Nome do Pedido</th>
        <th>Data do Pedido</th>
        <th>Valor Total</th>
        <th>Status</th>
        <th>Ver Detalhes</th>
    </tr>
    </thead>

<c:forEach items="${listOrder}" var="o">
    <tr>
        <td>${o.code}</td>
        <td>${o.label}</td>
        <td><fmt:formatDate value="${o.createdTime}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
        <td><fmt:formatNumber value="${o.total}" type="number"/> R$</td>
        <td>
            <c:if test="${o.state == 'DUE'}"><span>Em entrega/pagamento</span></c:if>
            <c:if test="${o.state == 'PAID'}"><span>Concluído</span></c:if>
            <c:if test="${o.state == 'CANCEL'}"><span>Cancelado</span></c:if>
        </td>
        <td class="row">
            <div class="button_admin">
                <a href="/detalhes-pedido/${o.id}" class="btn p-0 m-auto"><i class='fa fa-eye button_see'></i></a>
            </div>
        </td>
    </tr>
</c:forEach>

</table>
<br>
</body>
<jsp:include page="part/footer.jsp"/>
<jsp:include page="part/modal.jsp"/>
<jsp:include page="part/script.jsp"/>
</html>
