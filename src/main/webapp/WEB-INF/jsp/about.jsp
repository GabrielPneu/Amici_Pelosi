<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <jsp:include page="part/head.jsp"/>
    <title>Sobre Nós</title>
</head>

<body>
    <jsp:include page="part/header.jsp"/>

    <!-- Breadcrumb Section -->
    <section class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <h4>Sobre Nós</h4>
                        <div class="breadcrumb__links">
                            <a href="/">Página Inicial</a>
                            <span>Sobre Nós</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- About Section -->
    <section class="about spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="about__pic">
                        <img src="img/about/about-us.jpg" alt="Sobre nós">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <p class="about__text">
                        Bem-vindo à Amici Pelosi! Atuamos no cuidado e na beleza dos seus animais de estimação.
                        Nossa equipe é altamente capacitada, com treinamento de especialistas renomados.
                        Oferecemos uma ampla gama de produtos: alimentos, acessórios, suplementos, medicamentos e muito mais.
                    </p>
                </div>
            </div>
        </div>
    </section>

    <!-- Testimonial Section -->
    <section class="testimonial">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6 p-0">
                    <div class="testimonial__text">
                        <span class="icon_quotations"></span>
                        <p>“Equipe extremamente competente, meu Jorginho sempre esta limpinho graças a equipe de banho.”</p>
                        <div class="testimonial__author">
                            <div class="testimonial__author__pic">
                                <img src="img/blog/details/blog-author.jpg" alt="Autor do depoimento">
                            </div>
                            <div class="testimonial__author__text">
                                <h5>Regina Pereira</h5>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 p-0">
                    <div class="testimonial__pic set-bg" data-setbg="img/b.jpeg"></div>
                </div>
            </div>
        </div>
    </section>

    <!-- Counter Section -->
    <section class="counter spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="counter__item">
                        <h2 class="cn_num">1000</h2>
                        <span>Clientes Felizes</span>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="counter__item">
                        <h2 class="cn_num">10</h2>
                        <span>Tipos de Produtos</span>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="counter__item">
                        <h2 class="cn_num">8</h2>
                        <span>Parceiros</span>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="counter__item">
                        <h2 class="cn_num">98</h2>
                        <strong>%</strong>
                        <span>Satisfação</span>
                    </div>
                </div>
            </div>
        </div>
    </section>



    <!-- Client Section -->
    <section class="clients spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <span>Parceiros</span>
                        <h2>Principais Parceiros</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 col-md-4 col-sm-4 col-6">
                    <a href="#" class="client__item"><img src="img/clients/a.png" alt="Parceiro"></a>
                </div>
                <!-- Adicione mais parceiros conforme necessário -->
            </div>
        </div>
    </section>

    <jsp:include page="part/footer.jsp"/>
    <jsp:include page="part/modal.jsp"/>
    <jsp:include page="part/script.jsp"/>
</body>

</html>
