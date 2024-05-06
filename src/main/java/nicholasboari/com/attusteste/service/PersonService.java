package nicholasboari.com.attusteste.service;

import lombok.RequiredArgsConstructor;
import nicholasboari.com.attusteste.dto.request.CreatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.request.UpdatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.response.CreatePersonResponseDTO;
import nicholasboari.com.attusteste.dto.response.PersonResponseDTO;
import nicholasboari.com.attusteste.exception.ResourceNotFoundException;
import nicholasboari.com.attusteste.model.Person;
import nicholasboari.com.attusteste.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;
    private final ModelMapper mapper;

    public CreatePersonResponseDTO create(CreatePersonRequestDTO request) {
        Person person = mapper.map(request, Person.class);
        return mapper.map(repository.save(person), CreatePersonResponseDTO.class);
    }

    public PersonResponseDTO findByID(String id) {
        Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person ID not exists!"));
        return mapper.map(person, PersonResponseDTO.class);
    }

    public Page<PersonResponseDTO> findAll(Pageable pageable) {
        Page<Person> all = repository.findAll(pageable);
        return all.map(address -> mapper.map(address, PersonResponseDTO.class));
    }

    public PersonResponseDTO update(UpdatePersonRequestDTO request) {
        findByID(request.getId());
        Person person = mapper.map(request, Person.class);
        return mapper.map(repository.save(person), PersonResponseDTO.class);
    }
}
