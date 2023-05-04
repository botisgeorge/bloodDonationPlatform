package BloodDonationPlatform.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Location {
    @Id
    @SequenceGenerator(
            name = "location_sequence",
            sequenceName = "location_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "location_sequence"
    )
    private int Id;
    private String name;
    private String adress;
    private int maximumDonations;
    private String judet;
    private String photo;
    private int openingHour;
    private int closingHour;

    public Location(int id, String name, String adress, int maximumDonations, String judet, int openingHour, int closingHour, String photo) {
        Id = id;
        this.name = name;
        this.adress = adress;
        this.maximumDonations = maximumDonations;
        this.judet = judet;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.photo=photo;
    }

    public Location(String name, String adress, int maximumDonations, String judet, int openingHour, int closingHour, String photo) {
        this.name = name;
        this.adress = adress;
        this.maximumDonations = maximumDonations;
        this.judet = judet;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.photo=photo;
    }

    public Location() {
        Id = -1;
        this.name = "";
        this.adress = "";
        this.maximumDonations = 0;
        this.judet = "";
        this.openingHour = -1;
        this.closingHour = -1;
        this.photo="";
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getMaximumDonations() {
        return maximumDonations;
    }

    public void setMaximumDonations(int maximumDonations) {
        this.maximumDonations = maximumDonations;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public int getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(int openingHour) {
        this.openingHour = openingHour;
    }

    public int getClosingHour() {
        return closingHour;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setClosingHour(int closingHour) {
        this.closingHour = closingHour;
    }
}
