<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <jsp:include page="part/head.jsp" />
    <title>Fale Conosco</title>

</head>

<body>
<jsp:include page="part/header.jsp" />

    <!-- Início do Mapa -->
    <div class="map">
       <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d14638.181447090374!2d-46.8662018!3d-23.4768584!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94cf03aaf6d062af%3A0x2c22de58cd7f17f1!2sAlphaville%2C%20Santana%20de%20Parna%C3%ADba%20-%20SP%2C%2006542-115!5e0!3m2!1spt-BR!2sbr!4v1733004030111!5m2!1spt-BR!2sbr" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
       </div>
    <!-- Fim do Mapa -->

    <!-- Início da Seção de Contato -->
    <section class="contact spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="contact__text">
                        <div class="section-title">
                            <span>Informações</span>
                            <h2 class="text-left">Contato</h2>
                            <p>Para quaisquer dúvidas, entre em contato conosco.</p>
                        </div>
                        <ul>
                            <li>
                                <h4>Filial 1</h4>
                                <p>Edifício Landmark 81 <br />Hotline: +84 928 494 156</p>
                            </li>

                        </ul>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="contact__form">
                        <form action="/contact" method="post">
                            <div class="row">
                                <div class="col-lg-6">
                                    <input type="text" name="name" required placeholder="Nome">
                                </div>
                                <div class="col-lg-6">
                                    <input type="email" name="email" required placeholder="Email">
                                </div>
                                <div class="col-lg-12">
                                    <textarea name="message" placeholder="Mensagem"></textarea>
                                    <button type="submit" class="site-btn">Enviar Mensagem</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Fim da Seção de Contato -->

<jsp:include page="part/footer.jsp" />
<jsp:include page="part/modal.jsp" />
<jsp:include page="part/script.jsp" />
</body>

</html>
