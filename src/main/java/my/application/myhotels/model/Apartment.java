package my.application.myhotels.model;

import javax.persistence.*;

@Entity
@Table(name = "apartments")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private ApartmentType type;
    private int spots;
    private double price;
    private boolean free;

    public Apartment(){

    }

    public Apartment(int number, ApartmentType type, int spots, double price, boolean free) {
        this.number = number;
        this.type = type;
        this.spots = spots;
        this.price = price;
        this.free = free;
    }

    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ApartmentType getType() {
        return type;
    }

    public void setType(ApartmentType type) {
        this.type = type;
    }

    public int getSpots() {
        return spots;
    }

    public void setSpots(int spots) {
        this.spots = spots;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public boolean equals(Object object){
        if(object != null){
            Apartment apartment = (Apartment) object;
            return apartment.getId() == this.id;
        }
        return false;
    }
}
