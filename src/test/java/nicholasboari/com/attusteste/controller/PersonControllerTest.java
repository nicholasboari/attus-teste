package nicholasboari.com.attusteste.controller;

import nicholasboari.com.attusteste.dto.request.CreatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.request.UpdatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.response.CreatePersonResponseDTO;
import nicholasboari.com.attusteste.dto.response.PersonResponseDTO;
import nicholasboari.com.attusteste.service.PersonService;
import nicholasboari.com.attusteste.util.PersonCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

@ExtendWith(SpringExtension.class)
class PersonControllerTest {

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonService personService;

    private Pageable pageable;

    @BeforeEach
    void setup() {
        pageable = PageRequest.of(0, 3);
        Page<PersonResponseDTO> personPage = new PageImpl<>(Collections.singletonList(PersonCreator.personResponseDTO()));
        Mockito.when(this.personService.findAll(ArgumentMatchers.any(Pageable.class))).thenReturn(personPage);
    }

    @Test
    @DisplayName("Returns page of persons inside page object when successful")
    void findPaged_ReturnsPageOfPersons_WhenSuccessful() {
        Page<PersonResponseDTO> personPage = personController.findAll(pageable).getBody();

        Assertions.assertThat(personPage).isNotNull();
    }

    @Test
    @DisplayName("Returns a person when findById is called with a valid ID")
    void findById_ReturnsPerson_WhenSuccessful() {
        String validId = "426f80c0-6c7d-4b2a-9835-199e37e0c5a4";
        PersonResponseDTO expectedPerson = PersonCreator.personResponseDTO();

        Mockito.when(this.personService.findByID(validId)).thenReturn(expectedPerson);

        ResponseEntity<PersonResponseDTO> responseEntity = personController.findPersonByID(validId);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getId()).isEqualTo(validId);
    }

    @Test
    @DisplayName("Creates a new person when create is called with a valid DTO")
    void create_CreatesNewPerson_WhenSuccessful() {
        CreatePersonRequestDTO validPersonRequestDTO = PersonCreator.createAValidPersonRequestDTO();
        CreatePersonResponseDTO expectedPersonResponseDTO = PersonCreator.createAValidPersonResponseDTO();

        Mockito.when(this.personService.create(validPersonRequestDTO)).thenReturn(expectedPersonResponseDTO);

        ResponseEntity<CreatePersonResponseDTO> responseEntity = personController.create(validPersonRequestDTO);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(responseEntity.getBody()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getId()).isEqualTo(expectedPersonResponseDTO.getId());
    }

    @Test
    @DisplayName("Updates a person when update is called with a valid DTO")
    void update_UpdatesPerson_WhenSuccessful() {
        UpdatePersonRequestDTO validPersonRequestDTO = PersonCreator.updatePersonRequestDTO();
        PersonResponseDTO expectedPersonResponseDTO = PersonCreator.personResponseDTO();

        Mockito.when(this.personService.update(PersonCreator.updatePersonRequestDTO())).thenReturn(expectedPersonResponseDTO);

        ResponseEntity<PersonResponseDTO> responseEntity = personController.update(validPersonRequestDTO);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getId()).isEqualTo(expectedPersonResponseDTO.getId());
    }
}