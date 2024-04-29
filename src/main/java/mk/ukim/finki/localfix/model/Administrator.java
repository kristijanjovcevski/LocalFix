package mk.ukim.finki.localfix.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Person_admin")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Person person;

    @OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL)
    List<Problem_Administrator> problemAdministrators;

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", person=" + person.getUsername() +
                '}';
    }
}
