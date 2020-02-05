package designpattern.observerpattern;

public class ObserverTest {
    public static void main(String[] args) {
        //创建被观察者
        WeatherData weatherData = new WeatherData();
        //创建观察者
        Display display = new Display(weatherData);
        Task task = new Task(weatherData);
        new Thread(task, "ReportWeatherThread").start();
    }
}
