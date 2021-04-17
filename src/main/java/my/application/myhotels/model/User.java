package my.application.myhotels.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int discount;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private UserRole userRole;

    public User() {

    }

    public User(String firstName, String lastName, String email, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRole = userRole;
        setDiscount();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
        setDiscount();
    }

    public int getDiscount() {
        return discount;
    }

    private void setDiscount(){
        switch (this.userRole){
            case CUSTOMER:
                this.discount = 5;
                break;
            case USER:
            case ADMIN:
                this.discount = 10;
                break;
            default:
                this.discount = 0;
                break;
        }
    }

    @Override
    public boolean equals(Object object){
        if(object != null){
            User user = (User) object;
            return user.getId() == this.id;
        }
        return false;
    }
}
