package Salesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;

    }

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, String efficiency) {
        this.model = model;
        this.power = power;
        this.efficiency = efficiency;
        this.displacement = 0;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Power: " + this.power + "\n");
        if (this.displacement == 0) {
            stringBuilder.append("Displacement: n/a" + "\n");
        } else {
            stringBuilder.append("Displacement: " + this.displacement + "\n");
        }
        if (this.efficiency.equals("n/a")) {
            stringBuilder.append("Efficiency: n/a" + "\n");
        } else {
            stringBuilder.append("Efficiency: " + this.efficiency + "\n");
        }
        return stringBuilder.toString();

    }
}