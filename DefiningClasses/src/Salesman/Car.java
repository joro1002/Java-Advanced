package Salesman;

public class Car {
    private String model;
    private String engine;
    private int weight;
    private String color;

    public Car(String model, String engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, String engine) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }

    public Car(String model, String engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String model, String engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
        this.weight = 0;
    }

    public String getModel() {
        return model;
    }

    public String getEngine() {
        return engine;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if (this.weight == 0){
            builder.append("Weight: n/a" + "\n");
        }else {
            builder.append("Weight: " + this.weight + "\n");
        }
        if (this.color.equals("n/a")){
            builder.append("Color: n/a"  + "\n");
        }else {
            builder.append("Color: " + this.color + "\n");
        }
        return builder.toString();
    }
}
