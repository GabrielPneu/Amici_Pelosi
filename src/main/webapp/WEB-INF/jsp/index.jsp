<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <jsp:include page="part/head.jsp" />
    <title>Página Inicial</title>
</head>

<body>
<jsp:include page="part/header.jsp" />


     <section class="hero">
         <div class="hero__slider owl-carousel">
             <div class="hero__items set-bg" data-setbg="img/hero/1.jpg">
                 <div class="container">
                     <div class="row">
                         <div class="col-xl-5 col-lg-7 col-md-8">
                             <div class="hero__text">
                                 <h6>UTENSÍLIOS</h6>
                                 <h2 class="text-left">UTENSÍLIOS PARA ANIMAIS DE ESTIMAÇÃO</h2>
                            <p>Produtos de alta qualidade com garantia de 1 ano.</p>
                                 <a href="shop/toys-acessories/1" class="primary-btn">COMPRAR AGORA <span class="arrow_right"></span></a>
                                 <div class="hero__social">
                                     <a href="https://www.facebook.com/PETS-Coffee-And-Services-100166812056116"><i class="fa fa-facebook"></i></a>
                                     <a href="https://www.pinterest.com/petscoffeeandservices/_saved/"><i class="fa fa-pinterest"></i></a>
                                     <a href="https://www.instagram.com/petscoffeeandservices/"><i class="fa fa-instagram"></i></a>
                                 </div>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>

             <div class="hero__items set-bg" data-setbg="img/hero/ad.jpg">
                 <div class="container">
                     <div class="row">
                         <div class="col-xl-5 col-lg-7 col-md-8">
                             <div class="hero__text">
                                 <h6>SERVIÇOS</h6>
                                 <h2 class="text-left">SERVIÇOS DE CUIDADO PARA ANIMAIS DE ESTIMAÇÃO</h2>
                                 <p>Serviços de cuidados de saúde, spa e banho para animais de estimação.</p>
                                 <a href="#" class="primary-btn">EXPERIMENTE AGORA<span class="arrow_right"></span></a>
                                 <div class="hero__social">
                                     <a href="https://www.facebook.com/PETS-Coffee-And-Services-100166812056116"><i class="fa fa-facebook"></i></a>
                                     <a href="https://www.pinterest.com/petscoffeeandservices/_saved/"><i class="fa fa-pinterest"></i></a>
                                     <a href="https://www.instagram.com/petscoffeeandservices/"><i class="fa fa-instagram"></i></a>
                                 </div>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
             <div class="hero__items set-bg" data-setbg="img/hero/a.jpg">
                 <div class="container">
                     <div class="row">
                         <div class="col-xl-5 col-lg-7 col-md-8">
                             <div class="hero__text">
                                 <h6>ALIMENTOS</h6>
                                 <h2 class="text-left">ALIMENTOS PARA ANIMAIS DE ESTIMAÇÃO</h2>
                                 <p>Rações, patês e vitaminas para animais de estimação.</p>
                                 <a href="#" class="primary-btn">COMPRAR AGORA <span class="arrow_right"></span></a>
                                 <div class="hero__social">
                                    <a href="https://www.facebook.com/PETS-Coffee-And-Services-100166812056116"><i class="fa fa-facebook"></i></a>
                                     <a href="https://www.pinterest.com/petscoffeeandservices/_saved/"><i class="fa fa-pinterest"></i></a>
                                     <a href="https://www.instagram.com/petscoffeeandservices/"><i class="fa fa-instagram"></i></a>
                                 </div>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
         </div>
     </section>

    <section class="banner spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 offset-lg-4">
                    <div class="banner__item">
                        <div class="banner__item__pic">
                            <img src="img/banner/c.jpg" alt="">
                        </div>
                        <div class="banner__item__text">
                            <h2 class="text-left">Banho e Tosa</h2>
                            <a href="#">Experimente agora</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5">
                    <div class="banner__item banner__item--middle">
                        <div class="banner__item__pic">
                            <img src="img/banner/pt-toy.jpg" alt="">
                        </div>
                        <div class="banner__item__text">
                            <h2 class="text-left">Brinquedos</h2>
                            <a href="shop/toys-acessories/1">Comprar agora</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-7">
                    <div class="banner__item banner__item--last">
                        <div class="banner__item__pic">
                            <img src="img/banner/comida.jpeg" alt="">
                        </div>
                        <div class="banner__item__text">
                            <h2 class="text-left">Comida</h2>
                            <a href="shop/food/1">Comprar agora</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <section class="latest spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">

                        <h2>NOSSO BLOG</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic set-bg" data-setbg="img/blog/lua.jpeg"></div>
                        <div class="blog__item__text">
                            <span><img src="img/icon/calendar.png" alt="">16 de Maio de 2024</span>
                            <h5>Mamãe pela 2° vez</h5>
                            <a href="/blog-details">LEIA MAIS</a>
                        </div>
                    </div>

                </div>

                  <div class="col-lg-4 col-md-6 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic set-bg" data-setbg="img/blog/bucky-lupi.jpeg"></div>
                        <div class="blog__item__text">
                            <span><img src="img/icon/calendar.png" alt="">14 de fevereiro de 2024</span>
                            <h5>Melhores aumigos</h5>
                            <a href="/blog-details">LEIA MAIS</a>
                        </div>
                    </div>

                </div>

                  <div class="col-lg-4 col-md-6 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic set-bg" data-setbg="img/blog/lua-mae.jpeg"></div>
                        <div class="blog__item__text">
                            <span><img src="img/icon/calendar.png" alt="">15 de Novembro de 2024</span>
                            <h5>Solzinho todos dias</h5>
                            <a href="/">LEIA MAIS</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>
    <jsp:include page="part/footer.jsp" />
    <jsp:include page="part/modal.jsp" />
    <jsp:include page="part/script.jsp" />
</body>

</html>