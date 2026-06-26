package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage {

    WebDriver driver;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Search box
    By searchBox = By.id("twotabsearchtextbox");

    // Search button
    By searchButton = By.id("nav-search-submit-button");

    // Search product
    public void searchProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }
}