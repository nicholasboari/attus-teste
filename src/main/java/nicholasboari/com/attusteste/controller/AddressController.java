package nicholasboari.com.attusteste.controller;

import lombok.RequiredArgsConstructor;
import nicholasboari.com.attusteste.dto.request.CreateAddressRequestDTO;
import nicholasboari.com.attusteste.dto.request.CreatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.request.UpdateAddressRequestDTO;
import nicholasboari.com.attusteste.dto.request.UpdatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.response.*;
import nicholasboari.com.attusteste.service.AddressService;
import nicholasboari.com.attusteste.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
    private final AddressService service;

    @GetMapping("/all")
    public ResponseEntity<Page<AddressResponseDTO>> findAll(Pageable pageable){
        Page<AddressResponseDTO> response = service.findAll(pageable);
        LOGGER.info("Received request to fetch all addresses");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByPerson/{personId}")
    public ResponseEntity<Page<AddressResponseDTO>> findAllByPersonID(Pageable pageable, @PathVariable String personId){
        Page<AddressResponseDTO> response = service.findByPersonID(pageable, personId);
        LOGGER.info("Received request to fetch all addresses by person ID");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressResponseDTO> findByID(@PathVariable String addressId){
        AddressResponseDTO response = service.findByID(addressId);
        LOGGER.info("Received request to fetch an address");
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateAddressResponseDTO> create(@RequestBody CreateAddressRequestDTO request){
        CreateAddressResponseDTO response = service.create(request);
        LOGGER.info("Received request to create a new address");
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    }

    @PutMapping
    public ResponseEntity<UpdateAddressResponseDTO> update(@RequestBody UpdateAddressRequestDTO request){
        UpdateAddressResponseDTO response = service.update(request);
        LOGGER.info("Received request to update an address");
        return ResponseEntity.ok(response);
    }
}
