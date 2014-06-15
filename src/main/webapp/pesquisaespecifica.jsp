    <!-- pesquisa especifica -->

    <div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2>Pesquisar Escola Específica</h2>
                            <hr class="star-primary">
                        </div>
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2">
                                <form role="form" action="realizarConsultaEscolaEspecifica.jsp" method="post" name="form1">
                                    <div class="row">
                                        <div class="form-group col-xs-12">
                                            <label for="escola">Escola</label>
                                            <input class="form-control" type="text" name="nome" placeholder="Insira a Escola">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xs-12 ">
                                            <label for="Estado">Estado</label>
                                            <select id="select_estado" class="disable form-control" type="text" name="estado">
                                                <option value="x" disabled selected>Selecione o Estado</option>
                                                <option value="Distrito Federal">Distrito Federal</option>
                                                <option value="Goias">Goiás</option>
                                                <option value="Mato Grosso">Mato Grosso</option>
                                                <option value="Mato Grosso do Sul">Mato Grosso do Sul</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xs-12">
                                            <label for="municipio">Município</label>
                                            <input class="form-control" type="text" name="municipio" placeholder="Insira o Município">
                                        </div>
                                    </div>
                                <br></br>
                                <div class="row">
                                    <div class="form-group col-xs-12 floating-label-form-group">
                                    <input type="submit"/>
                                    <button type="button" class="btn btn-lg btn-success">Buscar Escola</button>
                                </div>
                        </div>
                    </form>
                </div>
            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
