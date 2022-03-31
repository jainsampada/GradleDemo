package com.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public static String path;

    public TestBase() {
        try {
            //Setting path of properties file
            path = System.getProperty("user.dir") + "//src//test//java//com//configuration//configuration.properties";

            //Read data from properties file
            FileInputStream ip = new FileInputStream(path);

            //Initializing the properties file
            prop = new Properties();

            prop.load(ip);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LaunchDriver() {
        //Setting up Chrome Driver
        WebDriverManager.chromedriver().setup();

        //Initializing Chrome Driver
        driver = new ChromeDriver();

        //Setting Implicit wait for 5 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));


        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));

    }
}
