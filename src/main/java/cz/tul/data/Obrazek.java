package cz.tul.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
@Document(collection = "tag")
public class Obrazek {

    @Id
    @GeneratedValue
    private int id;
    private String url;      /*  a. Musí být možné zadat pouze URL bez dat (tj. přidat externí obrázek)
                                 b.	Způsob uložení pro lokální obrázky je na Vás (filesystem, DB)  */
    //lze take relace M:N - @ManyToMany    @JoinTable(...
    private int autor;  // id autora
    private String nazev;
    private String vytvoreni;  // Datum vytvoreni
    private String aktualizace;  // Datum posledni aktualizace
    private int nlike;  // Počet like
    private int ndislake;    // Počet dislike
    private int komentar;  // id autora



}
