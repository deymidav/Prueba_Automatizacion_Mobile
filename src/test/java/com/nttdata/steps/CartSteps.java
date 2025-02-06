package com.nttdata.steps;

import com.nttdata.screens.CartScreen;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class CartSteps {

    private static CartSteps instance;
    private final CartScreen cartScreen;
    private int cantidadEsperada = 0;

    private CartSteps() {
        this.cartScreen = new CartScreen();
    }

    public static CartSteps getInstance() {
        if (instance == null) {
            instance = new CartSteps();
        }
        return instance;
    }

    @Step("Guardar la cantidad ingresada en la compra")
    public void setCantidadEsperada(int cantidad) {
        this.cantidadEsperada = cantidad;
        System.out.println("Cantidad esperada almacenada: " + cantidadEsperada);
    }
    @Step("Validar que la cantidad en el carrito es correcta")
    public void validarCantidadEnCarrito() {
        int cantidadActual = cartScreen.obtenerCantidadProducto();
        System.out.println("Cantidad en el carrito obtenida: " + cantidadActual);
        System.out.println("Cantidad esperada (desde Example): " + cantidadEsperada);
        Assert.assertEquals("Error: La cantidad en el carrito no coincide con la ingresada en el Example", cantidadEsperada, cantidadActual);
    }
}
