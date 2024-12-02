<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<!--Login Modal-->
<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="exampleModalLabel12" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title font-weight-bold text-uppercase" id="exampleModalLabel12">Entre</h5>
            </div>
            <form action="/login" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="email" class="col-form-label custom">E-mail:</label>
                        <input type="email" placeholder="Digite seu e-mail" class="form-control" name="email" id="email"/>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="col-form-label custom">Senha:</label>
                        <input type="password" placeholder="Digite sua senha" name="password" class="form-control"
                               id="password"/>
                    </div>
                    <div class="row"><p class=" col-8  custom">Não possui cadastro ?? <strong><a href="#" data-target="#registerModal"
                                                                          data-toggle="modal" data-dismiss="modal">Cadastre-se</a></strong></p>
                        <p class="custom col-4"> <strong><a href="#" data-target="#forgetModal"
                                                                         data-toggle="modal" data-dismiss="modal">Esqueceu a senha?</a></strong></p>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" id="submit" class="btn btn-danger custom">Entrar</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="registerModal" tabindex="-1" aria-labelledby="exampleModalLabel2" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title font-weight-bold text-uppercase" id="exampleModalLabel2">Cadastro</h5>
                <div class="custom1"><a href="#" data-target="#loginModal" data-toggle="modal" data-dismiss="modal">Voltar</a></div>
            </div>
            <form action="/register" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <input type="email" required placeholder="Digite seu e-mail" class="form-control" name="email"/>
                    </div>
                    <div class="mb-3">
                        <input type="password" required placeholder="Digite sua senha" name="password" class="form-control"/>
                    </div>
                    <div class="mb-3">
                        <input type="password" required placeholder="Confirme sua senha" class="form-control"
                               name="confirmPassword"/>
                    </div>
                    <div class="mb-3">
                        <input type="text"
                               id="phoneNumber"
                               required
                               placeholder="(DDD) 9XXXX-XXXX"
                               class="form-control"
                               name="phoneNumber" />

                        <script>
                            $(document).ready(function(){
                                $('#phoneNumber').mask('(00) 00000-0000');
                            });
                        </script>
                    </div>
                    <div class="mb-3">
                        <input type="text" required placeholder="Nome Completo"  class="form-control" name="fullName">
                    </div>
                    <div class="mb-3">
                        <div class="form-check">
                            <input class="form-check-input"  type="radio" name="radio" id="flexRadioDefault1"
                                   value="Male" checked/>
                            <label class="form-check-label" for="flexRadioDefault1">Masculino</label> &nbsp; &nbsp; &nbsp;
                            <input class="form-check-input" type="radio" name="radio" value="Female"
                                   id="flexRadioDefault2">
                            <label class="form-check-label" for="flexRadioDefault2">Feminino</label>
                        </div>
                    </div>
                    <div class="mb-3">
                        <input type="text" required placeholder="Endereço" class="form-control" name="address"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger custom">Cadastrar</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="forgetModal" tabindex="-1" aria-labelledby="exampleModalLabel2" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title font-weight-bold text-uppercase" id="exampleModalLabel6">Esqueci a senha</h5>
            </div>
            <form action="/send-mail-changepass" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="email" class="col-form-label custom">E-mail:</label>
                        <input type="email" required placeholder="Email" class="form-control" name="email"/>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger custom">Recuperar Senha</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="changePasswordModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">MUDAR SENHA</h5>
            </div>
            <form action="/updatePassword" method="post">
                <div class="modal-body">
                    <div class="form-group row">
                        <label class="col-md-4 control-label">Senha antiga: </label>
                        <div class="col-md-8">
                            <input class="form-control" type="password" name="oldPassword" placeholder="Senha antiga">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-4 control-label">Nova senha: </label>
                        <div class="col-md-8">
                            <input class="form-control" type="password" name="newPassword" placeholder="Nova senha">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-4 control-label">Confirmação da senha: </label>
                        <div class="col-md-8">
                            <input class="form-control" type="password" name="confirmPassword" placeholder="Confirmação da senha">
                        </div>
                    </div>
                    <button class="btn nut1 col-md-8" type="submit">Mudar senha</button>
                    <br/>  <br/>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
    <div class="modal-dialog" style="position: fixed; margin: auto; width: 100%; height: 100%; right: 0px;" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <section>
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 ">
                                <div class="shopping__cart__table" style="height: 500px; overflow: scroll;">
                                    <table class="tablecss">
                                        <thead>
                                        <tr>
                                            <th>Nome do Produto</th>
                                            <th>Quantidade</th>
                                            <th>Total</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <c:forEach items="${listCart}" var="p">
                                            <td class="product__cart__item">
                                                <div class="product__cart__item__pic">
                                                    <c:if test="${not empty p.value.product.sortName}">
                                                        <img src="/img/product/${p.value.product.pic}" alt="" style="max-width:230px;max-height:95px;width:auto;height:auto;">
                                                    </c:if>
                                                    <c:if test="${not empty p.value.food.sortName}">
                                                        <img src="/img/product/${p.value.food.pic}" alt="" style="max-width:230px;max-height:85px;width:100px;height:auto;">
                                                    </c:if>
                                                </div>
                                                <div class="product__cart__item__text">
                                                    <c:if test="${not empty p.value.product.sortName}">
                                                        <h6>${p.value.product.name}</h6>
                                                    </c:if>
                                                    <c:if test="${not empty p.value.food.sortName}">
                                                        <h6>${p.value.food.name}</h6>
                                                    </c:if>
                                                    <c:if test="${not empty p.value.product.sortName}">
                                                        <h5>${p.value.product.price} R$</h5>
                                                    </c:if>
                                                    <c:if test="${not empty p.value.food.sortName}">
                                                        <h5>${p.value.food.price} R$</h5>
                                                    </c:if>
                                                </div>
                                            </td>

                                            <td class="quantity__item">
                                                <div class="quantity">
                                                    <div class="pro-qty-2">
                                                        <input type="text" value="${p.value.quantity}">
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="cart__price">${p.value.total} R$</td>
                                            <c:if test="${not empty p.value.product.sortName}">
                                                <td class="cart__close"><a href="/shop/delete/${p.value.product.sortName}"><i class="fa fa-close"></i></a></td>
                                            </c:if>
                                            <c:if test="${not empty p.value.food.sortName}">
                                                <td class="cart__close"><a href="/shop/delete/${p.value.food.sortName}"><i class="fa fa-close"></i></a></td>
                                            </c:if>
                                        </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="row">
                                    <div class="col-lg-2 col-md-6 col-sm-6"></div>
                                    <div>
                                        <div class="continue__btn1 update__btn1">
                                            <a href="/cart"> AVANÇAR PARA O CARRINHO </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>
