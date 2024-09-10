package com.practice.java.DesignPatterns.Behavioral;

import java.util.ArrayList;
import java.util.List;

// Defines a dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
public class ObserverDesign {
    public static void main(String[] args) {
        ConcreteObserver concreteObserver1 = new ConcreteObserver("Observer1");
        ConcreteObserver concreteObserver2 = new ConcreteObserver("Observer2");
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.addObserver(concreteObserver1);
        concreteSubject.addObserver(concreteObserver2);

        concreteSubject.setState("New State 1");  // Both observers will be notified
        concreteSubject.setState("New State 2");  // Both observers will be notified

        concreteSubject.removeObserver(concreteObserver1);
        concreteSubject.setState("New State 3");  // Only Observer2 will be notified

    }


}

interface Observer {
    void update(String message);
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}

class ConcreteObserver implements Observer {

    private String name;
    public ConcreteObserver(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }
}

class ConcreteSubject implements Subject {
    private List<Observer> observerList = new ArrayList<>();
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer: observerList) {
            observer.update(state);
        }
    }
}