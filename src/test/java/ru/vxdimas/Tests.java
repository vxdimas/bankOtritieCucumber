package ru.vxdimas;

import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class Tests {

    public static void checkContainsName(List<Map<String,Object>> resultSearch, String namePage) {      // тест на наличие сайта банка открытия в результатах поиска
        Assertions.assertTrue(
                resultSearch.stream().anyMatch(x->x.get("NAME_PAGE").toString().contains(namePage))
                , "Среди результатов поиска отсутствует сайт банка Открытие"
        );
    }

    public static void checkTitle(String title, String namePage) {       // тест на соответствия тайтла открытого сайта заголовку сайта банка открытие
        Assertions.assertTrue(title.contains(namePage));
    }

    public static void checkDollarRate(List<Map<String,String>> resultExchangeRates, String moneyType) {  //тест на то, что курс покупки меньше курса продажи
         Assertions.assertTrue(
                Double.parseDouble(
                        resultExchangeRates.stream()
                        .filter(x->x.get("Валюта обмена").contains(moneyType))
                        .findFirst()
                        .get().get("Банк покупает").replace(",",".")
                )
                        <
                        Double.parseDouble(
                        resultExchangeRates.stream()
                                .filter(x->x.get("Валюта обмена").contains(moneyType))
                                .findFirst()
                                .get().get("Банк продает").replace(",",".")
                ));
    }

}
















