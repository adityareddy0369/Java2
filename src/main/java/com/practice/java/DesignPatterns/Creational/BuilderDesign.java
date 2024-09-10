package com.practice.java.DesignPatterns.Creational;

// Constructs complex objects step by step.
public class BuilderDesign {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.ComputerBuilder()
                .setCpu("Intel i9")
                .setRam("32GB")
                .setStorage("1TB SSD")
                .setGpu("NVIDIA RTX 3080")
                .build();

        Computer officePC = new Computer.ComputerBuilder()
                .setCpu("Intel i5")
                .setRam("16GB")
                .setStorage("512GB SSD")
                // GPU is optional for this build
                .build();

        System.out.println("Gaming PC: " + gamingPC);
        System.out.println("Office PC: " + officePC);
    }
}

class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;

    // Private constructor to enforce the use of the Builder
    private Computer(ComputerBuilder computerBuilder) {
        this.cpu = computerBuilder.cpu;
        this.ram = computerBuilder.ram;
        this.storage = computerBuilder.storage;
        this.gpu = computerBuilder.gpu;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", gpu='" + gpu + '\'' +
                '}';
    }

    public static class ComputerBuilder {
        private String cpu;
        private String ram;
        private String storage;
        private String gpu;

        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
