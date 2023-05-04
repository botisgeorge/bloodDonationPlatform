package BloodDonationPlatform.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Programare {
    @Id
    @SequenceGenerator(
            name = "programare_sequence",
            sequenceName = "programare_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "programare_sequence"
    )
    private int Id;
    private int idDonator;
    private int idDoctor;
    private int idLocatie;
    private int ora;
    private LocalDate data;
    private boolean acceptat;

    public Programare(int id, int idDonator, int idDoctor, int idLocatie, int ora, LocalDate data, boolean acceptat) {
        Id = id;
        this.idDonator = idDonator;
        this.idDoctor = idDoctor;
        this.idLocatie = idLocatie;
        this.ora = ora;
        this.acceptat = acceptat;
        this.data=data;
    }

    public Programare() {
        Id = -1;
        this.idDonator = -1;
        this.idDoctor = -1;
        this.idLocatie = -1;
        this.ora = -1;
        this.acceptat = false;
        this.data=null;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdDonator() {
        return idDonator;
    }

    public void setIdDonator(int idDonator) {
        this.idDonator = idDonator;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getIdLocatie() {
        return idLocatie;
    }

    public void setIdLocatie(int idLocatie) {
        this.idLocatie = idLocatie;
    }

    public int getOra() {
        return ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public boolean isAcceptat() {
        return acceptat;
    }

    public void setAcceptat(boolean acceptat) {
        this.acceptat = acceptat;
    }
}
