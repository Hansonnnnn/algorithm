package designpattern.observerpattern;

import java.util.Random;

public class Task implements Runnable{
    private WeatherData weatherData;

    public Task(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        weatherData.setMeasurements(new Random().nextInt(100));
    }
}
