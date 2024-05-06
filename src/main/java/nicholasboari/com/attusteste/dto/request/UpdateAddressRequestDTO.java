package nicholasboari.com.attusteste.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import nicholasboari.com.attusteste.model.BrazilStatesEnum;

@Data
public class UpdateAddressRequestDTO {

    private String id;
    private String city;
    private String zipCode;
    private String number;
    private String publicPlace;
    private Boolean primaryAddress;
    @Enumerated(EnumType.STRING)
    private BrazilStatesEnum state;
}
