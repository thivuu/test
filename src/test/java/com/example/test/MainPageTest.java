package com.example.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("http://192.168.105.112:3004/login");
    }

    @Test
    public void search() {
//        mainPage.searchButton.click();

        $("input[type='text']").sendKeys("0338313262");
        $("input[type='password']").sendKeys("1");

        $("button[class*='MuiButton-root']").click();

//
//        $("input[data-test='search-input']").shouldHave(attribute("value", "Selenium"));
    }

    @Test
    public void toolsMenu() {
//        mainPage.toolsMenu.click();

//        $("div[data-test='main-submenu']").shouldBe(visible);
    }
//
//    @Test
//    public void navigationToAllTools() {
//        mainPage.seeDeveloperToolsButton.click();
//        mainPage.findYourToolsButton.click();
//
//        $("#products-page").shouldBe(visible);
//
//        assertEquals(Selenide.title(), "All Developer Tools and Products by JetBrains");
//    }
}
