package com.amazon.tests;

import com.amazon.base.BaseTest;
import com.amazon.pages.AmazonHomePage;
import com.amazon.pages.SearchResultsPage;
import com.amazon.utils.CSVDataReader;
import com.amazon.utils.LoggerUtil;
import com.amazon.utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonSearchTest extends BaseTest {

    @Test
    public void searchProducts() {

        ExtentTest test = extent.createTest("Amazon Product Search Test");

        LoggerUtil.logger.info("Launching Amazon Website");

        AmazonHomePage homePage = new AmazonHomePage(driver);

        ScreenshotUtils.captureScreenshot(driver, "Amazon_Home_Page");

        List<String> products = CSVDataReader.readProducts();

        LoggerUtil.logger.info("Products loaded from CSV");

        for (String product : products) {

            LoggerUtil.logger.info("Searching Product : " + product);

            test.log(Status.INFO, "Searching Product : " + product);

            homePage.searchProduct(product);

            ScreenshotUtils.captureScreenshot(driver,
                    "Search_Result_" + product.replace(" ", "_"));

            SearchResultsPage resultsPage = new SearchResultsPage(driver);

            resultsPage.displayProducts();

            LoggerUtil.logger.info("Product details extracted successfully");

            test.log(Status.PASS, "Product details extracted");

            break;
        }

        LoggerUtil.logger.info("Automation Execution Completed");

        test.log(Status.PASS, "Automation Test Completed Successfully");
    }
}