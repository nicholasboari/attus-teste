package nicholasboari.com.attusteste.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class CreatePersonRequestDTO {

    private String name;
    private String birthday;
}
