package com.nttdata.steps;

import com.nttdata.model.OrdenEntity;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
public class BuscarPorIdStep {

    private static String URL = null;
    Response response;

    public void definirurl(String url){
        URL = url;
    };

    public void consultarOrden() {

        response =

                given()

                        .contentType("application/json")

                        .log()

                        .all()

                        .get(URL);

    }


    public Response getResponse() {

        return response;

    }

    public void imprimirArticulos() {
        // Convertimos el objeto JSON a un mapa
        Map<String, Object> mapa = response.jsonPath().getMap("");

        // Accedemos a la lista de objetos dentro del mapa
        List<OrdenEntity> ordenes = response.jsonPath().getList("orders", OrdenEntity.class);

        // Si la lista no existe, intentamos acceder a la lista de objetos dentro del mapa
        if (ordenes == null || ordenes.isEmpty()) {
            ordenes = response.jsonPath().getList("orden", OrdenEntity.class);
        }

        System.out.println("Total: " + ordenes.size());
        for (OrdenEntity orden : ordenes) {
            System.out.println("Titulo: " + orden.getId() + " - " + orden.getShipDate());
        }
    }
}
