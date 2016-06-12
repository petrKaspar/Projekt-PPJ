package cz.tul.data;

//import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
@Table(name = "obrazek")
@Document(collection = "obrazek")
public class Obrazek {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "url")
    private String url;      /*  a. Musí být možné zadat pouze URL bez dat (tj. přidat externí obrázek)
                                 b.	Způsob uložení pro lokální obrázky je na Vás (filesystem, DB)  */
    //lze take relace M:N - @ManyToMany    @JoinTable(...
    @Column
    private int autorid;  // id autora
    @Column
    private String nazev;
    @Column
    private String vytvoreni;  // Datum vytvoreni
    @Column
    private String aktualizace;  // Datum posledni aktualizace
    @Column
    private int nlike;  // Počet like
    private int ndislake;    // Počet dislike
    private int komentar;  // id autora

    protected Obrazek() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAutor() {
        return autorid;
    }

    public void setAutor(int autorid) {
        this.autorid = autorid;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getVytvoreni() {
        return vytvoreni;
    }

    public void setVytvoreni(String vytvoreni) {
        this.vytvoreni = vytvoreni;
    }

    public String getAktualizace() {
        return aktualizace;
    }

    public void setAktualizace(String aktualizace) {
        this.aktualizace = aktualizace;
    }

    public int getNlike() {
        return nlike;
    }

    public void setNlike(int nlike) {
        this.nlike = nlike;
    }

    public int getNdislake() {
        return ndislake;
    }

    public void setNdislake(int ndislake) {
        this.ndislake = ndislake;
    }

    public int getKomentar() {
        return komentar;
    }

    public void setKomentar(int komentar) {
        this.komentar = komentar;
    }

    @Override
    public String toString() {
        return "Obrazek{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", autorid=" + autorid +
                ", nazev='" + nazev + '\'' +
                ", vytvoreni='" + vytvoreni + '\'' +
                ", aktualizace='" + aktualizace + '\'' +
                ", nlike=" + nlike +
                ", ndislake=" + ndislake +
                ", komentar=" + komentar +
                '}';
    }
}
