<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <jsp:include page="part/head.jsp"/>
    <title>Informações Detalhadas</title>
</head>
<jsp:include page="part/header.jsp"/>
<body>
<!-- Início da Seção de Navegação Breadcrumb -->
<section class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb__text">
                    <h4>Informações Detalhadas</h4>
                    <div class="breadcrumb__links">
                        <a href="/">Página Inicial</a> <span>Informações Detalhadas</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<br>
<section>
    <div class="container">
        <form action="/updateInfor" method="post" name="myForm" enctype="multipart/form-data">
            <div class="row">
                <div class="col-md-4">
                    <div class="box_image_logo">
                        <div class="my-account-litle">Foto de Perfil</div>
                        <div style="width:330px; height: 236px;">
                            <label for="image"><img style="width:330px; height: 236px;"
                                    src="/user-photos/${customer1.id}/${customer1.avatarUrl}" id="thumbnail" alt="Pré-visualização da Imagem">
                            </label>
                            <input type="file" name="avatarUrl" style="text-decoration: none;" class="btn btn-block"
                                             id="image" accept="image/jpeg,image/png,image/jpg"/>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="box_info_account2">
                        <br>
                        <h3 class="text-center">INFORMAÇÕES DETALHADAS</h3>
                        <br/>
                        <!--Formulário-->
                        <div class="form_info_update">
                            <div class="form-group row">
                                <label class="col-md-4 control-label">Email:</label>
                                <div class="col-md-8">
                                    <input required class="form-control numeric" type="text"
                                           name="email" placeholder="Endereço" readonly value="${customer1.email}">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-4 control-label">Nome Completo:</label>
                                <div class="col-md-8">
                                    <input required class="form-control" type="text" name="fullName"
                                           value="${customer1.fullName}"
                                           placeholder="Nome Completo">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-4 control-label">Data de Nascimento:</label>
                                <div class="col-md-8">
                                    <input class="form-control" type="date" name="birthday" required
                                           value="<fmt:formatDate value="${customer1.birthday}" pattern="yyyy-MM-dd"/>"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-4 control-label">Telefone:</label>
                                <div class="col-md-8">
                                    <input class="form-control numeric" type="text" minlength="10"
                                           placeholder="Número de Telefone" name="phoneNumber" maxlength="11"
                                           value="${customer1.phone}" required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-4 control-label">Endereço:</label>
                                <div class="col-md-8">
                                    <input required class="form-control numeric" type="text"
                                           name="address" placeholder="Endereço" value="${customer1.address}">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 40px;">
                            <button class="btn nut text-uppercase" type="submit">Atualizar</button>
                            <button class="btn nut1 text-uppercase" type="button"
                                    data-toggle="modal" data-target="#changePasswordModal">MUDAR
                                SENHA
                            </button>
                            <br>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>
<!-- Fim da Seção de Navegação -->

</body>
<jsp:include page="part/footer.jsp"/>
<jsp:include page="part/modal.jsp"/>
<jsp:include page="part/script.jsp"/>
<script type="text/javascript">
    $(document).ready(function () {

        $("#image").change(function () {
            showImageThumbnail(this);
        });
        function showImageThumbnail(fileInput) {
            file = fileInput.files[0];
            reader = new FileReader();
            reader.onload = function (e) {
                $('#thumbnail').attr('src', e.target.result);
            };
            reader.readAsDataURL(file);
        }
    });
</script>
</html>
