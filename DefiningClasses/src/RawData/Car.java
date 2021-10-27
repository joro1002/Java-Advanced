package RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire1;
    private Tire tire2;
    private Tire tire3;
    private Tire tire4;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
               double pressure1, int age1,double pressure2, int age2, double pressure3, int age3,
               double pressure4, int age4){
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tire1 = new Tire(pressure1, age1);
        this.tire2 = new Tire(pressure2, age2);
        this.tire3 = new Tire(pressure3, age3);
        this.tire4 = new Tire(pressure4, age4);
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire getTire1() {
        return tire1;
    }

    public Tire getTire2() {
        return tire2;
    }

    public Tire getTire3() {
        return tire3;
    }

    public Tire getTire4() {
        return tire4;
    }

    public String getModel() {
        return model;
    }

    public boolean pressure(){
        if (tire1.getPressure() < 1){
            return true;
        }else if (tire2.getPressure() < 1){
            return true;
        }else if (tire3.getPressure() < 1){
            return true;
        }else if (tire4.getPressure() < 1){
            return true;
        }
        return false;
    }

    public boolean enginePower(){
        return this.engine.getEnginePower() > 250;
    }
}
