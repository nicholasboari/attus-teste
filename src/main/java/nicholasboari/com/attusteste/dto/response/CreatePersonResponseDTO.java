package nicholasboari.com.attusteste.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CreatePersonResponseDTO {

    private String id;

    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthday;
}
