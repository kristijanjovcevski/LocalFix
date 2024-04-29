package mk.ukim.finki.localfix.model;

import jakarta.persistence.*;
import lombok.*;
import mk.ukim.finki.localfix.model.enums.Impact;
import mk.ukim.finki.localfix.model.enums.Status;

import java.util.List;

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

    private String address;

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
    private Institution institution;

    @ManyToOne
    private User reportedBy;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
    List<Problem_Administrator> problemAdministratorList;


    public Problem(String title, String description, byte[] photo,
                   Institution institution, User reportedBy,Impact impact,City city, String address) {

        this.title = title;
        this.description = description;
        this.photo = photo;
        this.institution = institution;
        this.reportedBy = reportedBy;
        this.city = city;
        this.address = address;
        this.impact = impact;

    }
}
