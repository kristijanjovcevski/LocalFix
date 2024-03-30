package mk.ukim.finki.localfix.model;

import jakarta.persistence.*;
import lombok.*;
import mk.ukim.finki.localfix.model.enums.Impact;
import mk.ukim.finki.localfix.model.enums.Status;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Lob
    @Column(nullable = true)
    private byte[] photo;

    @Enumerated(EnumType.STRING)
    private Status status;

    private boolean isPermanent;

    @Enumerated(EnumType.STRING)
    private Impact impact;

    @Column(nullable = true)
    private String cause;

    @ManyToOne
    private User reportedBy;

    @ManyToOne
    private City city;
}
