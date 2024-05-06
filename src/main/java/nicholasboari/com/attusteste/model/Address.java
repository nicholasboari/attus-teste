package nicholasboari.com.attusteste.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_address")
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String city;
    private String zipCode;
    private String number;
    private String publicPlace;
    private Boolean main;

    @Enumerated(EnumType.STRING)
    private BrazilStatesEnum state;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
