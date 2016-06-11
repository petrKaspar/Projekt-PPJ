package cz.tul.data;

import org.hibernate.annotations.Type;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

/**
 * Created by Petr on 10.06.2016.
 */
@Entity      // tato anotace naznačuje, že se jedná o JPA entitu.
@Table(name = "autor")
@Document(collection = "autor")
public class Autor {
/*    @Id
    @SequenceGenerator(name="seq", initialValue=0, allocationSize=100)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")*/
   /* @Id
    @GeneratedValue(strategy=GenerationType.AUTO)   // samozřejmě autoinkrementace (v konstruktoru id již pak nemusí být)
    private int  id;*/
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
private Long id;

    @Column
    private String jmeno;
    @Column
    private String registrace;  // Datum registrace

    protected Autor() {}

    public Autor(String jmeno, String registrace) {
        this.jmeno = jmeno;
        this.registrace = registrace;
    }

    public Autor(Long id, String jmeno, String registrace) {
        this.id = id;
        this.jmeno = jmeno;
        this.registrace = registrace;
    }

    /*
    Výchozí konstruktor existuje pouze kvůli JPA. Nebude použít přímo, takže je označen jako chráněný.
    Druhý konstruktor je ten, který se bude používat k vytvoření instance Autora
     */

    public void setId(Long id) {
        this.id = id;
    }
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }
    public void setRegistrace(String registrace) {
        this.registrace = registrace;
    }

    public Long getId() {
        return id;
    }
    public String getJmeno() {
        return jmeno;
    }
    public String getRegistrace() {
        return registrace;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", jmeno='" + jmeno + '\'' +
                ", registrace='" + registrace + '\'' +
                '}';
    }
}
