package ru.vxdimas;


import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)  //будет запускать все тесты на кукумбере
@CucumberOptions(            //Задаем различные функции кукумбера
        strict = true,
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "pretty", "json:target/cucumber-report/report.json"}, // аллюр отчет
        features = "src/test/java/feature",            // пакет где лежат фичи(все)
        glue = "ru.vxdimas"  //там лежит расшифровка шагов
        //tags = {"@testcase2020_08_08"}
)


public class CucumberRunner {
}
