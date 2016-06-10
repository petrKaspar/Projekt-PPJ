package cz.tul.data;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Petr on 10.06.2016.
 */
@Entity
@Table(name = "autor")
@Document(collection = "autor")
public class Autor {

    private int id;
    private String jmeno;
    private String registrace;  // Datum registrace

    public Autor(int id, String jmeno, String registrace) {
        this.id = id;
        this.jmeno = jmeno;
        this.registrace = registrace;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }
    public void setRegistrace(String registrace) {
        this.registrace = registrace;
    }

    public int getId() {
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
