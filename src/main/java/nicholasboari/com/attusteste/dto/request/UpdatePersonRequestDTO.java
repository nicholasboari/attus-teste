package nicholasboari.com.attusteste.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePersonRequestDTO {

    @NonNull
    @NotBlank(message = "id is mandatory")
    private String id;
    @NonNull
    @NotBlank(message = "name is mandatory")
    private String name;
    @NonNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthday;
}
