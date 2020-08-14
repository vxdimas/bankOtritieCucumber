package ru.vxdimas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageObjectGoogleWithSearch {

    private static String selectorSearchItem = "//div[@class='g']";
    private static String selectorURL = ".//div[@class='r']/a[@href]";
    private static String selectorNamePage = ".//div[@class='r']/a[@href]";
    private static String selectorDiscriprion = ".//div[@class='s']";

    private WebDriver driver;

    private List<WebElement> searchItem = new ArrayList<>();
    private List<Map<String,Object>> collectResult = new ArrayList<>();

    public PageObjectGoogleWithSearch(WebDriver driver, String search) {
        this.driver = driver;
        this.driver.get("https://www.google.com/search?q=" + search);
        searchItem = driver.findElements(By.xpath(selectorSearchItem));
    }

    public PageObjectGoogleWithSearch(WebDriver driver) {
        this.driver = driver;
        searchItem = driver.findElements(By.xpath(selectorSearchItem));
    }

    public List<Map<String,Object>> getCollectResult() {                      //возвращаем распарсенные элементы поиска
            for(WebElement result : searchItem) {
                collectResult.add(Map.of(
                        "WEB_ELEMENT", result,
                        "URL", result.findElement(By.xpath(selectorURL)).getAttribute("href"),  // заготовка, можно убрать, в тесте не используется
                        "NAME_PAGE", result.findElement(By.xpath(selectorNamePage)).getText(),
                        "DISCRIPTION", result.findElement(By.xpath(selectorDiscriprion)).getText() // заготовка, можно убрать, в тесте не используется
                ));
            }
            return collectResult;
    }


    public static void goPage(List<Map<String,Object>> collectResult, String namePage) {         //открываем сайт
        WebElement pageLink = (WebElement) collectResult.stream()
                .filter(x->x.get("NAME_PAGE").toString().contains(namePage))
                .findFirst()
                .get().get("WEB_ELEMENT");
        pageLink.findElement(By.xpath(selectorNamePage)).click();
    }




}
