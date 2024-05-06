package nicholasboari.com.attusteste.util;

import nicholasboari.com.attusteste.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class PersonCreator {

    public static Person createAValidPersonResponseDTO(){
        return Person.builder()
                .id(UUID.randomUUID().toString())
                .name("Joao")
                .birthday(LocalDate.now())
                .addresses(new ArrayList<>())
                .build();
    }
}
