package com.practice.java.DesignPatterns.Creational;

// Ensures a class has only one instance and provides a global point of access to it.
public class SingletonDesign {

    // Volatile keyword ensures that changes to singletonObj are visible to all threads
    public static volatile SingletonDesign singletonDesignObj;

    // Private constructor to prevent instantiation
    private SingletonDesign() {
        // Prevent reflection-based instantiation
        if (singletonDesignObj != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingletonDesign getInstance() {
        // Double lock mechanism
        // First null check is to bypass the synchronized block and avoid the performance cost associated with locking.
        if(singletonDesignObj == null) { // First check (no lock)
            synchronized (SingletonDesign.class) {
                if(singletonDesignObj == null) { // Second check (with lock)
                    singletonDesignObj = new SingletonDesign();
                }
            }
        }
        return singletonDesignObj;
    }

    // Override clone to prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton class cannot be cloned");
    }
}
