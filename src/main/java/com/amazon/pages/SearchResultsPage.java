package com.amazon.pages;

import com.amazon.utils.CSVDataWriter;
import com.amazon.utils.ExcelDataWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {

    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void displayProducts() {

        List<WebElement> products = driver.findElements(
                By.xpath("//div[@data-component-type='s-search-result']")
        );

        System.out.println("====================================");
        System.out.println("Products Found : " + products.size());
        System.out.println("====================================");

        int limit = Math.min(products.size(), 10);

        for (int i = 0; i < limit; i++) {

            WebElement product = products.get(i);

            String name = "Not Available";
            String price = "Not Available";
            String rating = "Not Available";

            // Product Name
            try {
                name = product.findElement(
                        By.xpath(".//h2//span")
                ).getText();
            } catch (Exception e) {
                // Ignore
            }

            // Product Price
            try {
                price = "₹" + product.findElement(
                        By.xpath(".//span[@class='a-price-whole']")
                ).getText();
            } catch (Exception e) {
                // Ignore
            }

            // Product Rating
            try {
                rating = product.findElement(
                        By.xpath(".//span[contains(@class,'a-icon-alt')]")
                ).getText();
            } catch (Exception e) {
                // Ignore
            }

            System.out.println("----------------------------------");
            System.out.println("Product : " + name);
            System.out.println("Price   : " + price);
            System.out.println("Rating  : " + rating);

            CSVDataWriter.writeProduct(name, price, rating);

            ExcelDataWriter.writeProduct(name, price, rating);
        }

        // Save Excel file after writing all rows
        ExcelDataWriter.saveWorkbook();
    }
}