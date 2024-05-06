package nicholasboari.com.attusteste.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nicholasboari.com.attusteste.model.BrazilStatesEnum;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressRequestDTO {

    @NonNull
    @NotBlank(message = "id is mandatory")
    private String id;
    @NonNull
    @NotBlank(message = "personID is mandatory")
    private String personID;
    @NonNull
    @NotBlank(message = "city is mandatory")
    private String city;
    @NonNull
    @NotBlank(message = "zipCode is mandatory")
    private String zipCode;
    @NonNull
    @NotBlank(message = "number is mandatory")
    private String number;
    @NonNull
    @NotBlank(message = "publicPlacec is mandatory")
    private String publicPlace;
    @NonNull
    private Boolean primaryAddress;
    @NonNull
    @Enumerated(EnumType.STRING)
    private BrazilStatesEnum state;
}
