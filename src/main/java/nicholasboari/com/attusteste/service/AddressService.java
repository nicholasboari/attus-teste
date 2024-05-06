package nicholasboari.com.attusteste.service;

import lombok.RequiredArgsConstructor;
import nicholasboari.com.attusteste.dto.request.CreateAddressRequestDTO;
import nicholasboari.com.attusteste.dto.request.UpdateAddressRequestDTO;
import nicholasboari.com.attusteste.dto.response.AddressResponseDTO;
import nicholasboari.com.attusteste.dto.response.CreateAddressResponseDTO;
import nicholasboari.com.attusteste.dto.response.UpdateAddressResponseDTO;
import nicholasboari.com.attusteste.exception.ResourceConflictException;
import nicholasboari.com.attusteste.exception.ResourceNotFoundException;
import nicholasboari.com.attusteste.model.Address;
import nicholasboari.com.attusteste.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository repository;
    private final PersonService personService;
    private final ModelMapper mapper;

    public CreateAddressResponseDTO create(CreateAddressRequestDTO request) {
        personService.findByID(request.getPersonID());
        Page<AddressResponseDTO> addresses = findByPersonID(PageRequest.of(0, 20), request.getPersonID());
        if (request.getPrimaryAddress()) {
            addresses.forEach(address -> {
                if (address.getPrimaryAddress()) throw new ResourceConflictException("There is already a main address");
            });
        }
        Address address = mapper.map(request, Address.class);
        return mapper.map(repository.save(address), CreateAddressResponseDTO.class);
    }

    public AddressResponseDTO findByID(String id) {
        Address address = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address ID not exists"));
        return mapper.map(repository.save(address), AddressResponseDTO.class);
    }

    public Page<AddressResponseDTO> findAll(Pageable pageable) {
        Page<Address> all = repository.findAll(pageable);
        return all.map(address -> mapper.map(address, AddressResponseDTO.class));
    }

    public Page<AddressResponseDTO> findByPersonID(Pageable pageable, String personId) {
        Page<Address> all = repository.findAddressByPersonId(pageable, personId);
        return all.map(address -> mapper.map(address, AddressResponseDTO.class));
    }

    public AddressResponseDTO update(UpdateAddressRequestDTO request) {
        findByID(request.getId());
        Address address = mapper.map(request, Address.class);
        return mapper.map(repository.save(address), AddressResponseDTO.class);
    }
}
