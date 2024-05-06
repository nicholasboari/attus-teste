package nicholasboari.com.attusteste.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdatePersonRequestDTO {

    private String id;
    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthday;
}
