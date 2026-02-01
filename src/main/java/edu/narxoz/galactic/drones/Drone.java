package edu.narxoz.galactic.drones;


public abstract class Drone {
    private String id;
    private DroneStatus status;
    private double maxPayloadKg;

    protected Drone(String id, double maxPayloadKg) {
        this.id = id;
        this.maxPayloadKg = maxPayloadKg;
        this.status = DroneStatus.IDLE;

        if (maxPayloadKg <= 0) {
            throw new IllegalArgumentException("Max payload is incorrect");
        }
    }

    public String getId() {
        return id;
    }

    public DroneStatus getStatus() {
        return status;
    }

    public double getMaxPayloadKg() {
        return maxPayloadKg;
    }

    public abstract double speedKmPerMin();

    public void setStatus(DroneStatus status) {
        this.status = status;
    }
}