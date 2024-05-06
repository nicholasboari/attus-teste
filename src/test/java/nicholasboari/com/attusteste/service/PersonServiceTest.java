package nicholasboari.com.attusteste.service;

import nicholasboari.com.attusteste.dto.request.CreatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.request.UpdatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.response.CreatePersonResponseDTO;
import nicholasboari.com.attusteste.dto.response.PersonResponseDTO;
import nicholasboari.com.attusteste.model.Person;
import nicholasboari.com.attusteste.repository.PersonRepository;
import nicholasboari.com.attusteste.util.PersonCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private ModelMapper modelMapper;

    CreatePersonResponseDTO createPersonResponseDTO;
    CreatePersonRequestDTO createPersonRequestDTO;
    PersonResponseDTO personResponseDTO;
    Person person;

    @BeforeEach
    void setup(){
        createPersonResponseDTO = PersonCreator.createAValidPersonResponseDTO();
        createPersonRequestDTO = PersonCreator.createAValidPersonRequestDTO();
        personResponseDTO = PersonCreator.personResponseDTO();
        person = PersonCreator.createAValidPerson();

        Mockito.when(modelMapper.map(Mockito.any(Person.class), Mockito.eq(CreatePersonResponseDTO.class))).thenReturn(createPersonResponseDTO);
        Mockito.when(modelMapper.map(Mockito.any(Person.class), Mockito.eq(PersonResponseDTO.class))).thenReturn(personResponseDTO);
        Mockito.when(modelMapper.map(Mockito.any(UpdatePersonRequestDTO.class), Mockito.eq(Person.class))).thenReturn(person);
        Mockito.when(modelMapper.map(Mockito.any(CreatePersonRequestDTO.class), Mockito.eq(Person.class))).thenReturn(person);
    }
    @Test
    @DisplayName("Save a new person when ID null")
    void save_ShouldSaveNewPerson_WhenIdIsNull(){
        Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(PersonCreator.createAValidPerson());

        CreatePersonResponseDTO response = personService.create(createPersonRequestDTO);

        Assertions.assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("Find a person by ID")
    void findById_ShouldReturnPerson_WhenIdExists(){
        Mockito.when(personRepository.save(person)).thenReturn(person);

        String id = "426f80c0-6c7d-4b2a-9835-199e37e0c5a4";
        Mockito.when(personRepository.findById(id)).thenReturn(Optional.of(person));

        PersonResponseDTO response = personService.findByID(id);

        Assertions.assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("Find all persons")
    void findAll_ShouldReturnAllPersons(){
        Pageable pageable = PageRequest.of(0, 10);
        List<Person> personList = Arrays.asList(person, person, person);
        Page<Person> personPage = new PageImpl<>(personList);

        Mockito.when(personRepository.findAll(pageable)).thenReturn(personPage);

        Page<PersonResponseDTO> response = personService.findAll(pageable);

        Assertions.assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("Update a person")
    void update_ShouldUpdatePerson_WhenIdExists(){
        Mockito.when(personRepository.save(person)).thenReturn(person);

        String id = "426f80c0-6c7d-4b2a-9835-199e37e0c5a4";
        UpdatePersonRequestDTO request = UpdatePersonRequestDTO.builder().id(id).name("Joao").birthday(LocalDate.now()).build();

        Mockito.when(personRepository.findById(id)).thenReturn(Optional.of(person));

        PersonResponseDTO response = personService.update(request);

        Assertions.assertThat(response).isNotNull();
    }
}