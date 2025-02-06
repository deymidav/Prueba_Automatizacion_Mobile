package com.nttdata.stepsdefinitions;

import com.nttdata.steps.HomeSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;


public class HomeStepsDef {

    @Steps
    HomeSteps homeSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void abrirAplicacion() {
        homeSteps.validarHomeCargado();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validarProductosGaleria() {
        homeSteps.validarHomeCargado();
    }
}