package nicholasboari.com.attusteste.service;

import lombok.RequiredArgsConstructor;
import nicholasboari.com.attusteste.dto.request.CreatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.response.CreatePersonResponseDTO;
import nicholasboari.com.attusteste.model.Person;
import nicholasboari.com.attusteste.repository.PersonRepository;
import org.modelmapper.ModelMapper;
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
}
