package com.example.observer;

import java.beans.PropertyChangeSupport;

public class User {
    private String status;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void setStatus(String status) {
        support.firePropertyChange("status", this.status, status); // nazwa pola, stara wartość, nowa wartość
        this.status = status;
    }

    public void addPropertyChangeListener(Newsfeed newsfeed) {
        support.addPropertyChangeListener(newsfeed);
    }
}
