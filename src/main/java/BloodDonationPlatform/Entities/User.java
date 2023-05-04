package BloodDonationPlatform.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private int Id;
    private String name;
    private String username;
    private String password;
    private int role;
    private String location;
    private String grupaSange;
    private String phoneNumber;
    private String email;
    private String profilePicture;
    private String CNP;

    public User(int Id, String name, String username, String password, int role, String location, String grupaSange, String phoneNumber, String email, String profilePicture, String CNP) {
        this.Id = Id;
        this.name=name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.location = location;
        this.grupaSange = grupaSange;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.profilePicture=profilePicture;
        this.CNP=CNP;
    }

    public User(String username, String name, String password, int role, String location, String grupaSange, String phoneNumber, String email, String profilePicture, String CNP) {
        this.username = username;
        this.name=name;
        this.password = password;
        this.role = role;
        this.location = location;
        this.grupaSange = grupaSange;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.profilePicture=profilePicture;
        this.CNP=CNP;
    }

    public User() {
        this.Id=-1;
        this.name="";
        this.username = "";
        this.password = "";
        this.role = -1;
        this.location = "";
        this.grupaSange = "";
        this.phoneNumber = "";
        this.email = "";
        this.profilePicture = "";
        this.CNP = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGrupaSange() {
        return grupaSange;
    }

    public void setGrupaSange(String grupaSange) {
        this.grupaSange = grupaSange;
    }

    public int getId()
    {
        return Id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
