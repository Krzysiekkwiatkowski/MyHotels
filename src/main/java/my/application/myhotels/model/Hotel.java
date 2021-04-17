package my.application.myhotels.model;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Address address;
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Apartment> apartments;

    public Hotel(){

    }

    public Hotel(String name, String description, Address address, List<Apartment> apartments) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.apartments = apartments;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    @Override
    public boolean equals(Object object){
        if(object != null){
            Hotel hotel = (Hotel) object;
            return hotel.getId() == this.id;
        }
        return false;
    }
}
