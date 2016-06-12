package cz.tul.data;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

import static javax.swing.text.StyleConstants.Size;

/**
 * Created by Petr on 11.06.2016.
 */
@Entity     // tato anotace naznačuje, že se jedná o JPA entitu.
@Table(name = "tag")
@Document(collection = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private int id;
   // @Size(max = 16)
   @Column(name = "tag")
    private String tag;

    protected Tag() { }
}
