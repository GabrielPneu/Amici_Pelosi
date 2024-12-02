<!-- Page Preloder -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Início da Seção do Cabeçalho -->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7">
                    <div class="header__top__left">
                        <p>Itens Pets na Amici Pelosi</p>
                    </div>
                </div>
                <div class="col-lg-6 col-md-5">
                    <div class="header__top__right">
                        <div class="header__top__links">
                            <c:choose>
                                <c:when test="${customer.email == null}">
                                    <a href="#" data-target="#loginModal" data-toggle="modal">Entrar</a>
                                </c:when>
                                <c:otherwise>
                                    <div style="min-width:300px;" class="header__top__hover">
                                        <span>Olá <strong style="color:#e53637">${customer.fullName}</strong> <em
                                            class="arrow_carrot-down"></em></span>
                                        <ul>
                                            <li class="custom"><a href="/information">Informações</a></li>
                                            <li class="custom"><a href="/history">Histórico de Transações</a></li>
                                            <li><a href="/loggout" id="logout">Sair</a></li>
                                        </ul>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-2 col-md-1">
                <div class="header__logo">
                    <a href="/"><img src="/img/logo1.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-8 col-md-1">
                <nav class="header__menu mobile-menu">
                    <ul>
                        <li><a href="/">Página Inicial</a></li>
                        <li><a href="/about">Sobre Nós</a></li>
                        <!-- <li><a href="/product">Serviços</a> ainda em construção
                            <ul class="dropdown">
                            <li><a href="/product-details">Spa</a></li>
                             <li><a href="/product-details">Corte e Tosa</a></li>
                              <li><a href="/product-details">Banho</a></li>
                               <li><a href="/product-details">Exame de Saúde</a></li>

                            </ul>
                        </li> -->
                        <li><a href="javascript:void(0)">Produtos</a>
                            <ul class="dropdown">
                                <li><a href="/shop/toys-acessories/1">Brinquedos e acessórios</a></li>
                                <li><a href="/shop/food/1">Ração e petiscos</a></li>
                            </ul>
                        </li>
                        <li><a href="/blog">Blog</a></li>
                        <li><a href="/contact">Contato</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-2 col-md-1">
                <div class="header__nav__option">
                        <button type="button" class="btn btn-demo" data-toggle="modal" data-target="#myModal2"><i class="fa fa-cart-plus"></i></button>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- Fim da Seção do Cabeçalho -->
