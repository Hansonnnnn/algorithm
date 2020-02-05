package designpattern.observerpattern;

import java.util.Observable;

public class WeatherData extends Observable {
    private int note;

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(int note) {
        this.note = note;
        measurementsChanged();
    }

    public int getNote() {
        return note;
    }
}
