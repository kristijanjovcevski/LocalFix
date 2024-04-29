package mk.ukim.finki.localfix.model;

import jakarta.persistence.*;
import lombok.*;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", person=" + person.getUsername() +
                '}';
    }
}
