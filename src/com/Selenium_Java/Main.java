package com.Selenium_Java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://www.google.com/");
        WebElement element = chromeDriver.findElement(By.name("q"));
        element.sendKeys("Hello Selenium WebDriver.");
        element.submit();
        System.out.println("Page title is .." + chromeDriver.getTitle());
    }
}
