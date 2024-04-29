package mk.ukim.finki.localfix.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Problem_Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Problem problem;

    @ManyToOne
    private Administrator administrator;

    public Problem_Administrator(Administrator administrator, Problem problem) {
        this.administrator = administrator;
        this.problem = problem;

    }
}
