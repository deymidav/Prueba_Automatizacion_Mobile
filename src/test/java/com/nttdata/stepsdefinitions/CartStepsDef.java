package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CartSteps;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class CartStepsDef {

    @Steps
    CartSteps cartSteps = CartSteps.getInstance(); // Usamos el Singleton

    @Then("valido el carrito de compra actualice correctamente")
    public void validarCarrito() {
        cartSteps.validarCantidadEnCarrito();
    }

}
