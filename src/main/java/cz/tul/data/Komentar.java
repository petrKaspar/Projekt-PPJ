package cz.tul.data;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

/**
 * Created by Petr on 10.06.2016.
 */
@Entity     // tato anotace naznačuje, že se jedná o JPA entitu.
@Table(name = "komentar")
@Document(collection = "komentar")
public class Komentar {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    //lze take relace M:N - @ManyToMany    @JoinTable(...
    private int autor;  // id autora
    private String text;    //	Text komentáře
    private String vytvoreni;  // Datum vytvoreni
    private String aktualizace;  // Datum posledni aktualizace
    private int nlike;  // Počet like
    private int ndislake;    // Počet dislike

    protected Komentar() {}

    public Komentar(int autor, String text, String vytvoreni) {
        this.autor = autor;
        this.text = text;
        this.vytvoreni = vytvoreni;
    }

    /*
    Výchozí konstruktor existuje pouze kvůli JPA. Nebude použít přímo, takže je označen jako chráněný.
    Druhý konstruktor je ten, který se bude používat k vytvoření instance Komentar
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    @Override
    public String toString() {
        return "Komentar{" +
                "id=" + id +
                ", autor=" + autor +
                ", text='" + text + '\'' +
                ", vytvoreni='" + vytvoreni + '\'' +
                ", aktualizace='" + aktualizace + '\'' +
                ", nlike=" + nlike +
                ", ndislake=" + ndislake +
                '}';
    }
}
