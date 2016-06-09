package cz.tul.data;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "bills")
@Document(collection = "bills")
public class Bill {

    @Id
    @org.springframework.data.annotation.Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private long amount;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user")
    @DBRef
    private User user;

    public Bill() {
    }

    public Bill(UUID id, long amount, User user) {
        this.id = id;
        this.amount = amount;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        return id != null ? id.equals(bill.id) : bill.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", amount=" + amount +
                ", user=" + user +
                '}';
    }
}
