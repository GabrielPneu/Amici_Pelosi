<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <jsp:include page="part/head.jsp" />
    <title>Blog</title>

</head>

<body>
<jsp:include page="part/header.jsp" />

    <section class="breadcrumb-blog set-bg" data-setbg="img/monkeyBlog.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2 style="text-shadow: 3px 3px 6px rgba(0, 0, 0, 0.5);">Blog e Notícias</h2>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Blog Section Begin -->
    <section class="blog spad">
        <div class="container">
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
    </section>
    <!-- Blog Section End -->

<jsp:include page="part/footer.jsp" />
<jsp:include page="part/modal.jsp" />
<jsp:include page="part/script.jsp" />
</body>

</html>