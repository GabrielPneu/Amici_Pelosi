<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <jsp:include page="part/head.jsp"/>
    <title>Finalizar Compra</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
</head>

<body>
<jsp:include page="part/header.jsp"/>

<!-- Início da seção de navegação -->
<section class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb__text">
                    <h4>Finalizar Compra</h4>
                    <div class="breadcrumb__links">
                        <a href="/">Início</a>
                        <a href="/carrinho">Carrinho</a>
                        <span>Finalizar Compra</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Fim da seção de navegação -->

<!-- Início da seção de checkout -->
<section class="checkout spad">
    <div class="container">
        <div class="checkout__form">
            <form action="/shop/checkout" method="post">
                <div class="row">
                    <div class="col-lg-8 col-md-6">
                        <c:if test="${customer.email!=null}">
                            <h6 class="coupon__code"><span class="fas fa-user"></span> Olá, <em><strong>${customer.fullName}</strong></em></h6>
                        </c:if>
                        <h6 class="checkout__title">Informações Pessoais</h6>
                        <div class="checkout__input">
                            <p>Nome Completo<span>*</span></p>
                            <input style="color:blue" type="text" name="fullName" readonly value="<c:if test="${customer.email!=null}">${customer.fullName}</c:if>" placeholder="Digite seu nome completo"/>
                        </div>
                        <div class="checkout__input">
                            <p>Endereço<span>*</span></p>
                            <input type="text" name="address" style="color:blue" readonly value="<c:if test="${customer.email!=null}">${customer.address}</c:if>" placeholder="Digite seu endereço" class="checkout__input__add">
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Telefone<span>*</span></p>
                                    <input type="text" style="color:blue" name="phoneNumber" readonly value="<c:if test="${customer.email!=null}">${customer.phone}</c:if>" placeholder="Digite seu número de telefone">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Email<span>*</span></p>
                                    <input type="email" name="email" style="color:blue" readonly value="<c:if test="${customer.email!=null}">${customer.email}</c:if>" placeholder="Digite seu email">
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input__checkbox">
                            <p><em><a href="javascript:void(0)" style="color:blue" data-target="#registerModal" data-toggle="modal">Cadastre-se</a> aqui para se tornar membro e aproveitar mais promoções</em></p>
                        </div>
                        <div class="checkout__input">
                            <p>Observações para seu pedido<span>*</span></p>
                            <input type="text" name="note" placeholder="Digite suas observações">
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="checkout__order">
                            <h4 class="order__title">Seu Pedido</h4>
                            <div class="checkout__order__products">Produto <span>Total</span></div>
                            <ul class="checkout__total__products">
                                <c:forEach var="p" items="${listCart}">
                                    <li>
                                        <c:choose>
                                            <c:when test="${not empty p.value.product.code}">
                                                <h6>${p.value.product.name}</h6>
                                                <span><fmt:formatNumber type="number" value="${p.value.total}" /> BRL</span>
                                            </c:when>
                                            <c:otherwise>
                                                <h6>${p.value.food.name}</h6>
                                                <span><fmt:formatNumber type="number" value="${p.value.total}" /> BRL</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </li>
                                </c:forEach>
                            </ul>
                            <ul class="checkout__total__all">
                                <li>Total do Pedido <span><fmt:formatNumber value="${totalPrice}" type="number"/> BRL</span></li>
                            </ul>
                            <p>Forma de Pagamento</p>
                            <div class="checkout__input__checkbox">
                                <label for="COD">
                                    Pagamento na Entrega
                                    <input type="radio" required value="COD" id="COD" name="transaction" onclick="myFunction()"/>
                                    <span class="checkmark"></span>
                                </label>
                                <label for="ATM">
                                    Transferência Bancária (PIX)
                                    <input type="radio" required value="ATM" id="ATM" name="transaction" onclick="myFunction()"/>
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                            <p id="text2" style="display:none"><strong>Por favor, escolha a forma de pagamento</strong></p>
                            <p id="text" style="display:none">Transferir para a conta do Banco do Brasil: <strong>11 96545-4586</strong> com a descrição: <br/><strong><em>Compra Amici Pelosi</em></strong></p>
                            <button type="submit" onclick="myFunction()" id="submit" class="site-btn">Finalizar Pedido</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>
<!-- Fim da seção de checkout -->

<jsp:include page="part/footer.jsp"/>
<jsp:include page="part/modal.jsp"/>
<jsp:include page="part/script.jsp"/>
<script>
    function myFunction() {
        var checkBox = document.getElementById("ATM");
        var checkBoxCOD = document.getElementById("COD");
        var text = document.getElementById("text");
        var text2 = document.getElementById("text2");

        if ($("#submit").click && !$('input[name="transaction"]').is(':checked')) {
            text2.style.display = "block";
        } else {
            text2.style.display = "none";
        }
        if (checkBox.checked) {
            text.style.display = "block";
        } else if (checkBoxCOD.checked) {
            text.style.display = "none";
        }
    }
</script>
</body>

</html>
