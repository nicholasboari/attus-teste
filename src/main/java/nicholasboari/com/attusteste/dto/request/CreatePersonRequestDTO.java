package nicholasboari.com.attusteste.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
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
public class CreatePersonRequestDTO {

    @NonNull
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NonNull
    private LocalDate birthday;
}
