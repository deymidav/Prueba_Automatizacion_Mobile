package com.nttdata.steps;

import com.nttdata.screens.HomeScreen;


public class HomeSteps {

    private final HomeScreen homeScreen;

    public HomeSteps() {
        this.homeScreen = new HomeScreen();
    }

    public void validarHomeCargado() {
        homeScreen.waitForVisibility();
        assert homeScreen.isHomeDisplayed();
    }
}