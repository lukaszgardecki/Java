package com.example.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Location {
    private String weatherEvent;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void setWeatherEvent(String weatherEvent) {
        support.firePropertyChange("weatherEvent", this.weatherEvent, weatherEvent);
        this.weatherEvent = weatherEvent;
    }

    public void addPropertyListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
