package org.test.Webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WebpageTest {

    private static WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);

        Thread.sleep(2000);
        driver.get("https://techsmarttpk.github.io/mavenop/");
    }

    @Test
    public void titleValidationTest() {

        String actualTitle = driver.getTitle();
        String expectedTitle = "My Website";

        Assert.assertEquals(actualTitle, expectedTitle);

        assertTrue(
                actualTitle.contains("Website"),
                "Title should contain 'Website'"
        );
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {

        Thread.sleep(2000);

        if (driver != null) {
            driver.quit();
        }
    }
}