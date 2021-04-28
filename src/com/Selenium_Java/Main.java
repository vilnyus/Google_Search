package com.Selenium_Java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) {
        String currentUrl = "https://demoqa.com/buttons";
        String linksPageUrl = "https://demoqa.com/links";
        String newUrl;
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.get(currentUrl);
        WebElement doubleClickButton = chromeDriver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickButton = chromeDriver.findElement(By.id("rightClickBtn"));

        Actions a = new Actions(chromeDriver);

        a.moveToElement(doubleClickButton).doubleClick().build().perform();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        a.moveToElement(rightClickButton).contextClick().build().perform();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement doubleClickText = chromeDriver.findElement(By.id("doubleClickMessage"));
        WebElement rightClickText = chromeDriver.findElement(By.id("rightClickMessage"));
        boolean isDisplayed = doubleClickText.isDisplayed() || rightClickText.isDisplayed();
        System.out.println("Button is double clicked and right clicked " + isDisplayed);

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get(linksPageUrl);
        newUrl = chromeDriver.findElement(By.linkText("Home")).getAttribute("href");
        chromeDriver.navigate().to(newUrl);



    }
}
