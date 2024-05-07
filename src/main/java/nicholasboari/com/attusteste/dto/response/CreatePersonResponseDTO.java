package nicholasboari.com.attusteste.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePersonResponseDTO {

    private String id;

    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthday;
}
