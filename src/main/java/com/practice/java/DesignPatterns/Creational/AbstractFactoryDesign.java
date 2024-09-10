package com.practice.java.DesignPatterns.Creational;

public class AbstractFactoryDesign {
    public static void main(String[] args) {
        VehicleFactory1 bikeFactory = new BikeFactory1();
        VehicleFactory1 carFactory = new CarFactory1();
        VehicleFactory1 truckFactory = new TruckFactory1();

        Vehicle bike = bikeFactory.createVehicle();
        Accessory bikeAccessory = bikeFactory.createAccessory();

        Vehicle car = carFactory.createVehicle();
        Accessory carAccessory = carFactory.createAccessory();

        Vehicle truck = truckFactory.createVehicle();
        Accessory truckAccessory = truckFactory.createAccessory();

        System.out.println(bike.getType() + " with " + bikeAccessory.getType());
        System.out.println(car.getType() + " with " + carAccessory.getType());
        System.out.println(truck.getType() + " with " + truckAccessory.getType());
    }
}

// Product interfaces
interface Vehicle1 {
    String getType();
}

interface Accessory {
    String getType();
}

// Concrete Products for Vehicles
class Bike1 implements Vehicle1 {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Car1 implements Vehicle1 {
    @Override
    public String getType() {
        return "Car";
    }
}

class Truck1 implements Vehicle1 {
    @Override
    public String getType() {
        return "Truck";
    }
}

// Concrete Products for Accessories
class BikeAccessory implements Accessory {
    @Override
    public String getType() {
        return "Bike Accessory";
    }
}

class CarAccessory implements Accessory {
    @Override
    public String getType() {
        return "Car Accessory";
    }
}

class TruckAccessory implements Accessory {
    @Override
    public String getType() {
        return "Truck Accessory";
    }
}

// Abstract Factory interface
interface VehicleFactory1 {
    Vehicle createVehicle();
    Accessory createAccessory();
}

// Concrete Factories
class BikeFactory1 implements VehicleFactory1 {
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }

    @Override
    public Accessory createAccessory() {
        return new BikeAccessory();
    }
}

class CarFactory1 implements VehicleFactory1 {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Accessory createAccessory() {
        return new CarAccessory();
    }
}

class TruckFactory1 implements VehicleFactory1 {
    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }

    @Override
    public Accessory createAccessory() {
        return new TruckAccessory();
    }
}

