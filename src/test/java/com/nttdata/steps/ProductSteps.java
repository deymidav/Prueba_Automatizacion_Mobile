package com.nttdata.steps;

import com.nttdata.screens.CartScreen;
import com.nttdata.screens.HomeScreen;
import com.nttdata.screens.ProductScreen;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductSteps {

    @Steps
    HomeScreen homeScreen;

    @Steps
    ProductScreen productScreen;

    @Steps
    CartScreen cartScreen;

    @Step("Seleccionar el producto {0}")
    public void seleccionarProducto(String producto) {
        homeScreen.selectProduct(producto);
    }

    @Step("Validar que la pantalla del producto se ha cargado correctamente")
    public void validarPantallaProducto() {
        productScreen.waitForVisibility();
        assert productScreen.isProductPageDisplayed();
    }

    @Step("Ajustar cantidad del producto a {0} unidades")
    public void ajustarCantidad(int unidades) {
        System.out.println("Verificando si el elemento de cantidad es visible...");

        if (!productScreen.isQuantityElementVisible()) {
            System.out.println("Error: El elemento de cantidad no está visible. No se puede ajustar la cantidad.");
            return;
        }

        System.out.println("Elemento de cantidad visible. Ajustando a " + unidades + " unidades.");
        productScreen.adjustQuantity(unidades);
    }

    @Step("Agregar el producto al carrito")
    public void agregarAlCarrito() {
        productScreen.addToCart();
    }

    @Step("Navegar al carrito de compras")
    public void navegarAlCarrito() {
        productScreen.waitFor(ExpectedConditions.elementToBeClickable(productScreen.getBtnViewCart())).click();
        cartScreen.waitForVisibility();
    }

}
