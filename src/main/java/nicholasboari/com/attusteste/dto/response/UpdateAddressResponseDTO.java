package nicholasboari.com.attusteste.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import nicholasboari.com.attusteste.model.BrazilStatesEnum;

@Data
public class UpdateAddressResponseDTO {

    private String id;
    private String city;
    private String zipCode;
    private Integer number;
    private String publicPlace;
    private Boolean primaryAddress;
    @Enumerated(EnumType.STRING)
    private BrazilStatesEnum state;
}
