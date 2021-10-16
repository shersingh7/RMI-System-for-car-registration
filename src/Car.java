


import java.io.Serializable;

public class Car implements Serializable {

    private String model;
    private String color;
    private double mileage;
    private String plate;

    public Car(String model, String color, double mileage) {
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.plate = "NA";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void register(String number){
        plate = number;
    }

    @Override
    public String toString() {
        return "\n\tModel = " + model +
                "\n\tColor = " + color +
                "\n\tMileage = " + mileage +
                "\n\tPlate = " + plate;
    }
}
