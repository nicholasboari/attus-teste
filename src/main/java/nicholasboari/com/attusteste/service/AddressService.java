package nicholasboari.com.attusteste.service;

import lombok.RequiredArgsConstructor;
import nicholasboari.com.attusteste.dto.request.CreateAddressRequestDTO;
import nicholasboari.com.attusteste.dto.request.UpdateAddressRequestDTO;
import nicholasboari.com.attusteste.dto.response.AddressResponseDTO;
import nicholasboari.com.attusteste.dto.response.CreateAddressResponseDTO;
import nicholasboari.com.attusteste.dto.response.PersonResponseDTO;
import nicholasboari.com.attusteste.dto.response.UpdateAddressResponseDTO;
import nicholasboari.com.attusteste.exception.ResourceNotFoundException;
import nicholasboari.com.attusteste.model.Address;
import nicholasboari.com.attusteste.model.Person;
import nicholasboari.com.attusteste.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository repository;
    private final ModelMapper mapper;

    public CreateAddressResponseDTO create(CreateAddressRequestDTO request) {
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

    public UpdateAddressResponseDTO update(UpdateAddressRequestDTO request) {
        findByID(request.getId());
        Address address = mapper.map(request, Address.class);
        return mapper.map(repository.save(address), UpdateAddressResponseDTO.class);
    }
}
