package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void acceptCookies(){
        driver.get("https://www.aruodas.lt/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }
    public static void login(){
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div")).click();
        driver.findElement(By.id("userName")).sendKeys("naglisvcs@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Slaptazodis123");
        driver.findElement(By.id("loginAruodas")).click();
    }
}
