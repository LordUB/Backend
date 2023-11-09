package com.meditech.docseeker.healing.service;

import java.net.MalformedURLException;
import java.time.Duration;


import io.cucumber.java.ja.但し;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class NewSeleneseIT {
    private WebDriver driver=null;
    @BeforeClass
    public void inicializarDriver()throws MalformedURLException{

        //AQUI PUEDES CAMBIAR EL PATH DEL SELENIUM SI LO HAZ GUARADO EN OTRA PARTE EL .exe
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWD\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

    }


    @Test
    public void testLoginUsuario() {

        driver.get("http://localhost:4200/patientsLogIn");


        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        wait.until(pageLoadCondition);


        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Dni']"));
        username.sendKeys("6723518");


        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("contrasupersecreta");

        WebElement btnLogIn = driver.findElement(By.xpath("//button[@type='submit']"));
        btnLogIn.click();



        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10L)); // Aumenté la espera a 10 segundos por si acaso
        wait2.until(pageLoadCondition);

        // Aquí buscamos un elemento que sea único de la nueva vista.
        WebElement h1Whatdoyouneed = driver.findElement(By.xpath("//h1[contains(text(), 'What do you need?')]"));

        // Si este elemento es visible, entonces el inicio de sesión fue exitoso.
        wait2.until(ExpectedConditions.visibilityOf(h1Whatdoyouneed));

        // Assert para verificar que el título es el esperado
        Assert.assertEquals("What do you need?", h1Whatdoyouneed.getText());
    }
}
