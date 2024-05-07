package nicholasboari.com.attusteste.util;

import nicholasboari.com.attusteste.dto.request.CreatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.request.UpdatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.response.CreatePersonResponseDTO;
import nicholasboari.com.attusteste.dto.response.PersonResponseDTO;
import nicholasboari.com.attusteste.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;

public class PersonCreator {

    public static Person createAValidPerson(){
        return Person.builder()
                .id("426f80c0-6c7d-4b2a-9835-199e37e0c5a4")
                .name("Joao")
                .birthday(LocalDate.now())
                .addresses(new ArrayList<>())
                .build();
    }

    public static CreatePersonResponseDTO createAValidPersonResponseDTO(){
        return CreatePersonResponseDTO.builder()
                .id("426f80c0-6c7d-4b2a-9835-199e37e0c5a4")
                .name("Joao")
                .birthday(LocalDate.now())
                .build();
    }

    public static CreatePersonRequestDTO createAValidPersonRequestDTO(){
        return CreatePersonRequestDTO.builder()
                .name("Joao")
                .birthday(LocalDate.now())
                .build();
    }

    public static PersonResponseDTO personResponseDTO(){
        return PersonResponseDTO.builder()
                .id("426f80c0-6c7d-4b2a-9835-199e37e0c5a4")
                .name("Joao")
                .birthday(LocalDate.now())
                .build();
    }

    public static UpdatePersonRequestDTO updatePersonRequestDTO(){
        return UpdatePersonRequestDTO.builder()
                .id("426f80c0-6c7d-4b2a-9835-199e37e0c5a4")
                .name("Joao2")
                .birthday(LocalDate.now())
                .build();
    }
}
