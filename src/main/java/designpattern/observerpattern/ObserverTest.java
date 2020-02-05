package designpattern.observerpattern;

public class ObserverTest {
    public static void main(String[] args) {
        //�������۲���
        WeatherData weatherData = new WeatherData();
        //�����۲���
        Display display = new Display(weatherData);
        Task task = new Task(weatherData);
        new Thread(task, "ReportWeatherThread").start();
    }
}
