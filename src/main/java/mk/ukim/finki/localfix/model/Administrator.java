package mk.ukim.finki.localfix.model;

import lombok.*;

import javax.persistence.*;
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

    public Administrator(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", person=" + person.getUsername() +
                '}';
    }
}
