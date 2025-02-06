package com.nttdata.screens;


import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomeScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Products\"]")
    private WebElement lblProducts;

    @AndroidFindBy(accessibility = "Sauce Labs Bolt T-Shirt")
    private WebElement productTShirt;

    @AndroidFindBy(accessibility = "Sauce Labs Backpack")
    private WebElement productBackpack;

    @AndroidFindBy(accessibility = "Sauce Labs Bike Light")
    private WebElement productBikeLight;



    public void waitForVisibility() {
        waitFor(ExpectedConditions.visibilityOf(lblProducts));
    }

    public boolean isHomeDisplayed() {
        return lblProducts.isDisplayed();
    }
    public void selectProduct(String productName) {
        productName = productName.trim();
        System.out.println("Intentando seleccionar el producto: [" + productName + "]");

        WebElement selectedProduct = null;

        switch (productName) {
            case "Sauce Labs Bolt T-Shirt":
                selectedProduct = productTShirt;
                break;
            case "Sauce Labs Backpack":
                selectedProduct = productBackpack;
                break;
            case "Sauce Labs Bike Light":
                selectedProduct = productBikeLight;
                break;
            default:
                throw new IllegalArgumentException("Producto no encontrado: " + productName);
        }

        if (selectedProduct != null) {
            try {
                System.out.println("Esperando visibilidad del producto...");
                waitFor(ExpectedConditions.visibilityOf(selectedProduct));
                System.out.println("Producto encontrado. Haciendo clic...");
                selectedProduct.click();
            } catch (Exception e) {
                System.out.println("Error al seleccionar el producto: " + e.getMessage());
                throw new RuntimeException("Error al seleccionar el producto: " + productName, e);
            }
        }
    }

}