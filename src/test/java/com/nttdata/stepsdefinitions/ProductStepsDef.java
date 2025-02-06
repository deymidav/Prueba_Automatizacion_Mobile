package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CartSteps;
import com.nttdata.steps.ProductSteps;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class ProductStepsDef {

    @Steps
    ProductSteps productSteps;
    CartSteps cartSteps = CartSteps.getInstance();

    @When("agrego {int} del siguiente producto {string}")
    public void agregarProducto(int unidades, String producto) {
        productSteps.validarPantallaProducto();
        productSteps.seleccionarProducto(producto);
        productSteps.validarPantallaProducto();
        productSteps.ajustarCantidad(unidades);
        productSteps.agregarAlCarrito();
        productSteps.navegarAlCarrito();
        cartSteps.setCantidadEsperada(unidades);
    }

}
