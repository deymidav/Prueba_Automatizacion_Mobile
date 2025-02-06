package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays selected product\"]")
    private WebElement cartProductImage;

    public void waitForVisibility() {
        waitFor(cartProductImage).isVisible();
    }

    public int obtenerCantidadProducto() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5)); // Esperar hasta 5 segundos
            WebElement cantidadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.saucelabs.mydemoapp.android:id/itemsTV"))); // Asegúrate de que este ID es correcto

            String cantidadTexto = cantidadElement.getText().trim();
            System.out.println("Texto obtenido del carrito: " + cantidadTexto);
            String cantidadNumerica = cantidadTexto.replaceAll("[^0-9]", "");
            System.out.println("Cantidad extraída: " + cantidadNumerica);

            return Integer.parseInt(cantidadNumerica);
        } catch (Exception e) {
            System.out.println("Error al obtener la cantidad del carrito: " + e.getMessage());
            return 0;
        }
    }
}
