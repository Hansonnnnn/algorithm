package designpattern.observerpattern;

import java.util.Observable;
import java.util.Observer;

public class Display implements Observer {
    private int note;
    private Observable observable;

    public Display(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            note = ((WeatherData)o).getNote();
            display();
        }
    }

    private void display() {
        System.out.println("note is: " + note);
    }
}
