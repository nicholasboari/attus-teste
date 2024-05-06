package nicholasboari.com.attusteste.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nicholasboari.com.attusteste.model.BrazilStatesEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAddressResponseDTO {

    private String id;
    private String personID;
    private String city;
    private String zipCode;
    private Integer number;
    private String publicPlace;
    private Boolean primaryAddress;
    @Enumerated(EnumType.STRING)
    private BrazilStatesEnum state;
}
