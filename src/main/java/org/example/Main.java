package org.example;
import java.util.Scanner;

import static io.restassured.RestAssured.given;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму:");
        double amount = scanner.nextDouble();

        System.out.println("Введите исходную валюту:");
        String fromCurrency = scanner.next();

        System.out.println("Введите целевую валюту:");
        String toCurrency = scanner.next();
        System.out.println("Вы хотите конвертировать" + amount + " " + fromCurrency + " в " + toCurrency);
        double eurRate = Double.parseDouble(given().when().get("https://open.er-api.com/v6/latest/USD").path("rates.EUR").toString());
        double htgRate = Double.parseDouble(given().when().get("https://open.er-api.com/v6/latest/USD").path("rates.HTG").toString());
        double result = 0;
        if ( fromCurrency.equals("USD")) {
             result = amount * eurRate;
        } else if (fromCurrency.equals("EUR")){
             result = amount / eurRate;
        } else if (fromCurrency.equals(("HTG"))){
            result = amount / htgRate;
        }
        System.out.println("Результат: " + result);
    }
}