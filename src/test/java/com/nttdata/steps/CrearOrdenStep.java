package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CrearOrdenStep {
    private static String PET_ORDER = "https://petstore.swagger.io/v2/store/order";

    @Step("Crear orden {0} en PetPrder")
    public void crearOrder(String shipDate, String status, String quantity){
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"petId\": 2,\n" +
                        "  \"shipDate\": \""+shipDate+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"complete\": \"true\"" +
                        "}")
                .log().all()
                .post(PET_ORDER)
                .then()
                .log().all()
        ;

    }

    public void validarCodigoRespuesta(int codeStatus) {
        restAssuredThat(response -> response.statusCode(codeStatus));
    }
}
