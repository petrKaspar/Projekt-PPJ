package cz.tul.data;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Petr on 10.06.2016.
 */
@Entity
@Table(name = "komentar")
@Document(collection = "komentar")
public class Komentar {

    private int id;
    private int autor;  // id autora
    private String text;    //	Text komentáře
    private String vytvoreni;  // Datum vytvoreni
    private String aktualizace;  // Datum posledni aktualizace
    private int nlike;  // Počet like
    private int ndislake;    // Počet dislike

    public Komentar(int id, int autor, String text, String vytvoreni) {
        this.id = id;
        this.autor = autor;
        this.text = text;
        this.vytvoreni = vytvoreni;
    }

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
