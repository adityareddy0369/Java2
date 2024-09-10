package com.practice.java.DesignPatterns.Creational;

public class FactoryMethodDesign {
    public static void main(String[] args) {
        VehicleFactory bikeFactory = new BikeFactory();
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory truckFactory = new TruckFactory();

        Vehicle bike = bikeFactory.createVehicle();
        Vehicle car = carFactory.createVehicle();
        Vehicle truck = truckFactory.createVehicle();

        System.out.println(bike.getType());
        System.out.println(car.getType());
        System.out.println(truck.getType());
    }
}

interface Vehicle {
    String getType();
}

class Bike implements Vehicle {

    @Override
    public String getType() {
        return "Bike";
    }
}

class Car implements Vehicle {

    @Override
    public String getType() {
        return "Car";
    }
}

class Truck implements Vehicle {

    @Override
    public String getType() {
        return "Truck";
    }
}

abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class BikeFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Bike();
    }
}

class CarFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}

class TruckFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Truck();
    }
}
