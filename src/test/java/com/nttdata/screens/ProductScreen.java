package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Sauce Labs')]")
    private WebElement lblProductTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement btnIncreaseQuantity;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/minusIV")
    private WebElement btnDecreaseQuantity;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement txtQuantity;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement btnAddToCart;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement btnViewCart;

    public void waitForVisibility() {
        waitFor(ExpectedConditions.visibilityOf(lblProductTitle));
    }

    public boolean isProductPageDisplayed() {
        return lblProductTitle.isDisplayed();
    }

    public void adjustQuantity(int targetQuantity) {
        int currentQuantity = Integer.parseInt(txtQuantity.getText());

        while (currentQuantity < targetQuantity) {
            btnIncreaseQuantity.click();
            currentQuantity++;
        }
        while (currentQuantity > targetQuantity) {
            btnDecreaseQuantity.click();
            currentQuantity--;
        }
    }
    public boolean isQuantityElementVisible() {
        try {
            waitFor(ExpectedConditions.visibilityOf(txtQuantity));
            return txtQuantity.isDisplayed();
        } catch (Exception e) {
            System.out.println("Excepción al verificar la visibilidad del elemento de cantidad: " + e.getMessage());
            return false;
        }
    }

    public void addToCart() {
        waitFor(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
        waitFor(ExpectedConditions.visibilityOf(btnViewCart));
    }

    public WebElement getBtnViewCart() {
        return btnViewCart;
    }


}
