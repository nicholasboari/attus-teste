package nicholasboari.com.attusteste.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "cidade", nullable = false)
    private String city;
    @Column(name = "CEP", nullable = false)
    private String zipCode;
    @Column(name = "numero", nullable = false)
    private String number;
    @Column(name = "logradouro", nullable = false, columnDefinition = "TEXT")
    private String publicPlace;
    @Column(name = "endereco_principal", nullable = false)
    private Boolean primaryAddress;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private BrazilStatesEnum state;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
