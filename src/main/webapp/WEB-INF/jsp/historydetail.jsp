<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <jsp:include page="part/head.jsp"/>
    <title>Detalhes do Pedido</title>
</head>

<body>
<jsp:include page="part/header.jsp"/>

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb__text">
                    <h4>Detalhes do Pedido</h4>
                    <div class="breadcrumb__links">
                        <a href="/">Página Inicial</a>
                        <span>Detalhes do Pedido</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Shopping Cart Section Begin -->
<section class="shopping-cart spad">
    <div class="container">

        <div class="row">

            <div class="col-lg-12">

                <div class="shopping__cart__table">

                    <table>
                        <thead>
                        <tr>
                            <th>Nome do Produto</th>
                            <th>Quantidade</th>
                            <th>Preço Unitário</th>
                            <th>Total do Produto</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="orItem" items="${orderItemList}">
                            <tr>
                                <td class="product__cart__item">
                                    <div class="product__cart__item__pic">
                                        <%-- Imagem do produto (desabilitada) --%>
                                        <%-- <img style="max-width:230px;max-height:95px;width:auto;height: auto;"
                                                src="/img/product/${orItem.pic}" alt=""> --%>
                                    </div>
                                    <div class="product__cart__item__text">
                                        <h6>${orItem.name}</h6>
                                    </div>
                                </td>
                                <td class="cart__price">
                                    ${orItem.quantity}
                                </td>
                                <td class="cart__price">
                                    <h5><fmt:formatNumber value="${orItem.total/orItem.quantity}" type="number"/> R$</h5>
                                </td>
                                <td class="cart__price">
                                    <fmt:formatNumber value="${orItem.total}" type="number"/> R$
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <div class="continue__btn update__btn">
                            <h5 class="text-uppercase font-weight-bold">Total do Carrinho</h5>
                            <h6 class="text-uppercase font-weight-bold">
                                <fmt:formatNumber value="${totalPrice}" type="number"/> R$
                            </h6>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>
<!-- Shopping Cart Section End -->

<jsp:include page="part/footer.jsp"/>
<jsp:include page="part/modal.jsp"/>
<jsp:include page="part/script.jsp"/>
</body>

</html>
