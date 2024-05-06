package nicholasboari.com.attusteste.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nicholasboari.com.attusteste.dto.request.CreatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.request.UpdatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.response.CreatePersonResponseDTO;
import nicholasboari.com.attusteste.dto.response.PersonResponseDTO;
import nicholasboari.com.attusteste.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
    private final PersonService service;

    @GetMapping("/all")
    public ResponseEntity<Page<PersonResponseDTO>> findAll(Pageable pageable){
        Page<PersonResponseDTO> response = service.findAll(pageable);
        LOGGER.info("Received request to fetch all persons");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonResponseDTO> findPersonByID(@PathVariable String personId){
        PersonResponseDTO response = service.findByID(personId);
        LOGGER.info("Received request to fetch person by ID");
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreatePersonResponseDTO> create(@Valid @RequestBody CreatePersonRequestDTO request) {
        CreatePersonResponseDTO response = service.create(request);
        LOGGER.info("Received request to create a new person");
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    }

    @PutMapping
    public ResponseEntity<PersonResponseDTO> update(@Valid @RequestBody UpdatePersonRequestDTO request){
        PersonResponseDTO response = service.update(request);
        LOGGER.info("Received request to update a person");
        return ResponseEntity.ok(response);
    }
}
