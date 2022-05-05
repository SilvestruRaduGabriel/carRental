package ro.sda.finalProject.carRental.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Lob;

@Data
public class CarForm {

    private Long id;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private String bodyType;
    @NotNull
    private int year;
    @NotNull
    private String colour;
    @NotNull
    private int mileage;
    @NotNull
    private Status status;
    @NotNull
    private int amount;

    private String image;

}
