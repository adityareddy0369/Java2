package com.practice.java.DesignPatterns.Creational;

public class Singleton {

    // Volatile keyword ensures that changes to singletonObj are visible to all threads
    public static volatile Singleton singletonObj;

    // Private constructor to prevent instantiation
    private Singleton() {
        // Prevent reflection-based instantiation
        if (singletonObj != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static Singleton getInstance() {
        // Double lock mechanism
        // First null check is to bypass the synchronized block and avoid the performance cost associated with locking.
        if(singletonObj == null) { // First check (no lock)
            synchronized (Singleton.class) {
                if(singletonObj == null) { // Second check (with lock)
                    singletonObj = new Singleton();
                }
            }
        }
        return singletonObj;
    }

    // Override clone to prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton class cannot be cloned");
    }
}
