package com.thucnh.testweb;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = {TestwebApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@ExtendWith(TestResultLoggerExtension.class)
class TestwebApplicationTests {

    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    public TestwebApplicationTests() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/static/chromedriver2.exe");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void testLogin() {
        driver.get("http://localhost:8080/test");
        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtUsername")).sendKeys("thucnh");
        driver.findElement(By.id("txtPassword")).sendKeys("thucnh");
        driver.findElement(By.id("btnSubmit")).click();
        WebElement elementName = driver.findElement(By.id("txtResult"));
        String s = elementName.getText();
        assertEquals("thucnhthucnh", s);
    }

    @Test
    public void testEvaluate() {
        driver.get("http://localhost:8080/test2");
        driver.findElement(By.id("txtNumber1")).clear();
        driver.findElement(By.id("txtNumber2")).clear();
        driver.findElement(By.id("txtNumber1")).sendKeys("1");
        driver.findElement(By.id("txtNumber2")).sendKeys("2");
        driver.findElement(By.id("btnEvaluate")).click();
        WebElement elementName = driver.findElement(By.id("txtResult"));
        String result = elementName.getText();
        assertEquals("3", result);
    }

    private boolean checkElement(WebDriver driver) {
        if (driver.findElement(By.id("viewport")) != null) {
            return true;
        }
        return false;
    }

    private void close() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);

        }
    }


}
