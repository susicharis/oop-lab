package org.example;

import java.util.Random;

public class WeatherForecaster {
    private Random random;

    public WeatherForecaster() {
        this.random = new Random();
    }

    public String forecastWeather() {
        // this - referencira na trenutni objekt klase WeatherForecaster
        // nextDouble() - metoda klase Random koja vraca random broj tipa double
        double probability = this.random.nextDouble();
        if (probability <= 0.1)
            return "Sleet";
        else if (probability <= 0.4)
            return "Snow";
        else
            return "Sunny";
    }

    public int forecastTemperature() {
        return (int) (4 * this.random.nextGaussian() - 3);
    }

    public static void main(String[] args) {
        WeatherForecaster forecaster = new WeatherForecaster();

        // Ispis prognoze vremena i temperature
        System.out.println("Weather forecast: " + forecaster.forecastWeather());
        System.out.println("Temperature forecast: " + forecaster.forecastTemperature() + "°C");
    }
}

