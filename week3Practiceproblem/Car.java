// package week3Practiceproblem;

import java.util.*;
import java.time.Year; // For getting current year

public class Car {
    // Instance variables (attributes) - each object has its own copy
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;

    // Constructor to initialize all attributes
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false; // Engine is off initially
    }

    // Method to start the engine
    public void startEngine() {
        if (!isRunning) {
            isRunning = true;
            System.out.println(brand + " " + model + " engine started.");
        } else {
            System.out.println(brand + " " + model + " engine is already running.");
        }
    }

    // Method to stop the engine
    public void stopEngine() {
        if (isRunning) {
            isRunning = false;
            System.out.println(brand + " " + model + " engine stopped.");
        } else {
            System.out.println(brand + " " + model + " engine is already off.");
        }
    }

    // Method to display all car information
    public void displayInfo() {
        System.out.println("Car Info:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Engine running: " + isRunning);
        System.out.println("Age: " + getAge() + " years");
        System.out.println("------------------------");
    }

    // Method to calculate car age
    public int getAge() {
        int currentYear = Year.now().getValue(); // Get current year dynamically
        return currentYear - year;
    }

    public static void main(String[] args) {
        // Creating 3 Car objects (each object is a separate car in real world)
        Car car1 = new Car("Toyota", "Corolla", 2018, "Red");
        Car car2 = new Car("Honda", "Civic", 2020, "Blue");
        Car car3 = new Car("Ford", "Mustang", 2015, "Black");

        // Demonstrating method calls
        car1.startEngine(); // Start engine of car1
        car1.displayInfo(); // Display info of car1

        car2.startEngine(); // Start engine of car2
        car2.stopEngine(); // Stop engine of car2
        car2.displayInfo(); // Display info of car2

        car3.displayInfo(); // Just display info (engine not started yet)
        car3.startEngine(); // Start engine of car3
        car3.displayInfo(); // Display updated info

        /*
         * Real-world analogy:
         * - Each Car object represents a real car.
         * - Instance variables are attributes of each car (brand, model, color, etc.).
         * - Methods like startEngine() and stopEngine() represent actions you can
         * perform on the car.
         * - Each object maintains its own state (isRunning, color, model), just like
         * real cars
         * can be different even if they are the same brand.
         */
    }
}
