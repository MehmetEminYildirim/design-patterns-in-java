package Observer;

import java.util.Observable;
import java.util.Observer;

public class CargoDisplay implements Observer, DisplayElement {

    private String cargoNumber;
    private String description;
    private String address;
    private String location;

    public CargoDisplay(Observable obs) {
        obs.addObserver(this);
    }

    public void update(Observable obs, Object obj) {
        if(obs instanceof CargoData) {
            CargoData cd = (CargoData)obs;
            cargoNumber = cd.getCargoNumber();
            description = cd.getDescription();
            address = cd.getAddress();
            location = cd.getLocation();
        }
        display();
    }

    public void display() {
        System.out.println("ABOUT THE CARGO");
        System.out.println("-Cargo Number: " + cargoNumber);
        System.out.println("-Cargo Description: " + description);
        System.out.println("-Delivering Address: " + address);
        System.out.println("-Current Location: " + location + "\n");
    }
}
