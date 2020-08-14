package ru.vxdimas;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;


public class MyStepDef extends Steps {

    @Given("открыть браузер Google Chrome")
    public void открыть_браузер_Google_Chrome() {
        открытьХром();
    }


    @Then("Осуществить поиск '(.*)' на сайте Google")
    public void осуществитьПоискБанкОткрытиеНаСайтеGoogle(String searchWord) {
        PageObjectGoogleWithSearch googleWithSearch = new PageObjectGoogleWithSearch(chromeDriver, searchWord);
    }

    @Then("Удостовериться что среди результатов поиска есть сайт '(.*)'")
    public void удостоверитьсяЧтоСредиРезультатовПоискаЕстьСайтБанкОткрытиеВкладыКредитныеИДебетовые(String namePage) {
        PageObjectGoogleWithSearch googleWithSearchBankOtkr = new PageObjectGoogleWithSearch(chromeDriver);
        List<Map<String,Object>> resultSearchBankOtr = googleWithSearchBankOtkr.getCollectResult();
        Tests.checkContainsName(resultSearchBankOtr, namePage);
    }

    @Then("Перейти на сайт '(.*)' из результатов поиска Google")
    public void перейтиНаСайтБанкОткрытиеВкладыКредитныеИДебетовыеИзРезультатовПоискаGoogle(String namePage) {
        PageObjectGoogleWithSearch googleWithSearchBankOtkr = new PageObjectGoogleWithSearch(chromeDriver);
        List<Map<String,Object>> resultSearchBankOtr = googleWithSearchBankOtkr.getCollectResult();
        PageObjectGoogleWithSearch.goPage(resultSearchBankOtr, namePage);
    }

    @Then("Удостовериться, что открытая страница это '(.*)'")
    public void удостоверитьсяЧтоОткрытаяСтраницаЭтоБанкОткрытиеВкладыКредитныеИДебетовые(String namePage) {
        Tests.checkTitle(chromeDriver.getTitle(),namePage);

    }

    @Then("Удостовериться, что курс покупки валюты доллара меньше курса продажи валюты доллара")
    public void удостоверитьсяЧтоКурсПокупкиВалютыДоллараМеньшеКурсаПродажиВалютыДоллара() {
        PageObjectPageOtkritie pageOtkritie = new PageObjectPageOtkritie(chromeDriver);
        List<Map<String,String>> resultExchangeRates = pageOtkritie.getCollectExchangeRates();
        Tests.checkDollarRate(resultExchangeRates, "USD");
        закрытьХром();

    }
}























