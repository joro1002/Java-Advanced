package SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double consumer;
    private int distance;

    public Car(String model, double fuel, double consumer) {
        this.model = model;
        this.fuel = fuel;
        this.consumer = consumer;
        this.distance = 0;
    }

    public boolean drive(int distanceToDrive) {
        double neededFuel = distanceToDrive * consumer;
        if (neededFuel <= this.fuel){
            this.distance += distanceToDrive;
            this.fuel -= neededFuel;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %d", this.model, this.fuel, this.distance);
    }
}
