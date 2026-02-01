package edu.narxoz.galactic;

import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.*;
import edu.narxoz.galactic.task.*;
import edu.narxoz.galactic.dispatcher.*;

public class Main {
    public static void main(String[] args) {

        Planet earth = new Planet("Earth", 0, 0, "Oxygen");
        SpaceStation moon = new SpaceStation("Moon Base", 100, 100, 1);


        Cargo box = new Cargo(50.0, "Scientific Samples");

        LightDrone light = new LightDrone("L-01", 30.0);

        HeavyDrone heavy = new HeavyDrone("H-99", 500.0);

        Dispatcher dispatcher = new Dispatcher();
        DeliveryTask task = new DeliveryTask(earth, moon, box);

        System.out.println("--- Galactic Delivery System ---");


        Result r1 = dispatcher.assignTask(task, light);
        System.out.println("Step 1 (Failure expected): Success = " + r1.ok() + ", Reason = " + r1.reason());


        Result r2 = dispatcher.assignTask(task, heavy);
        System.out.println("Step 2 (Success expected): Success = " + r2.ok());
        System.out.println("Drone Status: " + heavy.getStatus() + ", Task State: " + task.getState());


        System.out.println("Step 3 (Estimation): Time = " + task.estimateTime() + " min");


        Result r3 = dispatcher.completeTask(task);
        System.out.println("Step 4 (Completion): Success = " + r3.ok());
        System.out.println("Final Drone Status: " + heavy.getStatus());
        System.out.println("Final Task State: " + task.getState());
    }
}