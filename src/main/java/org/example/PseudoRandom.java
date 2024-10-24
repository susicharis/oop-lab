package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class PseudoRandom {

    public static void main(String[] args) {
        WeatherForecaster forecaster = new WeatherForecaster();

        ArrayList<String> days = new ArrayList<String>();
        Collections.addAll(days, "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

        System.out.println("Weather forecast for the next week: ");
        for (String day : days) {
            String weatherForecast = forecaster.forecastWeather();
            int temperatureForecast = forecaster.forecastTemperature();

            System.out.println(day + " " + weatherForecast + " " + temperatureForecast + " degrees.");
        }
    }

}
