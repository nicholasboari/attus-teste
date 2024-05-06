package nicholasboari.com.attusteste.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nicholasboari.com.attusteste.model.BrazilStatesEnum;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAddressRequestDTO {

    @NonNull
    @NotEmpty(message = "personID cannot be empty")
    private String personID;
    @NonNull
    @NotEmpty(message = "city cannot be empty")
    private String city;
    @NonNull
    @NotEmpty(message = "zipCode cannot be empty")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "zipCode must be in the format XXXXX-XXX")
    private String zipCode;
    @NonNull
    @NotEmpty(message = "number cannot be empty")
    @Positive
    private Integer number;
    @NonNull
    @NotEmpty(message = "publicPlace cannot be empty")
    private String publicPlace;
    @NonNull
    private Boolean primaryAddress;
    @NonNull
    @Enumerated(EnumType.STRING)
    private BrazilStatesEnum state;
}
