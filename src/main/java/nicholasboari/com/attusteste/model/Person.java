package nicholasboari.com.attusteste.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "tb_person")
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nome", nullable = false)
    private String name;
    @Column(name = "data_nascimento", nullable = false)
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate birthday;

    @OneToMany(mappedBy = "person")
    private List<Address> addresses;
}
