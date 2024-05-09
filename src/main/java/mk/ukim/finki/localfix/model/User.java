package mk.ukim.finki.localfix.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Person_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Person person;

    @OneToMany(mappedBy = "reportedBy",fetch = FetchType.EAGER)
    private List<Problem> problems;

    public User(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", person=" + person.getUsername() +
                '}';
    }
}
