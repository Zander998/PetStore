package com.nttdata.glue;
import com.nttdata.steps.CrearOrdenStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CrearOrdenStepDef {

    @Steps
    private CrearOrdenStep crearOrdenStep;

    @When("agrago una mascota con shipDate{string}, status{string}, quantity{string}")
    public void agragoUnaMascotaConShipDateStatusQuantity(String shipDate, String status, String quantity) {
        crearOrdenStep.crearOrder(shipDate, status, quantity);

    }

    @Then("con el codigo de estado {int}")
    public void conElCodigoDeEstado(int codeStatus) {
        crearOrdenStep.validarCodigoRespuesta(codeStatus);
    }
}
