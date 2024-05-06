package nicholasboari.com.attusteste.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import nicholasboari.com.attusteste.model.BrazilStatesEnum;

@Data
public class AddressResponseDTO {

    private String id;
    private String personID;
    private String city;
    private String zipCode;
    private String number;
    private String publicPlace;
    private Boolean main;
    @Enumerated(EnumType.STRING)
    private BrazilStatesEnum state;
}
