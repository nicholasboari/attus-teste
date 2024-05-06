package nicholasboari.com.attusteste.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import nicholasboari.com.attusteste.model.Address;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonResponseDTO {
    private String id;

    private String name;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate birthday;

    private List<Address> addresses;
}
