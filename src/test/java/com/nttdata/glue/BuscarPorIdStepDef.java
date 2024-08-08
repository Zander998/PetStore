package com.nttdata.glue;

import com.nttdata.steps.BuscarPorIdStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BuscarPorIdStepDef {

    @Steps
    private BuscarPorIdStep buscarPorIdStep;

    @Given("la url {string} del servicio")
    public void laUrlDelServicio(String url) {
        buscarPorIdStep.definirurl(url);
    }

    @When("hago la consulta de la Orden")
    public void hagoLaConsultaDeLaOrden() {
        buscarPorIdStep.consultarOrden();
    }

    @Then("imprimo los articulos")
    public void imprimoLosArticulos() {
        buscarPorIdStep.imprimirArticulos();
    }


}
